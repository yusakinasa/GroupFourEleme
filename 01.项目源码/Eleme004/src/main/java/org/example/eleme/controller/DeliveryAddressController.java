package org.example.eleme.controller;


import org.example.eleme.service.CartService;
import org.example.eleme.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.eleme.model.DeliveryAddress;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;



import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/delivery_address")
public class DeliveryAddressController {
//    private CartMapper cartMapper;

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @GetMapping("/all")
    public Map<String, Object> getAllDeliveryAddresses() {
        Map<String, Object> response = new HashMap<>();
        List<DeliveryAddress> addresses = deliveryAddressService.getAllDeliveryAddresses();
        response.put("data", addresses);
        return response;
    }

    @PostMapping("/add")
    public Map<String, Object> addDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        Map<String, Object> response = new HashMap<>();
        try {
            deliveryAddressService.save(deliveryAddress);
            response.put("status", "success");
            response.put("data", deliveryAddress);
            response.put("message", "Address added successfully");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to add address: " + e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteDeliveryAddress(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            deliveryAddressService.deleteDeliveryAddress(id);
            response.put("success", true);
            response.put("message", "Address deleted successfully");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to delete address: " + e.getMessage());
        }
        return response;
    }



    @RequestMapping("/all")
    public Map<String,Object> getAll(){
//        cartService.

        Map mapjson = new HashMap<>();
        mapjson.put("data",deliveryAddressService.getAllDeliveryAddresses());
        System.out.println(mapjson);
        return mapjson;
    }
}
