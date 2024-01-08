package com.andreimattos06.hexatirador.controller;

import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
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

import com.andreimattos06.hexatirador.dto.HabitualityProfileDTO;
import com.andreimattos06.hexatirador.dto.HabitualityUsedGunDTO;
import com.andreimattos06.hexatirador.dto.UsedGunHabitualityDTO;
import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.HabitualityService;
import com.andreimattos06.hexatirador.service.ProfileService;
import com.andreimattos06.hexatirador.service.UsedGunService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/habitualities")
public class HabitualityController {

    @Autowired
    private HabitualityService habitualityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UsedGunService usedGunService;

    @GetMapping("/all") // Later this will be a ADMIN only route, for now its avaiable for all users for
                        // ease.
    public ResponseEntity<List<HabitualityEntity>> findAllHabitualitys() {
        List<HabitualityEntity> habitualities = habitualityService.findAllHabitualitys();
        return ResponseEntity.ok().body(habitualities);
    }

    @GetMapping
    public ResponseEntity<List<HabitualityEntity>> findByProfileEmail(HttpServletRequest request) {
        String user_email = request.getAttribute("user_email").toString();
        List<HabitualityEntity> habituality = habitualityService.findByProfileEmail(user_email);
        return ResponseEntity.ok().body(habituality);
    }

    @PostMapping
    public ResponseEntity<Object> saveHabituality(@RequestBody HabitualityUsedGunDTO habitualityUsedGunDTO,
            HttpServletRequest request) {
        String user_email = request.getAttribute("user_email").toString();
        ProfileEntity profile = profileService.findByEmail(user_email);
        HabitualityEntity habituality = habitualityUsedGunDTO.getHabitualityEntity();
        List<UsedGunEntity> used_guns = new ArrayList<>();
        used_guns.addAll(habitualityUsedGunDTO.getUsedGunEntity());
        if (profile != null && habituality != null && used_guns != null) {
            habituality.setId(null);
            habituality.setProfile(new HabitualityProfileDTO(profile));
            habituality = habitualityService.saveHabituality(habituality);
            for (UsedGunEntity used_gun : used_guns) {
                used_gun.setId(null);
                used_gun.setHabituality(new UsedGunHabitualityDTO(habituality));
                habituality.getUsed_guns().add(used_gun);
                usedGunService.saveUsedGun(used_gun);

            }
            habitualityService.updateHabituality(habituality);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(habituality.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        return ResponseEntity.badRequest().body("Inputed information is not valid.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHabituality(@PathVariable("id") String id,
            @RequestBody HabitualityUsedGunDTO habitualityUsedGunDTO,
            HttpServletRequest request) {
        String user_email = request.getAttribute("user_email").toString();
        HabitualityEntity habituality = habitualityService.findById(id);
        HabitualityEntity new_habituality = habitualityUsedGunDTO.getHabitualityEntity();
        List<UsedGunEntity> used_guns = new ArrayList<>();
        String error = "";
        used_guns.addAll(habitualityUsedGunDTO.getUsedGunEntity());
        if (habituality.getProfile().getEmail().equals(user_email)) {
            if (validateHabitulity(new_habituality)) {
                habituality.setCity(new_habituality.getCity());
                habituality.setClub_name(new_habituality.getClub_name());
                habituality.setDate(new_habituality.getDate());
                habituality.setState(new_habituality.getState());
                habitualityService.updateHabituality(habituality);

                for (UsedGunEntity used_gun : used_guns) {
                    usedGunService.updateUsedGun(used_gun, id); //Finished here                    
                }
            } 
            else {
                error = "Provided Habituality or Used Gun informations are incomplete or missing.";
            }
        } else {
            error = "Provided Profile doesn't match Habituality Profile.";
        }
        return ResponseEntity.badRequest().body(error);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        habitualityService.deleteHabitualityById(id);
    }

    // -----------Start of Functions---------------- //

    public boolean validateHabitulity(HabitualityEntity habituality) {
        if (habituality.getCity().isEmpty() && habituality.getClub_name().isEmpty() && habituality.getState().isEmpty()
                && habituality.getDate() == null
                && habituality.getProfile() == null) {
            return false;
        } else {
            return true;
        }
    }

}
