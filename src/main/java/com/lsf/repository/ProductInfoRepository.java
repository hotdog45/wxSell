package com.lsf.repository;

import com.lsf.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lishunfeng on 2018/8/8.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);



}
