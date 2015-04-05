package com.sp.fanikiwa.business.financialtransactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.server.spi.response.BadRequestException;
import com.sp.fanikiwa.Enums.FinanceTransactionType;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.api.TransactionTypeEndpoint;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.DoubleEntry;
import com.sp.fanikiwa.entity.MultiEntry;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.utils.Config;
import com.sp.utils.GLUtil;

public class TransactionFactory {
	public static List<Transaction> CreateTransactionsFromTransactionType(TransactionType tt,
			Date PostDate,
            Account DrAccount,
            Account CrAccount,
            double Amount,
            String Narr,
            String reference,
           String UserID,
           String Authorizer) throws Exception
        {
            /*
             * DR & CR Whatever the TType says
             */
            //1. Get the transaction type
            //throw the deposit in suspense if account does not exist
            
            //2. Get Accounts

		Account MainAcc; Account ContraAcc;
            if ("D".equals(tt.getDebitCredit())) //is a debit transation
            {
                MainAcc = DrAccount;
                ContraAcc = CrAccount;
            }
            else //is a credit transaction
            {
                MainAcc = CrAccount; 
                ContraAcc =DrAccount;
            }

            // 1.1 Get suspense accounts
            if (tt.getCanSuspend())
            { 
                if (tt.getSuspenseDrAccount() == 0)
                    throw new BadRequestException("SuspenseDrAccount does not exist");
                if (!GLUtil.AccountExists(tt.getSuspenseDrAccount()))
                    throw new BadRequestException("SuspenseDrAccount does not exist");

                if (tt.getSuspenseCrAccount() == 0)
                    throw new BadRequestException("SuspenseCrAccount does not exist");
                if (!GLUtil.AccountExists(tt.getSuspenseCrAccount()))
                    throw new BadRequestException("SuspenseCrAccount does not exist");

                AccountEndpoint aep = new AccountEndpoint();
                if(!GLUtil.AccountExists(MainAcc.getAccountID())) MainAcc = aep.getAccount( tt.getSuspenseDrAccount());
                if (!GLUtil.AccountExists(ContraAcc.getAccountID())) ContraAcc = aep.getAccount( tt.getSuspenseCrAccount());
            }


            //3. Get the transaction type
            
            GenericTransaction gt = new GenericTransaction(tt, tt.getShortCode(),
            	PostDate,
                ContraAcc,
                MainAcc,
                Amount,
                tt.getForcePost(),
                tt.getStatFlag(),
                UserID,
                Authorizer,
                reference);

            //4. Configure gt according to transaction type
            //eg a) dp.CommissionTransactionType = MPESACOMMACC
            TransactionTypeEndpoint tep = new TransactionTypeEndpoint();
            gt.CommissionTransactionType = tep.getTransactionType( tt.getCommissionTransactionType());
            gt.Narrative = Narr;
            

            //5.Get the GL transactions
            List<Transaction> txns = new ArrayList<Transaction>();
            
            //5.1 change formatting of narratives here
            NarrativeFormat fmt = new NarrativeFormat(tt);
            boolean useTTNarrative=false;
            if (tt.getNarrativeFlag() == 1) useTTNarrative = true;
            //5.2 Get transctions double entry
            DoubleEntry de = gt.GetDoubleEntry(fmt, useTTNarrative);
            if (de.getCr() != null) txns.add(de.getCr());
            if (de.getDr() != null) txns.add(de.getDr());

            //5.3 charge commission if need be

            if (tt.getChargeCommission())
            {
                DoubleEntry comm = gt.GetCommissionTransaction(fmt, useTTNarrative);
                if (comm.getCr() != null) txns.add(comm.getCr());
                if (comm.getDr() != null) txns.add(comm.getDr());
            }

            if (tt.getChargeCommissionToTransaction())
            {
                return gt.GetChargeCommissionToTransaction(fmt, useTTNarrative);
            }


            return txns;
        }
	public static List<Transaction> Deposit(TransactionType tt,
            Account Draccount,
            Account CrAccount,
            double Amount,
            String Narr,
            String reference,
            String UserID,
            String Authorizer) throws Exception
        {

            return CreateTransactionsFromTransactionType(
                  tt,
                  new Date(),
              Draccount,
              CrAccount,
              Amount,
              Narr,
              reference,
              UserID,
              Authorizer);
        }
	public static List<Transaction> MpesaDeposit(Long AccountId,
            double Amount,
            String Narr,
            String reference) throws Exception
        {
            Account ContraAcc = Config.GetAccount("MPESACASHACCOUNT");
            Account Suspense = Config.GetAccount("MPESASUSPENSEACCOUNT");
            TransactionType tt = Config.GetTransactionType("MPESADEPOSITTRANSACTIONTYPE");
            
            //Dr Acc
            AccountEndpoint aep = new AccountEndpoint();
            Account Draccount = aep.getAccount(AccountId);
            if (Draccount == null) Draccount = Suspense;
            	
            //Cr Acc
            if (tt.getDefaultMainAccount() != 0) 
            	ContraAcc = aep.getAccount(tt.getDefaultMainAccount());

            return Deposit(tt,
             Draccount,
            ContraAcc,
             Amount,
             Narr,
             reference,
             "SYS",
             "SYS");
        }
	public static List<Transaction> Withdraw(TransactionType TransactionType,
		    Account Draccount,
		    Account CrAccount,
		    double Amount,
		    String Narr,
		    String reference,
		    String UserID,
		    String Authorizer) throws Exception
		        {
		            return CreateTransactionsFromTransactionType(
		                  TransactionType,
		                  new Date(),
		              Draccount,
		              CrAccount,
		              Amount,
		              Narr,
		              reference,
		              UserID,
		              Authorizer);
		        }

	//Diary Transactions

	public static List<Transaction> LoanRepayment(TransactionType TransactionType,
			Date PostDate,
		    Account Draccount,
		    Account CrAccount,
		    double Amount,
		    String Narr,
		    String reference,
		    String UserID,
		    String Authorizer) throws Exception
		        {
		            return CreateTransactionsFromTransactionType(
		                  TransactionType,PostDate,
		              Draccount,
		              CrAccount,
		              Amount,
		              Narr,
		              reference,
		              UserID,
		              Authorizer);
		        }
}
