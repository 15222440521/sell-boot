package com.neuedu.sell.enums;


import lombok.Getter;

@Getter
public enum OrderStatusEnum {


   NEW(0,"新下单"),
   FINISHED(1,"已完成");

    private Integer code;
    private String msg;


     OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
