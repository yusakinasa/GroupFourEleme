package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


@TableName("cart_item")
@Data
public class CartItem {

    @TableId(type = IdType.AUTO)
    private Long cartitemid;
    private Long cartid;
    private Long foodid;
    private Integer quantity;
    private BigDecimal totalprice;

    private Cart cart;   // 关联的 Cart 对象
    private Food food;   // 关联的 Food 对象
    public BigDecimal getPrice() {
        return food != null ? food.getPrice() : BigDecimal.ZERO;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
