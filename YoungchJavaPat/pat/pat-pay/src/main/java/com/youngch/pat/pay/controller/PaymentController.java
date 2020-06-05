package com.youngch.pat.pay.controller;

import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.domain.PayOrderParam;
import com.youngch.pat.pay.exception.PayMethodNotSupportException;
import com.youngch.pat.pay.service.PayService;
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
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/6/4 15:42
 */
@Api(tags = "PaymentController")
@RestController
@RequestMapping(value = "/v1/payments")
public class PaymentController {

    @Autowired
    private PayService payService;

    @ApiOperation(value = "支付统一下单接口", httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity onPayment(HttpServletRequest request,
                                    @RequestBody PayOrderParam payOrderParam) {
        if (payOrderParam.getPayType().getCode() == PayConstant.PayType.AliPay.getCode()) {
            if (payOrderParam.getTradeType().getCode() == PayConstant.TradeType.NATIVE.getCode()) {
                return new ResponseEntity<>(payService.aliPayPreCreate(payOrderParam), HttpStatus.CREATED);
            }
        }
        throw new PayMethodNotSupportException(payOrderParam.getPayType().getName(), payOrderParam.getTradeType().getName());
    }

}
