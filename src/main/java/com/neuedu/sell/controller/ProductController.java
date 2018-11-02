package com.neuedu.sell.controller;

import com.neuedu.sell.VO.ProductCategoryVO;
import com.neuedu.sell.VO.ProductInfoVO;
import com.neuedu.sell.VO.ResultVO;
import com.neuedu.sell.entity.ProductCategory;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.service.ProductCategoryService;
import com.neuedu.sell.service.ProductInfoService;
import com.neuedu.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/buyer/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;
     //标注请求前台名字 对接前台请求
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
          List<ProductInfo> productInfoList = productInfoService.findUpAll();
          //2.根据商品列表查出商品类别的集合
        List<Integer> categoryTypeList = new ArrayList<>();
        //遍历商品集合  并获取商品的对应的商品类别编号   并把它放到categoryTypeList集合中
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

          //3.根据商品查询商品类别
     List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //4.将数据拼装   向前台只传过去两条数据
          // 1.将productCategoryList集合转化成VO的集合
       List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            //构建VO对象
            ProductCategoryVO productCategoryVO  = new ProductCategoryVO();
            // 将原对象的数据赋值到VO对象中 spring 提供了一个叫做BeanUtils的类来操作对象
            //第一个参数传一个被传入的对象   后面一个承装新对象
            BeanUtils.copyProperties(productCategory,productCategoryVO);
            //将商品原数据转化成转化成商品VO集合
            //创键一个商品data的集合
            List<ProductInfoVO> productInfoVOList =  new ArrayList<>();
            //遍历所有上架商品的集合productInfoList
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    //将所有上架商品加入到商品vo中 以便响应给前台
                    productInfoVOList.add(productInfoVO);
                }
            }
            //  将转化好的商品VO集合设置到类别中去
            productCategoryVO.setProductInfoVOList(productInfoVOList);
            productCategoryVOList.add(productCategoryVO);
        }
       return ResultVOUtils.success(productCategoryVOList);
    }

}
