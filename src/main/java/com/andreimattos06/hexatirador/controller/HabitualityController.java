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

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.service.HabitualityService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/habitualities")
public class HabitualityController {
        
    @Autowired
    private HabitualityService habitualityService;



    @GetMapping
    public ResponseEntity<List<HabitualityEntity>> findAllHabitualitys(){
        List<HabitualityEntity> habitualities = habitualityService.findAllHabitualitys();       
        return ResponseEntity.ok().body(habitualities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitualityEntity> findById(@PathVariable("id") String id){
        HabitualityEntity habituality = habitualityService.findById(id);
        return ResponseEntity.ok().body(habituality);
    }

    @GetMapping("/profile")
    public ResponseEntity<List<HabitualityEntity>> findAllByProfileId(HttpServletRequest request){
        String user_email = request.getAttribute("user_email").toString();
        List<HabitualityEntity> habituality = habitualityService.findAllByProfileEmail(user_email);
        return ResponseEntity.ok().body(habituality);
    }

    @PostMapping
    public ResponseEntity<Object> saveHabituality(@RequestBody HabitualityEntity habitualityEntity){
        habitualityEntity = habitualityService.saveHabituality(habitualityEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(habitualityEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HabitualityEntity> updateHabituality(@PathVariable("id") String id, @RequestBody HabitualityEntity habitualityEntity){
        HabitualityEntity habituality = habitualityService.updateHabituality(habitualityEntity, id);
        return ResponseEntity.ok().body(habituality);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        habitualityService.deleteHabitualityById(id);
    }

}
