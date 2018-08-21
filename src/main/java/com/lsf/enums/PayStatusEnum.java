package com.lsf.enums;

import lombok.Getter;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Getter
public enum  PayStatusEnum implements CodeEnum{

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

//    public static PayStatusEnum getPayStatusEnum(Integer code) {
//        for (PayStatusEnum payStatusEnum:PayStatusEnum.values()) {
//            if (payStatusEnum.getCode().equals(code)) {
//                return payStatusEnum;
//            }
//        }
//        return null;
//    }

}
