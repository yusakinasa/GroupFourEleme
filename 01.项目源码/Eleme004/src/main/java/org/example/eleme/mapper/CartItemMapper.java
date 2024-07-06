package org.example.eleme.mapper;

import org.example.eleme.model.CartItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartItemMapper {
    void insertCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void deleteCartItemById(Long cartitemid);
}

