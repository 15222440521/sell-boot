package com.neuedu.sell.dto;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CarDTO {

    //商品编号
    private String productId;

    //商品数量
    private Integer productQuantity;


    public CarDTO() {
    }


    public CarDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
