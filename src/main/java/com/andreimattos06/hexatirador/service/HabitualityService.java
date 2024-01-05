package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.repository.HabitualityRepository;
import com.andreimattos06.hexatirador.service.exceptions.ResourceNotFoundException;

@Service
public class HabitualityService {

    @Autowired
    private HabitualityRepository habitualityRepository;

    public List<HabitualityEntity> findAllHabitualitys() {
        return habitualityRepository.findAll();

    }

    public HabitualityEntity findById(String id) {
        Optional<HabitualityEntity> obj = habitualityRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<HabitualityEntity> findAllByProfileEmail(String email){
        Optional<List<HabitualityEntity>> obj = habitualityRepository.findAllByProfileEmail(email);
        return obj.orElseThrow(() -> new ResourceNotFoundException(email));
    }


    public HabitualityEntity saveHabituality(HabitualityEntity habitualityEntity) {
        return habitualityRepository.save(habitualityEntity);
    }

    public HabitualityEntity updateHabituality(HabitualityEntity habitualityEntity, String id) {
        return habitualityRepository.save(habitualityEntity);
    }


    public void deleteHabitualityById(String id) {        
            habitualityRepository.deleteById(id);      
        
    }


}
