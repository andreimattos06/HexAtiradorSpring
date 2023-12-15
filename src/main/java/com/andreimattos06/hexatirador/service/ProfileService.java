package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import com.andreimattos06.hexatirador.entity.ProfileEntity;

public interface ProfileService {
    List<ProfileEntity> findAllProfiles();

    Optional<ProfileEntity> findById(Long id);

    Optional<ProfileEntity> findByEmail(String email);

    ProfileEntity saveProfile(ProfileEntity profileEntity);

    ProfileEntity updateProfile(ProfileEntity profileEntity);

    void deleteProfileById(Long id);

    void deleteProfileByEmail(String email);

}
