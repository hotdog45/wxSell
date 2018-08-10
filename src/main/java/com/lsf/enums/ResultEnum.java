package com.lsf.enums;

import lombok.Getter;

/**
 * Created by lishunfeng on 2018/8/9.
 */
@Getter
public enum  ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态错误"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态错误"),

    CART_EMPTY(18,"购物车不能为空"),



    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }



}
