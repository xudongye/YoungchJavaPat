package com.youngch.pat.beyond.service;

import com.youngch.pat.beyond.model.request.hotel.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.request.order.AddOrderRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.HotelInfoResponseModel;
import com.youngch.pat.beyond.model.response.HotelRoomStatusResponseModel;
import com.youngch.pat.beyond.model.response.HotelSearchResponseModel;

import java.util.List;

public interface BeyondService {

    ApiRespModel<List<HotelSearchResponseModel>> onSearchHotel(HotelSearchRequestModel requestModel);

    ApiRespModel<HotelInfoResponseModel> onHotelInfo(HotelInfoRequestModel requestModel);

    ApiRespModel<List<HotelRoomStatusResponseModel>> onRoomStatus(HotelRoomStatusRequestModel requestModel);

    ApiRespModel<String> onAddOrder(AddOrderRequestModel requestModel);
}
