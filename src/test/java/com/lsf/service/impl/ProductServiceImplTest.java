package com.lsf.service.impl;

import com.lsf.dataObject.ProductInfo;
import com.lsf.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("12323");
        Assert.assertEquals("12323",productInfo.getProductId());

    }

    @Test
    public void findUpAll() throws Exception {

        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());


    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,3);
        Page<ProductInfo> productInfoPage =  productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("22353");
        productInfo.setProductName("冰糖雪梨");
        productInfo.setProductPrice(new BigDecimal(77.2));
        productInfo.setProductStock(990);
        productInfo.setProductDescription("棒棒棒那个的");
        productInfo.setProductIcon("http://xxx33x.com");
//        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(8);
        ProductInfo result =  productService.save(productInfo);
        Assert.assertNotNull(result);

    }

}