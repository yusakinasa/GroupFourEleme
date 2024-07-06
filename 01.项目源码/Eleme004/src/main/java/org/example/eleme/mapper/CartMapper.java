package org.example.eleme.mapper;

import org.example.eleme.model.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    void insertCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCartById(Long cartid);
}


