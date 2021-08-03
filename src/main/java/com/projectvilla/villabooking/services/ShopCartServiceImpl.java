package com.projectvilla.villabooking.services;


import java.util.List;
import java.util.Optional;

import com.projectvilla.villabooking.model.Cart;
import com.projectvilla.villabooking.model.LineItem;
import com.projectvilla.villabooking.model.LineItemId;
import com.projectvilla.villabooking.model.dto.VillaDto;
import com.projectvilla.villabooking.model.dto.ShopCartDto;
import com.projectvilla.villabooking.repository.CartRepository;
import com.projectvilla.villabooking.repository.LineItemRepository;

import org.springframework.stereotype.Service;

@Service
public class ShopCartServiceImpl implements ShopCartService{

    private LineItemRepository lineItemRepository;
    private CartRepository cartRepository;


    public ShopCartServiceImpl(LineItemRepository lineItemRepository, CartRepository cartRepository) {
        this.lineItemRepository = lineItemRepository;
        this.cartRepository = cartRepository;
    }



    @Override
    public Optional<Cart> addToCart(ShopCartDto shopCartDto) {
        // get cart to fetch cartId, gunakan optinal agar terhindar dari null trace
        Optional<Cart> cart = cartRepository.findCartOpen();

        if (!cart.isPresent()){
            cart = Optional.of(cartRepository.save(new Cart()));
        }

        // loop shopcartDto to get villadot
        for (VillaDto vill : shopCartDto.getVillaDto()) {
            // get id for cart & villa
            LineItemId lineItemId = new LineItemId(cart.get().getId(),
            vill.getVillId());

            LineItem lineItem = new LineItem(lineItemId, vill.getQuantity(),vill.getPrice());
            lineItemRepository.save(lineItem);
        }
        // 
        return cartRepository.findById(cart.get().getId());
    }



    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }
    
    
}
