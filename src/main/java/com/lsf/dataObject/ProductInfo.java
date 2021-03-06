package com.lsf.dataObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsf.enums.ProductStatusEnum;
import com.lsf.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;


    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     *
     * 小图
     */
    private String productIcon;

    /**
     *
     * 状态 0正常1下架
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 类目编号
     */
    private Integer categoryType;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
