package com.sp.fanikiwa.entity;

import java.math.BigDecimal;
import java.util.List;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TransactionType  {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long transactionTypeID;
@Persistent
	private byte absolute;

	@Persistent
	private String amountExpression;
@Persistent
	private byte canSuspend;
@Persistent
	private byte chargeCommission;
@Persistent
	private byte chargeCommissionToTransaction;
@Persistent
	private String chargeWho;
@Persistent
	private String commComputationMethod;
@Persistent
	private BigDecimal commissionAmount;

	@Persistent
	private String commissionAmountExpression;
@Persistent
	private String commissionContraNarrative;
@Persistent
	private int commissionCrAccount;
@Persistent
	private int commissionDrAccount;
@Persistent
	private byte commissionDrAnotherAccount;
@Persistent
	private String commissionMainNarrative;
@Persistent
	private short commissionNarrativeFlag;
@Persistent
	private int commissionTransactionType;
@Persistent
	private String crCommCalcMethod;
@Persistent
	private String debitCredit;
@Persistent
	private BigDecimal defaultAmount;
@Persistent
	private int defaultContraAccount;
@Persistent
	private String defaultContraNarrative;
@Persistent
	private int defaultMainAccount;
@Persistent
	private String defaultMainNarrative;
@Persistent
	private String description;
@Persistent
	private short dialogFlag;
@Persistent
	private String drCommCalcMethod;
@Persistent
	private byte forcePost;
@Persistent
	private short narrativeFlag;
@Persistent
	private byte printReceipt;
@Persistent
	private byte printReceiptPrompt;

	@Persistent
	private String receiptLayout;

	@Persistent
	private String screen;
@Persistent
	private String shortCode;
@Persistent
	private String statFlag;
@Persistent
	private int suspenseCrAccount;
@Persistent
	private int suspenseDrAccount;
@Persistent
	private int tieredTableId;
@Persistent
	private short txnClass;
@Persistent
	private short txnTypeView;
@Persistent
	private short valueDateOffset;
@Persistent
	private List<Transaction> transactions;

	public TransactionType() {
	}

	public long getTransactionTypeID() {
		return this.transactionTypeID;
	}

	public void setTransactionTypeID(long transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}

	public byte getAbsolute() {
		return this.absolute;
	}

	public void setAbsolute(byte absolute) {
		this.absolute = absolute;
	}

	public String getAmountExpression() {
		return this.amountExpression;
	}

	public void setAmountExpression(String amountExpression) {
		this.amountExpression = amountExpression;
	}

	public byte getCanSuspend() {
		return this.canSuspend;
	}

	public void setCanSuspend(byte canSuspend) {
		this.canSuspend = canSuspend;
	}

	public byte getChargeCommission() {
		return this.chargeCommission;
	}

	public void setChargeCommission(byte chargeCommission) {
		this.chargeCommission = chargeCommission;
	}

	public byte getChargeCommissionToTransaction() {
		return this.chargeCommissionToTransaction;
	}

	public void setChargeCommissionToTransaction(byte chargeCommissionToTransaction) {
		this.chargeCommissionToTransaction = chargeCommissionToTransaction;
	}

	public String getChargeWho() {
		return this.chargeWho;
	}

	public void setChargeWho(String chargeWho) {
		this.chargeWho = chargeWho;
	}

	public String getCommComputationMethod() {
		return this.commComputationMethod;
	}

	public void setCommComputationMethod(String commComputationMethod) {
		this.commComputationMethod = commComputationMethod;
	}

	public BigDecimal getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getCommissionAmountExpression() {
		return this.commissionAmountExpression;
	}

	public void setCommissionAmountExpression(String commissionAmountExpression) {
		this.commissionAmountExpression = commissionAmountExpression;
	}

	public String getCommissionContraNarrative() {
		return this.commissionContraNarrative;
	}

	public void setCommissionContraNarrative(String commissionContraNarrative) {
		this.commissionContraNarrative = commissionContraNarrative;
	}

	public int getCommissionCrAccount() {
		return this.commissionCrAccount;
	}

	public void setCommissionCrAccount(int commissionCrAccount) {
		this.commissionCrAccount = commissionCrAccount;
	}

	public int getCommissionDrAccount() {
		return this.commissionDrAccount;
	}

	public void setCommissionDrAccount(int commissionDrAccount) {
		this.commissionDrAccount = commissionDrAccount;
	}

	public byte getCommissionDrAnotherAccount() {
		return this.commissionDrAnotherAccount;
	}

	public void setCommissionDrAnotherAccount(byte commissionDrAnotherAccount) {
		this.commissionDrAnotherAccount = commissionDrAnotherAccount;
	}

	public String getCommissionMainNarrative() {
		return this.commissionMainNarrative;
	}

	public void setCommissionMainNarrative(String commissionMainNarrative) {
		this.commissionMainNarrative = commissionMainNarrative;
	}

	public short getCommissionNarrativeFlag() {
		return this.commissionNarrativeFlag;
	}

	public void setCommissionNarrativeFlag(short commissionNarrativeFlag) {
		this.commissionNarrativeFlag = commissionNarrativeFlag;
	}

	public int getCommissionTransactionType() {
		return this.commissionTransactionType;
	}

	public void setCommissionTransactionType(int commissionTransactionType) {
		this.commissionTransactionType = commissionTransactionType;
	}

	public String getCrCommCalcMethod() {
		return this.crCommCalcMethod;
	}

	public void setCrCommCalcMethod(String crCommCalcMethod) {
		this.crCommCalcMethod = crCommCalcMethod;
	}

	public String getDebitCredit() {
		return this.debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public BigDecimal getDefaultAmount() {
		return this.defaultAmount;
	}

	public void setDefaultAmount(BigDecimal defaultAmount) {
		this.defaultAmount = defaultAmount;
	}

	public int getDefaultContraAccount() {
		return this.defaultContraAccount;
	}

	public void setDefaultContraAccount(int defaultContraAccount) {
		this.defaultContraAccount = defaultContraAccount;
	}

	public String getDefaultContraNarrative() {
		return this.defaultContraNarrative;
	}

	public void setDefaultContraNarrative(String defaultContraNarrative) {
		this.defaultContraNarrative = defaultContraNarrative;
	}

	public int getDefaultMainAccount() {
		return this.defaultMainAccount;
	}

	public void setDefaultMainAccount(int defaultMainAccount) {
		this.defaultMainAccount = defaultMainAccount;
	}

	public String getDefaultMainNarrative() {
		return this.defaultMainNarrative;
	}

	public void setDefaultMainNarrative(String defaultMainNarrative) {
		this.defaultMainNarrative = defaultMainNarrative;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getDialogFlag() {
		return this.dialogFlag;
	}

	public void setDialogFlag(short dialogFlag) {
		this.dialogFlag = dialogFlag;
	}

	public String getDrCommCalcMethod() {
		return this.drCommCalcMethod;
	}

	public void setDrCommCalcMethod(String drCommCalcMethod) {
		this.drCommCalcMethod = drCommCalcMethod;
	}

	public byte getForcePost() {
		return this.forcePost;
	}

	public void setForcePost(byte forcePost) {
		this.forcePost = forcePost;
	}

	public short getNarrativeFlag() {
		return this.narrativeFlag;
	}

	public void setNarrativeFlag(short narrativeFlag) {
		this.narrativeFlag = narrativeFlag;
	}

	public byte getPrintReceipt() {
		return this.printReceipt;
	}

	public void setPrintReceipt(byte printReceipt) {
		this.printReceipt = printReceipt;
	}

	public byte getPrintReceiptPrompt() {
		return this.printReceiptPrompt;
	}

	public void setPrintReceiptPrompt(byte printReceiptPrompt) {
		this.printReceiptPrompt = printReceiptPrompt;
	}

	public String getReceiptLayout() {
		return this.receiptLayout;
	}

	public void setReceiptLayout(String receiptLayout) {
		this.receiptLayout = receiptLayout;
	}

	public String getScreen() {
		return this.screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getStatFlag() {
		return this.statFlag;
	}

	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag;
	}

	public int getSuspenseCrAccount() {
		return this.suspenseCrAccount;
	}

	public void setSuspenseCrAccount(int suspenseCrAccount) {
		this.suspenseCrAccount = suspenseCrAccount;
	}

	public int getSuspenseDrAccount() {
		return this.suspenseDrAccount;
	}

	public void setSuspenseDrAccount(int suspenseDrAccount) {
		this.suspenseDrAccount = suspenseDrAccount;
	}

	public int getTieredTableId() {
		return this.tieredTableId;
	}

	public void setTieredTableId(int tieredTableId) {
		this.tieredTableId = tieredTableId;
	}

	public short getTxnClass() {
		return this.txnClass;
	}

	public void setTxnClass(short txnClass) {
		this.txnClass = txnClass;
	}

	public short getTxnTypeView() {
		return this.txnTypeView;
	}

	public void setTxnTypeView(short txnTypeView) {
		this.txnTypeView = txnTypeView;
	}

	public short getValueDateOffset() {
		return this.valueDateOffset;
	}

	public void setValueDateOffset(short valueDateOffset) {
		this.valueDateOffset = valueDateOffset;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setTransactionType(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setTransactionType(null);

		return transaction;
	}

}