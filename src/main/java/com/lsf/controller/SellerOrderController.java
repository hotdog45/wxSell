package com.lsf.controller;

import com.lsf.dto.OrderDTO;
import com.lsf.enums.ResultEnum;
import com.lsf.exception.SellException;
import com.lsf.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by lishunfeng on 2018/8/20.
 */

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String,Object> map) {
        PageRequest request = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        return new ModelAndView("order/list");

    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderid") String orderId,
                               Map<String,Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
                log.error("[卖家端取消订单] 发生异常 {}",e);
                map.put("msg", e.getMessage());
                map.put("url", "/sell/seller/order/list");
                return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderid") String orderId,
                               Map<String,Object> map) {

        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("[卖家端取消订单] 发生异常 {}",e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderid") String orderId,
                               Map<String,Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("[卖家端wanjie   订单] 发生异常 {}",e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

}
