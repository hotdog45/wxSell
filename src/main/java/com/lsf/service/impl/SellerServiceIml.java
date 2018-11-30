package com.lsf.service.impl;

import com.lsf.dataObject.SellerInfo;
import com.lsf.repository.SellerInfoRepository;
import com.lsf.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lishunfeng on 2018/8/24.
 */
@Service
public class SellerServiceIml implements SellerService{

    @Autowired
    SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
