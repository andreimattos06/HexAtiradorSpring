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
    public ProfileEntity findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProfile'");
    }

    @Override
    public ProfileEntity updateProfile(ProfileEntity profileEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    }

    @Override
    public boolean deleteProfileById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfileById'");
    }

    @Override
    public boolean deleteProfileByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfileByEmail'");
    }
    
}
