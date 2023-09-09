package com.serenitydojo.model;

public class FeederWithSwitchCase {
    public String feed(String pet, Boolean isPremium) {
        //replaced if elses with switch-case
        switch (pet) {
            case "cat":
                String catFeed = (isPremium == true) ? "premium " + pet + " was fed premium food - salmon!" : pet + " was fed tuna.";
                return catFeed;
            case "dog":
                return (pet + " was fed bone.");
            case "hamster":
                return (pet + " was fed cabbage.");
            default:
                return ("sorry, can't feed " + pet + ".");
        }
    }
}