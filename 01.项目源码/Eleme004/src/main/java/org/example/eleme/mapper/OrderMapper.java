package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.example.eleme.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("SELECT o.orderid, b.imageurl, b.name, o.deliverytime, da.contactname, o.totalprice, o.paymentmethod " +
            "FROM `order` o " +
            "LEFT JOIN business b ON o.businessid = b.businessid " +
            "LEFT JOIN delivery_address da ON o.addressid = da.addressid " +
            "WHERE o.userid = #{userid}")
    List<Order> getOrdersByUserId(Long userid);

    @Insert("INSERT INTO `order` (userid, businessid, totalprice, deliverytime, paymentmethod, addressid) VALUES (#{userid}, #{businessid}, #{totalprice}, #{deliverytime}, #{paymentmethod}, #{addressid})")
    int insert(Order order);
}
