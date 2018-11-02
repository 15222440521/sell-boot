package com.neuedu.sell.service.impl;

import com.neuedu.sell.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findUpAllTest(){
        for (ProductInfo productInfo : productInfoService.findUpAll()) {
            System.out.println(productInfo);
        }
    }
    @Test
   public void findAllTest(){
        //需要构建一个pageable对象
        Pageable pageable = new PageRequest(0,2);
        for (ProductInfo productInfo : productInfoService.findAll(pageable)) {
            System.out.println(productInfo);
        }
   }


}