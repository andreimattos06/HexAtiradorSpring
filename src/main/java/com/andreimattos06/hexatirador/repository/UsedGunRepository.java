package com.andreimattos06.hexatirador.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreimattos06.hexatirador.entity.UsedGunEntity;

/**
 * ProfileRepository
 */
@Repository
public interface UsedGunRepository extends MongoRepository<UsedGunEntity, String>{

}