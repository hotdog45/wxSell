package com.lsf.service;

import com.lsf.dataObject.SellerInfo;
import com.lsf.dataObject.UserTest;

public interface UserTestService {

    /**
     * 通过mobile查询卖家端
     * @param mobile
     * @return
     */
    UserTest findUserByMobile(String mobile);

    UserTest save(UserTest userTest);


}
