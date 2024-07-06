package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.Business;


import java.util.List;

@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    @Select("select * from business")
    List<Business> getAll();
    @Select("SELECT * FROM business WHERE businessid = #{businessid}")
    Business findById(@Param("businessid") Long businessid);
}
