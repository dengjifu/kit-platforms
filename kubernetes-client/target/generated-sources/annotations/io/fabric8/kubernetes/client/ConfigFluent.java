package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.Fluent;
import org.slf4j.Logger;
import java.lang.String;
import java.lang.Long;
import okhttp3.TlsVersion;
import java.lang.Integer;
import java.util.Map;
import io.sundr.builder.annotations.Buildable;

public interface ConfigFluent<A extends ConfigFluent<A>> extends Fluent<A>{


    public boolean isTrustCerts();
    public A withTrustCerts(boolean trustCerts);
    public String getMasterUrl();
    public A withMasterUrl(String masterUrl);
    public String getApiVersion();
    public A withApiVersion(String apiVersion);
    public String getNamespace();
    public A withNamespace(String namespace);
    public String getCaCertFile();
    public A withCaCertFile(String caCertFile);
    public String getCaCertData();
    public A withCaCertData(String caCertData);
    public String getClientCertFile();
    public A withClientCertFile(String clientCertFile);
    public String getClientCertData();
    public A withClientCertData(String clientCertData);
    public String getClientKeyFile();
    public A withClientKeyFile(String clientKeyFile);
    public String getClientKeyData();
    public A withClientKeyData(String clientKeyData);
    public String getClientKeyAlgo();
    public A withClientKeyAlgo(String clientKeyAlgo);
    public String getClientKeyPassphrase();
    public A withClientKeyPassphrase(String clientKeyPassphrase);
    public String getUsername();
    public A withUsername(String username);
    public String getPassword();
    public A withPassword(String password);
    public String getOauthToken();
    public A withOauthToken(String oauthToken);
    public int getWatchReconnectInterval();
    public A withWatchReconnectInterval(int watchReconnectInterval);
    public int getWatchReconnectLimit();
    public A withWatchReconnectLimit(int watchReconnectLimit);
    public int getConnectionTimeout();
    public A withConnectionTimeout(int connectionTimeout);
    public int getRequestTimeout();
    public A withRequestTimeout(int requestTimeout);
    public long getRollingTimeout();
    public A withRollingTimeout(long rollingTimeout);
    public long getScaleTimeout();
    public A withScaleTimeout(long scaleTimeout);
    public int getLoggingInterval();
    public A withLoggingInterval(int loggingInterval);
    public String getHttpProxy();
    public A withHttpProxy(String httpProxy);
    public String getHttpsProxy();
    public A withHttpsProxy(String httpsProxy);
    public A withNoProxy(String... noProxy);
    public String[] getNoProxy();
    public A addToNoProxy(String... items);
    public A removeFromNoProxy(String... items);
    public String getUserAgent();
    public A withUserAgent(String userAgent);
    public A withTlsVersions(TlsVersion... tlsVersions);
    public TlsVersion[] getTlsVersions();
    public A addToTlsVersions(TlsVersion... items);
    public A removeFromTlsVersions(TlsVersion... items);
    public A addToErrorMessages(Integer key,String value);
    public A addToErrorMessages(Map<Integer,String> map);
    public A removeFromErrorMessages(Integer key);
    public A removeFromErrorMessages(Map<Integer,String> map);
    public Map<Integer,String> getErrorMessages();
    public A withErrorMessages(Map<Integer,String> errorMessages);



}
