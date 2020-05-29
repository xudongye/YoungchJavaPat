package com.youngch.pat.common.beyond.hepler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.common.beyond.model.request.ApiReqModel;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReqCommonHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReqCommonHelper.class);

    private static final String DOMAIN = "chunzhu";

    private static final String APP_KEY = "ycdzapp";

    private static final String URI = "http://openapi.beyondh.com";

    private static final String CHANNEL_KEY = "ycdz";

    private static final String AI_PMS = "http://aihotel.youngch-cloud.com/ai/pms/communicate";

    public static ApiReqModel getCommonRequestModel(String method, String bizContent) {
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = format.format(now);
        ApiReqModel responseModel = new ApiReqModel();
        responseModel.setChannelKey(CHANNEL_KEY);
        responseModel.setSignType("MD5");
        responseModel.setFormat("json");
        responseModel.setCharset("utf-8");
        responseModel.setVersion("1.0");
        responseModel.setTimestamp(timeStamp);
        responseModel.setBizContent(bizContent);
        responseModel.setMethod(method);

        return responseModel;
    }

    public static ResponseEntity<String> getRemoteRequest(ApiReqModel reqModel) {
        SignHelper.Sign(reqModel, APP_KEY);
        HttpHeaders headers = new HttpHeaders();
        headers.add("domain", DOMAIN);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        try {
            java.net.URI uri = new URI(URI);
            RequestEntity<ApiReqModel> requestEntity = new RequestEntity<ApiReqModel>(reqModel, headers, HttpMethod.POST, uri);
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustStrategy() {
                        @Override
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            return true;
                        }
                    })
                    .build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    //.setProxy(new HttpHost("127.0.0.1",8888))
                    .build();
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
            RestTemplate template = new RestTemplate(factory);
            return template.exchange(requestEntity, String.class);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        throw new IllegalArgumentException("【BEYOND】The call on to fail");
    }

    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static String callOnAiPmsServer(String responseBean) {
        HttpPost httpPost = new HttpPost(AI_PMS);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/octet-stream");
        StringEntity se = null;
        try {
            se = new StringEntity(responseBean, "utf-8");
            se.setContentType("application/octet-stream");
            se.setContentEncoding("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        httpPost.setEntity(se);
        return responseHandler(httpPost);
    }

    private static String responseHandler(HttpPost httpPost) {
        String result = "";
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    org.apache.http.HttpEntity entity = response.getEntity();
                    String result = entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
                    EntityUtils.consume(entity);
                    return result;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };

        try {
            result = httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

}
