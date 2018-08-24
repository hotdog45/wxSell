package com.lsf.form;

import lombok.Data;

/**
 * Created by lishunfeng on 2018/8/24.
 */
@Data
public class CategoryForm {


    private Integer categoryId;

    /**类目名称. */
    private String categoryName;

    /**
     * 类目类型
     */
    private Integer categoryType;
}
