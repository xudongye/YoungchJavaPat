package com.youngch.pat.beyond.service;

import com.youngch.pat.beyond.model.request.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.HotelInfoResponseModel;
import com.youngch.pat.beyond.model.response.HotelSearchResponseModel;

public interface BeyondService {

    ApiRespModel<HotelSearchResponseModel> onSearchHotel(HotelSearchRequestModel requestModel);

    ApiRespModel<HotelInfoResponseModel> onHotelInfo(HotelInfoRequestModel requestModel);
}
