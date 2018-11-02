package com.neuedu.sell.repository;


import com.neuedu.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {



    // 根据买家用户id去查找
    Page<OrderMaster> findByBuyerOpenid(String openId, Pageable pageable);



}
