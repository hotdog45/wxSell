package com.lsf.enums;

import lombok.Getter;

/**
 * Created by lishunfeng on 2018/8/9.
 */
@Getter
public enum  ResultEnum {


    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }



}
