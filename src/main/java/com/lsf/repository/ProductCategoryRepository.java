package com.lsf.repository;

import com.lsf.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lishunfeng on 2018/8/7.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);





}
