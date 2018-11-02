package com.neuedu.sell.service;

import com.neuedu.sell.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    /**
     *
     */
    List<ProductCategory> findAll();

    ProductCategory findOne(Integer categoryId);

    /**
     *  根据商品类目的集合去查询商品
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


    /**
     * 对商品信息进行增改
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);




}
