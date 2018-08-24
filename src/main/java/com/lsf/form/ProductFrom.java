package com.lsf.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsf.enums.ProductStatusEnum;
import com.lsf.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lishunfeng on 2018/8/24.
 */
@Data
public class ProductFrom {


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
     * 类目编号
     */
    private Integer categoryType;

}
