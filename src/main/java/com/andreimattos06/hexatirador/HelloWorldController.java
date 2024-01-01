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
import com.andreimattos06.hexatirador.dto.UsedGunCompetitionDTO;
import com.andreimattos06.hexatirador.dto.UsedGunHabitualityDTO;
import com.andreimattos06.hexatirador.entity.CompetitionEntity;
import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.entity.enums.CompetitionModality;
import com.andreimattos06.hexatirador.repository.CompetitionRepository;
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

        @Autowired
        CompetitionRepository competitionRepository;


    @GetMapping(path = "/auth/hello")
    public String helloWorld() {

        habitualityRepository.deleteAll();
        profileRepository.deleteAll();
        usedGunRepository.deleteAll();
        competitionRepository.deleteAll();;

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

        HabitualityEntity habituality3 = HabitualityEntity.builder()
        .city("Cristalina")
        .club_name("CACC")
        .date(Instant.now())
        .profile(new HabitualityProfileDTO(profile2))
        .state("GO")
        .build();

        HabitualityEntity habituality4 = HabitualityEntity.builder()
        .city("Caarapó")
        .club_name("Caarapo Tiro")
        .date(Instant.now())
        .profile(new HabitualityProfileDTO(profile1))
        .state("MS")
        .build();

        habitualityRepository.save(habituality1);
        habitualityRepository.save(habituality2);
        habitualityRepository.save(habituality3);
        habitualityRepository.save(habituality4);

        CompetitionEntity competition1 = new CompetitionEntity(
                null, Instant.now(), "Dourados Clube",
                "CBC - Tiro no Prato", "Dourados", "MS", CompetitionModality.valueOfString("Multigun"), new HabitualityProfileDTO(profile1),
                true                
        );

        CompetitionEntity competition2 = new CompetitionEntity(
                null, Instant.now(), "Amambai Clube",
                "CBC - Tiro no Disco", "Amambai", "MS", CompetitionModality.valueOfString("NRA"), new HabitualityProfileDTO(profile2),
                false                
        );

        CompetitionEntity competition3 = new CompetitionEntity(
                null, Instant.now(), "Dourados Clube",
                "CBC - Tiro no Prato", "Dourados", "MS", CompetitionModality.valueOfString("Multigun"), new HabitualityProfileDTO(profile1),
                true                
        );

        CompetitionEntity competition4 = new CompetitionEntity(
                null, Instant.now(), "Amambai Clube",
                "CBC - Tiro no Disco", "Amambai", "MS", CompetitionModality.valueOfString("NRA"), new HabitualityProfileDTO(profile2),
                false                
        );


        competitionRepository.save(competition1);
        competitionRepository.save(competition2);
        competitionRepository.save(competition3);
        competitionRepository.save(competition4);

        profile1.getHabitualities().addAll(Arrays.asList(habituality1, habituality2));
        profile1.getCompetitions().addAll(Arrays.asList(competition1, competition2));
        profileRepository.save(profile1);
        profile2.getHabitualities().addAll(Arrays.asList(habituality3, habituality4));
        profile2.getCompetitions().addAll(Arrays.asList(competition3, competition4));
        profileRepository.save(profile2);
        





       UsedGunEntity usedgun1 = UsedGunEntity.builder()
       .amount(35)
       .brand("Glock")
       .calibre("9mm")
       .gun("TS9")
       .competition(new UsedGunCompetitionDTO(competition1))
       .serial_number("123456")
       .build();

       UsedGunEntity usedgun2 = UsedGunEntity.builder()
       .amount(65)
       .brand("Sig Sauer")
       .calibre(".45 ACP")
       .gun("GH9")
       .competition(new UsedGunCompetitionDTO(competition2))
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

       competition1.getUsed_guns().addAll(Arrays.asList(usedgun1));
       competitionRepository.save(competition1);
       competition2.getUsed_guns().addAll(Arrays.asList(usedgun2));
       competitionRepository.save(competition2);
       competition1.getUsed_guns().addAll(Arrays.asList(usedgun3));
       competitionRepository.save(competition1);
       competition2.getUsed_guns().addAll(Arrays.asList(usedgun4));
       competitionRepository.save(competition2);

       System.out.println(competition1.getModality().toString());
       System.out.println(competition1.getModality().getName());

        return "abcdefg";
    }
}
