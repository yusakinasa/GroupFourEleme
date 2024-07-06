package org.example.eleme.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.DeliveryAddressMapper;
import org.example.eleme.mapper.OrderMapper;
import org.example.eleme.model.DeliveryAddress;
import org.example.eleme.model.Order;
import org.example.eleme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderservice")
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService  {
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void createOrder(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userid) {
        return orderMapper.getOrdersByUserId(userid);
    }

    @Override
    public void deleteOrder(Long orderid) {
        orderMapper.deleteById(orderid);
    }
}