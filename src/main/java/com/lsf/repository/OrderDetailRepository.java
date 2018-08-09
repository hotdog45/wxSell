package com.lsf.repository;

import com.lsf.dataObject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lishunfeng on 2018/8/8.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{

    List<OrderDetail> findByOrderId(String orderId);

}
