package com.lsf.repository;

import com.lsf.dataObject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lishunfeng on 2018/8/24.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>{

    SellerInfo findByOpenid(String openid);

}
