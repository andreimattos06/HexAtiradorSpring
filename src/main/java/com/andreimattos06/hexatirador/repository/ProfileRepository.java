package com.andreimattos06.hexatirador.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.ProfileEntity;


@Repository
public interface ProfileRepository extends MongoRepository<ProfileEntity, String>{

    Optional<ProfileEntity> findByEmail(String email);
    void deleteByEmail(String email);
}