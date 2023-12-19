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

    public ProfileEntity updateProfile(ProfileEntity profileEntity, Long id) {
        ProfileEntity profile = profileRepository.getReferenceById(id);
        updateData(profileEntity, profile);
        return profileRepository.save(profile);
    }

    private void updateData(ProfileEntity profileEntity, ProfileEntity profile) {
        profile.setEmail(profileEntity.getEmail());
        profile.setFirst_name(profileEntity.getFirst_name());
        profile.setGender(profileEntity.getGender());
        profile.setLast_name(profileEntity.getLast_name());
        profile.setPassword(profileEntity.getPassword());
    }

    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    public void deleteProfileByEmail(String email) {
        profileRepository.deleteByEmail(email);
    }

}
