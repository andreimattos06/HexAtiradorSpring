package com.andreimattos06.hexatirador;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.HabitualityService;
import com.andreimattos06.hexatirador.service.ProfileService;
import com.andreimattos06.hexatirador.service.UsedGunService;

@RestController
public class HelloWorldController {

    @Autowired
    private HabitualityService habitualityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UsedGunService usedGunService;

    @GetMapping(path = "/hello")
    public String helloWorld() {

        Optional<ProfileEntity> p1 = profileService.findById(1L);


        HabitualityEntity h1 = HabitualityEntity.builder()
                .id(null)
                .date(Instant.now())
                .club_name("Tiro certo")
                .city("Ponta Porã")
                .state("MS")
                .profile(p1.get())
                .build();
        


        UsedGunEntity ug1 = UsedGunEntity.builder()
                .id(null)
                .amount(33)
                .brand("Colt")
                .calibre("5,56")
                .gun("M4A4")
                .serial_number("AEE21")
                .habituality(h1)
                .build();


        UsedGunEntity ug2 = UsedGunEntity.builder()
                .id(null)
                .amount(66)
                .brand("AK")
                .calibre("7,62")
                .gun("47")
                .serial_number("5D81231")
                .habituality(h1)
                .build();        

        

        habitualityService.saveHabituality(h1);
        usedGunService.saveUsedGun(ug2);
        usedGunService.saveUsedGun(ug1);



        return "abcdefg";
    }
}
