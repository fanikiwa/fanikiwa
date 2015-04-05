/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-04-04 at 17:35:34 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.stoendpoint.model;

/**
 * Model definition for STO.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the stoendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class STO extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double amountDefaulted;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double amountPaid;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean chargeCommFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer chargeWho;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer commFreqFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer commSourceFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long commissionAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double commissionAmount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean commissionPaidFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long crAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long crTxnType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long drAccount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long drTxnType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime endDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer feesFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String interval;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer limitFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long loanId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime nextPayDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer noOfDefaults;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer noOfPayments;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer noOfPaymentsMade;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean partialPay;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double payAmount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime startDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer stoaccType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer stotype;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double totalToPay;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAmountDefaulted() {
    return amountDefaulted;
  }

  /**
   * @param amountDefaulted amountDefaulted or {@code null} for none
   */
  public STO setAmountDefaulted(java.lang.Double amountDefaulted) {
    this.amountDefaulted = amountDefaulted;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAmountPaid() {
    return amountPaid;
  }

  /**
   * @param amountPaid amountPaid or {@code null} for none
   */
  public STO setAmountPaid(java.lang.Double amountPaid) {
    this.amountPaid = amountPaid;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getChargeCommFlag() {
    return chargeCommFlag;
  }

  /**
   * @param chargeCommFlag chargeCommFlag or {@code null} for none
   */
  public STO setChargeCommFlag(java.lang.Boolean chargeCommFlag) {
    this.chargeCommFlag = chargeCommFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getChargeWho() {
    return chargeWho;
  }

  /**
   * @param chargeWho chargeWho or {@code null} for none
   */
  public STO setChargeWho(java.lang.Integer chargeWho) {
    this.chargeWho = chargeWho;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getCommFreqFlag() {
    return commFreqFlag;
  }

  /**
   * @param commFreqFlag commFreqFlag or {@code null} for none
   */
  public STO setCommFreqFlag(java.lang.Integer commFreqFlag) {
    this.commFreqFlag = commFreqFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getCommSourceFlag() {
    return commSourceFlag;
  }

  /**
   * @param commSourceFlag commSourceFlag or {@code null} for none
   */
  public STO setCommSourceFlag(java.lang.Integer commSourceFlag) {
    this.commSourceFlag = commSourceFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCommissionAccount() {
    return commissionAccount;
  }

  /**
   * @param commissionAccount commissionAccount or {@code null} for none
   */
  public STO setCommissionAccount(java.lang.Long commissionAccount) {
    this.commissionAccount = commissionAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getCommissionAmount() {
    return commissionAmount;
  }

  /**
   * @param commissionAmount commissionAmount or {@code null} for none
   */
  public STO setCommissionAmount(java.lang.Double commissionAmount) {
    this.commissionAmount = commissionAmount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getCommissionPaidFlag() {
    return commissionPaidFlag;
  }

  /**
   * @param commissionPaidFlag commissionPaidFlag or {@code null} for none
   */
  public STO setCommissionPaidFlag(java.lang.Boolean commissionPaidFlag) {
    this.commissionPaidFlag = commissionPaidFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCrAccount() {
    return crAccount;
  }

  /**
   * @param crAccount crAccount or {@code null} for none
   */
  public STO setCrAccount(java.lang.Long crAccount) {
    this.crAccount = crAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getCrTxnType() {
    return crTxnType;
  }

  /**
   * @param crTxnType crTxnType or {@code null} for none
   */
  public STO setCrTxnType(java.lang.Long crTxnType) {
    this.crTxnType = crTxnType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate createDate or {@code null} for none
   */
  public STO setCreateDate(com.google.api.client.util.DateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getDrAccount() {
    return drAccount;
  }

  /**
   * @param drAccount drAccount or {@code null} for none
   */
  public STO setDrAccount(java.lang.Long drAccount) {
    this.drAccount = drAccount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getDrTxnType() {
    return drTxnType;
  }

  /**
   * @param drTxnType drTxnType or {@code null} for none
   */
  public STO setDrTxnType(java.lang.Long drTxnType) {
    this.drTxnType = drTxnType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getEndDate() {
    return endDate;
  }

  /**
   * @param endDate endDate or {@code null} for none
   */
  public STO setEndDate(com.google.api.client.util.DateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getFeesFlag() {
    return feesFlag;
  }

  /**
   * @param feesFlag feesFlag or {@code null} for none
   */
  public STO setFeesFlag(java.lang.Integer feesFlag) {
    this.feesFlag = feesFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public STO setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getInterval() {
    return interval;
  }

  /**
   * @param interval interval or {@code null} for none
   */
  public STO setInterval(java.lang.String interval) {
    this.interval = interval;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getLimitFlag() {
    return limitFlag;
  }

  /**
   * @param limitFlag limitFlag or {@code null} for none
   */
  public STO setLimitFlag(java.lang.Integer limitFlag) {
    this.limitFlag = limitFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getLoanId() {
    return loanId;
  }

  /**
   * @param loanId loanId or {@code null} for none
   */
  public STO setLoanId(java.lang.Long loanId) {
    this.loanId = loanId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getNextPayDate() {
    return nextPayDate;
  }

  /**
   * @param nextPayDate nextPayDate or {@code null} for none
   */
  public STO setNextPayDate(com.google.api.client.util.DateTime nextPayDate) {
    this.nextPayDate = nextPayDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNoOfDefaults() {
    return noOfDefaults;
  }

  /**
   * @param noOfDefaults noOfDefaults or {@code null} for none
   */
  public STO setNoOfDefaults(java.lang.Integer noOfDefaults) {
    this.noOfDefaults = noOfDefaults;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNoOfPayments() {
    return noOfPayments;
  }

  /**
   * @param noOfPayments noOfPayments or {@code null} for none
   */
  public STO setNoOfPayments(java.lang.Integer noOfPayments) {
    this.noOfPayments = noOfPayments;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNoOfPaymentsMade() {
    return noOfPaymentsMade;
  }

  /**
   * @param noOfPaymentsMade noOfPaymentsMade or {@code null} for none
   */
  public STO setNoOfPaymentsMade(java.lang.Integer noOfPaymentsMade) {
    this.noOfPaymentsMade = noOfPaymentsMade;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getPartialPay() {
    return partialPay;
  }

  /**
   * @param partialPay partialPay or {@code null} for none
   */
  public STO setPartialPay(java.lang.Boolean partialPay) {
    this.partialPay = partialPay;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getPayAmount() {
    return payAmount;
  }

  /**
   * @param payAmount payAmount or {@code null} for none
   */
  public STO setPayAmount(java.lang.Double payAmount) {
    this.payAmount = payAmount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getStartDate() {
    return startDate;
  }

  /**
   * @param startDate startDate or {@code null} for none
   */
  public STO setStartDate(com.google.api.client.util.DateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getStoaccType() {
    return stoaccType;
  }

  /**
   * @param stoaccType stoaccType or {@code null} for none
   */
  public STO setStoaccType(java.lang.Integer stoaccType) {
    this.stoaccType = stoaccType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getStotype() {
    return stotype;
  }

  /**
   * @param stotype stotype or {@code null} for none
   */
  public STO setStotype(java.lang.Integer stotype) {
    this.stotype = stotype;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getTotalToPay() {
    return totalToPay;
  }

  /**
   * @param totalToPay totalToPay or {@code null} for none
   */
  public STO setTotalToPay(java.lang.Double totalToPay) {
    this.totalToPay = totalToPay;
    return this;
  }

  @Override
  public STO set(String fieldName, Object value) {
    return (STO) super.set(fieldName, value);
  }

  @Override
  public STO clone() {
    return (STO) super.clone();
  }

}
