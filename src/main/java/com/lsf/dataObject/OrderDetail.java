package com.lsf.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lishunfeng on 2018/8/8.
 */


@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private String productQuantity;


    /**
     * 图片
     */
    private String productIcon;


}
