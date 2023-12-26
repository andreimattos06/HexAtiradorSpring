package com.andreimattos06.hexatirador.dto;


import com.andreimattos06.hexatirador.entity.HabitualityEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsedGunHabitualityDTO {

    private String id;

    public UsedGunHabitualityDTO() {
    }

    public UsedGunHabitualityDTO(HabitualityEntity habituality) {
        id = habituality.getId();

    }

}
