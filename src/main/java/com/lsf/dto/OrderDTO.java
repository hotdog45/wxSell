package com.lsf.dto;

import com.lsf.dataObject.OrderDetail;
import com.lsf.enums.OrderStatusEnum;
import com.lsf.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Data
public class OrderDTO {

    /**
     * 订单id
     */
    @Id
    private  String orderId;

    /**
     * 买家名字
     */
    private  String buyerName;

    /**
     * 买家手机号
     */
    private  String buyerPhone;

    /**
     * 买家地址
     */
    private  String buyerAddress;

    /**
     * 买家微信openid
     */
    private  String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为新下单.
     */
    private  Integer orderStatus ;


    /**
     * 支付状态,
     */
    private  Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
