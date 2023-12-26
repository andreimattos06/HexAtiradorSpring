package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.Column;
import jakarta.persistence.Id;
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
@Document(collection = "profile")
public class ProfileEntity implements Serializable{

    @Id
    private String id;

    private String first_name;

    private String last_name;

    //@Column(unique = true)
    private String email;

    private String password;

    private String gender;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    @Builder.Default
    @ToString.Exclude
    private List<HabitualityEntity> habitualities = new ArrayList<>();


}