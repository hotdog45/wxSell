package com.lsf.service.impl;

import com.lsf.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lishunfeng on 2018/8/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {

        ProductCategory productCategory = categoryService.findOne(2);
        Assert.assertEquals(new  Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findeAll() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findeAll();
        Assert.assertNotEquals(0,productCategoryList.size());

    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,6));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("美男",16);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);


    }

}