package com.lsf.controller;

import com.lsf.VO.ResultVO;
import com.lsf.converter.OrderFrom2OrderDTOConverter;
import com.lsf.dto.OrderDTO;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.form.OrderFrom;
import com.lsf.service.BuyerService;
import com.lsf.service.OrderService;
import com.lsf.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private BuyerService buyerService;


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
    @GetMapping("/list")
    public  ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                          @RequestParam(value = "page" ,defaultValue = "0") Integer page,
                                          @RequestParam(value = "size" ,defaultValue = "10" ) Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("[查询订单列表] 参数错误 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }


    //订单详情
    @GetMapping("/detail")
    public  ResultVO<List<OrderDTO>> detail(@RequestParam("openid") String openid,
                                            @RequestParam("orderid") String orderid) {
        // 校验用户 ,不安全

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderid);

//        OrderDTO orderDTO = orderService.findOne(orderid);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @GetMapping("/cancel")
    public  ResultVO<List<OrderDTO>> cancel(@RequestParam("openid") String openid,
                                            @RequestParam("orderid") String orderid) {
        // 校验用户 ,不安全

        OrderDTO orderDTO = buyerService.cancelOrderOne(openid, orderid);
//        OrderDTO orderDTO = orderService.findOne(orderid);
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }






}
