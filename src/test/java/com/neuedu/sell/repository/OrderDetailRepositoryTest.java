package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderDetail;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@DynamicUpdate
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("78901");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("1");
        orderDetail.setProductName("小米粥");
        orderDetail.setProductPrice(new BigDecimal(3.5));
        orderDetail.setProductIcon("www.baidu.com");
        orderDetail.setProductQuantity(5);  //商品数量
        orderDetailRepository.save(orderDetail);
    }
    @Test
    public void findByOrderidTest(){
        List<OrderDetail> detailList=orderDetailRepository.findByOrderId("123456");
        for (OrderDetail orderDetail : detailList) {
            System.out.println(orderDetail);
        }
    }


}