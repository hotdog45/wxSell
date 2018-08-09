package com.lsf.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by lishunfeng on 2018/8/7.
 */

@Entity
@Data
@DynamicUpdate
public class ProductCategory {


    @Id
    @GeneratedValue
    private Integer categoryId;

    /**类目名称. */
    private String categoryName;

    /**
     * 类目类型
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
