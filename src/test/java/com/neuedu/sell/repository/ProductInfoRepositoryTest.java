package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findAllTest(){
        List<ProductInfo> productInfoList = productInfoRepository.findAll();
        for (ProductInfo productInfo : productInfoList) {
            System.out.println(productInfo);
        }

    }

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("4");
        productInfo.setProductName("张p");
        productInfo.setCategoryType(4);
        productInfo.setProductStock(1020);
        productInfo.setProductDescription("有点尿味");
        productInfo.setProductIcon("http:www.lidaspeng");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfoRepository.save(productInfo);
    }

    @Test
    public void findByProductStatusTest(){
     List<ProductInfo> productInfoList=productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
        System.out.println(productInfoList);
    }

}