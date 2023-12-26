package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andreimattos06.hexatirador.dto.HabitualityProfileDTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "habituality")
public class HabitualityEntity implements Serializable {

    @Id
    private String id;

    private Instant date;
    private String club_name;
    private String city;
    private String state;

    private HabitualityProfileDTO profile;

    @DBRef(lazy = true)
    @Builder.Default
    private List<UsedGunEntity> used_guns = new ArrayList<>();

}
