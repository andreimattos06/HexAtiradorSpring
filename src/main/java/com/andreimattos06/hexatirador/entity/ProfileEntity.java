package com.andreimattos06.hexatirador.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    
    @Indexed(unique = true)
    private String email;
    private String password;
    private String gender;

    @DBRef(lazy = true)
    @Builder.Default
    private List<HabitualityEntity> habitualities = new ArrayList<>();


}