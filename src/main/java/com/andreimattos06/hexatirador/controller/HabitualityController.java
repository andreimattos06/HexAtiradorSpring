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

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.service.HabitualityService;

@RestController
@RequestMapping("/habitualities")
public class HabitualityController {
        
    @Autowired
    private HabitualityService habitualityService;



    @GetMapping
    public List<HabitualityEntity> findAllHabitualitys(){
        return habitualityService.findAllHabitualitys();
        
    }

    @GetMapping("/{id}")
    public Optional<HabitualityEntity> findById(@PathVariable("id") Long id){
        return habitualityService.findById(id);
    }

    /*
    @GetMapping("/{email}")
    public Optional<HabitualityEntity> findByEmail(@PathVariable("email") String email){
        return habitualityService.findByEmail(email);
    }
    */

    @PostMapping
    public HabitualityEntity saveHabituality(@RequestBody HabitualityEntity habitualityEntity){
        return habitualityService.saveHabituality(habitualityEntity);
    }

    @PutMapping
    public HabitualityEntity updateHabituality(@RequestBody HabitualityEntity habitualityEntity){
        return habitualityService.updateHabituality(habitualityEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        habitualityService.deleteHabitualityById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        habitualityService.deleteHabitualityByEmail(email);
    }
    */
}
