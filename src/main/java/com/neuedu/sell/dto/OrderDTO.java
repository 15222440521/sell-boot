package com.neuedu.sell.dto;


import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.enums.OrderStatusEnum;
import com.neuedu.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {


    private String orderId;
    //买家用户名
    private String buyerName;
    //买家电话
    private String buyerPhone;
    //收货地址
    private String buyerAddress;
    //用户的openid
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态  默认是新下单 0为新下单  1为未支付 在枚举中已经定义
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态  默认未支付  0是未支付  1是已支付
    private Integer payStatus = PayStatusEnum.NOT_PAY.getCode() ;
    //创建订单的是时间
    private Date createTime;
    //修改订单的时间
    private  Date updateTime;

    //详情的集合   关联此表
    private List<OrderDetail> orderDetailList;

}
