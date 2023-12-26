package com.andreimattos06.hexatirador.dto;

import com.andreimattos06.hexatirador.entity.ProfileEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsedGunProfileDTO {
    
    private String id;
   

    public UsedGunProfileDTO() {
    }

    public UsedGunProfileDTO(ProfileEntity profile) {
        id = profile.getId();

    }


    

    

}
