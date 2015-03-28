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
 * on 2015-03-28 at 10:13:48 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.diaryprogramcontrolendpoint;

/**
 * Service definition for Diaryprogramcontrolendpoint (v1).
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
 * This service uses {@link DiaryprogramcontrolendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Diaryprogramcontrolendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the diaryprogramcontrolendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "diaryprogramcontrolendpoint/v1/";

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
  public Diaryprogramcontrolendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Diaryprogramcontrolendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "insertDiaryprogramcontrol".
   *
   * This request holds the parameters needed by the diaryprogramcontrolendpoint server.  After
   * setting any optional parameters, call the {@link InsertDiaryprogramcontrol#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol}
   * @return the request
   */
  public InsertDiaryprogramcontrol insertDiaryprogramcontrol(com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol content) throws java.io.IOException {
    InsertDiaryprogramcontrol result = new InsertDiaryprogramcontrol(content);
    initialize(result);
    return result;
  }

  public class InsertDiaryprogramcontrol extends DiaryprogramcontrolendpointRequest<com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol> {

    private static final String REST_PATH = "diaryprogramcontrol";

    /**
     * Create a request for the method "insertDiaryprogramcontrol".
     *
     * This request holds the parameters needed by the the diaryprogramcontrolendpoint server.  After
     * setting any optional parameters, call the {@link InsertDiaryprogramcontrol#execute()} method to
     * invoke the remote operation. <p> {@link InsertDiaryprogramcontrol#initialize(com.google.api.cli
     * ent.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol}
     * @since 1.13
     */
    protected InsertDiaryprogramcontrol(com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol content) {
      super(Diaryprogramcontrolendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol.class);
    }

    @Override
    public InsertDiaryprogramcontrol setAlt(java.lang.String alt) {
      return (InsertDiaryprogramcontrol) super.setAlt(alt);
    }

    @Override
    public InsertDiaryprogramcontrol setFields(java.lang.String fields) {
      return (InsertDiaryprogramcontrol) super.setFields(fields);
    }

    @Override
    public InsertDiaryprogramcontrol setKey(java.lang.String key) {
      return (InsertDiaryprogramcontrol) super.setKey(key);
    }

    @Override
    public InsertDiaryprogramcontrol setOauthToken(java.lang.String oauthToken) {
      return (InsertDiaryprogramcontrol) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertDiaryprogramcontrol setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertDiaryprogramcontrol) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertDiaryprogramcontrol setQuotaUser(java.lang.String quotaUser) {
      return (InsertDiaryprogramcontrol) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertDiaryprogramcontrol setUserIp(java.lang.String userIp) {
      return (InsertDiaryprogramcontrol) super.setUserIp(userIp);
    }

    @Override
    public InsertDiaryprogramcontrol set(String parameterName, Object value) {
      return (InsertDiaryprogramcontrol) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listDiaryprogramcontrol".
   *
   * This request holds the parameters needed by the diaryprogramcontrolendpoint server.  After
   * setting any optional parameters, call the {@link ListDiaryprogramcontrol#execute()} method to
   * invoke the remote operation.
   *
   * @return the request
   */
  public ListDiaryprogramcontrol listDiaryprogramcontrol() throws java.io.IOException {
    ListDiaryprogramcontrol result = new ListDiaryprogramcontrol();
    initialize(result);
    return result;
  }

  public class ListDiaryprogramcontrol extends DiaryprogramcontrolendpointRequest<com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.CollectionResponseDiaryprogramcontrol> {

    private static final String REST_PATH = "diaryprogramcontrol";

    /**
     * Create a request for the method "listDiaryprogramcontrol".
     *
     * This request holds the parameters needed by the the diaryprogramcontrolendpoint server.  After
     * setting any optional parameters, call the {@link ListDiaryprogramcontrol#execute()} method to
     * invoke the remote operation. <p> {@link ListDiaryprogramcontrol#initialize(com.google.api.clien
     * t.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListDiaryprogramcontrol() {
      super(Diaryprogramcontrolendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.CollectionResponseDiaryprogramcontrol.class);
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
    public ListDiaryprogramcontrol setAlt(java.lang.String alt) {
      return (ListDiaryprogramcontrol) super.setAlt(alt);
    }

    @Override
    public ListDiaryprogramcontrol setFields(java.lang.String fields) {
      return (ListDiaryprogramcontrol) super.setFields(fields);
    }

    @Override
    public ListDiaryprogramcontrol setKey(java.lang.String key) {
      return (ListDiaryprogramcontrol) super.setKey(key);
    }

    @Override
    public ListDiaryprogramcontrol setOauthToken(java.lang.String oauthToken) {
      return (ListDiaryprogramcontrol) super.setOauthToken(oauthToken);
    }

    @Override
    public ListDiaryprogramcontrol setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListDiaryprogramcontrol) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListDiaryprogramcontrol setQuotaUser(java.lang.String quotaUser) {
      return (ListDiaryprogramcontrol) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListDiaryprogramcontrol setUserIp(java.lang.String userIp) {
      return (ListDiaryprogramcontrol) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListDiaryprogramcontrol setCount(java.lang.Integer count) {
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

    public ListDiaryprogramcontrol setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListDiaryprogramcontrol set(String parameterName, Object value) {
      return (ListDiaryprogramcontrol) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeDiaryprogramcontrol".
   *
   * This request holds the parameters needed by the diaryprogramcontrolendpoint server.  After
   * setting any optional parameters, call the {@link RemoveDiaryprogramcontrol#execute()} method to
   * invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveDiaryprogramcontrol removeDiaryprogramcontrol(java.lang.Long id) throws java.io.IOException {
    RemoveDiaryprogramcontrol result = new RemoveDiaryprogramcontrol(id);
    initialize(result);
    return result;
  }

  public class RemoveDiaryprogramcontrol extends DiaryprogramcontrolendpointRequest<Void> {

    private static final String REST_PATH = "diaryprogramcontrol/{id}";

    /**
     * Create a request for the method "removeDiaryprogramcontrol".
     *
     * This request holds the parameters needed by the the diaryprogramcontrolendpoint server.  After
     * setting any optional parameters, call the {@link RemoveDiaryprogramcontrol#execute()} method to
     * invoke the remote operation. <p> {@link RemoveDiaryprogramcontrol#initialize(com.google.api.cli
     * ent.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveDiaryprogramcontrol(java.lang.Long id) {
      super(Diaryprogramcontrolendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveDiaryprogramcontrol setAlt(java.lang.String alt) {
      return (RemoveDiaryprogramcontrol) super.setAlt(alt);
    }

    @Override
    public RemoveDiaryprogramcontrol setFields(java.lang.String fields) {
      return (RemoveDiaryprogramcontrol) super.setFields(fields);
    }

    @Override
    public RemoveDiaryprogramcontrol setKey(java.lang.String key) {
      return (RemoveDiaryprogramcontrol) super.setKey(key);
    }

    @Override
    public RemoveDiaryprogramcontrol setOauthToken(java.lang.String oauthToken) {
      return (RemoveDiaryprogramcontrol) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveDiaryprogramcontrol setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveDiaryprogramcontrol) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveDiaryprogramcontrol setQuotaUser(java.lang.String quotaUser) {
      return (RemoveDiaryprogramcontrol) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveDiaryprogramcontrol setUserIp(java.lang.String userIp) {
      return (RemoveDiaryprogramcontrol) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveDiaryprogramcontrol setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveDiaryprogramcontrol set(String parameterName, Object value) {
      return (RemoveDiaryprogramcontrol) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateDiaryprogramcontrol".
   *
   * This request holds the parameters needed by the diaryprogramcontrolendpoint server.  After
   * setting any optional parameters, call the {@link UpdateDiaryprogramcontrol#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol}
   * @return the request
   */
  public UpdateDiaryprogramcontrol updateDiaryprogramcontrol(com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol content) throws java.io.IOException {
    UpdateDiaryprogramcontrol result = new UpdateDiaryprogramcontrol(content);
    initialize(result);
    return result;
  }

  public class UpdateDiaryprogramcontrol extends DiaryprogramcontrolendpointRequest<com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol> {

    private static final String REST_PATH = "diaryprogramcontrol";

    /**
     * Create a request for the method "updateDiaryprogramcontrol".
     *
     * This request holds the parameters needed by the the diaryprogramcontrolendpoint server.  After
     * setting any optional parameters, call the {@link UpdateDiaryprogramcontrol#execute()} method to
     * invoke the remote operation. <p> {@link UpdateDiaryprogramcontrol#initialize(com.google.api.cli
     * ent.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol}
     * @since 1.13
     */
    protected UpdateDiaryprogramcontrol(com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol content) {
      super(Diaryprogramcontrolendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.diaryprogramcontrolendpoint.model.Diaryprogramcontrol.class);
    }

    @Override
    public UpdateDiaryprogramcontrol setAlt(java.lang.String alt) {
      return (UpdateDiaryprogramcontrol) super.setAlt(alt);
    }

    @Override
    public UpdateDiaryprogramcontrol setFields(java.lang.String fields) {
      return (UpdateDiaryprogramcontrol) super.setFields(fields);
    }

    @Override
    public UpdateDiaryprogramcontrol setKey(java.lang.String key) {
      return (UpdateDiaryprogramcontrol) super.setKey(key);
    }

    @Override
    public UpdateDiaryprogramcontrol setOauthToken(java.lang.String oauthToken) {
      return (UpdateDiaryprogramcontrol) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateDiaryprogramcontrol setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateDiaryprogramcontrol) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateDiaryprogramcontrol setQuotaUser(java.lang.String quotaUser) {
      return (UpdateDiaryprogramcontrol) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateDiaryprogramcontrol setUserIp(java.lang.String userIp) {
      return (UpdateDiaryprogramcontrol) super.setUserIp(userIp);
    }

    @Override
    public UpdateDiaryprogramcontrol set(String parameterName, Object value) {
      return (UpdateDiaryprogramcontrol) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Diaryprogramcontrolendpoint}.
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

    /** Builds a new instance of {@link Diaryprogramcontrolendpoint}. */
    @Override
    public Diaryprogramcontrolendpoint build() {
      return new Diaryprogramcontrolendpoint(this);
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
     * Set the {@link DiaryprogramcontrolendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setDiaryprogramcontrolendpointRequestInitializer(
        DiaryprogramcontrolendpointRequestInitializer diaryprogramcontrolendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(diaryprogramcontrolendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
