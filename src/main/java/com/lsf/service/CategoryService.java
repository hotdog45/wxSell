package com.lsf.service;

import com.lsf.dataObject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by lishunfeng on 2018/8/8.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findeAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);



}
