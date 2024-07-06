package org.example.eleme.service;

import org.example.eleme.model.Cart;

public interface CartService {
    void addToCart(Cart cart);
    void removeFromCart(Long cartid);
}


