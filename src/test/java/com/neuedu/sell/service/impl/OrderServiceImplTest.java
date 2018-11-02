package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
   @Autowired
   private OrderServiceImpl orderService;
    @Test
    public void  createTest(){
        //看前台传过来的有哪些参数
     OrderDTO orderDTO = new OrderDTO();
     orderDTO.setBuyerName("张三");
     orderDTO.setBuyerPhone("1333333333");
     orderDTO.setBuyerAddress("西七道");
     orderDTO.setBuyerOpenid("abc123");
     //   还有一个订单详情表的集合 这是用户提交的是订单详情
        List<OrderDetail> list = new ArrayList<>();
        list.add(new OrderDetail("1",2));
        list.add(new OrderDetail("2",5));
        //    将list集合  包装到orderdpo中为了我们可以实现与前台的传输
        orderDTO.setOrderDetails(list);
        //调用service层的方法 create()
        orderService.create(orderDTO);
    }


}