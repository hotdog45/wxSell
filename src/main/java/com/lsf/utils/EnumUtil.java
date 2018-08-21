package com.lsf.utils;

import com.lsf.enums.CodeEnum;

/**
 * Created by lishunfeng on 2018/8/21.
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code , Class<T> enumClass) {
        for (T each:enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
