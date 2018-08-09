package com.lsf.exception;

import com.lsf.enums.ResultEnum;

/**
 * Created by lishunfeng on 2018/8/9.
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();


    }






}
