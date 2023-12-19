package com.andreimattos06.hexatirador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloWorldController {


    @GetMapping(path = "/hello")
    public String helloWorld() {


/*
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


*/
        return "abcdefg";
    }
}
