package com.neuedu.sell.converter;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMaster2OrderDTOConverter {

    //我们需要写一个静态转化方法
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    //  将ordermaster集合转化成 orderDTO集合
    public  static  List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterList) {
              orderDTOList.add(convert(orderMaster));
        }
        return orderDTOList;
    }
}
