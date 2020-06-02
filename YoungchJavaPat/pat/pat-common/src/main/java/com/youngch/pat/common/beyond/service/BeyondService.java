package com.youngch.pat.common.beyond.service;

import com.youngch.pat.common.beyond.model.request.*;
import com.youngch.pat.common.beyond.model.request.AddOrderRequestModel;
import com.youngch.pat.common.beyond.model.request.CheckInRequestModel;
import com.youngch.pat.common.beyond.model.response.*;

public interface BeyondService {

    ApiRespModel onSearchHotel(HotelSearchRequestModel requestModel);

    ApiRespModel onHotelInfo(HotelInfoRequestModel requestModel);

    ApiRespModel onGetAvailableRooms(GetAvailableRoomsRequestModel requestModel);

    ApiRespModel onRoomStatus(HotelRoomStatusRequestModel requestModel);

    ApiRespModel onAddOrder(AddOrderRequestModel requestModel);

    ApiRespModel onCheckInQuery(CheckInRequestModel requestModel);

    ApiRespModel onSearchOrgWithRoomPriceAndRoomCount(SearchOrgWithRoomPriceAndRoomCountRequestModel requestModel);

    ApiRespModel onGetOrgRoomTypes(GetOrgRoomTypesRequestModel requestModel);

    ApiRespModel onGetMemberHourRentPrice(GetMemberHourRentPriceRequestModel requestModel);

    ApiRespModel onSearchMembers(SearchMembersRequestModel requestModel);

    ApiRespModel onQueryOrders(QueryOrdersRequestModel queryOrdersRequestModel);

    ApiRespModel onQuerySingleOrder(QuerySingleOrderRequestModel requestModel);

    ApiRespModel onAddCheckIn(AddCheckInRequestModel requestModel);
}
