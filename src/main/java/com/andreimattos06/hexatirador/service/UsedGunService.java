package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UsedGunEntity saveUsedGun(UsedGunEntity usedGunEntity) {
        return usedGunRepository.save(usedGunEntity);
    }

    public UsedGunEntity updateUsedGun(UsedGunEntity usedGunEntity, String id) {
        return usedGunRepository.save(usedGunEntity);
    }


    public void deleteUsedGunById(String id) {
        usedGunRepository.deleteById(id);
    }

}
