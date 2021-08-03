package com.projectvilla.villabooking.repository;


import com.projectvilla.villabooking.model.LineItem;
import com.projectvilla.villabooking.model.LineItemId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem,LineItemId>{
    
}