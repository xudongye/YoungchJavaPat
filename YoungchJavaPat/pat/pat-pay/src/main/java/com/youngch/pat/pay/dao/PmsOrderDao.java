package com.youngch.pat.pay.dao;

import com.youngch.pat.model.PmsOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @author: yexudong
 * @Date: 2020/6/3 9:50
 */
public interface PmsOrderDao {

    PmsOrder getByOrderId(@Param("orderId") String orderId);

    void markOrderPaid(@Param("orderId") String orderId, @Param("payType") int payType);
}
