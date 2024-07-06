package org.example.eleme.service.impl;

import org.example.eleme.mapper.CartItemMapper;
import org.example.eleme.model.CartItem;
import org.example.eleme.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    @Transactional
    public void addToCart(CartItem cartItem) {
        cartItemMapper.insertCartItem(cartItem);
    }

    @Override
    @Transactional
    public void removeFromCart(Long cartitemid) {
        cartItemMapper.deleteCartItemById(cartitemid);
    }
}


