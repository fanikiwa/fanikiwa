package com.sp.fanikiwa.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class OfferReceipient   {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long offerReceipientId;
@Persistent
	private String idType;
@Persistent
	private String mailingGroup;

	@Persistent
	private String memberEmail;
@Persistent
	private int memberId;
@Persistent
	private String memberTelno;
@Persistent
	private int offerId;

	public OfferReceipient() {
	}

	public long getOfferReceipientId() {
		return this.offerReceipientId;
	}

	public void setOfferReceipientId(long offerReceipientId) {
		this.offerReceipientId = offerReceipientId;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getMailingGroup() {
		return this.mailingGroup;
	}

	public void setMailingGroup(String mailingGroup) {
		this.mailingGroup = mailingGroup;
	}

	public String getMemberEmail() {
		return this.memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberTelno() {
		return this.memberTelno;
	}

	public void setMemberTelno(String memberTelno) {
		this.memberTelno = memberTelno;
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

}