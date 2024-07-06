package org.example.eleme.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Food;

import java.util.List;

@Mapper
public interface FoodMapper {

    @Select("SELECT * FROM food WHERE categoryid IN (SELECT categoryid FROM category WHERE businessid = #{businessid})")
    List<Food> getFoodsByBusinessId(Long businessid);
}


