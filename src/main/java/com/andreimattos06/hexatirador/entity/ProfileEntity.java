package com.andreimattos06.hexatirador.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.andreimattos06.hexatirador.entity.enums.Role;

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
public class ProfileEntity implements UserDetails{

    @Id
    private String id;
    private String first_name;
    private String last_name;
    
    @Indexed(unique = true)
    private String email;
    private String password;
    private String gender;
    private Byte shooter_level;
    private Role role;

    
    @Builder.Default
    @DBRef(lazy = true)
    private List<HabitualityEntity> habitualities = new ArrayList<>();

    
    @Builder.Default
    @DBRef(lazy = true)
    private List<CompetitionEntity> competitions = new ArrayList<>();

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}