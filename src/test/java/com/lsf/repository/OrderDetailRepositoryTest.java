package com.lsf.repository;

import com.lsf.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12w2");
        orderDetail.setProductIcon("http:www.aa.com");
        orderDetail.setProductId("1122w211");
        orderDetail.setOrderId("111221");
        orderDetail.setProductPrice(new BigDecimal(75.33));
        orderDetail.setProductName("你猜2猜");
        orderDetail.setProductQuantity(423);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId("111221");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}