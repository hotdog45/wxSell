package com.lsf.repository;

import com.lsf.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "ddddddddddgg";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("3433312");
        orderMaster.setBuyerName("dfiaoguai");
        orderMaster.setBuyerPhone("12349786756");
        orderMaster.setBuyerAddress("ss西溪联合大厦");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(23.45));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);

        Assert.assertNotNull(result);


    }

}