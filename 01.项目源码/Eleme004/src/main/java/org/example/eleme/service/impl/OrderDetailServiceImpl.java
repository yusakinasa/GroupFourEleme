package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.OrderDetailMapper;
import org.example.eleme.model.OrderDetail;
import org.example.eleme.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper,OrderDetail>  implements OrderDetailService {



    public List<OrderDetail> getAllOrderDetails() {
        return baseMapper.getAll();
    }

//    public OrderDetail getOrderDetailById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public OrderDetail createOrderDetail(OrderDetail user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteOrderDetail(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public OrderDetail getOrderDetailByOrderDetailname(String username) {
//        return userRepository.findByOrderDetailname(username);
//    }
}
