package com.serenitydojo;

public class HamsterInheritsFromPet extends Pet {
    private String favoriteGame;

    public HamsterInheritsFromPet(String name, Integer age, String favoriteGame){
        super(name, age);
        this.favoriteGame = favoriteGame;
    }

    public void setFavoriteGame(String favoriteGame) {
        this.favoriteGame = favoriteGame;
    }

    public String getFavoriteGame() {
        return this.favoriteGame;
    }

    //Implements the abstract method declared in Parent Pet Class
    public String goForWalks(){
        return "I am not very keen on going for walks";
    }
}
