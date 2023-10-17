package com.serenitydojo;

public class DogInheritsFromPet extends Pet {
    private String favoriteToy;

    public DogInheritsFromPet (String name, Integer age, String favoriteToy) {
        super(name, age);
        this.favoriteToy = favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public String getFavoriteToy() {
        return this.favoriteToy;
    }

    //automatically oevrrides makeNoise() method defined in Parent Pet Class
    //..because of the same method name and parameter pattern
    @Override
    public String makeNoise(){
        return "woof";
    }

    //Implements the abstract method declared in Parent Pet Class
    public String goForWalks() { return "enjoying a walk with my owner"; }
}
