package org.example.eleme.controller;

import org.example.eleme.model.CartItem;
import org.example.eleme.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add")
    public void addToCart(@RequestBody CartItem cartItem) {
        cartItemService.addToCart(cartItem);
    }

    @DeleteMapping("/remove/{cartitemid}")
    public void removeFromCart(@PathVariable Long cartitemid) {
        cartItemService.removeFromCart(cartitemid);
    }
}

