package com.util;

import com.exception.HttpApiException;
import com.exception.MyErr;
import com.exception.MyException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2016/2/2.
 */
public class HttpHelper {

    private static Logger logger = Logger.getLogger(HttpHelper.class);
    private static PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 8000;
    private static CloseableHttpClient httpClient=null;
    private static CloseableHttpClient httpsClient=null;

    static {
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(100);

        ScheduledExecutorService scheduleder = Executors.newScheduledThreadPool(1);
        scheduleder.scheduleAtFixedRate(new IdleConnectionMonitor(connMgr), 0, 240, TimeUnit.SECONDS);

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    private static CloseableHttpClient getHttpclient(){
        if (httpClient == null) {
            httpClient = HttpClients.custom()
                    .setConnectionManager(connMgr)
                    .setRetryHandler(new DefaultHttpRequestRetryHandler())
                    .build();
        }
        return httpClient;
    }

    private static CloseableHttpClient getHttpsclient(){
        if (httpsClient == null) {
            httpsClient = createSSLClientDefault();
        }
        return httpsClient;
    }

    public static String httpPost(String url,JsonNode param,boolean isForm) throws HttpApiException {
        String retStr="";
        HttpPost post=new HttpPost(url);
        post.setConfig(requestConfig);
        CloseableHttpResponse response=null;
        if(isForm){
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            ObjectMapper mapper = new ObjectMapper();
            Map<String,String> map = null;
            try {
                map = mapper.readValue(param.toString(), Map.class);
            } catch (IOException e) {
                e.printStackTrace();logger.error(e);logger.error(e);
            }
            for(Map.Entry<String,String> entry:map.entrySet()){
                String k = entry.getKey();
                String v = entry.getValue()+"";
                formparams.add(new BasicNameValuePair(k,v));
            }
            try {
                post.setEntity(new UrlEncodedFormEntity(formparams,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }else {
            post.setHeader("Content-Type","application/json");
            post.setEntity(new StringEntity(param.toString(),"utf-8"));
        }
        try {
            response = getHttpclient().execute(post);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            if(e.getMessage().replace(" ","").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
        }
        HttpEntity entity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();//返回状态码
        try {
            if(entity!=null) retStr= EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        if(200!=statusCode){
            throw new HttpApiException("http状态码"+statusCode+"--"+retStr,statusCode,retStr,"err");
        }

        if(null!=response){
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        post.releaseConnection();
        post.abort();
        return retStr;

    }


    public static String httpPut(String url,JsonNode param) throws HttpApiException {
        String retStr="";
        HttpPut put=new HttpPut(url);
        put.setConfig(requestConfig);
        CloseableHttpResponse response=null;

        put.setHeader("Content-Type","application/json");
        put.setEntity(new StringEntity(param.toString(),"utf-8"));

        try {
            response = getHttpclient().execute(put);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            if(e.getMessage().replace(" ","").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
        }
        HttpEntity entity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();//返回状态码
        try {
            if(entity!=null) retStr= EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        if(200!=statusCode){
            throw new HttpApiException("http状态码"+statusCode+"--"+retStr,statusCode,retStr,"err");
        }

        if(null!=response){
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        put.releaseConnection();
        put.abort();
        return retStr;

    }


    public static String httpGet(String url,JsonNode param) throws HttpApiException {
        int statusCode = -1;
        CloseableHttpResponse response=null;
        String api = "";
        StringBuffer paramSb=new StringBuffer();
        if(param!=null){
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = new HashMap<String, Object>();
            try {
                map = mapper.readValue(param.toString(),map.getClass());
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
            for(Map.Entry<String,Object> entry:map.entrySet()){
                String k = entry.getKey();
                String v = URLDecoder.decode(entry.getValue()+"");
                String p = k+"="+v;
                paramSb.append(p+"&");
            }
            paramSb.deleteCharAt(paramSb.length()-1);
            api = url+"?"+paramSb;
        }else {
            api=url;
        }
        logger.info(api);
        String retStr="";
        HttpGet httpGet=new HttpGet(api);
        httpGet.setConfig(requestConfig);

        try {
            response=getHttpclient().execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            if(e.getMessage().replace(" ","").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
        }
        HttpEntity entity = response.getEntity();
        statusCode = response.getStatusLine().getStatusCode();//返回状态码
        try {
            if(entity != null) retStr= EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        if(200!=statusCode){
            throw new HttpApiException("http状态码"+statusCode+"--"+retStr,statusCode,retStr,"err");
        }


        if(null!=response){
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        httpGet.releaseConnection();
        httpGet.abort();
        return retStr;
    }

    public static String httpDelete(String url) throws HttpApiException {
        int statusCode = -1;
        CloseableHttpResponse response=null;
        logger.info(url);
        String retStr="";
        HttpDelete httpdelete=new HttpDelete(url);
        httpdelete.setConfig(requestConfig);
        try {
            response=getHttpclient().execute(httpdelete);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            if(e.getMessage().replace(" ","").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
        }
        HttpEntity entity = response.getEntity();
        statusCode = response.getStatusLine().getStatusCode();//返回状态码
        try {
            if(entity != null) retStr= EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        if(200!=statusCode){
            throw new HttpApiException("http状态码"+statusCode+"--"+retStr,statusCode,retStr,"err");
        }

        if(null!=response){
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        httpdelete.releaseConnection();
        httpdelete.abort();
        return retStr;
    }

    //信任ssl证书
    public static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType){
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom()
                    .setConnectionManager(connMgr)
                    .setRetryHandler(new DefaultHttpRequestRetryHandler())
                    .setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
            logger.error(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(e);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return  HttpClients.createDefault();
    }



    public static String httpsPost(String url,String param){
        String retStr="";
        int statusCode = -1;
        CloseableHttpResponse response = null;
        HttpPost post=new HttpPost(url);
        post.setConfig(requestConfig);
        post.setHeader("Content-Type","application/json;charset=utf-8");
        post.setEntity(new StringEntity(param,"utf-8"));
        try {
            response = getHttpsclient().execute(post);
            HttpEntity entity = response.getEntity();
            statusCode = response.getStatusLine().getStatusCode();//返回状态码
            try {
                if(entity!=null) retStr= EntityUtils.toString(entity,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
            if(200!=statusCode){
                throw new HttpApiException("http状态码"+statusCode+"--"+retStr,statusCode,retStr,"err");
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
            logger.error("HttpHelper==>httpsPost:",e);
            if(e.getMessage().replace(" ","").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
            retStr="{\"code\":1,\"msg\":\"抛异常IOException\"}";
        }finally {
            if(null!=response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e);
                }
            }
            post.releaseConnection();
            post.abort();
            return retStr;
        }
    }


    public static String httpsGet(String url){
        int statusCode = -1;
        String resStr="";
        CloseableHttpResponse response=null;
        HttpGet httpGet=new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            response=getHttpsclient().execute(httpGet);
            HttpEntity entity = response.getEntity();
            statusCode = response.getStatusLine().getStatusCode();//返回状态码
            try {
                if(entity!=null) resStr= EntityUtils.toString(entity,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
            if(200!=statusCode){
                throw new MyException("http状态码"+statusCode,statusCode,"err");
            }
        }catch (IOException e2) {
            e2.printStackTrace();
            logger.error("HttpHelper==>httpsGet(json):",e2);
            if(e2.getMessage().replace(""," ").equalsIgnoreCase("readtimedout")){
                throw new HttpApiException(MyErr.HTTPTIMEOUT.getErrCode(),
                        MyErr.HTTPTIMEOUT.getErrMsg(),
                        MyErr.HTTPTIMEOUT.getThrowMsg());
            }
            resStr="{\"code\":1,\"msg\":\"抛异常IOException\"}";
        }finally {//关闭连接
            if(null!=response){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e);
                }
            }
            httpGet.releaseConnection();
            httpGet.abort();
            return resStr;
        }
    }

    /*
    * 定时清理超时的连接
    * */
    private static final class IdleConnectionMonitor implements Runnable {
        PoolingHttpClientConnectionManager connectionManager;

        public IdleConnectionMonitor(PoolingHttpClientConnectionManager connectionManager) {
            this.connectionManager = connectionManager;
        }

        public void run() {
            //关闭失效的连接
            connectionManager.closeExpiredConnections();
            //关闭15s内不活动的连接
            connectionManager.closeIdleConnections(60, TimeUnit.SECONDS);
        }
    }

}
