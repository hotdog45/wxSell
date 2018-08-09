package com.lsf.repository;

import com.lsf.dataObject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lishunfeng on 2018/8/8.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);


}
