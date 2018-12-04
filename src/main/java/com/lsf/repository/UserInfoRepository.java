package com.lsf.repository;

import com.lsf.dataObject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {


//    UserInfo findById(String id);

}
