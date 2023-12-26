package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.andreimattos06.hexatirador.dto.UsedGunHabitualityDTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usedgun")
public class UsedGunEntity implements Serializable{
    
    @Id
    private String id;

    private String gun;
    private String brand;
    private String calibre;
    private Integer amount;   
    private String serial_number;

    private UsedGunHabitualityDTO habituality;
  

}
