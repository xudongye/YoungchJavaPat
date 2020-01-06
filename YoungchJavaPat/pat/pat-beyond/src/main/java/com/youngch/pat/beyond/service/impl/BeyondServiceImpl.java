package com.youngch.pat.beyond.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.youngch.pat.beyond.constant.BeyondConstant;
import com.youngch.pat.beyond.exception.BeyondCallOnFailException;
import com.youngch.pat.beyond.hepler.JsonHelper;
import com.youngch.pat.beyond.hepler.ReqCommonHelper;
import com.youngch.pat.beyond.hepler.SignHelper;
import com.youngch.pat.beyond.model.request.ApiReqModel;
import com.youngch.pat.beyond.model.request.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.HotelInfoResponseModel;
import com.youngch.pat.beyond.model.response.HotelRoomStatusResponseModel;
import com.youngch.pat.beyond.model.response.HotelSearchResponseModel;
import com.youngch.pat.beyond.service.BeyondService;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

@Service
public class BeyondServiceImpl implements BeyondService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeyondServiceImpl.class);

    @Value("${domain}")
    private String domain;

    private final String APP_KEY = "6AF0062B-9C6D-4796-8760-803779CF7E48";

    private final String URI = "https://cpmsinterface.test.beyondh.com:7898/";

    @Override
    public ApiRespModel<HotelSearchResponseModel> onSearchHotel(HotelSearchRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_SearchHotelWithRoomPriceAndRoomCount.getName(), bizContent);
        ApiRespModel<HotelSearchResponseModel> respModel = handleApiResult(reqModel);
        LOGGER.info("酒店列表: call on method hotel with room price and count,result code {} message {}", respModel.Code, respModel.Message);
        return respModel;

    }

    @Override
    public ApiRespModel<HotelInfoResponseModel> onHotelInfo(HotelInfoRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);

        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetOrgInfo.getName(), bizContent);

        ApiRespModel<HotelInfoResponseModel> respModel = handleApiResult(reqModel);
        LOGGER.info("酒店信息: call on method with hotel info , result code {} message {}", respModel.Code, respModel.Message);
        return respModel;

    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void pollRoomStatus() {
        HotelRoomStatusRequestModel requestModel = new HotelRoomStatusRequestModel();
        requestModel.setOrgId(1L);
        requestModel.setRoomNos(new String[]{"801", "802", "803"});
        ApiRespModel<HotelRoomStatusResponseModel> respModel = onRoomStatus(requestModel);
        if (respModel.Code.equals("10000")) {
            List<HotelRoomStatusResponseModel> responseModels = respModel.Data;
            for (HotelRoomStatusResponseModel responseModel : responseModels) {
                switch (responseModel.getStatus()) {
                    case "VD":
                        LOGGER.info("房间{}状态为空脏", responseModel.getRoomNo());
                    case "VC":
                        LOGGER.info("房间{}状态为空净", responseModel.getRoomNo());
                    case "OOO":
                        LOGGER.info("房间{}状态为维修房", responseModel.getRoomNo());
                    case "OD":
                        LOGGER.info("房间{}状态为住脏", responseModel.getRoomNo());
                    case "OC":
                        LOGGER.info("房间{}状态为住净", responseModel.getRoomNo());
                }
            }
        }
    }

    @Override
    public ApiRespModel<HotelRoomStatusResponseModel> onRoomStatus(HotelRoomStatusRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetRoomStatus.getName(), bizContent);

        ApiRespModel<HotelRoomStatusResponseModel> respModel = handleApiResult(reqModel);

        LOGGER.info("房态查询: call on method with hotel room status, result code {} message {}", respModel.Code, respModel.Message);

        return respModel;
    }

    private <E> ApiRespModel<E> handleApiResult(ApiReqModel reqModel) {
        ApiRespModel<E> result = new ApiRespModel<>();

        SignHelper.Sign(reqModel, APP_KEY);

        HttpHeaders headers = new HttpHeaders();
        headers.add("domain", domain);
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
            ResponseEntity<String> responseMessage = template.exchange(requestEntity, String.class);
            LOGGER.info("beyond api result: {}", responseMessage.getBody());
            result = JsonHelper.DeserializeObject(responseMessage.getBody(), new TypeReference<ApiRespModel<HotelSearchResponseModel>>() {
            });
            if (result != null && "10000".equals(result.Code)) {
                return result;
            }
        } catch (Exception e) {
            LOGGER.error("别样红接口访问失败，错误原因{}", e.getMessage());
        }
        throw new BeyondCallOnFailException();
    }

}
