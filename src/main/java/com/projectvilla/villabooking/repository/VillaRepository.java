package com.projectvilla.villabooking.repository;

import com.projectvilla.villabooking.model.Villa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VillaRepository extends JpaRepository<Villa,Long>{
    
}