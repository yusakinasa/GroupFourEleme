package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.DeliveryAddress;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;



public interface DeliveryAddressService extends IService<DeliveryAddress> {


    public List<DeliveryAddress> getAllDeliveryAddresses() ;
    @Transactional
    void saveDeliveryAddress(DeliveryAddress deliveryAddress);
    @Transactional
    void deleteDeliveryAddress(Long id);

//    public DeliveryAddress getDeliveryAddressById(Long id);
//
//    public DeliveryAddress createDeliveryAddress(DeliveryAddress user);
//
//    public void deleteDeliveryAddress(Long id);
//
//    public DeliveryAddress getDeliveryAddressByDeliveryAddressname(String username);
}
