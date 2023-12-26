package com.andreimattos06.hexatirador.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HabitualityDTO {
    
    private Instant date;
    private String club_name;
    private String city;
    private String state;
    private HabitualityProfileDTO profile;
    private List<UsedGunEntity> used_guns = new ArrayList<>();
    

    public HabitualityDTO() {
    }

    public HabitualityDTO(HabitualityEntity habituality) {
        date = habituality.getDate();
        club_name = habituality.getClub_name();
        city = habituality.getCity();
        state = habituality.getState();
        profile = habituality.getProfile();
        used_guns = habituality.getUsed_guns();

    }


    

    

}
