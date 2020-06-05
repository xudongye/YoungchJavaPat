package com.youngch.pat.pay.service;

import com.youngch.pat.common.utils.enums.EnumUtil;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.exception.InvalidOutTradeNoPrefixException;
import com.youngch.pat.pay.exception.BusinessTypeNotSupportException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:40
 */
public class OutTradeNoGenerator {

    public static final String beyond_prefix_tag = "BEYOND";

    public static final String zhuzher_prefix_tag = "ZHUZHER";


    public static String generate(int orderType) {
        String prefix_tag = getPrefixTag(orderType);
        String currentDateTimeText = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        String randomNumber = (Math.random() + "").replace(".", "").substring(0, 6);
        return prefix_tag + currentDateTimeText + randomNumber;
    }

    public static int getBusinessTypeByOutTradePrefixTag(String outTradeNo) throws InvalidOutTradeNoPrefixException {

        if (outTradeNo.startsWith(OutTradeNoGenerator.beyond_prefix_tag)) {
            return PayConstant.BusinessType.Beyond.getCode();
        }

        if (outTradeNo.startsWith(OutTradeNoGenerator.zhuzher_prefix_tag)) {
            return PayConstant.BusinessType.ZhuZher.getCode();
        }

        throw new InvalidOutTradeNoPrefixException();
    }

    private static String getPrefixTag(int businessType) {
        switch (businessType) {
            case 1:
                return beyond_prefix_tag;
            case 2:
                return zhuzher_prefix_tag;
            default:
                throw new BusinessTypeNotSupportException();
        }
    }



}
