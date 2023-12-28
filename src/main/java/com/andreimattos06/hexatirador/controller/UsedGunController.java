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

import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.UsedGunService;

@RestController
@RequestMapping("/usedguns")
public class UsedGunController {
        
    @Autowired
    private UsedGunService usedGunService;



    @GetMapping
    public ResponseEntity<List<UsedGunEntity>> findAllUsedGuns(){
        List<UsedGunEntity> used_guns = usedGunService.findAllUsedGuns();
        return ResponseEntity.ok().body(used_guns);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsedGunEntity> findById(@PathVariable("id") String id){
        UsedGunEntity used_gun = usedGunService.findById(id);
        return ResponseEntity.ok().body(used_gun);
    }


    @PostMapping
    public ResponseEntity<Object> saveUsedGun(@RequestBody UsedGunEntity usedGunEntity){
        usedGunEntity = usedGunService.saveUsedGun(usedGunEntity);        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usedGunEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsedGunEntity> updateUsedGun(@PathVariable("id") String id, @RequestBody UsedGunEntity usedGunEntity){
        UsedGunEntity used_gun = usedGunService.updateUsedGun(usedGunEntity, id);
        return ResponseEntity.ok().body(used_gun);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        usedGunService.deleteUsedGunById(id);
    }

}
