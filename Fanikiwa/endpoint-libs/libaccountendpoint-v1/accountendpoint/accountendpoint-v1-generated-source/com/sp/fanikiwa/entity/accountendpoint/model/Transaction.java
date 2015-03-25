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
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-24 at 18:06:00 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for Transaction.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Transaction extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Account account;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double amount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String authorizer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String contraReference;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean forcePostFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String narrative;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime postDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime recordDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String reference;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String statementFlag;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long transactionID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private TransactionType transactionType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String userID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime valueDate;

  /**
   * @return value or {@code null} for none
   */
  public Account getAccount() {
    return account;
  }

  /**
   * @param account account or {@code null} for none
   */
  public Transaction setAccount(Account account) {
    this.account = account;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAmount() {
    return amount;
  }

  /**
   * @param amount amount or {@code null} for none
   */
  public Transaction setAmount(java.lang.Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAuthorizer() {
    return authorizer;
  }

  /**
   * @param authorizer authorizer or {@code null} for none
   */
  public Transaction setAuthorizer(java.lang.String authorizer) {
    this.authorizer = authorizer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getContraReference() {
    return contraReference;
  }

  /**
   * @param contraReference contraReference or {@code null} for none
   */
  public Transaction setContraReference(java.lang.String contraReference) {
    this.contraReference = contraReference;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getForcePostFlag() {
    return forcePostFlag;
  }

  /**
   * @param forcePostFlag forcePostFlag or {@code null} for none
   */
  public Transaction setForcePostFlag(java.lang.Boolean forcePostFlag) {
    this.forcePostFlag = forcePostFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNarrative() {
    return narrative;
  }

  /**
   * @param narrative narrative or {@code null} for none
   */
  public Transaction setNarrative(java.lang.String narrative) {
    this.narrative = narrative;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getPostDate() {
    return postDate;
  }

  /**
   * @param postDate postDate or {@code null} for none
   */
  public Transaction setPostDate(com.google.api.client.util.DateTime postDate) {
    this.postDate = postDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getRecordDate() {
    return recordDate;
  }

  /**
   * @param recordDate recordDate or {@code null} for none
   */
  public Transaction setRecordDate(com.google.api.client.util.DateTime recordDate) {
    this.recordDate = recordDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getReference() {
    return reference;
  }

  /**
   * @param reference reference or {@code null} for none
   */
  public Transaction setReference(java.lang.String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getStatementFlag() {
    return statementFlag;
  }

  /**
   * @param statementFlag statementFlag or {@code null} for none
   */
  public Transaction setStatementFlag(java.lang.String statementFlag) {
    this.statementFlag = statementFlag;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTransactionID() {
    return transactionID;
  }

  /**
   * @param transactionID transactionID or {@code null} for none
   */
  public Transaction setTransactionID(java.lang.Long transactionID) {
    this.transactionID = transactionID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public TransactionType getTransactionType() {
    return transactionType;
  }

  /**
   * @param transactionType transactionType or {@code null} for none
   */
  public Transaction setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getUserID() {
    return userID;
  }

  /**
   * @param userID userID or {@code null} for none
   */
  public Transaction setUserID(java.lang.String userID) {
    this.userID = userID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getValueDate() {
    return valueDate;
  }

  /**
   * @param valueDate valueDate or {@code null} for none
   */
  public Transaction setValueDate(com.google.api.client.util.DateTime valueDate) {
    this.valueDate = valueDate;
    return this;
  }

  @Override
  public Transaction set(String fieldName, Object value) {
    return (Transaction) super.set(fieldName, value);
  }

  @Override
  public Transaction clone() {
    return (Transaction) super.clone();
  }

}
