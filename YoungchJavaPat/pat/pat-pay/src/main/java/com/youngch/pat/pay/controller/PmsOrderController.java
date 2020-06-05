package com.youngch.pat.pay.controller;

import com.youngch.pat.model.PmsOrder;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.domain.PmsOrderParam;
import com.youngch.pat.pay.exception.PayMethodNotSupportException;
import com.youngch.pat.pay.service.PmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/6/5 13:51
 */
@Api(tags = "PmsOrderController")
@RestController
@RequestMapping(value = "/v1/pms-orders")
public class PmsOrderController {

    @Autowired
    private PmsOrderService pmsOrderService;

    @ApiOperation(value = "PMS订单推送记录", httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> onOrder(HttpServletRequest request,
                                                       @RequestBody PmsOrderParam payOrderParam) {

        Map<String, Object> responseBody = new HashMap<>();
        PmsOrder pmsOrder = pmsOrderService.create(payOrderParam);
        responseBody.put("success", true);
        responseBody.put("data", pmsOrder);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

}
