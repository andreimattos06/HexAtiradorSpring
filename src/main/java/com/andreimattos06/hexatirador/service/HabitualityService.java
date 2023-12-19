package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.repository.HabitualityRepository;
import com.andreimattos06.hexatirador.service.exceptions.DatabaseException;
import com.andreimattos06.hexatirador.service.exceptions.ResourceNotFoundException;

@Service
public class HabitualityService {

    @Autowired
    private HabitualityRepository habitualityRepository;

    public List<HabitualityEntity> findAllHabitualitys() {
        return habitualityRepository.findAll();

    }

    public HabitualityEntity findById(Long id) {
        Optional<HabitualityEntity> obj = habitualityRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /*public Optional<HabitualityEntity> findByEmail(String email) {
        return habitualityRepository.findByEmail(email);
    }*/

    public HabitualityEntity saveHabituality(HabitualityEntity habitualityEntity) {
        return habitualityRepository.save(habitualityEntity);
    }

    public HabitualityEntity updateHabituality(HabitualityEntity habitualityEntity, Long id) {
        HabitualityEntity entity = habitualityRepository.getReferenceById(id);
        updateData(habitualityEntity, entity);
        return habitualityRepository.save(entity);
    }

    private void updateData(HabitualityEntity habitualityEntity, HabitualityEntity habituality) {
        habituality.setCity(habitualityEntity.getCity());
        habituality.setClub_name(habitualityEntity.getClub_name());
        habituality.setDate(habitualityEntity.getDate());
        habituality.setState(habitualityEntity.getState());
    }

    public void deleteHabitualityById(Long id) {
        try{
            habitualityRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());            
        }catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
        
        
    }

    /*
    public void deleteHabitualityByEmail(String email) {
        habitualityRepository.deleteByEmail(email);
    }*/

}
