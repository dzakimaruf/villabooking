package com.projectvilla.villabooking.model.dto;

import javax.validation.constraints.Min;

public class VillaDto {
    private Long villId;

    private Long lineItemId;

    @Min(value=1,message="must be greater than 0")
    private int quantity;
    
    private double price;
    
    public VillaDto() {
    }

    public VillaDto(Long villId, Long lineItemId, @Min(value = 1, message = "must be greater than 0") int quantity,
            double price) {
        this.villId = villId;
        this.lineItemId = lineItemId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getVillId() {
        return villId;
    }

    public void setVillId(Long villId) {
        this.villId = villId;
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

  
    
    
}