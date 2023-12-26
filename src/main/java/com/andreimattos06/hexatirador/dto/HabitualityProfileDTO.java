package com.andreimattos06.hexatirador.dto;

import com.andreimattos06.hexatirador.entity.ProfileEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitualityProfileDTO {
    
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    

    public HabitualityProfileDTO() {
    }

    public HabitualityProfileDTO(ProfileEntity profile) {
        id = profile.getId();
        first_name = profile.getFirst_name();
        last_name = profile.getLast_name();
        email = profile.getEmail();
    }


    

    

}
