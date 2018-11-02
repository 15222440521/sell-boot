package com.neuedu.sell.entity;

import lombok.Data;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情表
 */
@Entity
@Data
public class OrderDetail {

     //商品详情id
    @Id
    private String detailId;
    /*主订单id  关联这两张表*/
    private String orderId;
     //商品编号
    private String productId;
    //商品名称
    private String productName;
    //定义商品单价
    private BigDecimal productPrice;
    //商品数量
    private Integer productQuantity;
    //小图
    private  String productIcon;

    public OrderDetail() {
    }

    public OrderDetail(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
