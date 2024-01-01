package com.andreimattos06.hexatirador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreimattos06.hexatirador.entity.CompetitionEntity;
import com.andreimattos06.hexatirador.repository.CompetitionRepository;
import com.andreimattos06.hexatirador.service.exceptions.ResourceNotFoundException;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public List<CompetitionEntity> findAllCompetitions() {
        return competitionRepository.findAll();

    }

    public CompetitionEntity findById(String id) {
        Optional<CompetitionEntity> obj = competitionRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<CompetitionEntity> findAllByProfileId(String id){
        Optional<List<CompetitionEntity>> obj = competitionRepository.findAllByProfileId(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public CompetitionEntity saveCompetition(CompetitionEntity competitionEntity) {
        return competitionRepository.save(competitionEntity);
    }

    public CompetitionEntity updateCompetition(CompetitionEntity competitionEntity, String id) {
        return competitionRepository.save(competitionEntity);
    }


    public void deleteCompetitionById(String id) {        
            competitionRepository.deleteById(id);      
        
    }


}
