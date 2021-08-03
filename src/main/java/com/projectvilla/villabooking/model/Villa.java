package com.projectvilla.villabooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "villa")
public class Villa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="villa_id")
    private Long villaId;
    
    @Column(name="villa_title", length = 25)
    @NotBlank(message="Nama Villa Harus Diisi")
    private String title;

    @Column(name="description", length = 255)
    private String description;

    @Column(name="address", length=255)
    private String address;

    @Column(name="price",precision=17, scale = 2)
    @DecimalMin(value="100.00", message="price must hiher than '${validateValue}'")
    @DecimalMax(value="50000.00", message = "not greater than '${value}'")
    private Double price;

    @Column(name="bedroom")
    private int bedroom;

    @Column(name="bathroom")
    private int bathroom;

    @Column(name="lantai")
    private int lantai;

    @Column(name="vill_image",length = 255)
    private String villImage;

    public Villa() {
    }

    public Villa(Long villaId, @NotBlank(message = "Nama Villa Harus Diisi") String title, String description,
            String address,
            @DecimalMin(value = "100.00", message = "price must hiher than '${validateValue}'") @DecimalMax(value = "50000.00", message = "not greater than '${value}'") Double price,
            int bedroom, int bathroom, int lantai, String villImage) {
        this.villaId = villaId;
        this.title = title;
        this.description = description;
        this.address = address;
        this.price = price;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.lantai = lantai;
        this.villImage = villImage;
    }

    public Long getVillaId() {
        return villaId;
    }

    public void setVillaId(Long villaId) {
        this.villaId = villaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getLantai() {
        return lantai;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    public String getVillImage() {
        return villImage;
    }

    public void setVillImage(String villImage) {
        this.villImage = villImage;
    }
  
}