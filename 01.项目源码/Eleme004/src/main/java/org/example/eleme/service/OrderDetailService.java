package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.OrderDetail;

import java.util.List;


public interface OrderDetailService extends IService<OrderDetail> {


    public List<OrderDetail> getAllOrderDetails() ;

//    public OrderDetail getOrderDetailById(Long id);
//
//    public OrderDetail createOrderDetail(OrderDetail user);
//
//    public void deleteOrderDetail(Long id);
//
//    public OrderDetail getOrderDetailByOrderDetailname(String username);
}
