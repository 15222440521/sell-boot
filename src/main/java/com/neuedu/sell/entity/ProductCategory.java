package com.neuedu.sell.entity;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类别实体类
 */
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    /*  类目名称
     */
    private String categoryName;
    //  类目种类
    private Integer categoryType;
  /*  //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;*/

}
