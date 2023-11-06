package com.serenitydojo;

//This is to show how Enums can have the features that can make them like full blown Classes
public enum LevelEnumLikeAClass implements CompareHeightWith {
    HIGH(4), MEDIUM(3), LOW(2), REALLY_LOW(1);

    private Integer levelCode;

    //A constructor for Enum
    LevelEnumLikeAClass(Integer levelCode){
        this.levelCode = levelCode;
    }

    //A getter in Enum
    public Integer getLevelCode(){
        return this.levelCode;
    }

    //A method in Enum
    public Boolean isLevelHighEnoughTo(Integer expectedLevel){
        return this.levelCode >= expectedLevel;
    }
}
