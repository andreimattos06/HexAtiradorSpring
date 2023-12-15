package com.andreimattos06.hexatirador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<ProfileEntity> findAllProfiles(){
        return profileService.findAllProfiles();
        
    }

    @GetMapping("/{id}")
    public Optional<ProfileEntity> findById(@PathVariable("id") Long id){
        return profileService.findById(id);
    }

    /*
    @GetMapping("/{email}")
    public Optional<ProfileEntity> findByEmail(@PathVariable("email") String email){
        return profileService.findByEmail(email);
    }
    */

    @PostMapping
    public ProfileEntity saveProfile(@RequestBody ProfileEntity profileEntity){
        return profileService.saveProfile(profileEntity);
    }

    @PutMapping
    public ProfileEntity updateProfile(@RequestBody ProfileEntity profileEntity){
        return profileService.updateProfile(profileEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        profileService.deleteProfileById(id);
    }

    /*
    @DeleteMapping
    public void deleteByEmail(@PathVariable("email") String email){
        profileService.deleteProfileByEmail(email);
    }
    */
}
