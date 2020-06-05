package com.youngch.pat.pay.service.impl;

import com.youngch.pat.mapper.PayOrderMapper;
import com.youngch.pat.model.PayOrder;
import com.youngch.pat.model.PayOrderExample;
import com.youngch.pat.pay.dao.PayOrderDao;
import com.youngch.pat.pay.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:58
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PayOrderDao payOrderDao;


    @Override
    public PayOrder getNotPaidByOrderId(String orderId, int payType, String tradeType) {
        PayOrderExample example = new PayOrderExample();
        example.createCriteria()
                .andPmsOrderIdEqualTo(orderId)
                .andPaidEqualTo(false)
                .andPayTypeEqualTo(payType)
                .andTradeTypeEqualTo(tradeType);
        List<PayOrder> payOrders = payOrderMapper.selectByExample(example);
        if (payOrders.isEmpty()) {
            return null;
        }
        return payOrders.get(0);
    }

    @Override
    public PayOrder getByOutTradeNo(String outTradeNo) {
        return payOrderDao.getByOutTradeNo(outTradeNo);
    }

    @Override
    public void create(PayOrder payOrder) {
        payOrderMapper.insert(payOrder);
    }

    @Override
    public void update(PayOrder payOrder) {
        payOrderMapper.updateByPrimaryKey(payOrder);
    }
}
