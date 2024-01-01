package com.andreimattos06.hexatirador.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.CompetitionEntity;


@Repository
public interface CompetitionRepository extends MongoRepository<CompetitionEntity, String>{

    public Optional<List<CompetitionEntity>> findAllByProfileId(String id);

}