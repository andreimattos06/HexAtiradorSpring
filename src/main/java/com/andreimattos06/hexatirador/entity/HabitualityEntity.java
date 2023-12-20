package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @OneToMany(mappedBy = "habituality")
    @JsonIgnore
    @Builder.Default
    @ToString.Exclude
    private List<UsedGunEntity> used_guns = new ArrayList<>();

}
