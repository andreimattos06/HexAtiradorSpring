package com.andreimattos06.hexatirador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.andreimattos06.hexatirador.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Autowired
    ProfileRepository profileRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> profileRepository.findByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    
}
