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
 * on 2015-03-24 at 17:52:19 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.organizationendpoint;

/**
 * Service definition for Organizationendpoint (v1).
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
 * This service uses {@link OrganizationendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Organizationendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the organizationendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://1-dot-fanikiwaweb.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "organizationendpoint/v1/";

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
  public Organizationendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Organizationendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getOrganization".
   *
   * This request holds the parameters needed by the organizationendpoint server.  After setting any
   * optional parameters, call the {@link GetOrganization#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetOrganization getOrganization(java.lang.Long id) throws java.io.IOException {
    GetOrganization result = new GetOrganization(id);
    initialize(result);
    return result;
  }

  public class GetOrganization extends OrganizationendpointRequest<com.sp.fanikiwa.entity.organizationendpoint.model.Organization> {

    private static final String REST_PATH = "organization/{id}";

    /**
     * Create a request for the method "getOrganization".
     *
     * This request holds the parameters needed by the the organizationendpoint server.  After setting
     * any optional parameters, call the {@link GetOrganization#execute()} method to invoke the remote
     * operation. <p> {@link GetOrganization#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetOrganization(java.lang.Long id) {
      super(Organizationendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.organizationendpoint.model.Organization.class);
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
    public GetOrganization setAlt(java.lang.String alt) {
      return (GetOrganization) super.setAlt(alt);
    }

    @Override
    public GetOrganization setFields(java.lang.String fields) {
      return (GetOrganization) super.setFields(fields);
    }

    @Override
    public GetOrganization setKey(java.lang.String key) {
      return (GetOrganization) super.setKey(key);
    }

    @Override
    public GetOrganization setOauthToken(java.lang.String oauthToken) {
      return (GetOrganization) super.setOauthToken(oauthToken);
    }

    @Override
    public GetOrganization setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetOrganization) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetOrganization setQuotaUser(java.lang.String quotaUser) {
      return (GetOrganization) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetOrganization setUserIp(java.lang.String userIp) {
      return (GetOrganization) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetOrganization setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetOrganization set(String parameterName, Object value) {
      return (GetOrganization) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertOrganization".
   *
   * This request holds the parameters needed by the organizationendpoint server.  After setting any
   * optional parameters, call the {@link InsertOrganization#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.organizationendpoint.model.Organization}
   * @return the request
   */
  public InsertOrganization insertOrganization(com.sp.fanikiwa.entity.organizationendpoint.model.Organization content) throws java.io.IOException {
    InsertOrganization result = new InsertOrganization(content);
    initialize(result);
    return result;
  }

  public class InsertOrganization extends OrganizationendpointRequest<com.sp.fanikiwa.entity.organizationendpoint.model.Organization> {

    private static final String REST_PATH = "organization";

    /**
     * Create a request for the method "insertOrganization".
     *
     * This request holds the parameters needed by the the organizationendpoint server.  After setting
     * any optional parameters, call the {@link InsertOrganization#execute()} method to invoke the
     * remote operation. <p> {@link InsertOrganization#initialize(com.google.api.client.googleapis.ser
     * vices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.organizationendpoint.model.Organization}
     * @since 1.13
     */
    protected InsertOrganization(com.sp.fanikiwa.entity.organizationendpoint.model.Organization content) {
      super(Organizationendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.organizationendpoint.model.Organization.class);
    }

    @Override
    public InsertOrganization setAlt(java.lang.String alt) {
      return (InsertOrganization) super.setAlt(alt);
    }

    @Override
    public InsertOrganization setFields(java.lang.String fields) {
      return (InsertOrganization) super.setFields(fields);
    }

    @Override
    public InsertOrganization setKey(java.lang.String key) {
      return (InsertOrganization) super.setKey(key);
    }

    @Override
    public InsertOrganization setOauthToken(java.lang.String oauthToken) {
      return (InsertOrganization) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertOrganization setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertOrganization) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertOrganization setQuotaUser(java.lang.String quotaUser) {
      return (InsertOrganization) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertOrganization setUserIp(java.lang.String userIp) {
      return (InsertOrganization) super.setUserIp(userIp);
    }

    @Override
    public InsertOrganization set(String parameterName, Object value) {
      return (InsertOrganization) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listOrganization".
   *
   * This request holds the parameters needed by the organizationendpoint server.  After setting any
   * optional parameters, call the {@link ListOrganization#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListOrganization listOrganization() throws java.io.IOException {
    ListOrganization result = new ListOrganization();
    initialize(result);
    return result;
  }

  public class ListOrganization extends OrganizationendpointRequest<com.sp.fanikiwa.entity.organizationendpoint.model.CollectionResponseOrganization> {

    private static final String REST_PATH = "organization";

    /**
     * Create a request for the method "listOrganization".
     *
     * This request holds the parameters needed by the the organizationendpoint server.  After setting
     * any optional parameters, call the {@link ListOrganization#execute()} method to invoke the
     * remote operation. <p> {@link ListOrganization#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListOrganization() {
      super(Organizationendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.organizationendpoint.model.CollectionResponseOrganization.class);
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
    public ListOrganization setAlt(java.lang.String alt) {
      return (ListOrganization) super.setAlt(alt);
    }

    @Override
    public ListOrganization setFields(java.lang.String fields) {
      return (ListOrganization) super.setFields(fields);
    }

    @Override
    public ListOrganization setKey(java.lang.String key) {
      return (ListOrganization) super.setKey(key);
    }

    @Override
    public ListOrganization setOauthToken(java.lang.String oauthToken) {
      return (ListOrganization) super.setOauthToken(oauthToken);
    }

    @Override
    public ListOrganization setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListOrganization) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListOrganization setQuotaUser(java.lang.String quotaUser) {
      return (ListOrganization) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListOrganization setUserIp(java.lang.String userIp) {
      return (ListOrganization) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListOrganization setCount(java.lang.Integer count) {
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

    public ListOrganization setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListOrganization set(String parameterName, Object value) {
      return (ListOrganization) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeOrganization".
   *
   * This request holds the parameters needed by the organizationendpoint server.  After setting any
   * optional parameters, call the {@link RemoveOrganization#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveOrganization removeOrganization(java.lang.Long id) throws java.io.IOException {
    RemoveOrganization result = new RemoveOrganization(id);
    initialize(result);
    return result;
  }

  public class RemoveOrganization extends OrganizationendpointRequest<Void> {

    private static final String REST_PATH = "organization/{id}";

    /**
     * Create a request for the method "removeOrganization".
     *
     * This request holds the parameters needed by the the organizationendpoint server.  After setting
     * any optional parameters, call the {@link RemoveOrganization#execute()} method to invoke the
     * remote operation. <p> {@link RemoveOrganization#initialize(com.google.api.client.googleapis.ser
     * vices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveOrganization(java.lang.Long id) {
      super(Organizationendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveOrganization setAlt(java.lang.String alt) {
      return (RemoveOrganization) super.setAlt(alt);
    }

    @Override
    public RemoveOrganization setFields(java.lang.String fields) {
      return (RemoveOrganization) super.setFields(fields);
    }

    @Override
    public RemoveOrganization setKey(java.lang.String key) {
      return (RemoveOrganization) super.setKey(key);
    }

    @Override
    public RemoveOrganization setOauthToken(java.lang.String oauthToken) {
      return (RemoveOrganization) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveOrganization setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveOrganization) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveOrganization setQuotaUser(java.lang.String quotaUser) {
      return (RemoveOrganization) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveOrganization setUserIp(java.lang.String userIp) {
      return (RemoveOrganization) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveOrganization setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveOrganization set(String parameterName, Object value) {
      return (RemoveOrganization) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateOrganization".
   *
   * This request holds the parameters needed by the organizationendpoint server.  After setting any
   * optional parameters, call the {@link UpdateOrganization#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.organizationendpoint.model.Organization}
   * @return the request
   */
  public UpdateOrganization updateOrganization(com.sp.fanikiwa.entity.organizationendpoint.model.Organization content) throws java.io.IOException {
    UpdateOrganization result = new UpdateOrganization(content);
    initialize(result);
    return result;
  }

  public class UpdateOrganization extends OrganizationendpointRequest<com.sp.fanikiwa.entity.organizationendpoint.model.Organization> {

    private static final String REST_PATH = "organization";

    /**
     * Create a request for the method "updateOrganization".
     *
     * This request holds the parameters needed by the the organizationendpoint server.  After setting
     * any optional parameters, call the {@link UpdateOrganization#execute()} method to invoke the
     * remote operation. <p> {@link UpdateOrganization#initialize(com.google.api.client.googleapis.ser
     * vices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.organizationendpoint.model.Organization}
     * @since 1.13
     */
    protected UpdateOrganization(com.sp.fanikiwa.entity.organizationendpoint.model.Organization content) {
      super(Organizationendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.organizationendpoint.model.Organization.class);
    }

    @Override
    public UpdateOrganization setAlt(java.lang.String alt) {
      return (UpdateOrganization) super.setAlt(alt);
    }

    @Override
    public UpdateOrganization setFields(java.lang.String fields) {
      return (UpdateOrganization) super.setFields(fields);
    }

    @Override
    public UpdateOrganization setKey(java.lang.String key) {
      return (UpdateOrganization) super.setKey(key);
    }

    @Override
    public UpdateOrganization setOauthToken(java.lang.String oauthToken) {
      return (UpdateOrganization) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateOrganization setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateOrganization) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateOrganization setQuotaUser(java.lang.String quotaUser) {
      return (UpdateOrganization) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateOrganization setUserIp(java.lang.String userIp) {
      return (UpdateOrganization) super.setUserIp(userIp);
    }

    @Override
    public UpdateOrganization set(String parameterName, Object value) {
      return (UpdateOrganization) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Organizationendpoint}.
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

    /** Builds a new instance of {@link Organizationendpoint}. */
    @Override
    public Organizationendpoint build() {
      return new Organizationendpoint(this);
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
     * Set the {@link OrganizationendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setOrganizationendpointRequestInitializer(
        OrganizationendpointRequestInitializer organizationendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(organizationendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
