package com.lsf.service;

import com.lsf.dto.OrderDTO;

/**
 * Created by lishunfeng on 2018/8/10.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);


    //取消订单
    OrderDTO cancelOrderOne(String openid,String orderId);

}
