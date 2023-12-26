package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.dto.UsedGunDTO;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.repository.UsedGunRepository;
import com.andreimattos06.hexatirador.service.exceptions.ResourceNotFoundException;

@Service
public class UsedGunService {

    @Autowired
    private UsedGunRepository usedGunRepository;

    public List<UsedGunEntity> findAllUsedGuns() {
        return usedGunRepository.findAll();

    }

    public UsedGunEntity findById(String id) {
        Optional<UsedGunEntity> obj = usedGunRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /*public Optional<UsedGunEntity> findByEmail(String email) {
        return usedGunRepository.findByEmail(email);
    }*/

    public UsedGunEntity saveUsedGun(UsedGunEntity usedGunEntity) {
        return usedGunRepository.save(usedGunEntity);
    }

    public UsedGunEntity updateUsedGun(UsedGunEntity usedGunEntity, String id) {
        /*UsedGunEntity usedgun = usedGunRepository.getReferenceById(id);
        updateData(usedGunEntity, usedgun);*/
        return usedGunRepository.save(usedGunEntity);
    }

    /*private void updateData(UsedGunEntity usedGunEntity, UsedGunEntity usedgun) {
        usedgun.setAmount(usedGunEntity.getAmount());
        usedgun.setBrand(usedGunEntity.getBrand());
        usedgun.setCalibre(usedGunEntity.getCalibre());
        usedgun.setGun(usedGunEntity.getGun());
        usedgun.setSerial_number(usedGunEntity.getSerial_number());
        
    }*/

    public void deleteUsedGunById(String id) {
        usedGunRepository.deleteById(id);
    }

    public UsedGunEntity fromDTO(UsedGunDTO usedGunDTO){
        return UsedGunEntity.builder()
        .amount(usedGunDTO.getAmount())
        .brand(usedGunDTO.getBrand())
        .calibre(usedGunDTO.getCalibre())
        .gun(usedGunDTO.getGun())
        .habituality(usedGunDTO.getHabituality())
        .build();
    }

    /*
    public void deleteUsedGunByEmail(String email) {
        usedGunRepository.deleteByEmail(email);
    }*/

}
