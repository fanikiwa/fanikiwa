package com.sp.fanikiwa.entity;

import java.util.Date;  

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
  
@Entity
public class STO  {
	
	@Id  Long  id;

	private double amountDefaulted;

	private double amountPaid;

	private byte chargeCommFlag;

	private short chargeWho;

	private short commFreqFlag;

	private int commissionAccount;

	private double commissionAmount;

	private byte commissionPaidFlag;

	private short commSourceFlag;

	private int crAccount;
	
	private Date createDate;

	private int crTxnType;

	private int drAccount;

	private int drTxnType;

	private Date endDate;

	private String interval;

	private int limitFlag;

	private int loanId;
	
	private Date nextPayDate;

	private int noOfDefaults;

	private int noOfPayments;

	private int noOfPaymentsMade;

	private byte partialPay;

	private double payAmount;

	
	private Date startDate;

	private int STOAccType;

	private int STOType;

	private double totalToPay;

	public STO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmountDefaulted() {
		return this.amountDefaulted;
	}

	public void setAmountDefaulted(double amountDefaulted) {
		this.amountDefaulted = amountDefaulted;
	}

	public double getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
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

	public double getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(double commissionAmount) {
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

	public double getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(double payAmount) {
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

	public double getTotalToPay() {
		return this.totalToPay;
	}

	public void setTotalToPay(double totalToPay) {
		this.totalToPay = totalToPay;
	}

}