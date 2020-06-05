package com.youngch.pat.pay.service;

import com.youngch.pat.model.PayConfig;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:37
 */
public interface PayConfigService {

    PayConfig getByHotelId(String hotelId, int payType);
}
