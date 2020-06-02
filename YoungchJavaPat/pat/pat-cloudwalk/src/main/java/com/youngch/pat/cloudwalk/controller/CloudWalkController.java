package com.youngch.pat.cloudwalk.controller;

import com.youngch.pat.cloudwalk.constant.CloudWalkConstant;
import com.youngch.pat.cloudwalk.service.CheckInParam;
import com.youngch.pat.cloudwalk.service.CloudWalkService;
import com.youngch.pat.cloudwalk.service.HotelRoomQueryCondition;
import com.youngch.pat.cloudwalk.service.MemberQueryCondition;
import com.youngch.pat.cloudwalk.vo.*;
import com.youngch.pat.common.beyond.model.response.ApiRespModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/5/26 14:06
 */
@Api(tags = "CloudWalkController")
@RestController
@RequestMapping(value = "/v1/cloud-walk")
public class CloudWalkController {

    @Autowired
    private CloudWalkService cloudWalkService;

    @ApiOperation(value = "查询订单详情", httpMethod = "GET")
    @RequestMapping(value = "/singleOrderInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> singleOrderInfo(HttpServletRequest request,
                                                               @RequestParam @ApiParam(name = "hotelId", value = "酒店编号", required = true) String hotelId,
                                                               @RequestParam @ApiParam(name = "orderId", value = "订单编号", required = true) String orderId) {
        Map<String, Object> responseBody = new HashMap<>();
        PreOrderInfo orderInfo = cloudWalkService.getSingleOrder(orderId, hotelId);
        responseBody.put("success", true);
        responseBody.put("data", orderInfo);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "办理入住", httpMethod = "POST")
    @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addOrder(HttpServletRequest request,
                                                        @RequestBody CheckInParam checkInParam) {
        Map<String, Object> responseBody = new HashMap<>();
        boolean isChecked = cloudWalkService.checkIn(checkInParam);
        responseBody.put("success", isChecked);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }


    @ApiOperation(value = "通过入住用户身份信息查询预订单", httpMethod = "GET")
    @RequestMapping(value = "/preOrderInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> orderInfo(HttpServletRequest request,
                                                         @RequestParam @ApiParam(name = "hotelId", value = "酒店编号", required = true) String hotelId,
                                                         @RequestParam @ApiParam(name = "keyword", value = "关键字，预订人或者联系人的姓名和手机号", required = true) String keyword) {
        Map<String, Object> responseBody = new HashMap<>();
        List<PreOrderInfo> preOrderInfos = cloudWalkService.getOrderByLiaison(hotelId, keyword);
        responseBody.put("success", true);
        responseBody.put("data", preOrderInfos);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "通过条件查询会员信息", httpMethod = "GET")
    @RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> memberInfo(HttpServletRequest request,
                                                          @RequestParam @ApiParam(name = "idCardNo", value = "身份证号", required = false) String idCardNo) {
        Map<String, Object> responseBody = new HashMap<>();
        MemberQueryCondition condition = new MemberQueryCondition();
        condition.setIdCardNo(idCardNo);
        MemberInfo memberInfo = cloudWalkService.getMember(condition);
        responseBody.put("success", true);
        responseBody.put("data", memberInfo);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "酒店信息获取接口-场景：入住机所在酒店首页展示", httpMethod = "GET")
    @RequestMapping(value = "/hotelInfo/{hotelId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> hotelInfo(HttpServletRequest request,
                                                         @PathVariable @ApiParam(name = "hotelId", value = "酒店编号", required = true) String hotelId) {
        Map<String, Object> responseBody = new HashMap<>();
        Hotel hotel = cloudWalkService.getHotelInfo(hotelId);
        responseBody.put("success", true);
        responseBody.put("data", hotel);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "酒店房型查看-场景：入住机所在酒店房型展示", httpMethod = "GET")
    @RequestMapping(value = "/hotelRoomTypes", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> roomTypeList(HttpServletRequest request,
                                                            @RequestParam @ApiParam(name = "hotelId", value = "酒店编号", required = true) String hotelId,
                                                            @RequestParam @ApiParam(name = "arriveTime", value = "格式：yyyy-MM-dd HH:mm:ss", required = false) String arriveTime,
                                                            @RequestParam @ApiParam(name = "departureTime", value = "格式：yyyy-MM-dd HH:mm:ss", required = false) String departureTime,
                                                            @RequestParam @ApiParam(name = "checkInType", value = "入住类型：Normal、LongTerm、Trip、Conference、Free", required = true) CloudWalkConstant.CheckInType checkInType) {

        Map<String, Object> responseBody = new HashMap<>();
        HotelRoomQueryCondition condition = new HotelRoomQueryCondition();
        condition.setHotelId(hotelId);
        condition.setArriveTime(arriveTime);
        condition.setDepartureTime(departureTime);
        condition.setCheckInType(checkInType);
        List<RoomTypeInfo> roomTypeInfos = cloudWalkService.getHotelRoomTypeCountAndPriceList(condition);
        responseBody.put("success", true);
        responseBody.put("data", roomTypeInfos);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @ApiOperation(value = "根据房型列出房间-场景：入住机所在酒店房间选择", httpMethod = "GET")
    @RequestMapping(value = "/hotelRooms", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRoomList(HttpServletRequest request,
                                                           @RequestParam @ApiParam(name = "hotelId", value = "酒店编号", required = true) String hotelId,
                                                           @RequestParam @ApiParam(name = "arriveTime", value = "格式：yyyy-MM-dd HH:mm:ss", required = false) String arriveTime,
                                                           @RequestParam @ApiParam(name = "departureTime", value = "格式：yyyy-MM-dd HH:mm:ss", required = false) String departureTime,
                                                           @RequestParam @ApiParam(name = "checkInType", value = "入住类型：Normal、LongTerm、Trip、Conference、Free", required = true) CloudWalkConstant.CheckInType checkInType,
                                                           @RequestParam @ApiParam(name = "roomTypeIds", value = "房间类型：[\"DR\",\"DT\",\"TR\"]", required = true) String[] roomTypeIds) {

        Map<String, Object> responseBody = new HashMap<>();
        HotelRoomQueryCondition condition = new HotelRoomQueryCondition();
        condition.setHotelId(hotelId);
        condition.setArriveTime(arriveTime);
        condition.setDepartureTime(departureTime);
        condition.setCheckInType(checkInType);
        condition.setRoomTypeIds(roomTypeIds);
        List<Room> rooms = cloudWalkService.getRoomByRoomType(condition);
        responseBody.put("success", true);
        responseBody.put("data", rooms);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
