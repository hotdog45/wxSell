package com.lsf.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by lishunfeng on 2018/8/10.
 */
@Data
public class OrderFrom {

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名必填")
    private  String name;

    /**
     * 手机号
     */
    @NotEmpty(message = "手机号必填")
    private  String phone;

    /**
     * 地址
     */
    @NotEmpty(message = "地址必填")
    private String address;


    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;


    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
