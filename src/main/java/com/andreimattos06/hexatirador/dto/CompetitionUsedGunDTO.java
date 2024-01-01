package com.andreimattos06.hexatirador.dto;

import java.util.List;

import com.andreimattos06.hexatirador.entity.CompetitionEntity;
import com.andreimattos06.hexatirador.entity.UsedGunEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompetitionUsedGunDTO{

    CompetitionEntity competitionEntity;
    List<UsedGunEntity> usedGunEntity;
    
}
