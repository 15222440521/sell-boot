package com.neuedu.sell.exception;

import com.neuedu.sell.enums.ResultEnum;

public class SellException extends RuntimeException {

    //定义枚举
    private Integer code;



    //super 把我们的异常信息传给父亲异常   构造函数生成  异常写成枚举的形式  传给异常
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
}
