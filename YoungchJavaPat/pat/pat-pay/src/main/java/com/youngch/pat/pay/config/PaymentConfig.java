package com.youngch.pat.pay.config;

import com.youngch.pat.common.utils.enums.EnumUtil;
import com.youngch.pat.pay.business.HandleAliPayResultBusiness;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.exception.BusinessTypeNotSupportException;
import com.youngch.pat.pay.service.PayBusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/6/4 15:40
 */
@Configuration
public class PaymentConfig {


    public static PayBusinessDelegate getBusinessDelegate(Map<String, PayBusinessDelegate> payBusinessDelegateMap, int businessType) {
        String serviceName = EnumUtil.getEnumObjectName(businessType, PayConstant.BusinessType.class) + "PayBusinessDelegateImpl";
        if (payBusinessDelegateMap.containsKey(serviceName)) {
            return payBusinessDelegateMap.get(serviceName);
        }
        throw new BusinessTypeNotSupportException();
    }

    public static void doHandlePayResultBusiness(HttpServletRequest request, HandleAliPayResultBusiness.ResultListener listener) throws UnsupportedEncodingException {
        new HandleAliPayResultBusiness().handle(request, listener);
    }

}
