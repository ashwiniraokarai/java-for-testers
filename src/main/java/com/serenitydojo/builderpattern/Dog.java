package com.serenitydojo.builderpattern;

import java.time.LocalDateTime;

public class Dog {
    private String name, breed, color, optionalFavoriteFood, optionalFavoriteToy;
    private LocalDateTime dateOfBirth;
    public interface RequiredBreed {
        public RequiredColor ofBreed(String breed);
    }
    public interface RequiredColor {
        public  DogBuilder ofColor(String color);
    }

    private Dog(String name, String breed, String color, String optionalFavoriteFood, String optionalFavoriteToy, LocalDateTime dateOfBirth){
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.optionalFavoriteFood = optionalFavoriteFood;
        this.optionalFavoriteToy = optionalFavoriteToy;
        this.dateOfBirth = dateOfBirth;
    }

    public static RequiredBreed named(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder implements RequiredColor, RequiredBreed {
        private String name, breed, color, optionalFavoriteFood, optionalFavoriteToy;
        private LocalDateTime dateOfBirth;
        public DogBuilder(String name){
             this.name = name;
        }

        public RequiredColor ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public  DogBuilder ofColor(String color){
            this.color = color;
            return this;
        }

        public DogBuilder likesToEat(String optionalFavoriteFood){
            this.optionalFavoriteFood = optionalFavoriteFood;
            return this;
        }

        public DogBuilder enjoysPlayingWith(String optionalFavoriteToy){
            this.optionalFavoriteToy = optionalFavoriteToy;
            return this;
        }

        public Dog bornOn(LocalDateTime dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return new Dog(name, breed, color, optionalFavoriteFood, optionalFavoriteToy, dateOfBirth);
        }
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
