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

import com.andreimattos06.hexatirador.dto.HabitualityDTO;
import com.andreimattos06.hexatirador.dto.ProfileDTO;
import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    
    @Autowired
    private ProfileService profileService;



    @GetMapping
    public ResponseEntity<List<ProfileDTO>> findAllProfiles(){
        List<ProfileEntity> profiles = profileService.findAllProfiles();
        List<ProfileDTO> list_dto = profiles.stream().map(e -> new ProfileDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list_dto);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable("id") String id){
        ProfileDTO profile = new ProfileDTO(profileService.findById(id));
        return ResponseEntity.ok().body(profile);
    }

    @GetMapping("/{id}/habitualities")
    public ResponseEntity<List<HabitualityDTO>> findByHabitualities(@PathVariable("id") String id){
        List<HabitualityEntity> habitualities = profileService.findById(id).getHabitualities();
        List<HabitualityDTO> habitualities_dto = habitualities.stream().map(e -> new HabitualityDTO(e)).collect(Collectors.toList());
        return ResponseEntity.ok().body(habitualities_dto);
    }

    
    @GetMapping("/email/{email}")
    public ResponseEntity<ProfileDTO> findByEmail(@PathVariable("email") String email){      
        ProfileDTO profile = new ProfileDTO(profileService.findByEmail(email));
        return ResponseEntity.ok().body(profile);
    }
    

    @PostMapping
    public ResponseEntity<Object> saveProfile(@RequestBody ProfileDTO profileDTO){
        ProfileEntity profile = profileService.fromDTO(profileDTO);
        profile = profileService.saveProfile(profile);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable("id") String id, @RequestBody ProfileEntity profileEntity){
        ProfileDTO profile = new ProfileDTO(profileService.updateProfile(profileEntity, id));
        return ResponseEntity.ok().body(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        profileService.deleteProfileById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        profileService.deleteProfileByEmail(email);
    }
    */
}
