package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.CarDTO;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.enums.ProductStatusEnum;
import com.neuedu.sell.enums.ResultEnum;
import com.neuedu.sell.exception.SellException;
import com.neuedu.sell.repository.ProductInfoRepository;;
import com.neuedu.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
       private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo findOne(String productInfoId) {
        return productInfoRepository.findOne(productInfoId);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void decreaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            // 根据商品id去查询
                 ProductInfo productInfo = productInfoRepository.findOne(carDTO.getProductId());
                 if(productInfo == null){
                     //商品不存在时 抛出一个异常
                    throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
                 }
                 //判断商品数量是否合法？
              if(carDTO.getProductQuantity() <= 0) {
                  //抛出一个异常  去结果枚举类中 定义一个 这样的异常
                  throw  new SellException(ResultEnum.Quantity_NOT_LEAGAL);
              }
              //我们还需要判断库存量大于商品的购买数量
            if(carDTO.getProductQuantity() > productInfo.getProductStock()){
                throw new SellException(ResultEnum.STOCK_NOT_ENOUGH);
            }
            //   最好的情况是我们需要扣库存  更改库存
       productInfo.setProductStock(productInfo.getProductStock() - carDTO.getProductQuantity());
                 productInfoRepository.save(productInfo);
        }


    }

    @Override
    public void increaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            // 根据商品id去查询
            ProductInfo productInfo = productInfoRepository.findOne(carDTO.getProductId());
            if(productInfo == null){
                //商品不存在时 抛出一个异常
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断商品数量是否合法？
            if(carDTO.getProductQuantity() <= 0) {
                //抛出一个异常  去结果枚举类中 定义一个 这样的异常
                throw  new SellException(ResultEnum.Quantity_NOT_LEAGAL);
            }
            //增加库存
            productInfo.setProductStock(productInfo.getProductStock() + carDTO.getProductQuantity());
            productInfoRepository.save(productInfo);
        }
    }
}
