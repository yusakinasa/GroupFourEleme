package org.example.eleme.controller;

import org.example.eleme.model.DeliveryAddress;
import org.example.eleme.model.Order;
import org.example.eleme.service.OrderService;
import org.example.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;



    @GetMapping("/orders/{userPhone}")
    public List<Order> getOrdersByUserPhone(@PathVariable String userPhone) {

        Long userId = userService.getUserIdByPhone(userPhone);
        if (userId != null) {
            return orderService.getOrdersByUserId(userId);
        } else {
            throw new IllegalArgumentException("用户手机号无效");
        }
    }


    @PostMapping("/create")
    public String createOrder(@RequestBody Map<String, Object> orderData) {
        Order order = new Order();
//        order.setOrderid(Long.valueOf((Integer) orderData.get("orderid")));  // 如果 orderid 是整型
        order.setUserid(Long.valueOf((Integer) orderData.get("userid")));  // 转换为 Long 类型
        order.setBusinessid(Long.valueOf((Integer) orderData.get("businessid")));  // 转换为 Long 类型
        order.setTotalprice(BigDecimal.valueOf((Double) orderData.get("totalprice")));
        order.setDeliverytime((String) orderData.get("deliverytime"));
        order.setPaymentmethod((String) orderData.get("paymentmethod"));
        order.setAddressid(Long.valueOf((Integer) orderData.get("addressid")));  // 转换为 Long 类型

        orderService.createOrder(order);
        return "订单提交成功";
    }

    @DeleteMapping("/order/{orderid}")
    public void deleteOrder(@PathVariable Long orderid) {
        orderService.deleteOrder(orderid);
    }


   
    
}

