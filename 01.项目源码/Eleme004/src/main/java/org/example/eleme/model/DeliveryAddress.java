package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("delivery_address")
@Data
public class DeliveryAddress {

    @TableId(type = IdType.AUTO)
    private Long addressid;
    private Long userid;
    private String contactname;
    private String contactphone;
    private String address;

    private User user; // 关联的 User 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
