package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import com.andreimattos06.hexatirador.entity.ProfileEntity;

public interface ProfileService {
    List<ProfileEntity> findAllProfiles();

    Optional<ProfileEntity> findById(Long id);

    ProfileEntity findByEmail(String email);

    ProfileEntity saveProfile(ProfileEntity profileEntity);

    ProfileEntity updateProfile(ProfileEntity profileEntity);

    boolean deleteProfileById(Long id);

    boolean deleteProfileByEmail(String email);

}
