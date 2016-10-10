package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import okhttp3.TlsVersion;
import java.lang.Integer;
import java.util.Map;
import java.util.LinkedHashMap;
import java.lang.Object;

public class ConfigFluentImpl<A extends ConfigFluent<A>> extends BaseFluent<A> implements ConfigFluent<A>{

    private boolean trustCerts;
    private String masterUrl;
    private String apiVersion;
    private String namespace;
    private String caCertFile;
    private String caCertData;
    private String clientCertFile;
    private String clientCertData;
    private String clientKeyFile;
    private String clientKeyData;
    private String clientKeyAlgo;
    private String clientKeyPassphrase;
    private String username;
    private String password;
    private String oauthToken;
    private int watchReconnectInterval;
    private int watchReconnectLimit;
    private int connectionTimeout;
    private int requestTimeout;
    private long rollingTimeout;
    private long scaleTimeout;
    private int loggingInterval;
    private String httpProxy;
    private String httpsProxy;
    private List<String> noProxy = new ArrayList<String>();
    private String userAgent;
    private List<TlsVersion> tlsVersions = new ArrayList<TlsVersion>();
    private Map<Integer,String> errorMessages = new LinkedHashMap<Integer,String>();

    public ConfigFluentImpl(){
    }
    public ConfigFluentImpl(Config instance){
            this.withMasterUrl(instance.getMasterUrl()); 
            this.withApiVersion(instance.getApiVersion()); 
            this.withNamespace(instance.getNamespace()); 
            this.withTrustCerts(instance.isTrustCerts()); 
            this.withCaCertFile(instance.getCaCertFile()); 
            this.withCaCertData(instance.getCaCertData()); 
            this.withClientCertFile(instance.getClientCertFile()); 
            this.withClientCertData(instance.getClientCertData()); 
            this.withClientKeyFile(instance.getClientKeyFile()); 
            this.withClientKeyData(instance.getClientKeyData()); 
            this.withClientKeyAlgo(instance.getClientKeyAlgo()); 
            this.withClientKeyPassphrase(instance.getClientKeyPassphrase()); 
            this.withUsername(instance.getUsername()); 
            this.withPassword(instance.getPassword()); 
            this.withOauthToken(instance.getOauthToken()); 
            this.withWatchReconnectInterval(instance.getWatchReconnectInterval()); 
            this.withWatchReconnectLimit(instance.getWatchReconnectLimit()); 
            this.withConnectionTimeout(instance.getConnectionTimeout()); 
            this.withRequestTimeout(instance.getRequestTimeout()); 
            this.withRollingTimeout(instance.getRollingTimeout()); 
            this.withScaleTimeout(instance.getScaleTimeout()); 
            this.withLoggingInterval(instance.getLoggingInterval()); 
            this.withHttpProxy(instance.getHttpProxy()); 
            this.withHttpsProxy(instance.getHttpsProxy()); 
            this.withNoProxy(instance.getNoProxy()); 
            this.withErrorMessages(instance.getErrorMessages()); 
            this.withUserAgent(instance.getUserAgent()); 
            this.withTlsVersions(instance.getTlsVersions()); 
    }

    public boolean isTrustCerts(){
            return this.trustCerts;
    }

    public A withTrustCerts(boolean trustCerts){
            this.trustCerts=trustCerts; return (A) this;
    }

    public String getMasterUrl(){
            return this.masterUrl;
    }

    public A withMasterUrl(String masterUrl){
            this.masterUrl=masterUrl; return (A) this;
    }

    public String getApiVersion(){
            return this.apiVersion;
    }

    public A withApiVersion(String apiVersion){
            this.apiVersion=apiVersion; return (A) this;
    }

    public String getNamespace(){
            return this.namespace;
    }

    public A withNamespace(String namespace){
            this.namespace=namespace; return (A) this;
    }

    public String getCaCertFile(){
            return this.caCertFile;
    }

    public A withCaCertFile(String caCertFile){
            this.caCertFile=caCertFile; return (A) this;
    }

    public String getCaCertData(){
            return this.caCertData;
    }

    public A withCaCertData(String caCertData){
            this.caCertData=caCertData; return (A) this;
    }

    public String getClientCertFile(){
            return this.clientCertFile;
    }

    public A withClientCertFile(String clientCertFile){
            this.clientCertFile=clientCertFile; return (A) this;
    }

    public String getClientCertData(){
            return this.clientCertData;
    }

    public A withClientCertData(String clientCertData){
            this.clientCertData=clientCertData; return (A) this;
    }

    public String getClientKeyFile(){
            return this.clientKeyFile;
    }

    public A withClientKeyFile(String clientKeyFile){
            this.clientKeyFile=clientKeyFile; return (A) this;
    }

    public String getClientKeyData(){
            return this.clientKeyData;
    }

    public A withClientKeyData(String clientKeyData){
            this.clientKeyData=clientKeyData; return (A) this;
    }

    public String getClientKeyAlgo(){
            return this.clientKeyAlgo;
    }

    public A withClientKeyAlgo(String clientKeyAlgo){
            this.clientKeyAlgo=clientKeyAlgo; return (A) this;
    }

    public String getClientKeyPassphrase(){
            return this.clientKeyPassphrase;
    }

    public A withClientKeyPassphrase(String clientKeyPassphrase){
            this.clientKeyPassphrase=clientKeyPassphrase; return (A) this;
    }

    public String getUsername(){
            return this.username;
    }

    public A withUsername(String username){
            this.username=username; return (A) this;
    }

    public String getPassword(){
            return this.password;
    }

    public A withPassword(String password){
            this.password=password; return (A) this;
    }

    public String getOauthToken(){
            return this.oauthToken;
    }

    public A withOauthToken(String oauthToken){
            this.oauthToken=oauthToken; return (A) this;
    }

    public int getWatchReconnectInterval(){
            return this.watchReconnectInterval;
    }

    public A withWatchReconnectInterval(int watchReconnectInterval){
            this.watchReconnectInterval=watchReconnectInterval; return (A) this;
    }

    public int getWatchReconnectLimit(){
            return this.watchReconnectLimit;
    }

    public A withWatchReconnectLimit(int watchReconnectLimit){
            this.watchReconnectLimit=watchReconnectLimit; return (A) this;
    }

    public int getConnectionTimeout(){
            return this.connectionTimeout;
    }

    public A withConnectionTimeout(int connectionTimeout){
            this.connectionTimeout=connectionTimeout; return (A) this;
    }

    public int getRequestTimeout(){
            return this.requestTimeout;
    }

    public A withRequestTimeout(int requestTimeout){
            this.requestTimeout=requestTimeout; return (A) this;
    }

    public long getRollingTimeout(){
            return this.rollingTimeout;
    }

    public A withRollingTimeout(long rollingTimeout){
            this.rollingTimeout=rollingTimeout; return (A) this;
    }

    public long getScaleTimeout(){
            return this.scaleTimeout;
    }

    public A withScaleTimeout(long scaleTimeout){
            this.scaleTimeout=scaleTimeout; return (A) this;
    }

    public int getLoggingInterval(){
            return this.loggingInterval;
    }

    public A withLoggingInterval(int loggingInterval){
            this.loggingInterval=loggingInterval; return (A) this;
    }

    public String getHttpProxy(){
            return this.httpProxy;
    }

    public A withHttpProxy(String httpProxy){
            this.httpProxy=httpProxy; return (A) this;
    }

    public String getHttpsProxy(){
            return this.httpsProxy;
    }

    public A withHttpsProxy(String httpsProxy){
            this.httpsProxy=httpsProxy; return (A) this;
    }

    public A withNoProxy(String... noProxy){
            this.noProxy.clear(); if (noProxy != null) {for (String item :noProxy){ this.addToNoProxy(item);}} return (A) this;
    }

    public String[] getNoProxy(){
            String[] result = new String[noProxy.size()];
int index=0;
for (String item : noProxy) {
    result[index++]=item;
}
return result;

    }

    public A addToNoProxy(String... items){
            for (String item : items) {this.noProxy.add(item);} return (A)this;
    }

    public A removeFromNoProxy(String... items){
            for (String item : items) {this.noProxy.remove(item);} return (A)this;
    }

    public String getUserAgent(){
            return this.userAgent;
    }

    public A withUserAgent(String userAgent){
            this.userAgent=userAgent; return (A) this;
    }

    public A withTlsVersions(TlsVersion... tlsVersions){
            this.tlsVersions.clear(); if (tlsVersions != null) {for (TlsVersion item :tlsVersions){ this.addToTlsVersions(item);}} return (A) this;
    }

    public TlsVersion[] getTlsVersions(){
            TlsVersion[] result = new TlsVersion[tlsVersions.size()];
int index=0;
for (TlsVersion item : tlsVersions) {
    result[index++]=item;
}
return result;

    }

    public A addToTlsVersions(TlsVersion... items){
            for (TlsVersion item : items) {this.tlsVersions.add(item);} return (A)this;
    }

    public A removeFromTlsVersions(TlsVersion... items){
            for (TlsVersion item : items) {this.tlsVersions.remove(item);} return (A)this;
    }

    public A addToErrorMessages(Integer key,String value){
            if(key != null && value != null) {this.errorMessages.put(key, value);} return (A)this;
    }

    public A addToErrorMessages(Map<Integer,String> map){
            if(map != null) { this.errorMessages.putAll(map);} return (A)this;
    }

    public A removeFromErrorMessages(Integer key){
            if(key != null) {this.errorMessages.remove(key);} return (A)this;
    }

    public A removeFromErrorMessages(Map<Integer,String> map){
            if(map != null) { for(Object key : map.keySet()) {this.errorMessages.remove(key);}} return (A)this;
    }

    public Map<Integer,String> getErrorMessages(){
            return this.errorMessages;
    }

    public A withErrorMessages(Map<Integer,String> errorMessages){
            this.errorMessages.clear();
            if (errorMessages != null) {this.errorMessages.putAll(errorMessages);} return (A) this;
    }

    public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            ConfigFluentImpl that = (ConfigFluentImpl) o;
            if (trustCerts != that.trustCerts) return false;
            if (masterUrl != null ? !masterUrl.equals(that.masterUrl) :that.masterUrl != null) return false;
            if (apiVersion != null ? !apiVersion.equals(that.apiVersion) :that.apiVersion != null) return false;
            if (namespace != null ? !namespace.equals(that.namespace) :that.namespace != null) return false;
            if (caCertFile != null ? !caCertFile.equals(that.caCertFile) :that.caCertFile != null) return false;
            if (caCertData != null ? !caCertData.equals(that.caCertData) :that.caCertData != null) return false;
            if (clientCertFile != null ? !clientCertFile.equals(that.clientCertFile) :that.clientCertFile != null) return false;
            if (clientCertData != null ? !clientCertData.equals(that.clientCertData) :that.clientCertData != null) return false;
            if (clientKeyFile != null ? !clientKeyFile.equals(that.clientKeyFile) :that.clientKeyFile != null) return false;
            if (clientKeyData != null ? !clientKeyData.equals(that.clientKeyData) :that.clientKeyData != null) return false;
            if (clientKeyAlgo != null ? !clientKeyAlgo.equals(that.clientKeyAlgo) :that.clientKeyAlgo != null) return false;
            if (clientKeyPassphrase != null ? !clientKeyPassphrase.equals(that.clientKeyPassphrase) :that.clientKeyPassphrase != null) return false;
            if (username != null ? !username.equals(that.username) :that.username != null) return false;
            if (password != null ? !password.equals(that.password) :that.password != null) return false;
            if (oauthToken != null ? !oauthToken.equals(that.oauthToken) :that.oauthToken != null) return false;
            if (watchReconnectInterval != that.watchReconnectInterval) return false;
            if (watchReconnectLimit != that.watchReconnectLimit) return false;
            if (connectionTimeout != that.connectionTimeout) return false;
            if (requestTimeout != that.requestTimeout) return false;
            if (rollingTimeout != that.rollingTimeout) return false;
            if (scaleTimeout != that.scaleTimeout) return false;
            if (loggingInterval != that.loggingInterval) return false;
            if (httpProxy != null ? !httpProxy.equals(that.httpProxy) :that.httpProxy != null) return false;
            if (httpsProxy != null ? !httpsProxy.equals(that.httpsProxy) :that.httpsProxy != null) return false;
            if (noProxy != null ? !noProxy.equals(that.noProxy) :that.noProxy != null) return false;
            if (userAgent != null ? !userAgent.equals(that.userAgent) :that.userAgent != null) return false;
            if (tlsVersions != null ? !tlsVersions.equals(that.tlsVersions) :that.tlsVersions != null) return false;
            if (errorMessages != null ? !errorMessages.equals(that.errorMessages) :that.errorMessages != null) return false;
            return true;
    }




}
