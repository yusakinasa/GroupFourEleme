package org.example.eleme.service;

import org.example.eleme.model.CartItem;

public interface CartItemService {
    void addToCart(CartItem cartItem);
    void removeFromCart(Long cartitemid);
}


