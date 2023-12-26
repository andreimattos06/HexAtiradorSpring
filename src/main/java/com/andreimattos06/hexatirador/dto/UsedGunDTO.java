package com.andreimattos06.hexatirador.dto;

import com.andreimattos06.hexatirador.entity.UsedGunEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsedGunDTO {
    
    private String gun;
    private String brand;
    private String calibre;
    private Integer amount;   
    private String serial_number;

    private UsedGunHabitualityDTO habituality;
    

    public UsedGunDTO() {
    }

    public UsedGunDTO(UsedGunEntity used_gun) {
        gun = used_gun.getGun();
        brand = used_gun.getBrand();
        calibre = used_gun.getCalibre();
        amount = used_gun.getAmount();
        serial_number = used_gun.getSerial_number();
        habituality = used_gun.getHabituality();

    }


    

    

}
