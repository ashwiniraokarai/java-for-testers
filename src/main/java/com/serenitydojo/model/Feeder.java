package com.serenitydojo.model;

public class Feeder {
    public String feed(String pet, Boolean isPremium) {
        if (pet.equals("cat")) {
//            if(isPremium == true){
//                return(pet + " was fed premium food - salmon!");
//            } else {
//                return(pet + " was fed tuna.");
//            }

//          using ternary operator instead for the inner nested-if
            String catFeed = (isPremium == true) ? "premium " + pet + " was fed premium food - salmon!" : pet + " was fed tuna." ;
            return catFeed;

        } else if (pet.equals("dog")) {
            return (pet + " was fed bone.");
        } else if (pet.equals("hamster")) {
            return(pet + " was fed cabbage.");
        } else {
            return("sorry, can't feed " + pet + ".");
        }
    }
}