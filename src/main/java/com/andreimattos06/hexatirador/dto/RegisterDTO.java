package com.andreimattos06.hexatirador.dto;

import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.entity.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String gender;


    public ProfileEntity fromDTO(RegisterDTO register){
        return ProfileEntity.builder()
        .email(register.getEmail())
        .first_name(register.getFirst_name())
        .gender(register.getGender())
        .last_name(register.getLast_name())
        .password(register.getPassword())
        .role(Role.USER)
        .build();
    }
}
