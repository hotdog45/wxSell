package com.lsf.service.impl;

import com.lsf.dataObject.OrderDetail;
import com.lsf.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String buyerOpenid = "110110";

    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("xixilianhe");
        orderDTO.setBuyerPhone("134335233232");
        orderDTO.setBuyerOpenid(buyerOpenid);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("12323");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("12373");
        orderDetail2.setProductQuantity(5);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result =  orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findList() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}