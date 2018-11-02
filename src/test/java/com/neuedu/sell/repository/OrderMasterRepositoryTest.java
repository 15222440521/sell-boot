package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderMaster;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
@DynamicUpdate    //动态的修改系统默认的时间以及日期
public class OrderMasterRepositoryTest {

    public  static final String OPENID="abc123";
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");   //订单id 是随机数+时间生成的
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerAddress("天津市武清区");
        orderMaster.setBuyerPhone("13920659864");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(120));
        //将新的订单信息对象加入到数据库中去
        orderMasterRepository.save(orderMaster);
    }
      //根据用户的openid去查询

     @Test
     public void  findByBuyerOpenidTest(){
        Page<OrderMaster> page=orderMasterRepository.findByBuyerOpenid(OPENID,new PageRequest(0,3));
         for (OrderMaster orderMaster : page.getContent()) {
             System.out.println(orderMaster);
         }
     }

}