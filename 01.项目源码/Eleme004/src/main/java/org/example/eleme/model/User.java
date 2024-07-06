package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("user")
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long userid;
    //private String username;
    private String password;

    private String phone;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
