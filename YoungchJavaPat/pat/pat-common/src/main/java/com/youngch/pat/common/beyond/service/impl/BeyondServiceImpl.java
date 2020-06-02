package com.youngch.pat.common.beyond.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.youngch.pat.common.beyond.constant.BeyondConstant;
import com.youngch.pat.common.beyond.hepler.JsonHelper;
import com.youngch.pat.common.beyond.hepler.ReqCommonHelper;
import com.youngch.pat.common.beyond.model.request.*;
import com.youngch.pat.common.beyond.model.request.AddOrderRequestModel;
import com.youngch.pat.common.beyond.model.request.CheckInRequestModel;
import com.youngch.pat.common.beyond.model.response.*;
import com.youngch.pat.common.beyond.service.BeyondService;
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
        LOGGER.debug("【酒店列表】: {}", respModel.Data);
        return respModel;

    }

    @Override
    public ApiRespModel onHotelInfo(HotelInfoRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetOrgInfo.getName(), bizContent);

        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【酒店信息】: {}", respModel.Data);
        return respModel;

    }

    @Override
    public ApiRespModel onGetAvailableRooms(GetAvailableRoomsRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Hotel_GetAvailableRooms.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【酒店空房】：{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onRoomStatus(HotelRoomStatusRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(
                BeyondConstant.BeyondMethod.Hotel_GetRoomStatus.getName(), bizContent);

        ApiRespModel respModel = handleApiResult(reqModel);

        LOGGER.debug("【房态查询】: {}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onAddOrder(AddOrderRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_Add.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【创建订单】：{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onCheckInQuery(CheckInRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_Query_CheckIns.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【入住查询】：{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onSearchOrgWithRoomPriceAndRoomCount(SearchOrgWithRoomPriceAndRoomCountRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Hotel_SearchOrgWithRoomPriceAndRoomCount.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【查询酒店房量房价】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onGetOrgRoomTypes(GetOrgRoomTypesRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Hotel_GetOrgRoomTypes.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【查询酒店房型】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onGetMemberHourRentPrice(GetMemberHourRentPriceRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Hotel_GetMemberHourRentPrice.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【查询酒店房型】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onSearchMembers(SearchMembersRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Member_SearchMembers.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【会员信息查询】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onQueryOrders(QueryOrdersRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_QueryOrders.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【预订单查询】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onQuerySingleOrder(QuerySingleOrderRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_QuerySingleOrder.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【单个订单详情】:{}", respModel.Data);
        return respModel;
    }

    @Override
    public ApiRespModel onAddCheckIn(AddCheckInRequestModel requestModel) {
        String bizContent = JsonHelper.SerializeObject(requestModel);
        ApiReqModel reqModel = ReqCommonHelper.getCommonRequestModel(BeyondConstant.BeyondMethod.Order_AddCheckin.getName(), bizContent);
        ApiRespModel respModel = handleApiResult(reqModel);
        LOGGER.debug("【办理入住】:{}", respModel.Data);
        return respModel;
    }

    private ApiRespModel handleApiResult(ApiReqModel reqModel) {

        ResponseEntity<String> responseMessage = ReqCommonHelper.getRemoteRequest(reqModel);

        LOGGER.debug("beyond api result: {}", responseMessage.getBody());

        ApiRespModel result = JsonHelper.DeserializeObject(responseMessage.getBody(), new TypeReference<ApiRespModel>() {
        });

        if (result == null) {
            throw new IllegalArgumentException(responseMessage.getBody());
        }
        if (result.Code != 10000) {
            throw new IllegalArgumentException(result.SubMessage);
        }
        return result;
    }

}
