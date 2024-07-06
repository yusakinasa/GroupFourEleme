package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("category")
@Data
public class Category {

    @TableId(type = IdType.AUTO)
    private Long categoryid;
    private Long businessid;
    private String name;

    private Business business; // 关联的 Business 对象


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
