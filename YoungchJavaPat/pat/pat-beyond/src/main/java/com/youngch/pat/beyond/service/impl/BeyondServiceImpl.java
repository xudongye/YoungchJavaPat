package com.youngch.pat.beyond.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngch.pat.beyond.constant.BeyondConstant;
import com.youngch.pat.beyond.exception.ResultResolveFailException;
import com.youngch.pat.beyond.hepler.JsonHelper;
import com.youngch.pat.beyond.hepler.ReqCommonHelper;
import com.youngch.pat.beyond.model.request.ApiReqModel;
import com.youngch.pat.beyond.model.request.hotel.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.request.order.AddOrderRequestModel;
import com.youngch.pat.beyond.model.request.order.CheckInRequestModel;
import com.youngch.pat.beyond.model.response.*;
import com.youngch.pat.beyond.service.BeyondService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;


@Service
public class BeyondServiceImpl implements BeyondService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeyondServiceImpl.class);

    @Override
    public ApiRespModel onSearchHotel(HotelSearchRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_SearchHotelWithRoomPriceAndRoomCount.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.info("酒店列表: {}", respModel.Data);
        return respModel;

    }

    @Override
    public ApiRespModel onHotelInfo(HotelInfoRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetOrgInfo.getName(), bizContent);

        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.info("酒店信息: {}", respModel.Data);
        return respModel;

    }

    @Override
    public ApiRespModel onRoomStatus(HotelRoomStatusRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetRoomStatus.getName(), bizContent);

        ApiRespModel respModel = handleApiResult(reqModel);

        LOGGER.info("房态查询: {}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onAddOrder(AddOrderRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_Add.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.info("创建订单：{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onCheckInQuery(CheckInRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_Query_CheckIns.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("入住查询：{}", respModel.Data);
        return respModel;
    }

    private ApiRespModel handleApiResult(ApiReqModel reqModel) {

        ResponseEntity<String> responseMessage = ReqCommonHelper.getRemoteRequest(reqModel);

        LOGGER.info("beyond api result: {}", responseMessage.getBody());

        ApiRespModel result = JsonHelper.DeserializeObject(responseMessage.getBody(), new TypeReference<ApiRespModel>() {
        });

        if (result == null) {
            throw new ResultResolveFailException(responseMessage.getBody());
        }
        if (result.Code == 10000) {
            return result;
        }
        throw new ResultResolveFailException(result.SubMessage);
    }

}
