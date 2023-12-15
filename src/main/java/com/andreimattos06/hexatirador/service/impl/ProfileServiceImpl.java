package com.andreimattos06.hexatirador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.repository.ProfileRepository;
import com.andreimattos06.hexatirador.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<ProfileEntity> findAllProfiles() {
        return profileRepository.findAll();

    }

    @Override
    public Optional<ProfileEntity> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public Optional<ProfileEntity> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    @Override
    public ProfileEntity updateProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void deleteProfileByEmail(String email) {
        profileRepository.deleteByEmail(email);
    }
    
}
