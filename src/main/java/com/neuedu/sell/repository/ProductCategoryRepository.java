package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductCategory;
import org.apache.log4j.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//我们写的这个借口一旦继承jpa jpa帮我们去写实现方法  我们只需要将此接口注入到service层
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

     //根据商品类目的集合去查询商品
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


}
