package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileEntity> findAllProfiles() {
        return profileRepository.findAll();

    }

    public Optional<ProfileEntity> findById(Long id) {
        return profileRepository.findById(id);
    }

    public Optional<ProfileEntity> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    public ProfileEntity updateProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    public void deleteProfileByEmail(String email) {
        profileRepository.deleteByEmail(email);
    }

}
