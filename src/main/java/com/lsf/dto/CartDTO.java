package com.lsf.dto;

import lombok.Data;

/**
 * 购物车
 * Created by lishunfeng on 2018/8/9.
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
