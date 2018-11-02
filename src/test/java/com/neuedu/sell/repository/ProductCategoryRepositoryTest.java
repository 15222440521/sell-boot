package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private  ProductCategoryRepository productCategoryRepository;
    @Test
    public void findAllTest(){
      List<ProductCategory> productCategoryList = productCategoryRepository.findAll();
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void saveTest(){
     ProductCategory productCategory = new ProductCategory();
     productCategory.setCategoryName("我是雷恩喷");
     productCategory.setCategoryType(2);
     //调用productCategoryRepository该对象的增加方法 传入一个productCategory对象 进去
     productCategoryRepository.save(productCategory);

    }
   // 通过自定义方法去查
    @Test
    public void findByCategoryTypeTest(){
        //我们构建一个商品类别的集合 不对他进行删改
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> productCategoryList = productCategoryRepository.findByCategoryTypeIn(list);
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory);
        }
    }



}