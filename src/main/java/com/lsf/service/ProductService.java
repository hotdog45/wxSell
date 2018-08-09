package com.lsf.service;

import com.lsf.dataObject.OrderDetail;
import com.lsf.dataObject.ProductInfo;
import com.lsf.dto.CartDTO;
import com.lsf.dto.OrderDTO;
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
    void increaseStock(List<CartDTO> cartDTOList);


    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
