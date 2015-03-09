package com.sp.fanikiwa.entity;
 
import java.util.Date;  

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
 
 
@Entity
public class Loan   {
	
	@Id Long  id;

	private double amount;
	
	private Date createdDate;

	private double interest;
	
	private Date maturityDate;

	private int memberId;

	private int offerId;

	private byte partialPay;

	private int term;

	public Loan() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Date getMaturityDate() {
		return this.maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public byte getPartialPay() {
		return this.partialPay;
	}

	public void setPartialPay(byte partialPay) {
		this.partialPay = partialPay;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}