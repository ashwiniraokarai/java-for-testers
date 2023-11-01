package com.serenitydojo.people;

public class Person {
    private String name;
    private Integer age;
    //gender could be a potential Enum to restrict values
    private String gender;
    private String favoriteColor;
    private Integer points;

    public  Person(String name, Integer age, String gender, String favoriteColor){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.favoriteColor = favoriteColor ;
        this.points = 0;
    }

    public Integer getAge(){
       return  this.age;
    }

    public String getFavoriteColor(){
        return this.favoriteColor;
    }
    //Override default toString so println on Person Object prints their name instead of hashcode

    public String getName() {
        return this.name;
    }

    public void setPoints(Integer earnedPoints){
        System.out.println("About to set points for: "  + this.name);
        this.points = this.points + earnedPoints;
    }

    public Integer getPoints(){
        return this.points;
    }
    @Override
    public String toString(){
        return this.name;
    }

}
