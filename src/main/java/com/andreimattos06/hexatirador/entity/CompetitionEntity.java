package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andreimattos06.hexatirador.dto.HabitualityProfileDTO;
import com.andreimattos06.hexatirador.entity.enums.CompetitionModality;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "competition")
public class CompetitionEntity implements Serializable {

    @Id
    private String id;

    private Instant date;
    private String club_name;
    private String name;
    private String city;
    private String state;
    private Integer modality;
    private HabitualityProfileDTO profile;
    private boolean national_international;

    @DBRef(lazy = true)
    private List<UsedGunEntity> used_guns = new ArrayList<>();

    public CompetitionEntity(){

    }

    public CompetitionEntity(String id, Instant date, String club_name, String name, String city, String state,
            CompetitionModality modality, HabitualityProfileDTO profile, boolean national_international) {
        this.id = id;
        this.date = date;
        this.club_name = club_name;
        this.name = name;
        this.city = city;
        this.state = state;
        setModality(modality);
        this.profile = profile;
        this.national_international = national_international;
    }


    public CompetitionModality getModality(){
        return CompetitionModality.valueOf(modality);
    }

    public void setModality(CompetitionModality modality){
        if (modality != null){
            this.modality = modality.getCode();
        }
        
    }
   

}
