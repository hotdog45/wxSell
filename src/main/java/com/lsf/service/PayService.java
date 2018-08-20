package com.lsf.service;

import com.lly835.bestpay.model.PayResponse;
import com.lsf.dto.OrderDTO;

/**
 * Created by lishunfeng on 2018/8/17.
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

}
