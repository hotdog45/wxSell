package com.lsf.controller;

import com.lsf.VO.ResultVO;
import com.lsf.converter.OrderFrom2OrderDTOConverter;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.form.OrderFrom;
import com.lsf.service.OrderService;
import com.lsf.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishunfeng on 2018/8/10.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;


    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderFrom orderFrom,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("[创建订单] 参数错误 orderFrom={}",orderFrom);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFrom2OrderDTOConverter.convert(orderFrom);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单] 购物车为空 ");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult =  orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表


    //订单详情


    //取消订单







}
