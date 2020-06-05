package com.youngch.pat.pay.dao;

import com.youngch.pat.model.PayOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yexudong
 * @Date: 2020/6/3 15:28
 */
public interface PayOrderDao {

    PayOrder getByOutTradeNo(@Param(value = "outTradeNo") String outTradeNo);

}
