package com.lsf.service.impl;

import com.lsf.dto.OrderDTO;
import com.lsf.service.BuyerService;
import com.lsf.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lishunfeng on 2018/8/10.
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("[]");
        }
        return null;
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderId) {
        return null;
    }
}
