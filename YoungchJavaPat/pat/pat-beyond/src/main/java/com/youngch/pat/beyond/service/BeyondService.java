package com.youngch.pat.beyond.service;

import com.youngch.pat.beyond.model.request.hotel.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.request.order.AddOrderRequestModel;
import com.youngch.pat.beyond.model.request.order.CheckInRequestModel;
import com.youngch.pat.beyond.model.response.*;

import java.util.List;

public interface BeyondService {

    ApiRespModel onSearchHotel(HotelSearchRequestModel requestModel);

    ApiRespModel onHotelInfo(HotelInfoRequestModel requestModel);

    ApiRespModel onRoomStatus(HotelRoomStatusRequestModel requestModel);

    ApiRespModel onAddOrder(AddOrderRequestModel requestModel);

    ApiRespModel onCheckInQuery(CheckInRequestModel requestModel);
}
