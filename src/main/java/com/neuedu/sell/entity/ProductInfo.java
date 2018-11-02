package com.neuedu.sell.entity;


import com.neuedu.sell.enums.ProductStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;

    private String productName;
    private BigDecimal productPrice;
    /*商品库存*/
    private Integer productStock;
 /*商品描述*/
    private String productDescription;
    /*商品小图*/
    private String productIcon;
    /**
     * 商品状态  0 正常  1下架
     * 需要给他赋初值
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /*商品类目*/
    private Integer categoryType;
}
