package com.lsf.service.impl;

import com.lsf.dataObject.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImlTest {

    @Autowired
    private SellerServiceIml sellerServiceIml;

    private static final String openid = "abc";

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo result =  sellerServiceIml.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,result.getOpenid());
    }

}