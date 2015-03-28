package com.sp.fanikiwa.entity;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class TransactionModel {
	@Id
	Long TransactionID;
	private Date PostDate;
	private String Narrative;
	private double Debit;
	private double Credit;
	private double Balance;
	private double Amount;
	private String ContraReference;
	
	public TransactionModel()
	{
		
	}

	public Long getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Long transactionID) {
		TransactionID = transactionID;
	}

	public Date getPostDate() {
		return PostDate;
	}

	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}

	public String getNarrative() {
		return Narrative;
	}

	public void setNarrative(String narrative) {
		Narrative = narrative;
	}

	public double getDebit() {
		return Debit;
	}

	public void setDebit(double debit) {
		Debit = debit;
	}

	public double getCredit() {
		return Credit;
	}

	public void setCredit(double credit) {
		Credit = credit;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getContraReference() {
		return ContraReference;
	}

	public void setContraReference(String contraReference) {
		ContraReference = contraReference;
	}
	
}
