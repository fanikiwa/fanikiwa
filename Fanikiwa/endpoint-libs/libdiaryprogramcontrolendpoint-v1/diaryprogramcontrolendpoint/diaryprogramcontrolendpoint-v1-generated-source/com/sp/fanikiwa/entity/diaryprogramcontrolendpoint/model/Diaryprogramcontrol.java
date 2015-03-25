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
 * on 2015-03-24 at 18:19:10 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model;

/**
 * Model definition for Diaryprogramcontrol.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the diaryprogramcontrolendpoint. For a detailed
 * explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Diaryprogramcontrol extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime lastRun;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime nextRun;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Diaryprogramcontrol setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getLastRun() {
    return lastRun;
  }

  /**
   * @param lastRun lastRun or {@code null} for none
   */
  public Diaryprogramcontrol setLastRun(com.google.api.client.util.DateTime lastRun) {
    this.lastRun = lastRun;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getNextRun() {
    return nextRun;
  }

  /**
   * @param nextRun nextRun or {@code null} for none
   */
  public Diaryprogramcontrol setNextRun(com.google.api.client.util.DateTime nextRun) {
    this.nextRun = nextRun;
    return this;
  }

  @Override
  public Diaryprogramcontrol set(String fieldName, Object value) {
    return (Diaryprogramcontrol) super.set(fieldName, value);
  }

  @Override
  public Diaryprogramcontrol clone() {
    return (Diaryprogramcontrol) super.clone();
  }

}
