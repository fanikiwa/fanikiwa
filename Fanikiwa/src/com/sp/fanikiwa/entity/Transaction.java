package com.sp.fanikiwa.entity;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Transaction  {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  transactionID;
@Persistent
	private double amount;
@Persistent
	private String authorizer;
@Persistent
	private String contraReference;
@Persistent
	private boolean forcePostFlag;

	@Persistent
	private String narrative;

	@Persistent
	private Date postDate;

	@Persistent
	private Date recordDate;
@Persistent
	private String reference;
@Persistent
	private String statementFlag;
@Persistent
	private String userID;

	@Persistent
	private Date valueDate;

	@Persistent
	private Account account;

	@Persistent
	private TransactionType transactiontype;

	public Transaction() {
	}

	public long getTransactionID() {
		return this.transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAuthorizer() {
		return this.authorizer;
	}

	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}

	public String getContraReference() {
		return this.contraReference;
	}

	public void setContraReference(String contraReference) {
		this.contraReference = contraReference;
	}

	public boolean getForcePostFlag() {
		return this.forcePostFlag;
	}

	public void setForcePostFlag(boolean forcePostFlag) {
		this.forcePostFlag = forcePostFlag;
	}

	public String getNarrative() {
		return this.narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public Date getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStatementFlag() {
		return this.statementFlag;
	}

	public void setStatementFlag(String statementFlag) {
		this.statementFlag = statementFlag;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getValueDate() {
		return this.valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TransactionType getTransactionType() {
		return this.transactiontype;
	}

	public void setTransactionType(TransactionType transactiontype) {
		this.transactiontype = transactiontype;
	}

	

}