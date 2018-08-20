package com.lsf.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lsf.dto.OrderDTO;
import com.lsf.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lishunfeng on 2018/8/17.
 */
@Service
public class PayServiceImpl implements PayService{

    private static final String ORDER_NAME = "微信点餐业务";

    @Autowired
    private BestPayServiceImpl bestPayService;


    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);


        PayResponse payResponse = bestPayService.pay(payRequest);

        return payResponse;
    }
}
