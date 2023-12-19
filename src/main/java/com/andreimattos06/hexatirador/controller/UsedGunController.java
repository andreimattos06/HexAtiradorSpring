package com.andreimattos06.hexatirador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.UsedGunService;

@RestController
@RequestMapping("/usedgun")
public class UsedGunController {
        
    @Autowired
    private UsedGunService usedGunService;



    @GetMapping
    public List<UsedGunEntity> findAllUsedGuns(){
        return usedGunService.findAllUsedGuns();
        
    }

    @GetMapping("/{id}")
    public Optional<UsedGunEntity> findById(@PathVariable("id") Long id){
        return usedGunService.findById(id);
    }

    /*
    @GetMapping("/{email}")
    public Optional<UsedGunEntity> findByEmail(@PathVariable("email") String email){
        return usedGunService.findByEmail(email);
    }
    */

    @PostMapping
    public UsedGunEntity saveUsedGun(@RequestBody UsedGunEntity usedGunEntity){
        return usedGunService.saveUsedGun(usedGunEntity);
    }

    @PutMapping
    public UsedGunEntity updateUsedGun(@RequestBody UsedGunEntity usedGunEntity){
        return usedGunService.updateUsedGun(usedGunEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        usedGunService.deleteUsedGunById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        usedGunService.deleteUsedGunByEmail(email);
    }
    */
}