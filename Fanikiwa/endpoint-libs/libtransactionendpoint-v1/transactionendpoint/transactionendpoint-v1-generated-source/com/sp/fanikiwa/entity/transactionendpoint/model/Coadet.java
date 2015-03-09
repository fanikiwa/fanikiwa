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
 * on 2015-03-08 at 16:04:40 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.transactionendpoint.model;

/**
 * Model definition for Coadet.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the transactionendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Coadet extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Coa coa;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer coalevel;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer rorder;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String shortCode;

  /**
   * @return value or {@code null} for none
   */
  public Coa getCoa() {
    return coa;
  }

  /**
   * @param coa coa or {@code null} for none
   */
  public Coadet setCoa(Coa coa) {
    this.coa = coa;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getCoalevel() {
    return coalevel;
  }

  /**
   * @param coalevel coalevel or {@code null} for none
   */
  public Coadet setCoalevel(java.lang.Integer coalevel) {
    this.coalevel = coalevel;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public Coadet setDescription(java.lang.String description) {
    this.description = description;
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
  public Coadet setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getRorder() {
    return rorder;
  }

  /**
   * @param rorder rorder or {@code null} for none
   */
  public Coadet setRorder(java.lang.Integer rorder) {
    this.rorder = rorder;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getShortCode() {
    return shortCode;
  }

  /**
   * @param shortCode shortCode or {@code null} for none
   */
  public Coadet setShortCode(java.lang.String shortCode) {
    this.shortCode = shortCode;
    return this;
  }

  @Override
  public Coadet set(String fieldName, Object value) {
    return (Coadet) super.set(fieldName, value);
  }

  @Override
  public Coadet clone() {
    return (Coadet) super.clone();
  }

}
