package com.andreimattos06.hexatirador.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.HabitualityEntity;


@Repository
public interface HabitualityRepository extends MongoRepository<HabitualityEntity, String>{

    public Optional<List<HabitualityEntity>> findAllByProfileEmail(String email);

}