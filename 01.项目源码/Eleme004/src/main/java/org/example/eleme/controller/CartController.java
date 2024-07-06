package org.example.eleme.controller;

import org.example.eleme.model.Cart;
import org.example.eleme.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public void addToCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
    }

    @DeleteMapping("/remove/{cartid}")
    public void removeFromCart(@PathVariable Long cartid) {
        cartService.removeFromCart(cartid);
    }
}

