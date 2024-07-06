package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.example.eleme.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {
//    private CartMapper cartMapper;

    @Autowired
    private OrderDetailService orderDetailService;



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",orderDetailService.getAllOrderDetails());
        System.out.println(mapjson);
        return mapjson;
    }
}
