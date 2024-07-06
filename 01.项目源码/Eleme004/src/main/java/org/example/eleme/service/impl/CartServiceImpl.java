package org.example.eleme.service.impl;

import org.example.eleme.mapper.CartMapper;
import org.example.eleme.model.Cart;
import org.example.eleme.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    @Transactional
    public void addToCart(Cart cart) {
        cartMapper.insertCart(cart);
    }

    @Override
    @Transactional
    public void removeFromCart(Long cartid) {
        cartMapper.deleteCartById(cartid);
    }
}


