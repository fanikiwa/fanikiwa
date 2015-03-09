package com.sp.fanikiwa;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.Diaryprogramcontrol;
import com.sp.fanikiwa.entity.STO;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.Enums.STOType;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.utils.DateExtension;
import com.sp.utils.Utils;

public class DiaryComponent {
	boolean EnableLog = true;

	private static final Logger log = Logger.getLogger(DiaryComponent.class.getName());

    public void RunDiary(Date date)
    {
        DiaryProgramControlEndpoint dDac = new DiaryProgramControlEndpoint();
        List<Diaryprogramcontrol> controlRec = dDac.Select();
        Diaryprogramcontrol dp = new Diaryprogramcontrol();
        
        if (controlRec.Count == 0)
        {

            dp.LastRun = date;
            dp.NextRun =DateExtension.addDays(date, 1) ;
            dDac.Create(dp);
        }
        else { dp = controlRec[0]; }

        Date lastRun = dp.LastRun;
        for (Date i = dp.LastRun; i.after(date) ; i = DateExtension.addDays(i,1))
        {
            if (EnableLog) log.info("Processing started for [" + i + "]");
            //1. Run STOsn 
            RunSTOs(i);

            //2. Clear valuedated transactions
            RunClearItems(i);

            //update control rec
            lastRun = i;
        }

        //update db now- control rec
        dp.LastRun = lastRun;
        dp.NextRun = DateExtension.addDays(lastRun,1);
        dDac.UpdateById(dp);
    }

    private void RunClearItems(Date date)
    {
    	AccountEndpoint st = new AccountEndpoint();
        st.ClearEffects(date);
    }

    /// <summary>
    /// RunSTO business method. 
    /// </summary>
    /// <param name="_Today">A _Today value.</param>
    /// <returns>Returns a List<STO> object.</returns>



    private void RunSTOs(Date date)
    {

        //1. Run STOs
        STOEndpoint st = new STOEndpoint();
        List<STO> _ScheduleTransactions = st.SelectSTOByDateFrom(date);

        if (EnableLog) log.Info("Processing [" + _ScheduleTransactions.Count + "] transactions");
        for (STO _sto : _ScheduleTransactions)
        {
            //Process now
            try
            {
                String msg = String.format("Processing STO Id[{0}], NextPayDate[{7}] "+ 
                        "DrAccount[{1}],  "+ 
                        "CrAccount[{2}],  "+ 
                        "PayAmount[{3}],  "+ 
                        "TotalToPay[{4}],  "+ 
                        "CrTxnType[{5}],  "+ 
                        "DrTxnType[{6}] ", 
                 _sto.getId(),
                 _sto.getDrAccount(),
                 _sto.getCrAccount(),
                 _sto.getPayAmount(),
                 _sto.getTotalToPay(),
                 _sto.getCrTxnType(),
                 _sto.getDrTxnType(),
                 _sto.getNextPayDate());
                if (EnableLog) log.info(msg);

                ProcessSTOTxn(_sto, date);
                if (EnableLog) log.info("Processing STO[" + _sto.getId()+ "] completed");
            }
            catch (Exception ex)
            {
                log.log(Level.SEVERE, "An error occurred while processing STO[" + _sto.getId() + "] completed\n", ex);
            }

        }

    }


    private void ProcessSTOTxn(STO _sto, Date date)
    {
        /*
         * STO transfers money from one account to another
         */
    	STOType stoflag = STOType.values()[ _sto.getSTOType()];
 		
        switch (stoflag)
        {
            case Normal: //Normal STO; pays the sto
                ProcessNormalSTO(_sto, date);
                break;
            case Sweep: //Sweep STO; sweeps the DrAcc
                ProcessSweepSTO(_sto, date);
                break;
            default:
                ProcessNormalSTO(_sto, date);
                break;
        }


    }

    private void ProcessNormalSTO(STO _sto, Date date)
    {
        //1. if all payments are don, return
        if (_sto.getAmountPaid() >= _sto.getTotalToPay())
        {
            // log
            if (EnableLog) log.info("STO already cleared...");
            return;
        }

        //2. compute AmountToPay
        double commission = 0, AmountNeeded = 0;
        double AmountToPay = _sto.getTotalToPay() - _sto.getAmountPaid();
        if (AmountToPay > _sto.getPayAmount())
        {
            AmountToPay = _sto.getPayAmount();
        }


        //2. compute AmountNeeded
        //get commission
        CommissionComponent comm = new CommissionComponent();
        /*Compute commission taking care of flags 
         * 1 _sto.ChargeCommFlag
         * 2 _sto.CommissionPaidFlag
         * 3 _stoCommSourceFlag
         */
        commission = comm.GetCommissionAmountForSTO(_sto);

        AmountNeeded = commission + AmountToPay; //commission will be 0 if not charged
        AccountEndpoint aep = new AccountEndpoint();
        Account acc = aep.getAccount(_sto.getDrAccount());
        double AmountAvailable = acc.getClearedBalance()-acc.getLimit();


        /*
         * Scenario A - STOpartial pay = false
         * Scenario A1 - Account has enough money for both repayment and commission
         * Scenario A2 - Account has enough money for commission only
         * Scenario A3 - Account does not have enough money even for commission 
         * 
         * Scenario B - STOpartial pay = true
         * Scenario B1 - Account has enough money for both repayment and commission
         * Scenario B2 - Account has enough money for commission only
         * Scenario B3 - Account does not have enough money even for commission 

         */

        //First and foremost charge commission
        /* 1.
        ChargeCommission takes care of
        commission == 0
        sto.CommissionPaidFlag
        sto.ChargeCommFlag
        sto.STOCommFreqFlag.NoCommission
    */
        ChargeCommission(_sto.getDrAccount(), _sto.getCrAccount(), _sto, commission, date);

        //Scenario A1 && Scenario B1
        if (AmountAvailable >= AmountNeeded)
        {
            //if account has money, post full amount
            AmountToPay = _sto.getPayAmount();
            ProcessInstallment(_sto.getDrAccount(), _sto.getCrAccount(), _sto, AmountToPay, date, AmountAvailable);
            return;
        }
        else
        {

            //Scenario A2  - taken care of Batchposting with limit checking

            //Scenario B2
            if (_sto.getPartialPay())
            {
                //account doesnt have enough money, pay whatever is there 
                AmountToPay = acc.getClearedBalance()-acc.getLimit();
                ProcessInstallment(_sto.getDrAccount(), _sto.getCrAccount(), _sto, AmountToPay, date, AmountToPay);
                return;
            }

            //Scenario A3 && Scenario B3
            if (AmountAvailable < commission)
            {
                ProcessNonPay(_sto.getDrAccount(), _sto.getCrAccount(), _sto, commission, date, AmountAvailable);
                return;
            }
        }

    }

    private void ProcessSweepSTO(STO _sto, Date date)
    {
        /*
         * Sweep everything in the account.
         * Does not consider the value sto.Payamount field
         */
    	 AccountEndpoint aep = new AccountEndpoint();
         Account acc = aep.getAccount(_sto.getDrAccount());
         double AmountAvailable = acc.getClearedBalance()-acc.getLimit();
         
        CommissionComponent comm = new CommissionComponent();
        double commission = comm.GetCommissionAmountForSTO(_sto); //get the commission for running the sto from the transaction type
        double PayAmount = AmountAvailable - commission; //minus comm coz it is going to b charged herebelow separately
        ChargeCommission(_sto.getDrAccount(), _sto.getCrAccount(), _sto, commission, date);
        ProcessInstallment(_sto.getDrAccount(), _sto.getCrAccount(), _sto, PayAmount, date, PayAmount);
    }


    private void ProcessInstallment(Long DrAcc, Long CrAcc, STO _sto, double PayAmount, Date date, double AmountAvailable)
    {

        //1. Move Money from DrAcc to CrAcc
        PostSTOTransactions(DrAcc, CrAcc, _sto, PayAmount, date);

        //2. set flags
        _sto.setAmountPaid(_sto.getAmountPaid()+ PayAmount);
        _sto.setNextPayDate (this.AddInterval(date, _sto.getInterval()));
        _sto.setNoOfPaymentsMade(_sto.getNoOfPaymentsMade()+1);
        _sto.setAmountDefaulted (_sto.getAmountDefaulted()+ (_sto.getPayAmount() - _sto.getPayAmount()));
        if (_sto.getAmountDefaulted() > 0)
        {
            _sto.setNoOfDefaults(_sto.getNoOfDefaults()+1);
            _sto.setNextPayDate(DateExtension.addDays(date, 1)) ; //keep checking every day
        }

        STOEndpoint stPost = new STOEndpoint();
        stPost.updateSTO(_sto);

        //3. log
        if (EnableLog) log.info("Payment NOT made.: AmountNeeded[" + _sto.getPayAmount() +
           "], AmountAvailable[" + AmountAvailable + "]");
    }

    private void ProcessNonPay(Long Borrower, Long Investor, STO _sto, double commission, Date date, double AmountAvailable)
    {
        _sto.setNextPayDate(DateExtension.addDays(date, 1)); //keep checking every day
        _sto.setNoOfDefaults(_sto.getNoOfDefaults()+1);
        _sto.setAmountDefaulted (_sto.getAmountDefaulted()+  _sto.getPayAmount());

        //update db
        STOEndpoint stPost = new STOEndpoint();
        stPost.UpdateSTO(_sto);
        if (EnableLog) log.Info(@"Payment NOT made.: AmountNeeded[" + _sto.PayAmount +
            "],  Commission[" + commission + "] AmountAvailable[" + AmountAvailable + "]");
    }

    private List<Transaction> MakeRepayMoneyTxns(String contraref, int DrAcc, int CrAcc, int TxnType, double Amount, Date stoCreateDate)
    {
        StaticTransactionsComponent scom = new StaticTransactionsComponent();
        TransactionType tt = scom.GetTransactionType(TxnType);
        bool forcePost = tt.ForcePost;

        List<Transaction> txns = new List<Transaction>();
        if (Amount != 0)
        {
            //Build the debit transaction 
            Transaction drtransaction = new Transaction();
            //borrower currentaccount was credited when loan was created, now debit to repay back money
            drtransaction.AccountID = DrAcc;
            drtransaction.Amount = Amount * -1;
            drtransaction.TransactionTypeId = TxnType;

            drtransaction.PostDate = stoCreateDate;
            drtransaction.RecordDate = Date.Today;

            drtransaction.ForcePostFlag = forcePost; //forcePost is implemented as a force post
            drtransaction.StatementFlag = "Y";
            drtransaction.Authorizer = "SYSTEM";
            drtransaction.UserID = "SYSTEM";
            drtransaction.Reference = Config.GetString("FANIKIWAAGENT");
            drtransaction.ContraReference = contraref;


            //Build the credit transaction
            Transaction crtransaction = new Transaction();
            //investor currentaccount was debit when loan was created, now credit to receive back money owed
            crtransaction.AccountID = CrAcc;
            crtransaction.Amount = Amount;
            crtransaction.TransactionTypeId = TxnType;

            crtransaction.PostDate = stoCreateDate;
            crtransaction.RecordDate = Date.Today;

            crtransaction.ForcePostFlag = forcePost;
            crtransaction.StatementFlag = "Y";
            crtransaction.Authorizer = "SYSTEM";
            crtransaction.UserID = "SYSTEM";
            crtransaction.Reference = Config.GetString("FANIKIWAAGENT");
            crtransaction.ContraReference = contraref;

            //Crossreference narratives
            drtransaction.Narrative = "Repayment " + crtransaction.AccountID;
            crtransaction.Narrative = "Repayment " + drtransaction.AccountID;

            txns.Add(drtransaction);
            txns.Add(crtransaction);
        }
        return txns;
    }

    private bool PostSTOTransactions(int DrAcc, int CrAcc, STO sto, double Amount, Date stoCreatedDate)
    {

        //Create Ref and contra
        string contraref = Utils.GetRandomHexNumber(10);

        List<Transaction> txns = MakeRepayMoneyTxns(contraref, DrAcc, CrAcc, sto.DrTxnType, Amount, stoCreatedDate);

        //Post
        FinancialPostingComponent fPost = new FinancialPostingComponent();

        //now request posting service to post
        fPost.BatchPostWithSimulation(txns);
        return true;
    }

    private Date AddInterval(Date d, string interval)
    {
        Date ret = d;
        switch (interval.ToUpper())
        {
            case "D":
                ret = ret.AddDays(1);
                break;

            case "M":
                ret = ret.AddMonths(1);
                break;
            case "Y":
                ret = ret.AddYears(1);
                break;
        }
        return ret;
    }

    private void ChargeCommission(int DrAcc, int CrAcc, STO sto, double commission, Date date)
    {
        if (commission == 0) return;

        if (sto.CommissionPaidFlag) return;

        if (!sto.ChargeCommFlag) return;

        if (sto.CommFreqFlag == (short)STOCommFreqFlag.NoCommission) return;

        ChargeCommissionImpl(DrAcc, CrAcc, sto, commission, date);
    }

    private void ChargeCommissionImpl(int DrAcc, int CrAcc, STO sto, double commission, Date date)
    {
        //build commission transactions

        List<Transaction> txns = new List<Transaction>();
        //Create Ref and contra
        string contraref = Utils.GetRandomHexNumber(10);

        bool forcePost = (sto.LimitFlag == (short)PostingLimitCheckFlag.ForcePost);


        /*
            1. If r.ChargeWho == 'L' // Borrower to pay commission
            2. If r.ChargeWho == 'I' // Investor to pay commission
            3. If r.ChargeWho == 'B' // Both to pay commission
         */
        switch (sto.ChargeWho)
        {
            case (short)STOCommissionChargeWho.Borrower:
                txns = MakeCommissionTxns(forcePost, contraref, DrAcc, sto, commission, date);
                break;
            case (short)STOCommissionChargeWho.Investor:
                txns = MakeCommissionTxns(forcePost, contraref, CrAcc, sto, commission, date);
                break;
            case (short)STOCommissionChargeWho.BothBorrowerAndInvestor:
                txns = MakeCommissionTxns(forcePost, contraref, DrAcc, sto, commission, date);
                txns.AddRange(MakeCommissionTxns(forcePost, contraref, CrAcc, sto, commission, date));
                break;
            default:
                break;
        }

        //Post
        FinancialPostingComponent fPost = new FinancialPostingComponent();
        //now request posting service to post with limit checking according to sto set up
        fPost.BatchPost(txns, (PostingLimitCheckFlag)sto.LimitFlag);


        //Mark STO Commission as paid
        /*
            Mark comm as paid if CommFreqFlag== STOCommFreqFlag.PayCommissionPerOnce
         */
        if (sto.CommFreqFlag == (short)STOCommFreqFlag.PayCommissionPerOnce)
        {
            sto.CommissionPaidFlag = true;
            StaticTransactionsComponent sPost = new StaticTransactionsComponent();
            sPost.UpdateSTO(sto);
        }
    }
    private List<Transaction> MakeCommissionTxns(bool forcePost, string contraref, int DrAcc, STO sto, double Amount, Date date)
    {
        List<Transaction> txns = new List<Transaction>();

        if (Amount != 0)
        {
            //Build the debit transaction 
            Transaction drtransaction = new Transaction();
            drtransaction.AccountID = DrAcc;
            drtransaction.Amount = Amount * -1;
            drtransaction.TransactionTypeId = sto.DrTxnType;

            //postdate is sto createddate
            drtransaction.PostDate = date;
            drtransaction.RecordDate = Date.Today;

            drtransaction.ForcePostFlag = forcePost;
            drtransaction.StatementFlag = "Y";
            drtransaction.Authorizer = "SYSTEM";
            drtransaction.UserID = "SYSTEM";
            drtransaction.Reference = Config.GetString("FANIKIWAAGENT");
            drtransaction.ContraReference = contraref;

            //Build the credit transaction
            int commissionAccount = sto.CommissionAccount;
            Transaction crtransaction = new Transaction();
            //credit commission account
            crtransaction.AccountID = commissionAccount;
            crtransaction.Amount = Amount;
            crtransaction.TransactionTypeId = sto.CrTxnType;

            //postdate is sto createddate
            crtransaction.PostDate = date;
            crtransaction.RecordDate = Date.Today;

            crtransaction.ForcePostFlag = forcePost;
            crtransaction.StatementFlag = "Y";
            crtransaction.Authorizer = "SYSTEM";
            crtransaction.UserID = "SYSTEM";
            crtransaction.Reference = Config.GetString("FANIKIWAAGENT");
            crtransaction.ContraReference = contraref;

            //Crossreference narratives
            drtransaction.Narrative = "Commisson " + crtransaction.AccountID;
            crtransaction.Narrative = "Credited " + drtransaction.AccountID;

            txns.Add(drtransaction);
            txns.Add(crtransaction);

        }
        return txns;
    }


    //private void ClearInvestment(Member Borrower, Member Investor, int TTYpe, double Amount, Date stoCreatedDate)
    //{
    //    try
    //    {
    //        //build commission transactions

    //        List<Transaction> txns = new List<Transaction>();
    //        //Create Ref and contra
    //        string contraref = Utils.GetRandomHexNumber(10);

    //        MakeClearInvestmentTxns(contraref, Borrower, Investor, TTYpe, Amount, txns, stoCreatedDate);
    //        //Post
    //        FinancialPostingComponent fPost = new FinancialPostingComponent();
    //        //now request posting service to post
    //        fPost.BatchPost(txns);

    //        //ask log4net to log posted transactions details
    //        foreach (var txn in txns)
    //        {
    //            infoLog.Info(string.Format("Posted ClearInvestment Transaction. AccountID: {0}, Amount: {1}, PostDate: {2}, RecordDate: {3}, Narrative: {4} ", txn.AccountID, txn.Amount, txn.PostDate, txn.RecordDate, txn.Narrative));
    //        }

    //    }
    //    catch (Exception ex)
    //    {
    //        //TODO: Handle your exceptions here. Remove any try-catch blocks if you
    //        //are not handling any exceptions.  
    //        bool rethrow = false;
    //        rethrow = BusinessLogicExceptionHandler.HandleException(ref ex);
    //        if (rethrow)
    //        {
    //            CustomExpMsg customMsg = new CustomExpMsg(ex.Message);
    //            throw new FaultException<CustomExpMsg>(customMsg,
    //                new FaultReason(customMsg.ErrorMsg),
    //                new FaultCode("ClearInvestment"));
    //        }
    //    }
    //}

    //public void MakeClearInvestmentTxns(string contraref, Member Borrower, Member Investor, int TxnType, double Amount, List<Transaction> txns, Date stoCreateDate)
    //{
    //    try
    //    {
    //        //Build the debit transaction 
    //        Transaction drtransaction = new Transaction();
    //        //investor investmentaccount was credited when loan was created, now debit to show repayment
    //        drtransaction.AccountID = Investor.InvestmentAccountId;
    //        drtransaction.Amount = Amount * -1;
    //        drtransaction.TransactionTypeId = TxnType;

    //        //postdate is sto createddate
    //        drtransaction.PostDate = stoCreateDate;
    //        drtransaction.RecordDate = Date.Today;

    //        drtransaction.ForcePostFlag = false;
    //        drtransaction.StatementFlag = "Y";
    //        drtransaction.Authorizer = "SYSTEM";
    //        drtransaction.UserID = "SYSTEM";
    //        drtransaction.Reference = Config.GetInt["FANIKIWAAGENT"];
    //        drtransaction.ContraReference = contraref;


    //        //Build the credit transaction
    //        Transaction crtransaction = new Transaction();
    //        //borrower loanaccount was debited when loan was created, now credit to show the repayment
    //        crtransaction.AccountID = Borrower.LoanAccountId;
    //        crtransaction.Amount = Amount;
    //        crtransaction.TransactionTypeId = TxnType;

    //        //postdate is sto createddate
    //        crtransaction.PostDate = stoCreateDate;
    //        crtransaction.RecordDate = Date.Today;

    //        crtransaction.ForcePostFlag = false;
    //        crtransaction.StatementFlag = "Y";
    //        crtransaction.Authorizer = "SYSTEM";
    //        crtransaction.UserID = "SYSTEM";
    //        crtransaction.Reference = Config.GetInt["FANIKIWAAGENT"];
    //        crtransaction.ContraReference = contraref;

    //        //Crossreference narratives
    //        drtransaction.Narrative = "ClearInvestment " + crtransaction.AccountID;
    //        crtransaction.Narrative = "ClearInvestment " + drtransaction.AccountID;

    //        txns.Add(drtransaction);
    //        txns.Add(crtransaction);
    //    }
    //    catch (Exception ex)
    //    {
    //        //TODO: Handle your exceptions here. Remove any try-catch blocks if you
    //        //are not handling any exceptions.  
    //        bool rethrow = false;
    //        rethrow = BusinessLogicExceptionHandler.HandleException(ref ex);
    //        if (rethrow)
    //        {
    //            CustomExpMsg customMsg = new CustomExpMsg(ex.Message);
    //            throw new FaultException<CustomExpMsg>(customMsg,
    //                new FaultReason(customMsg.ErrorMsg),
    //                new FaultCode("MakeClearInvestmentTxns"));
    //        }
    //    }
    //}


    #endregion



    #endregion


}
}