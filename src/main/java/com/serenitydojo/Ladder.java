package com.serenitydojo;

public class Ladder implements CompareHeightWith{
    private Integer ladderHeight;

    Ladder(Integer ladderHeight){
        this.ladderHeight = ladderHeight;
    }
    public Boolean isLevelHighEnoughTo(Integer expectedLevel){
        return ladderHeight >= expectedLevel;
    }
}
