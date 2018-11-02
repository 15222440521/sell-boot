package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


    //  通过orderId  订单id查询订单详情
    List<OrderDetail> findByOrderId(String orderId);



}
