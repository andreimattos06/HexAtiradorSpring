package com.andreimattos06.hexatirador.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;

/**
 * ProfileRepository
 */
@Repository
public interface HabitualityRepository extends JpaRepository<HabitualityEntity, Long>{

}