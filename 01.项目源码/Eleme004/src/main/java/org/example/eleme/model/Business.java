package org.example.eleme.model;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@TableName("business")
@Data
public class Business {

    @TableId(type = IdType.AUTO)
    private Long businessid;
    private String name;
    private String imageurl;
    private Float rating;
    private Integer sales;
    private Float distance;
    private Float avgprice;
    private String address;
    private String notice;
    private String phone;



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
