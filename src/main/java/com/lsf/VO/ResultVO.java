package com.lsf.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息")
    private String msg = "";
    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;

}
