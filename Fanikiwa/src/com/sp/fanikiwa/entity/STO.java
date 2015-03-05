package com.sp.fanikiwa.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class STO  {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  id;
@Persistent
	private BigDecimal amountDefaulted;
@Persistent
	private BigDecimal amountPaid;
@Persistent
	private byte chargeCommFlag;
@Persistent
	private short chargeWho;
@Persistent
	private short commFreqFlag;
@Persistent
	private int commissionAccount;
@Persistent
	private BigDecimal commissionAmount;
@Persistent
	private byte commissionPaidFlag;
@Persistent
	private short commSourceFlag;
@Persistent
	private int crAccount;

	@Persistent
	private Date createDate;
@Persistent
	private int crTxnType;
@Persistent
	private int drAccount;
@Persistent
	private int drTxnType;
@Persistent
	private Date endDate;
@Persistent
	private String interval;
@Persistent
	private int limitFlag;
@Persistent
	private int loanId;

	@Persistent
	private Date nextPayDate;
@Persistent
	private int noOfDefaults;
@Persistent
	private int noOfPayments;
@Persistent
	private int noOfPaymentsMade;
@Persistent
	private byte partialPay;
@Persistent
	private BigDecimal payAmount;

	@Persistent
	private Date startDate;
@Persistent
	private int STOAccType;
@Persistent
	private int STOType;
@Persistent
	private BigDecimal totalToPay;

	public STO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmountDefaulted() {
		return this.amountDefaulted;
	}

	public void setAmountDefaulted(BigDecimal amountDefaulted) {
		this.amountDefaulted = amountDefaulted;
	}

	public BigDecimal getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public byte getChargeCommFlag() {
		return this.chargeCommFlag;
	}

	public void setChargeCommFlag(byte chargeCommFlag) {
		this.chargeCommFlag = chargeCommFlag;
	}

	public short getChargeWho() {
		return this.chargeWho;
	}

	public void setChargeWho(short chargeWho) {
		this.chargeWho = chargeWho;
	}

	public short getCommFreqFlag() {
		return this.commFreqFlag;
	}

	public void setCommFreqFlag(short commFreqFlag) {
		this.commFreqFlag = commFreqFlag;
	}

	public int getCommissionAccount() {
		return this.commissionAccount;
	}

	public void setCommissionAccount(int commissionAccount) {
		this.commissionAccount = commissionAccount;
	}

	public BigDecimal getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public byte getCommissionPaidFlag() {
		return this.commissionPaidFlag;
	}

	public void setCommissionPaidFlag(byte commissionPaidFlag) {
		this.commissionPaidFlag = commissionPaidFlag;
	}

	public short getCommSourceFlag() {
		return this.commSourceFlag;
	}

	public void setCommSourceFlag(short commSourceFlag) {
		this.commSourceFlag = commSourceFlag;
	}

	public int getCrAccount() {
		return this.crAccount;
	}

	public void setCrAccount(int crAccount) {
		this.crAccount = crAccount;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCrTxnType() {
		return this.crTxnType;
	}

	public void setCrTxnType(int crTxnType) {
		this.crTxnType = crTxnType;
	}

	public int getDrAccount() {
		return this.drAccount;
	}

	public void setDrAccount(int drAccount) {
		this.drAccount = drAccount;
	}

	public int getDrTxnType() {
		return this.drTxnType;
	}

	public void setDrTxnType(int drTxnType) {
		this.drTxnType = drTxnType;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInterval() {
		return this.interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public int getLimitFlag() {
		return this.limitFlag;
	}

	public void setLimitFlag(int limitFlag) {
		this.limitFlag = limitFlag;
	}

	public int getLoanId() {
		return this.loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getNextPayDate() {
		return this.nextPayDate;
	}

	public void setNextPayDate(Date nextPayDate) {
		this.nextPayDate = nextPayDate;
	}

	public int getNoOfDefaults() {
		return this.noOfDefaults;
	}

	public void setNoOfDefaults(int noOfDefaults) {
		this.noOfDefaults = noOfDefaults;
	}

	public int getNoOfPayments() {
		return this.noOfPayments;
	}

	public void setNoOfPayments(int noOfPayments) {
		this.noOfPayments = noOfPayments;
	}

	public int getNoOfPaymentsMade() {
		return this.noOfPaymentsMade;
	}

	public void setNoOfPaymentsMade(int noOfPaymentsMade) {
		this.noOfPaymentsMade = noOfPaymentsMade;
	}

	public byte getPartialPay() {
		return this.partialPay;
	}

	public void setPartialPay(byte partialPay) {
		this.partialPay = partialPay;
	}

	public BigDecimal getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getSTOAccType() {
		return this.STOAccType;
	}

	public void setSTOAccType(int STOAccType) {
		this.STOAccType = STOAccType;
	}

	public int getSTOType() {
		return this.STOType;
	}

	public void setSTOType(int STOType) {
		this.STOType = STOType;
	}

	public BigDecimal getTotalToPay() {
		return this.totalToPay;
	}

	public void setTotalToPay(BigDecimal totalToPay) {
		this.totalToPay = totalToPay;
	}

}