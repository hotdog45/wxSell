package com.lsf.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lsf.dataObject.OrderDetail;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.form.OrderFrom;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishunfeng on 2018/8/10.
 */
@Slf4j
public class OrderFrom2OrderDTOConverter {


    public static OrderDTO convert(OrderFrom orderFrom) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderFrom.getName());
        orderDTO.setBuyerPhone(orderFrom.getPhone());
        orderDTO.setBuyerAddress(orderFrom.getAddress());
        orderDTO.setBuyerOpenid(orderFrom.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderFrom.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());

        } catch (Exception e){
            log.error("[对象转换]  错误,json={}",orderFrom);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;

    }


}
