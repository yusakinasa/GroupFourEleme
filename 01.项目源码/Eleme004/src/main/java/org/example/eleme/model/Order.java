package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@TableName("order")
@Data
public class Order {

    @TableId(type = IdType.AUTO)
    private Long orderid;
    private Long userid;
    private Long businessid;
    private BigDecimal totalprice;
    private String deliverytime;
    private String paymentmethod;
    private Long addressid;

//    private Business business;
//    private DeliveryAddress deliveryAddress;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
