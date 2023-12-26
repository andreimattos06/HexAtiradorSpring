package com.andreimattos06.hexatirador.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andreimattos06.hexatirador.dto.HabitualityDTO;
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
    public HabitualityEntity findById(@PathVariable("id") String id){
        return habitualityService.findById(id);
    }

    /*
    @GetMapping("/{email}")
    public Optional<HabitualityEntity> findByEmail(@PathVariable("email") String email){
        return habitualityService.findByEmail(email);
    }
    */

    @PostMapping
    public ResponseEntity<Object> saveHabituality(@RequestBody HabitualityDTO habitualityDTO){
        HabitualityEntity habituality = habitualityService.fromDTO(habitualityDTO);
        habituality = habitualityService.saveHabituality(habituality);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(habituality.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public HabitualityEntity updateHabituality(@PathVariable("id") String id, @RequestBody HabitualityEntity habitualityEntity){
        return habitualityService.updateHabituality(habitualityEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        habitualityService.deleteHabitualityById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        habitualityService.deleteHabitualityByEmail(email);
    }
    */
}
