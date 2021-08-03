package com.projectvilla.villabooking.services;

import java.util.List;
import java.util.Optional;

import com.projectvilla.villabooking.model.Cart;
import com.projectvilla.villabooking.model.dto.ShopCartDto;

public interface ShopCartService{

    Optional<Cart> addToCart(ShopCartDto shopCartDto);

    List<Cart> findAllCart();

}