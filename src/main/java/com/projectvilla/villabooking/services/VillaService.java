package com.projectvilla.villabooking.services;

import java.util.List;
import java.util.Optional;

import com.projectvilla.villabooking.model.Villa;


public interface VillaService {
    //findall
    List<Villa> findAllVilla();
    //insert object category
    Villa addVilla(Villa villa);
    //cari data category yg sesuai id
    Optional <Villa> findVillaById(Long id);
    //delete
    void deleteVillaById(Long id);

}
