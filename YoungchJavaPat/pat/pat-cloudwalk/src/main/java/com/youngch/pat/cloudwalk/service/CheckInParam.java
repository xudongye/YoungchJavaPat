package com.youngch.pat.cloudwalk.service;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 10:43
 */
@Data
public class CheckInParam {

    @ApiParam(name = "hotelId", value = "酒店编号", required = true)
    private String hotelId;
    @ApiParam(name = "orderId", value = "通过查询获取到有效的订单id", required = true)
    private String orderId;
    @ApiParam(name = "occupationId", value = "通过查询获取到有效的占房id", required = true)
    private String occupationId;
    @ApiParam(name = "name", value = "用户性名，通过身份证识别", required = true)
    private String name;
    @ApiParam(name = "idCardNo", value = "身份证号码，通过身份证识别", required = true)
    private String idCardNo;
    @ApiParam(name = "mobile", value = "用户手机号", required = true)
    private String mobile;
    @ApiParam(name = "iCheckIn", value = "通过人脸识别判断是否本人办理入住", required = true)
    private boolean iCheckIn;
}
