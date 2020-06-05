package com.youngch.pat.pay.service.impl;

import com.youngch.pat.mapper.PayConfigMapper;
import com.youngch.pat.model.PayConfig;
import com.youngch.pat.model.PayConfigExample;
import com.youngch.pat.pay.service.PayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:38
 */
@Service
public class PayConfigServiceImpl implements PayConfigService {

    @Autowired
    private PayConfigMapper payConfigMapper;

    @Override
    public PayConfig getByHotelId(String hotelId, int payType) {
        PayConfigExample example = new PayConfigExample();
        example.createCriteria().andHotelIdEqualTo(hotelId).andPayTypeEqualTo(payType);
        List<PayConfig> payConfigs = payConfigMapper.selectByExample(example);
        if (payConfigs.isEmpty()) {
            return null;
        }
        return payConfigs.get(0);
    }
}
