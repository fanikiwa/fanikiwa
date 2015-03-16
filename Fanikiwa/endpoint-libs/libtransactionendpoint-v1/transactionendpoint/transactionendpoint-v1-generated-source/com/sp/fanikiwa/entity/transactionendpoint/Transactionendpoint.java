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
 * on 2015-03-16 at 08:02:17 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.transactionendpoint;

/**
 * Service definition for Transactionendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link TransactionendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Transactionendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the transactionendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://fanikiwaweb.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "transactionendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Transactionendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Transactionendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getTransaction".
   *
   * This request holds the parameters needed by the transactionendpoint server.  After setting any
   * optional parameters, call the {@link GetTransaction#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetTransaction getTransaction(java.lang.Long id) throws java.io.IOException {
    GetTransaction result = new GetTransaction(id);
    initialize(result);
    return result;
  }

  public class GetTransaction extends TransactionendpointRequest<com.sp.fanikiwa.entity.transactionendpoint.model.Transaction> {

    private static final String REST_PATH = "transaction/{id}";

    /**
     * Create a request for the method "getTransaction".
     *
     * This request holds the parameters needed by the the transactionendpoint server.  After setting
     * any optional parameters, call the {@link GetTransaction#execute()} method to invoke the remote
     * operation. <p> {@link GetTransaction#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetTransaction(java.lang.Long id) {
      super(Transactionendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.transactionendpoint.model.Transaction.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetTransaction setAlt(java.lang.String alt) {
      return (GetTransaction) super.setAlt(alt);
    }

    @Override
    public GetTransaction setFields(java.lang.String fields) {
      return (GetTransaction) super.setFields(fields);
    }

    @Override
    public GetTransaction setKey(java.lang.String key) {
      return (GetTransaction) super.setKey(key);
    }

    @Override
    public GetTransaction setOauthToken(java.lang.String oauthToken) {
      return (GetTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public GetTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetTransaction setQuotaUser(java.lang.String quotaUser) {
      return (GetTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetTransaction setUserIp(java.lang.String userIp) {
      return (GetTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetTransaction setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetTransaction set(String parameterName, Object value) {
      return (GetTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertTransaction".
   *
   * This request holds the parameters needed by the transactionendpoint server.  After setting any
   * optional parameters, call the {@link InsertTransaction#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.transactionendpoint.model.Transaction}
   * @return the request
   */
  public InsertTransaction insertTransaction(com.sp.fanikiwa.entity.transactionendpoint.model.Transaction content) throws java.io.IOException {
    InsertTransaction result = new InsertTransaction(content);
    initialize(result);
    return result;
  }

  public class InsertTransaction extends TransactionendpointRequest<com.sp.fanikiwa.entity.transactionendpoint.model.Transaction> {

    private static final String REST_PATH = "transaction";

    /**
     * Create a request for the method "insertTransaction".
     *
     * This request holds the parameters needed by the the transactionendpoint server.  After setting
     * any optional parameters, call the {@link InsertTransaction#execute()} method to invoke the
     * remote operation. <p> {@link InsertTransaction#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.transactionendpoint.model.Transaction}
     * @since 1.13
     */
    protected InsertTransaction(com.sp.fanikiwa.entity.transactionendpoint.model.Transaction content) {
      super(Transactionendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.transactionendpoint.model.Transaction.class);
    }

    @Override
    public InsertTransaction setAlt(java.lang.String alt) {
      return (InsertTransaction) super.setAlt(alt);
    }

    @Override
    public InsertTransaction setFields(java.lang.String fields) {
      return (InsertTransaction) super.setFields(fields);
    }

    @Override
    public InsertTransaction setKey(java.lang.String key) {
      return (InsertTransaction) super.setKey(key);
    }

    @Override
    public InsertTransaction setOauthToken(java.lang.String oauthToken) {
      return (InsertTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertTransaction setQuotaUser(java.lang.String quotaUser) {
      return (InsertTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertTransaction setUserIp(java.lang.String userIp) {
      return (InsertTransaction) super.setUserIp(userIp);
    }

    @Override
    public InsertTransaction set(String parameterName, Object value) {
      return (InsertTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listTransaction".
   *
   * This request holds the parameters needed by the transactionendpoint server.  After setting any
   * optional parameters, call the {@link ListTransaction#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListTransaction listTransaction() throws java.io.IOException {
    ListTransaction result = new ListTransaction();
    initialize(result);
    return result;
  }

  public class ListTransaction extends TransactionendpointRequest<com.sp.fanikiwa.entity.transactionendpoint.model.CollectionResponseTransaction> {

    private static final String REST_PATH = "transaction";

    /**
     * Create a request for the method "listTransaction".
     *
     * This request holds the parameters needed by the the transactionendpoint server.  After setting
     * any optional parameters, call the {@link ListTransaction#execute()} method to invoke the remote
     * operation. <p> {@link ListTransaction#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListTransaction() {
      super(Transactionendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.transactionendpoint.model.CollectionResponseTransaction.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListTransaction setAlt(java.lang.String alt) {
      return (ListTransaction) super.setAlt(alt);
    }

    @Override
    public ListTransaction setFields(java.lang.String fields) {
      return (ListTransaction) super.setFields(fields);
    }

    @Override
    public ListTransaction setKey(java.lang.String key) {
      return (ListTransaction) super.setKey(key);
    }

    @Override
    public ListTransaction setOauthToken(java.lang.String oauthToken) {
      return (ListTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public ListTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListTransaction setQuotaUser(java.lang.String quotaUser) {
      return (ListTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListTransaction setUserIp(java.lang.String userIp) {
      return (ListTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListTransaction setCount(java.lang.Integer count) {
      this.count = count;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListTransaction setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListTransaction set(String parameterName, Object value) {
      return (ListTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeTransaction".
   *
   * This request holds the parameters needed by the transactionendpoint server.  After setting any
   * optional parameters, call the {@link RemoveTransaction#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveTransaction removeTransaction(java.lang.Long id) throws java.io.IOException {
    RemoveTransaction result = new RemoveTransaction(id);
    initialize(result);
    return result;
  }

  public class RemoveTransaction extends TransactionendpointRequest<Void> {

    private static final String REST_PATH = "transaction/{id}";

    /**
     * Create a request for the method "removeTransaction".
     *
     * This request holds the parameters needed by the the transactionendpoint server.  After setting
     * any optional parameters, call the {@link RemoveTransaction#execute()} method to invoke the
     * remote operation. <p> {@link RemoveTransaction#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveTransaction(java.lang.Long id) {
      super(Transactionendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveTransaction setAlt(java.lang.String alt) {
      return (RemoveTransaction) super.setAlt(alt);
    }

    @Override
    public RemoveTransaction setFields(java.lang.String fields) {
      return (RemoveTransaction) super.setFields(fields);
    }

    @Override
    public RemoveTransaction setKey(java.lang.String key) {
      return (RemoveTransaction) super.setKey(key);
    }

    @Override
    public RemoveTransaction setOauthToken(java.lang.String oauthToken) {
      return (RemoveTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveTransaction setQuotaUser(java.lang.String quotaUser) {
      return (RemoveTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveTransaction setUserIp(java.lang.String userIp) {
      return (RemoveTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveTransaction setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveTransaction set(String parameterName, Object value) {
      return (RemoveTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateTransaction".
   *
   * This request holds the parameters needed by the transactionendpoint server.  After setting any
   * optional parameters, call the {@link UpdateTransaction#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.transactionendpoint.model.Transaction}
   * @return the request
   */
  public UpdateTransaction updateTransaction(com.sp.fanikiwa.entity.transactionendpoint.model.Transaction content) throws java.io.IOException {
    UpdateTransaction result = new UpdateTransaction(content);
    initialize(result);
    return result;
  }

  public class UpdateTransaction extends TransactionendpointRequest<com.sp.fanikiwa.entity.transactionendpoint.model.Transaction> {

    private static final String REST_PATH = "transaction";

    /**
     * Create a request for the method "updateTransaction".
     *
     * This request holds the parameters needed by the the transactionendpoint server.  After setting
     * any optional parameters, call the {@link UpdateTransaction#execute()} method to invoke the
     * remote operation. <p> {@link UpdateTransaction#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.transactionendpoint.model.Transaction}
     * @since 1.13
     */
    protected UpdateTransaction(com.sp.fanikiwa.entity.transactionendpoint.model.Transaction content) {
      super(Transactionendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.transactionendpoint.model.Transaction.class);
    }

    @Override
    public UpdateTransaction setAlt(java.lang.String alt) {
      return (UpdateTransaction) super.setAlt(alt);
    }

    @Override
    public UpdateTransaction setFields(java.lang.String fields) {
      return (UpdateTransaction) super.setFields(fields);
    }

    @Override
    public UpdateTransaction setKey(java.lang.String key) {
      return (UpdateTransaction) super.setKey(key);
    }

    @Override
    public UpdateTransaction setOauthToken(java.lang.String oauthToken) {
      return (UpdateTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateTransaction setQuotaUser(java.lang.String quotaUser) {
      return (UpdateTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateTransaction setUserIp(java.lang.String userIp) {
      return (UpdateTransaction) super.setUserIp(userIp);
    }

    @Override
    public UpdateTransaction set(String parameterName, Object value) {
      return (UpdateTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Transactionendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Transactionendpoint}. */
    @Override
    public Transactionendpoint build() {
      return new Transactionendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link TransactionendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTransactionendpointRequestInitializer(
        TransactionendpointRequestInitializer transactionendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(transactionendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
