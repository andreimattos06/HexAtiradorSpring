package com.andreimattos06.hexatirador.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.andreimattos06.hexatirador.dto.UsedGunDTO;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.UsedGunService;

@RestController
@RequestMapping("/usedguns")
public class UsedGunController {
        
    @Autowired
    private UsedGunService usedGunService;



    @GetMapping
    public ResponseEntity<List<UsedGunDTO>> findAllUsedGuns(){
        List<UsedGunEntity> used_guns = usedGunService.findAllUsedGuns();
        List<UsedGunDTO> used_guns_dto = used_guns.stream().map(e -> new UsedGunDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(used_guns_dto);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsedGunDTO> findById(@PathVariable("id") String id){
        UsedGunDTO used_gun = new UsedGunDTO(usedGunService.findById(id));
        return ResponseEntity.ok().body(used_gun);
    }

    /*
    @GetMapping("/{email}")
    public Optional<UsedGunEntity> findByEmail(@PathVariable("email") String email){
        return usedGunService.findByEmail(email);
    }
    */

    @PostMapping
    public ResponseEntity<Object> saveUsedGun(@RequestBody UsedGunDTO usedGunDTO){
        UsedGunEntity usedGunEntity = usedGunService.fromDTO(usedGunDTO);
        usedGunEntity = usedGunService.saveUsedGun(usedGunEntity);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usedGunEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsedGunDTO> updateUsedGun(@PathVariable("id") String id, @RequestBody UsedGunEntity usedGunEntity){
        UsedGunDTO used_gun = new UsedGunDTO(usedGunService.updateUsedGun(usedGunEntity, id));
        return ResponseEntity.ok().body(used_gun);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        usedGunService.deleteUsedGunById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        usedGunService.deleteUsedGunByEmail(email);
    }
    */
}
