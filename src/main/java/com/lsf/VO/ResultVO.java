package com.lsf.VO;

import lombok.Data;

/**
 * Created by lishunfeng on 2018/8/8.
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg = "";
    /**
     * 数据
     */
    private T data;

}
