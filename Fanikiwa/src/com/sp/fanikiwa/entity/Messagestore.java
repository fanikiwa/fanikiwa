package com.sp.fanikiwa.entity;

import java.math.BigDecimal;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Messagestore  {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  id;

	@Persistent
	private String amPm;

	@Persistent
	private String dateReceived;

	@Persistent
	private String dateSent;

	@Persistent
	private String firstName;
@Persistent
	private byte isDeleted;

	@Persistent
	private String lastName;

	@Persistent
	private String messageBody;

	@Persistent
	private String messageIndex;

	@Persistent
	private String messageStatus;

	@Persistent
	private String messageType;
@Persistent
	private BigDecimal mpesaAmount;
@Persistent
	private BigDecimal mpesaBalance;

	@Persistent
	private String originatingAddress;

	@Persistent
	private String originatingAddressType;

	@Persistent
	private String phoneNo;
@Persistent
	private byte processed;

	@Persistent
	private String SCTimestamp;

	@Persistent
	private String smscAddress;

	@Persistent
	private String smscAddressType;

	@Persistent
	private String status;

	@Persistent
	private String storage;

	@Persistent
	private String timeSent;

	@Persistent
	private String userDataText;

	public Messagestore() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmPm() {
		return this.amPm;
	}

	public void setAmPm(String amPm) {
		this.amPm = amPm;
	}

	public String getDateReceived() {
		return this.dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMessageBody() {
		return this.messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getMessageIndex() {
		return this.messageIndex;
	}

	public void setMessageIndex(String messageIndex) {
		this.messageIndex = messageIndex;
	}

	public String getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public BigDecimal getMpesaAmount() {
		return this.mpesaAmount;
	}

	public void setMpesaAmount(BigDecimal mpesaAmount) {
		this.mpesaAmount = mpesaAmount;
	}

	public BigDecimal getMpesaBalance() {
		return this.mpesaBalance;
	}

	public void setMpesaBalance(BigDecimal mpesaBalance) {
		this.mpesaBalance = mpesaBalance;
	}

	public String getOriginatingAddress() {
		return this.originatingAddress;
	}

	public void setOriginatingAddress(String originatingAddress) {
		this.originatingAddress = originatingAddress;
	}

	public String getOriginatingAddressType() {
		return this.originatingAddressType;
	}

	public void setOriginatingAddressType(String originatingAddressType) {
		this.originatingAddressType = originatingAddressType;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public byte getProcessed() {
		return this.processed;
	}

	public void setProcessed(byte processed) {
		this.processed = processed;
	}

	public String getSCTimestamp() {
		return this.SCTimestamp;
	}

	public void setSCTimestamp(String SCTimestamp) {
		this.SCTimestamp = SCTimestamp;
	}

	public String getSmscAddress() {
		return this.smscAddress;
	}

	public void setSmscAddress(String smscAddress) {
		this.smscAddress = smscAddress;
	}

	public String getSmscAddressType() {
		return this.smscAddressType;
	}

	public void setSmscAddressType(String smscAddressType) {
		this.smscAddressType = smscAddressType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getTimeSent() {
		return this.timeSent;
	}

	public void setTimeSent(String timeSent) {
		this.timeSent = timeSent;
	}

	public String getUserDataText() {
		return this.userDataText;
	}

	public void setUserDataText(String userDataText) {
		this.userDataText = userDataText;
	}

}