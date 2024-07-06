package org.example.eleme.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category WHERE businessid = #{businessid}")
    List<Category> getCategoriesByBusinessId(Long businessid);
}
