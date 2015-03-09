package com.sp.fanikiwa.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.googlecode.objectify.annotation.Id;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Offer  {
	
	@Id Long id;

	private BigDecimal amount;

	
	private Date createdDate;

	
	private String description;

	private Date expiryDate;

	private double interest;

	private int memberId;

	
	private String offerees;

	private String offerType;

	private byte partialPay;

	private String publicOffer;

	private String status;

	private int term;

	public Offer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getOfferees() {
		return this.offerees;
	}

	public void setOfferees(String offerees) {
		this.offerees = offerees;
	}

	public String getOfferType() {
		return this.offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public byte getPartialPay() {
		return this.partialPay;
	}

	public void setPartialPay(byte partialPay) {
		this.partialPay = partialPay;
	}

	public String getPublicOffer() {
		return this.publicOffer;
	}

	public void setPublicOffer(String publicOffer) {
		this.publicOffer = publicOffer;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}