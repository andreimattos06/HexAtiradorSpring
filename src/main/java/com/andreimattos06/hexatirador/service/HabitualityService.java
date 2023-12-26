package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.dto.HabitualityDTO;
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

    /*public Optional<HabitualityEntity> findByEmail(String email) {
        return habitualityRepository.findByEmail(email);
    }*/

    public HabitualityEntity saveHabituality(HabitualityEntity habitualityEntity) {
        return habitualityRepository.save(habitualityEntity);
    }

    public HabitualityEntity updateHabituality(HabitualityEntity habitualityEntity, String id) {
        /*HabitualityEntity entity = habitualityRepository.getReferenceById(id);
        updateData(habitualityEntity, entity);*/
        return habitualityRepository.save(habitualityEntity);
    }

    /*private void updateData(HabitualityEntity habitualityEntity, HabitualityEntity habituality) {
        habituality.setCity(habitualityEntity.getCity());
        habituality.setClub_name(habitualityEntity.getClub_name());
        habituality.setDate(habitualityEntity.getDate());
        habituality.setState(habitualityEntity.getState());
    }*/

    public void deleteHabitualityById(String id) {        
            habitualityRepository.deleteById(id);      
        
    }

    public HabitualityEntity fromDTO(HabitualityDTO habitiality){
        return HabitualityEntity.builder()
        .city(habitiality.getCity())
        .club_name(habitiality.getClub_name())
        .date(habitiality.getDate())
        .state(habitiality.getState())
        .profile(habitiality.getProfile())
        .build();
    }

    /*
    public void deleteHabitualityByEmail(String email) {
        habitualityRepository.deleteByEmail(email);
    }*/

}
