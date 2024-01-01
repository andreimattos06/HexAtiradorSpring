package com.andreimattos06.hexatirador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreimattos06.hexatirador.dto.CompetitionUsedGunDTO;
import com.andreimattos06.hexatirador.entity.CompetitionEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;
import com.andreimattos06.hexatirador.service.CompetitionService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/competitions")
public class CompetitionController {
        
    @Autowired
    private CompetitionService competitionService;



    @GetMapping
    public ResponseEntity<List<CompetitionEntity>> findAllCompetitions(){
        List<CompetitionEntity> habitualities = competitionService.findAllCompetitions();       
        return ResponseEntity.ok().body(habitualities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionEntity> findById(@PathVariable("id") String id){
        CompetitionEntity competition = competitionService.findById(id);
        return ResponseEntity.ok().body(competition);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<List<CompetitionEntity>> findAllByProfileId(@PathVariable("id") String id){
        List<CompetitionEntity> competition = competitionService.findAllByProfileId(id);
        return ResponseEntity.ok().body(competition);
    }

    /*@PostMapping
    public ResponseEntity<Object> saveCompetition(@RequestBody CompetitionEntity competitionEntity, List<UsedGunEntity> used_guns){
        competitionEntity = competitionService.saveCompetition(competitionEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(competitionEntity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }*/

    @Transactional
    @PostMapping
    public void saveCompetition(@RequestBody CompetitionUsedGunDTO competitionUsedGunDTO){
        System.out.println(competitionUsedGunDTO.getCompetitionEntity().getCity());
        List<UsedGunEntity> lista = competitionUsedGunDTO.getUsedGunEntity();
        //competitionEntity = competitionService.saveCompetition(competitionEntity);
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(competitionEntity.getId()).toUri();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CompetitionEntity> updateCompetition(@PathVariable("id") String id, @RequestBody CompetitionEntity competitionEntity){
        CompetitionEntity competition = competitionService.updateCompetition(competitionEntity, id);
        return ResponseEntity.ok().body(competition);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        competitionService.deleteCompetitionById(id);
    }

}
