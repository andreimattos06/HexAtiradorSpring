package com.andreimattos06.hexatirador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.UsedGunEntity;

/**
 * ProfileRepository
 */
@Repository
public interface UsedGunRepository extends JpaRepository<UsedGunEntity, Long>{

}