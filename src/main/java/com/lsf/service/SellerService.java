package com.lsf.service;

import com.lsf.dataObject.SellerInfo;

/**
 * Created by lishunfeng on 2018/8/24.
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端id
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
