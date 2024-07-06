package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("cart")
@Data
public class Cart {

    @TableId(type = IdType.AUTO)
    private Long cartid;
    private Long userid;
    private Long businessid;

    private User user;         // 关联的 User 对象
    private Business business; // 关联的 Business 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
