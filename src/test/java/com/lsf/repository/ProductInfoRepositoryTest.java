package com.lsf.repository;

import com.lsf.dataObject.ProductInfo;
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
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());

    }
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12373");
        productInfo.setProductName("哈密瓜");
        productInfo.setProductPrice(new BigDecimal(32));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("还不错");
        productInfo.setProductIcon("http://xxxx.com");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);
        ProductInfo result =  repository.save(productInfo);
        Assert.assertNotNull(result);
    }

}