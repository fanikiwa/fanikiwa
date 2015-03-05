package com.sp.fanikiwa.entity;


import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Account {

	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long accountID;
           
@Persistent
	private String accountName;

@Persistent
	private String accountNo;

@Persistent
	private double accruedInt;
@Persistent
	private double bal30;
@Persistent
	private double bal60;
@Persistent
	private double bal90;
@Persistent
	private double balOver90;
@Persistent
	private double bookBalance;
@Persistent
	private String branch;
@Persistent
	private double clearedBalance;
@Persistent
	private boolean closed;
@Persistent
	private long COAId;
@Persistent
	private long customerId;
@Persistent
	private double interestRate;
@Persistent
	private double intRate30;
@Persistent
	private double intRate60;
@Persistent
	private double intRate90;
@Persistent
	private double intRateOver90;
@Persistent
	private double limit;
@Persistent
	private int limitCheckFlag;
@Persistent
	private int limitFlag;
@Persistent
	private int passFlag;

@Persistent
	private AccountType accounttype;
@Persistent
	private List<Transaction> transaction;

	public Account() {
	}

	public Long getAccountID() {
		return this.accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAccruedInt() {
		return this.accruedInt;
	}

	public void setAccruedInt(double accruedInt) {
		this.accruedInt = accruedInt;
	}

	public double getBal30() {
		return this.bal30;
	}

	public void setBal30(double bal30) {
		this.bal30 = bal30;
	}

	public double getBal60() {
		return this.bal60;
	}

	public void setBal60(double bal60) {
		this.bal60 = bal60;
	}

	public double getBal90() {
		return this.bal90;
	}

	public void setBal90(double bal90) {
		this.bal90 = bal90;
	}

	public double getBalOver90() {
		return this.balOver90;
	}

	public void setBalOver90(double balOver90) {
		this.balOver90 = balOver90;
	}

	public double getBookBalance() {
		return this.bookBalance;
	}

	public void setBookBalance(double bookBalance) {
		this.bookBalance = bookBalance;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getClearedBalance() {
		return this.clearedBalance;
	}

	public void setClearedBalance(double clearedBalance) {
		this.clearedBalance = clearedBalance;
	}

	public boolean getClosed() {
		return this.closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public long getCOAId() {
		return this.COAId;
	}

	public void setCOAId(int COAId) {
		this.COAId = COAId;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getIntRate30() {
		return this.intRate30;
	}

	public void setIntRate30(double intRate30) {
		this.intRate30 = intRate30;
	}

	public double getIntRate60() {
		return this.intRate60;
	}

	public void setIntRate60(double intRate60) {
		this.intRate60 = intRate60;
	}

	public double getIntRate90() {
		return this.intRate90;
	}

	public void setIntRate90(double intRate90) {
		this.intRate90 = intRate90;
	}

	public double getIntRateOver90() {
		return this.intRateOver90;
	}

	public void setIntRateOver90(double intRateOver90) {
		this.intRateOver90 = intRateOver90;
	}

	public double getLimit() {
		return this.limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public int getLimitCheckFlag() {
		return this.limitCheckFlag;
	}

	public void setLimitCheckFlag(int limitCheckFlag) {
		this.limitCheckFlag = limitCheckFlag;
	}

	public int getLimitFlag() {
		return this.limitFlag;
	}

	public void setLimitFlag(int i) {
		this.limitFlag = i;
	}

	public int getPassFlag() {
		return this.passFlag;
	}

	public void setPassFlag(int i) {
		this.passFlag = i;
	}

	public AccountType getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(AccountType accounttype) {
		this.accounttype = accounttype;
	}

	public List<Transaction> getTransaction() {
		return this.transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransaction().add(transaction);
		transaction.setAccount(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransaction().remove(transaction);
		transaction.setAccount(null);

		return transaction;
	}

}