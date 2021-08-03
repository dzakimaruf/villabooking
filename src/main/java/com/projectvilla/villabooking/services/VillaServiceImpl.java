package com.projectvilla.villabooking.services;

import java.util.List;
import java.util.Optional;

import com.projectvilla.villabooking.model.Villa;
import com.projectvilla.villabooking.repository.VillaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillaServiceImpl implements VillaService{

    @Autowired
    private VillaRepository villaRepository;

    @Override
    public List<Villa> findAllVilla() {
        return villaRepository.findAll();
    }

    @Override
    public Villa addVilla(Villa villa) {
        
        return villaRepository.save(villa);
    }

    @Override
    public Optional<Villa> findVillaById(Long id) {
        
        return villaRepository.findById(id);
    }
    @Override
    public void deleteVillaById(Long id) {
        villaRepository.deleteById(id);
        
    }
    
}
