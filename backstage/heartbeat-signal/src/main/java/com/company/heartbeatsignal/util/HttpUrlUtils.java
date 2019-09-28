package com.company.heartbeatsignal.util;

import com.company.heartbeatsignal.exception.CheckedException;
import com.company.heartbeatsignal.exception.UnCheckedException;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author Liquid
 * @类名： HttpRequestUtils
 * @描述：
 * @date 2019/4/13
 */
public class HttpUrlUtils {

    private static HttpClientBuilder httpClientBuilder;

    private static RequestConfig requestConfig;

    private static ThreadLocal<StringBuilder> stringBuilderThreadLocal = ThreadLocal.withInitial(StringBuilder::new);

    private static Charset charset = Charset.forName("UTF-8");

    static {
        requestConfig = RequestConfig.custom().setConnectTimeout(1000).setConnectionRequestTimeout(1000).setSocketTimeout(10000).build();
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(100);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(10);
        httpClientBuilder = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager);
    }

    public static String sendGetWithStringParams(String url, String params) throws CheckedException {

        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url + "?" + params);
        httpGet.setConfig(requestConfig);
        return getResponse(httpClient, httpGet);
    }

    public static String sendGetWithStringParams(String url, String params, Map<String, String> headers) throws CheckedException {

        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpGet httpGet = new HttpGet(url + "?" + params);
        String key = headers.keySet().iterator().next();
        httpGet.setHeader(key, headers.get(key));
        httpGet.setConfig(requestConfig);
        return getResponse(httpClient, httpGet);
    }

    public static String sendGetWithParams(String url, Map<String, String> map) throws CheckedException {
        String newUrl = url;
        CloseableHttpClient httpClient = httpClientBuilder.build();
        if (map != null) {
            StringBuilder stringBuilder = stringBuilderThreadLocal.get();
            stringBuilder.append(url).append("?");
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                stringBuilder.append(stringStringEntry.getKey())
                        .append("=")
                        .append(stringStringEntry.getValue())
                        .append("&");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            newUrl = stringBuilder.toString();
        }
        HttpGet httpGet = new HttpGet(newUrl);
        httpGet.setConfig(requestConfig);

        return getResponse(httpClient, httpGet);
    }

    public static String sendPost(String url) throws CheckedException {
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        return getResponse(httpClient, httpPost);
    }

    public static String sendPostWithParamsString(String url, String params) throws CheckedException {
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new ByteArrayEntity(params.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new CheckedException("参数转换异常" + e.toString());
        }
        return getResponse(httpClient, httpPost);
    }

    public static String sendPostWithParamsMap(String url, Map<String, String> map) throws CheckedException {
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            params.add(new BasicNameValuePair(stringStringEntry.getKey(), stringStringEntry.getValue()));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, charset));
        return getResponse(httpClient, httpPost);
    }

    public static String sendPostJson(String url, String jsonParams) throws CheckedException {
        CloseableHttpClient httpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(jsonParams, charset));
        return getResponse(httpClient, httpPost);
    }

    private static String getResponse(CloseableHttpClient httpClient, HttpRequestBase httpRequestBase) throws CheckedException {
        CloseableHttpResponse httpResponse = null;
        String result;
        try {
            httpResponse = httpClient.execute(httpRequestBase);
            if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new UnCheckedException("发送Http请求状态码异常:" + (httpResponse.getStatusLine().getStatusCode()));
            }
            result = EntityUtils.toString(httpResponse.getEntity(), charset);

        } catch (IOException e) {
            throw new CheckedException("发送Http请求异常:" + e.toString());
        } finally {

            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static String getUrlWithParams(String url, Map<String, String> params) {
        StringBuilder result = new StringBuilder(url);
        result.append("?");
        for (Map.Entry<String, String> paramsEntry : params.entrySet()) {
            result.append(paramsEntry.getKey()).append("=").append(paramsEntry.getValue()).append("&");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static String transformToGetParams(Map<String, String> params) {

        Set<String> keySet = params.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);

        Collections.sort(keyList);

        StringBuilder result = new StringBuilder();
        for (String param : keyList) {
            result.append(param).append("=").append(params.get(param)).append("&");
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println("result = " + result);
        return result.toString();
    }

}
