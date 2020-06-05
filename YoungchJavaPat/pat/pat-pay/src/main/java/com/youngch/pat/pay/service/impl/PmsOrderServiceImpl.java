package com.youngch.pat.pay.service.impl;

import com.youngch.pat.mapper.PmsOrderMapper;
import com.youngch.pat.model.PmsOrder;
import com.youngch.pat.model.PmsOrderExample;
import com.youngch.pat.pay.constant.PayConstant;
import com.youngch.pat.pay.dao.PmsOrderDao;
import com.youngch.pat.pay.domain.PmsOrderParam;
import com.youngch.pat.pay.exception.PmsOrderNotFoundException;
import com.youngch.pat.pay.service.PmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/6/2 16:20
 */
@Service
public class PmsOrderServiceImpl implements PmsOrderService {

    @Autowired
    private PmsOrderMapper pmsOrderMapper;

    @Autowired
    private PmsOrderDao pmsOrderDao;

    @Override
    public PmsOrder create(PmsOrderParam pmsOrderParam) {
        PmsOrder pmsOrder = new PmsOrder();
        pmsOrder.setHotelId(pmsOrderParam.getHotelId());
        pmsOrder.setOccupationId(pmsOrderParam.getOccupationId());
        pmsOrder.setOrderId(pmsOrderParam.getOrderId());
        pmsOrder.setPayStatus(PayConstant.PayStatus.Created.getCode());
        pmsOrder.setCreateTime(new Date());
        pmsOrder.setTotalFee(pmsOrderParam.getTotalFee());
        pmsOrderMapper.insert(pmsOrder);
        return pmsOrder;
    }

    @Override
    public PmsOrder getByOrderId(String orderId) {
        return pmsOrderDao.getByOrderId(orderId);
    }

    @Override
    public PmsOrder getPaidByOrderId(String orderId) {
        PmsOrderExample example = new PmsOrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        example.createCriteria().andPayStatusEqualTo(PayConstant.PayStatus.Created.getCode());
        List<PmsOrder> orders = pmsOrderMapper.selectByExample(example);
        if (orders.isEmpty()) {
            return null;
        }
        return orders.get(0);
    }

    @Override
    public boolean isOrderPaid(String orderId) {

        PmsOrder order = pmsOrderDao.getByOrderId(orderId);
        if (order == null) {
            throw new PmsOrderNotFoundException();
        }
        return order.getPayStatus() == PayConstant.PayStatus.Paid.getCode();
    }

    @Override
    public void markOrderPaid(String orderId, int payType) {
        pmsOrderDao.markOrderPaid(orderId, payType);
    }
}
