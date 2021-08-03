package com.projectvilla.villabooking.model.dto;

import java.util.List;

public class ShopCartDto {
    private Long cartId;
    private List<VillaDto> villaDto;
    
    public ShopCartDto() {
    }

    public ShopCartDto(Long cartId, List<VillaDto> villaDto) {
        this.cartId = cartId;
        this.villaDto = villaDto;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<VillaDto> getVillaDto() {
        return villaDto;
    }

    public void setVillaDto(List<VillaDto> villaDto) {
        this.villaDto = villaDto;
    }

    
}
