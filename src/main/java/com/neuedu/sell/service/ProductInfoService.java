package com.neuedu.sell.service;

import com.neuedu.sell.dto.CarDTO;
import com.neuedu.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

public interface ProductInfoService {
    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品  并分页
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);
    /**
     * 根据id查询商品
     * @param productInfoId
     * @return
     */
    ProductInfo findOne(String productInfoId);

    /**
     * 增加或修改商品
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 扣库存
     * @param carDTOList
     */
    void decreaseStock(List<CarDTO> carDTOList);

    /**
     * 增加库存
     * @param carDTOList
     */
    void increaseStock(List<CarDTO> carDTOList);


}
