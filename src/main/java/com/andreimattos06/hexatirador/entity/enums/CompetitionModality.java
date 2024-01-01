package com.andreimattos06.hexatirador.entity.enums;

public enum CompetitionModality{

    SHOTGUN_IPSC(1,"Shotgun IPSC"),
    MINI_RIFLE_IPSC(2, "Mini Rifle IPSC"),
    RIFLE_IPSC(3, "Rifle IPSC"),
    HANDGUN_IPSC(4, "Handgun IPSC"),
    CLC_HANDGUN(5, "CLC Handgun"),
    NRA(6, "NRA"),
    SAQUE_RAPIDO(7, "Saque Rápido"),
    TIRO_RAPIDO_DE_PRECISAO(8, "Tiro Rápido de Precisão"),
    STEEL_CHALLENGE_DESAFIO_DO_ACO(9, "Steel Challenge Desafio do Aço"),
    MULTIGUN(10, "Multigun"),
    SHOOTOFF(11, "Shootoff");

    private Integer code;
    private String name;


    private CompetitionModality(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode(){
        return code;
    }
    
    public String getName(){
        return name;
    }

    public static CompetitionModality valueOf(int code){
        for (CompetitionModality value: CompetitionModality.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Competition Modality code.");
    }

    public static CompetitionModality valueOfString(String name){
        for (CompetitionModality value: CompetitionModality.values()){
            if(value.getName().equalsIgnoreCase(name)){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Competition Modality code.");
    }


}
