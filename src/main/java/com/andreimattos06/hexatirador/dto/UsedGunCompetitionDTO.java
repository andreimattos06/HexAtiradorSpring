package com.andreimattos06.hexatirador.dto;


import com.andreimattos06.hexatirador.entity.CompetitionEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsedGunCompetitionDTO {

    private String id;

    public UsedGunCompetitionDTO() {
    }

    public UsedGunCompetitionDTO(CompetitionEntity competition) {
        id = competition.getId();

    }

}
