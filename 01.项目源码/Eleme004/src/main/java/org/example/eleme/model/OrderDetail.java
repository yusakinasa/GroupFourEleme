package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


@TableName("order_detail")
@Data
public class OrderDetail {

    @TableId(type = IdType.AUTO)
    private Long orderdetailid;
    private Long orderid;
    private Long foodid;
    private Integer quantity;
    private BigDecimal totalprice;

    private Order order;   // 关联的 Orders 对象
    private Food food;      // 关联的 Food 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
