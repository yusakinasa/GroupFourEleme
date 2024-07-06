package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.DeliveryAddress;
import org.example.eleme.model.Order;
import java.util.List;

public interface OrderService extends IService<Order> {
    void createOrder(Order order);
    List<Order> getOrdersByUserId(Long userid);
    void deleteOrder(Long orderid);  // 添加删除订单的方法

    
}
