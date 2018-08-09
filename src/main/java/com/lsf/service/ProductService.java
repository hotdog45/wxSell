package com.lsf.service;

import com.lsf.dataObject.ProductInfo;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by lishunfeng on 2018/8/8.
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);


    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */

    /**
     * 减库存
     */
}
