package com.serenitydojo.builderpattern;

import java.time.LocalDateTime;

//Copy of Dog class refactored with builder code moved out to external files.
//Constructor is called by ExternalDogBuilder class via a static method
//The eventual caller (test) calls the static method as the new entry point to build a Dog
public class DogOnly {
    private String name, breed, color, optionalFavoriteFood, optionalFavoriteToy;
    private LocalDateTime dateOfBirth;

    public DogOnly(String name, String breed, String color, String optionalFavoriteFood, String optionalFavoriteToy, LocalDateTime dateOfBirth){
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.optionalFavoriteFood = optionalFavoriteFood;
        this.optionalFavoriteToy = optionalFavoriteToy;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public String getColor(){
        return this.color;
    }

    public String getOptionalFavoriteFood(){
        return optionalFavoriteFood;
    }

    public String getOptionalFavoriteToy(){
        return optionalFavoriteToy;
    }

    public LocalDateTime getDateOfBirth() {
        return this.dateOfBirth;
    }
}
