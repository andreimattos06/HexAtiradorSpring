package com.andreimattos06.hexatirador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.ProfileEntity;

/**
 * ProfileRepository
 */
@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long>{

    ProfileEntity findByEmail(String email);
}