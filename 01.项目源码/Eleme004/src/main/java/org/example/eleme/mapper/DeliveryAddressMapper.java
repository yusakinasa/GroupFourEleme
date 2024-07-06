package org.example.eleme.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.eleme.model.DeliveryAddress;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {
    @Select("select * from delivery_address")
    List<DeliveryAddress> getAll();
    void insertDeliveryAddress(DeliveryAddress deliveryAddress);
    void deleteDeliveryAddress(Long id);
}
