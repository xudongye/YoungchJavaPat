package com.youngch.pat.web;

import com.youngch.pat.beyond.model.request.HotelInfoRequestModel;
import com.youngch.pat.beyond.model.request.HotelSearchRequestModel;
import com.youngch.pat.beyond.model.response.ApiRespModel;
import com.youngch.pat.beyond.model.response.HotelInfoResponseModel;
import com.youngch.pat.beyond.model.response.HotelSearchResponseModel;
import com.youngch.pat.beyond.service.BeyondService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "beyond-hotel")
@RestController
@RequestMapping(value = "/api/youngch/v1/beyond")
public class BeyondHotelSearchController {

    @Autowired
    private BeyondService beyondService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> test(HttpServletRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("path", request.getServletPath());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店列表请求接口", notes = "别样红第三方酒店搜索接口", httpMethod = "POST")
    @RequestMapping(value = "/hotels", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> searchHotel(HttpServletRequest request,
                                                           @RequestBody HotelSearchRequestModel requestModel) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel<List<HotelSearchResponseModel>> responseModel = beyondService.onSearchHotel(requestModel);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "别样红搜索酒店基本信息请求接口", notes = "别样红第三方酒店基本信息接口", httpMethod = "GET")
    @RequestMapping(value = "/hotelInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> searchHotel(HttpServletRequest request,
                                                           @RequestParam Long OrgId) {
        Map<String, Object> responseBody = new HashMap<>();
        ApiRespModel<HotelInfoResponseModel> responseModel = beyondService.onHotelInfo(OrgId);
        responseBody.put("success", true);
        responseBody.put("data", responseModel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
