package com.neuedu.sell.service.impl;


import com.neuedu.sell.dto.CarDTO;
import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.OrderMaster;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.enums.ResultEnum;
import com.neuedu.sell.exception.SellException;
import com.neuedu.sell.repository.OrderDetailRepository;
import com.neuedu.sell.repository.OrderMasterRepository;
import com.neuedu.sell.service.OrderService;
import com.neuedu.sell.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

   /*  @Autowired
     private ProductInfoRepository productInfoRepository;*/
     @Autowired
     private OrderDetailRepository orderDetailRepository;
     @Autowired
     private OrderMasterRepository orderMasterRepository;
     //注入业务层的实现类
     @Autowired
     private ProductInfoServiceImpl productInfoService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //创建总价的对象   初始化尽量不直接出现数字   即传入的0  可以写成
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //生成订单主表id
        String orderId = KeyUtils.generateUniqueKey();
        //1.查询商品   前台不穿商品信息  所以需要我们去查询商品信息  我们根据商品id去查商品信息
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            ProductInfo productInfo =productInfoService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                //商品不存在时 抛出一个异常
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //  如果商品存在的话我们需要计算总价
            //2.计算总价   在上面获取总价属性的对象  并初始化  商品数量是我们的属性
            //orderAmount += productInfo.getProductPrice() * orderDetail.getProductQuantity();
            orderAmount = orderAmount.add(productInfo.getProductPrice().
                    multiply(new BigDecimal(orderDetail.getProductQuantity())));
            //multiply 代表乘法
            //写入订单数据库（orderMaster和orderDetail）   生成订单数据
            //3.将我们遍历出来的订单详情数据入库
            //.  需要设定订单主表id
            orderDetail.setOrderId(orderId);
            //  设定订单详情 id 同样的方式生成
            orderDetail.setDetailId(KeyUtils.generateUniqueKey());
            //  将我们查询到的商品信息 复制给 商品详情表的传输
            BeanUtils.copyProperties(productInfo,orderDetail);
            //将我们的订单详情加入到数据库中
            orderDetailRepository.save(orderDetail);
        }
        //4..订单主表入库    与上方主表id一致
        OrderMaster orderMaster = new OrderMaster();
        //将传输的信息表 传入到我们的订单详情表
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        //增加到数据库中
        orderMasterRepository.save(orderMaster);
        //5.扣库存   （一旦生成订单  我们必须要减少库存） 传入的 参数是个 订单详情的集合
        //遍历OrderDetails集合get方法得到商品数量和id放到CarDTO的集合中去
         List<CarDTO> carDTOList = new ArrayList<>();

         for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
             carDTOList.add(new CarDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()));
        }
        productInfoService.decreaseStock(carDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findByOrderId(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
