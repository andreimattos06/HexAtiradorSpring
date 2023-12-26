package com.andreimattos06.hexatirador;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreimattos06.hexatirador.controller.HabitualityController;
import com.andreimattos06.hexatirador.controller.ProfileController;
import com.andreimattos06.hexatirador.controller.UsedGunController;
import com.andreimattos06.hexatirador.dto.HabitualityProfileDTO;
import com.andreimattos06.hexatirador.dto.UsedGunHabitualityDTO;
import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.repository.HabitualityRepository;
import com.andreimattos06.hexatirador.repository.ProfileRepository;
import com.andreimattos06.hexatirador.repository.UsedGunRepository;



@RestController
public class HelloWorldController {

        @Autowired
        HabitualityController habitualityController;

        @Autowired
        HabitualityRepository habitualityRepository;

        @Autowired
        ProfileController profileController;

        @Autowired
        ProfileRepository profileRepository;

        @Autowired
        UsedGunController usedGunController;

        @Autowired
        UsedGunRepository usedGunRepository;


    @GetMapping(path = "/hello")
    public String helloWorld() {

        habitualityRepository.deleteAll();
        profileRepository.deleteAll();
        usedGunRepository.deleteAll();

        ProfileEntity profile1 = ProfileEntity.builder()
        .email("andreimattos06@gmail.com")
        .first_name("Andrei")
        .gender("Masculino")
        .last_name("dos Santos Mattos")
        .password("12345")
        .build();

        ProfileEntity profile2 = ProfileEntity.builder()
        .email("karlafelette@gmail.com")
        .first_name("Karla Fernanda")
        .gender("Feminino")
        .last_name("Felette")
        .password("4567")
        .build();

        profileRepository.save(profile1);
        profileRepository.save(profile2);






        HabitualityEntity habituality1 = HabitualityEntity.builder()
        .city("Caarapó")
        .club_name("Caarapo Tiro")
        .date(Instant.now())
        .profile(new HabitualityProfileDTO(profile1))
        .state("MS")
        .build();

        HabitualityEntity habituality2 = HabitualityEntity.builder()
        .city("Cristalina")
        .club_name("CACC")
        .date(Instant.now())
        .profile(new HabitualityProfileDTO(profile2))
        .state("GO")
        .build();

        habitualityRepository.save(habituality1);
        habitualityRepository.save(habituality2);




        profile1.getHabitualities().addAll(Arrays.asList(habituality1));
        profileRepository.save(profile1);
        profile2.getHabitualities().addAll(Arrays.asList(habituality2));
        profileRepository.save(profile2);





       UsedGunEntity usedgun1 = UsedGunEntity.builder()
       .amount(35)
       .brand("Glock")
       .calibre("9mm")
       .gun("TS9")
       .habituality(new UsedGunHabitualityDTO(habituality1))
       .serial_number("123456")
       .build();

       UsedGunEntity usedgun2 = UsedGunEntity.builder()
       .amount(65)
       .brand("Sig Sauer")
       .calibre(".45 ACP")
       .gun("GH9")
       .habituality(new UsedGunHabitualityDTO(habituality2))
       .serial_number("78910")
       .build();

       UsedGunEntity usedgun3 = UsedGunEntity.builder()
       .amount(15)
       .brand("Taurus")
       .calibre(".40")
       .gun("G3C")
       .habituality(new UsedGunHabitualityDTO(habituality1))
       .serial_number("AASE145F")
       .build();

       UsedGunEntity usedgun4 = UsedGunEntity.builder()
       .amount(5)
       .brand("Beretta")
       .calibre("9mm")
       .gun("TT 198C")
       .habituality(new UsedGunHabitualityDTO(habituality2))
       .serial_number("VVFBZ24")
       .build();

       usedGunRepository.save(usedgun1);
       usedGunRepository.save(usedgun2);
       usedGunRepository.save(usedgun3);
       usedGunRepository.save(usedgun4);

       habituality1.getUsed_guns().addAll(Arrays.asList(usedgun1));
       habitualityRepository.save(habituality1);
       habituality2.getUsed_guns().addAll(Arrays.asList(usedgun2));
       habitualityRepository.save(habituality2);
       habituality1.getUsed_guns().addAll(Arrays.asList(usedgun3));
       habitualityRepository.save(habituality1);
       habituality2.getUsed_guns().addAll(Arrays.asList(usedgun4));
       habitualityRepository.save(habituality2);


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
