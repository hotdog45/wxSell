package com.lsf.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lsf.dataObject.OrderDetail;
import com.lsf.enums.OrderStatusEnum;
import com.lsf.enums.PayStatusEnum;
import com.lsf.utils.EnumUtil;
import com.lsf.utils.serializer.Date2LongSerializer;
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


//不返回空
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class  OrderDTO {

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
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}
