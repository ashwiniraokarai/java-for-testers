package com.serenitydojo.builderpattern;

import java.time.LocalDateTime;

//Builder code
public class ExternalDogBuilder implements RequiredColor, RequiredBreed {
    private String name, breed, color, optionalFavoriteFood, optionalFavoriteToy;
    private LocalDateTime dateOfBirth;

    //Shifted entry point for the test (caller) to start building a Dog
    public static ExternalDogBuilder aDog(){
        return new ExternalDogBuilder();
    }

    public static ExternalDogBuilder aStandardDog(){
        return new ExternalDogBuilder().ofBreed("Golden retriever");
    }

    public static ExternalDogBuilder aSmallDog(){
        return new ExternalDogBuilder().ofBreed("poodle");
    }

    public static ExternalDogBuilder aLargeDog(){
        return new ExternalDogBuilder().ofBreed("husky");
    }

    public static ExternalDogBuilder aGuardDog(){
        return new ExternalDogBuilder().ofBreed("german shepherd");
    }

    public ExternalDogBuilder named(String name){
        this.name = name;
        return this;
    }

    public ExternalDogBuilder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public  ExternalDogBuilder ofColor(String color){
        this.color = color;
        return this;
    }

    public ExternalDogBuilder likesToEat(String optionalFavoriteFood){
        this.optionalFavoriteFood = optionalFavoriteFood;
        return this;
    }

    public ExternalDogBuilder enjoysPlayingWith(String optionalFavoriteToy){
        this.optionalFavoriteToy = optionalFavoriteToy;
        return this;
    }

    public DogOnly bornOn(LocalDateTime dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return new DogOnly(name, breed, color, optionalFavoriteFood, optionalFavoriteToy, dateOfBirth);
    }
}