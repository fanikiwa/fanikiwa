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
 * on 2015-03-24 at 18:20:48 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.userprofileendpoint;

/**
 * Service definition for Userprofileendpoint (v1).
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
 * This service uses {@link UserprofileendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Userprofileendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the userprofileendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "userprofileendpoint/v1/";

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
  public Userprofileendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Userprofileendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getUserprofileByUserID".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link GetUserprofileByUserID#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public GetUserprofileByUserID getUserprofileByUserID(java.lang.String id) throws java.io.IOException {
    GetUserprofileByUserID result = new GetUserprofileByUserID(id);
    initialize(result);
    return result;
  }

  public class GetUserprofileByUserID extends UserprofileendpointRequest<com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile> {

    private static final String REST_PATH = "userprofile/{id}";

    /**
     * Create a request for the method "getUserprofileByUserID".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link GetUserprofileByUserID#execute()} method to invoke the
     * remote operation. <p> {@link GetUserprofileByUserID#initialize(com.google.api.client.googleapis
     * .services.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetUserprofileByUserID(java.lang.String id) {
      super(Userprofileendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile.class);
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
    public GetUserprofileByUserID setAlt(java.lang.String alt) {
      return (GetUserprofileByUserID) super.setAlt(alt);
    }

    @Override
    public GetUserprofileByUserID setFields(java.lang.String fields) {
      return (GetUserprofileByUserID) super.setFields(fields);
    }

    @Override
    public GetUserprofileByUserID setKey(java.lang.String key) {
      return (GetUserprofileByUserID) super.setKey(key);
    }

    @Override
    public GetUserprofileByUserID setOauthToken(java.lang.String oauthToken) {
      return (GetUserprofileByUserID) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUserprofileByUserID setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUserprofileByUserID) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUserprofileByUserID setQuotaUser(java.lang.String quotaUser) {
      return (GetUserprofileByUserID) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUserprofileByUserID setUserIp(java.lang.String userIp) {
      return (GetUserprofileByUserID) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetUserprofileByUserID setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetUserprofileByUserID set(String parameterName, Object value) {
      return (GetUserprofileByUserID) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertUserprofile".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link InsertUserprofile#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile}
   * @return the request
   */
  public InsertUserprofile insertUserprofile(com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile content) throws java.io.IOException {
    InsertUserprofile result = new InsertUserprofile(content);
    initialize(result);
    return result;
  }

  public class InsertUserprofile extends UserprofileendpointRequest<com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile> {

    private static final String REST_PATH = "userprofile";

    /**
     * Create a request for the method "insertUserprofile".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link InsertUserprofile#execute()} method to invoke the
     * remote operation. <p> {@link InsertUserprofile#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile}
     * @since 1.13
     */
    protected InsertUserprofile(com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile content) {
      super(Userprofileendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile.class);
    }

    @Override
    public InsertUserprofile setAlt(java.lang.String alt) {
      return (InsertUserprofile) super.setAlt(alt);
    }

    @Override
    public InsertUserprofile setFields(java.lang.String fields) {
      return (InsertUserprofile) super.setFields(fields);
    }

    @Override
    public InsertUserprofile setKey(java.lang.String key) {
      return (InsertUserprofile) super.setKey(key);
    }

    @Override
    public InsertUserprofile setOauthToken(java.lang.String oauthToken) {
      return (InsertUserprofile) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertUserprofile setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertUserprofile) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertUserprofile setQuotaUser(java.lang.String quotaUser) {
      return (InsertUserprofile) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertUserprofile setUserIp(java.lang.String userIp) {
      return (InsertUserprofile) super.setUserIp(userIp);
    }

    @Override
    public InsertUserprofile set(String parameterName, Object value) {
      return (InsertUserprofile) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listUserprofile".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link ListUserprofile#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListUserprofile listUserprofile() throws java.io.IOException {
    ListUserprofile result = new ListUserprofile();
    initialize(result);
    return result;
  }

  public class ListUserprofile extends UserprofileendpointRequest<com.sp.fanikiwa.entity.userprofileendpoint.model.CollectionResponseUserprofile> {

    private static final String REST_PATH = "userprofile";

    /**
     * Create a request for the method "listUserprofile".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link ListUserprofile#execute()} method to invoke the remote
     * operation. <p> {@link ListUserprofile#initialize(com.google.api.client.googleapis.services.Abst
     * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListUserprofile() {
      super(Userprofileendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.userprofileendpoint.model.CollectionResponseUserprofile.class);
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
    public ListUserprofile setAlt(java.lang.String alt) {
      return (ListUserprofile) super.setAlt(alt);
    }

    @Override
    public ListUserprofile setFields(java.lang.String fields) {
      return (ListUserprofile) super.setFields(fields);
    }

    @Override
    public ListUserprofile setKey(java.lang.String key) {
      return (ListUserprofile) super.setKey(key);
    }

    @Override
    public ListUserprofile setOauthToken(java.lang.String oauthToken) {
      return (ListUserprofile) super.setOauthToken(oauthToken);
    }

    @Override
    public ListUserprofile setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListUserprofile) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListUserprofile setQuotaUser(java.lang.String quotaUser) {
      return (ListUserprofile) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListUserprofile setUserIp(java.lang.String userIp) {
      return (ListUserprofile) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListUserprofile setCount(java.lang.Integer count) {
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

    public ListUserprofile setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListUserprofile set(String parameterName, Object value) {
      return (ListUserprofile) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "login".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link Login#execute()} method to invoke the remote operation.
   *
   * @param userId
   * @param pwd
   * @return the request
   */
  public Login login(java.lang.String userId, java.lang.String pwd) throws java.io.IOException {
    Login result = new Login(userId, pwd);
    initialize(result);
    return result;
  }

  public class Login extends UserprofileendpointRequest<com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile> {

    private static final String REST_PATH = "Login/{userId}/{pwd}";

    /**
     * Create a request for the method "login".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link Login#execute()} method to invoke the remote
     * operation. <p> {@link
     * Login#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param userId
     * @param pwd
     * @since 1.13
     */
    protected Login(java.lang.String userId, java.lang.String pwd) {
      super(Userprofileendpoint.this, "POST", REST_PATH, null, com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile.class);
      this.userId = com.google.api.client.util.Preconditions.checkNotNull(userId, "Required parameter userId must be specified.");
      this.pwd = com.google.api.client.util.Preconditions.checkNotNull(pwd, "Required parameter pwd must be specified.");
    }

    @Override
    public Login setAlt(java.lang.String alt) {
      return (Login) super.setAlt(alt);
    }

    @Override
    public Login setFields(java.lang.String fields) {
      return (Login) super.setFields(fields);
    }

    @Override
    public Login setKey(java.lang.String key) {
      return (Login) super.setKey(key);
    }

    @Override
    public Login setOauthToken(java.lang.String oauthToken) {
      return (Login) super.setOauthToken(oauthToken);
    }

    @Override
    public Login setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Login) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Login setQuotaUser(java.lang.String quotaUser) {
      return (Login) super.setQuotaUser(quotaUser);
    }

    @Override
    public Login setUserIp(java.lang.String userIp) {
      return (Login) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String userId;

    /**

     */
    public java.lang.String getUserId() {
      return userId;
    }

    public Login setUserId(java.lang.String userId) {
      this.userId = userId;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String pwd;

    /**

     */
    public java.lang.String getPwd() {
      return pwd;
    }

    public Login setPwd(java.lang.String pwd) {
      this.pwd = pwd;
      return this;
    }

    @Override
    public Login set(String parameterName, Object value) {
      return (Login) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeUserprofile".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link RemoveUserprofile#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveUserprofile removeUserprofile(java.lang.String id) throws java.io.IOException {
    RemoveUserprofile result = new RemoveUserprofile(id);
    initialize(result);
    return result;
  }

  public class RemoveUserprofile extends UserprofileendpointRequest<Void> {

    private static final String REST_PATH = "userprofile/{id}";

    /**
     * Create a request for the method "removeUserprofile".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link RemoveUserprofile#execute()} method to invoke the
     * remote operation. <p> {@link RemoveUserprofile#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveUserprofile(java.lang.String id) {
      super(Userprofileendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveUserprofile setAlt(java.lang.String alt) {
      return (RemoveUserprofile) super.setAlt(alt);
    }

    @Override
    public RemoveUserprofile setFields(java.lang.String fields) {
      return (RemoveUserprofile) super.setFields(fields);
    }

    @Override
    public RemoveUserprofile setKey(java.lang.String key) {
      return (RemoveUserprofile) super.setKey(key);
    }

    @Override
    public RemoveUserprofile setOauthToken(java.lang.String oauthToken) {
      return (RemoveUserprofile) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveUserprofile setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveUserprofile) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveUserprofile setQuotaUser(java.lang.String quotaUser) {
      return (RemoveUserprofile) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveUserprofile setUserIp(java.lang.String userIp) {
      return (RemoveUserprofile) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveUserprofile setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveUserprofile set(String parameterName, Object value) {
      return (RemoveUserprofile) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateUserprofile".
   *
   * This request holds the parameters needed by the userprofileendpoint server.  After setting any
   * optional parameters, call the {@link UpdateUserprofile#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile}
   * @return the request
   */
  public UpdateUserprofile updateUserprofile(com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile content) throws java.io.IOException {
    UpdateUserprofile result = new UpdateUserprofile(content);
    initialize(result);
    return result;
  }

  public class UpdateUserprofile extends UserprofileendpointRequest<com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile> {

    private static final String REST_PATH = "userprofile";

    /**
     * Create a request for the method "updateUserprofile".
     *
     * This request holds the parameters needed by the the userprofileendpoint server.  After setting
     * any optional parameters, call the {@link UpdateUserprofile#execute()} method to invoke the
     * remote operation. <p> {@link UpdateUserprofile#initialize(com.google.api.client.googleapis.serv
     * ices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile}
     * @since 1.13
     */
    protected UpdateUserprofile(com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile content) {
      super(Userprofileendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.userprofileendpoint.model.Userprofile.class);
    }

    @Override
    public UpdateUserprofile setAlt(java.lang.String alt) {
      return (UpdateUserprofile) super.setAlt(alt);
    }

    @Override
    public UpdateUserprofile setFields(java.lang.String fields) {
      return (UpdateUserprofile) super.setFields(fields);
    }

    @Override
    public UpdateUserprofile setKey(java.lang.String key) {
      return (UpdateUserprofile) super.setKey(key);
    }

    @Override
    public UpdateUserprofile setOauthToken(java.lang.String oauthToken) {
      return (UpdateUserprofile) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateUserprofile setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateUserprofile) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateUserprofile setQuotaUser(java.lang.String quotaUser) {
      return (UpdateUserprofile) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateUserprofile setUserIp(java.lang.String userIp) {
      return (UpdateUserprofile) super.setUserIp(userIp);
    }

    @Override
    public UpdateUserprofile set(String parameterName, Object value) {
      return (UpdateUserprofile) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Userprofileendpoint}.
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

    /** Builds a new instance of {@link Userprofileendpoint}. */
    @Override
    public Userprofileendpoint build() {
      return new Userprofileendpoint(this);
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
     * Set the {@link UserprofileendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUserprofileendpointRequestInitializer(
        UserprofileendpointRequestInitializer userprofileendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(userprofileendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
