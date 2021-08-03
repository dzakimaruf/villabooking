package com.projectvilla.villabooking.controllers;


import java.util.Optional;


import com.projectvilla.villabooking.model.Cart;
import com.projectvilla.villabooking.model.dto.ShopCartDto;
import com.projectvilla.villabooking.services.ShopCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;


    @GetMapping
    public ResponseEntity<?> findAllLineItems() {
        return ResponseEntity.ok().body(shopCartService.findAllCart());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody ShopCartDto shopCartDto){
        Optional<Cart> cart = shopCartService.addToCart(shopCartDto);
        return ResponseEntity.ok().body(cart);
    }

   

}