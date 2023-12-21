package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.dto.ProfileDTO;
import com.andreimattos06.hexatirador.entity.ProfileEntity;
import com.andreimattos06.hexatirador.repository.ProfileRepository;
import com.andreimattos06.hexatirador.service.exceptions.ResourceNotFoundException;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileEntity> findAllProfiles() {
        return profileRepository.findAll();

    }

    public ProfileEntity findById(String id) {
        Optional<ProfileEntity> obj = profileRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Optional<ProfileEntity> findByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public ProfileEntity saveProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    public ProfileEntity updateProfile(ProfileEntity profileEntity, String id) {
        /*ProfileEntity profile = profileRepository.getReferenceById(id);
        updateData(profileEntity, profile);*/
        return profileRepository.save(profileEntity);
    }

    /*private void updateData(ProfileEntity profileEntity, ProfileEntity profile) {
        profile.setEmail(profileEntity.getEmail());
        profile.setFirst_name(profileEntity.getFirst_name());
        profile.setGender(profileEntity.getGender());
        profile.setLast_name(profileEntity.getLast_name());
        profile.setPassword(profileEntity.getPassword());
    }*/

    public void deleteProfileById(String id) {
        profileRepository.deleteById(id);
    }

    public void deleteProfileByEmail(String email) {
        profileRepository.deleteByEmail(email);
    }

    public ProfileEntity fromDTO(ProfileDTO profile){
        return new ProfileEntity().builder().email(profile.getEmail()).first_name(profile.getFirst_name()).gender(profile.getGender())
        .last_name(profile.getLast_name()).password(profile.getPassword()).build();
    }

}
