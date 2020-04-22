package com.youngch.pat.beyond.controller;

import com.youngch.pat.beyond.model.request.hotel.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelRoomStatusRequestModel;
import com.youngch.pat.beyond.model.request.hotel.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.request.order.AddOrderRequestModel;
import com.youngch.pat.beyond.model.request.order.CheckInRequestModel;
import com.youngch.pat.beyond.model.response.*;
import com.youngch.pat.beyond.service.BeyondService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "beyond-pms")
@RestController
@RequestMapping(value = "/api/youngch/v1/beyond")
public class BeyondHotelSearchController {

    @Autowired
    private BeyondService beyondService;

    @ApiOperation(value = "别样红测试接口", httpMethod = "GET")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> test(HttpServletRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("path", request.getServletPath());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店列表请求接口", httpMethod = "POST")
    @RequestMapping(value = "/hotelSearch", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> searchHotel(HttpServletRequest request,
                                                           @RequestBody HotelSearchRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel responseModel = beyondService.onSearchHotel(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @ApiOperation(value = "别样红搜索酒店基本信息请求接口", httpMethod = "POST")
    @RequestMapping(value = "/hotelInfo", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> searchInfo(HttpServletRequest request,
                                                          @RequestBody HotelInfoRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel responseModel = beyondService.onHotelInfo(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店创建订单", httpMethod = "POST")
    @RequestMapping(value = "/orderAdd", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addOrder(HttpServletRequest request,
                                                        @RequestBody AddOrderRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel responseModel = beyondService.onAddOrder(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店房态查询", httpMethod = "POST")
    @RequestMapping(value = "/roomStatus", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> roomStatus(HttpServletRequest request,
                                                          @RequestBody HotelRoomStatusRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel responseModel = beyondService.onRoomStatus(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店入住查询", httpMethod = "POST")
    @RequestMapping(value = "/checkInQuery", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> checkInQuery(HttpServletRequest request,
                                                            @RequestBody CheckInRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel responseModel = beyondService.onCheckInQuery(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
