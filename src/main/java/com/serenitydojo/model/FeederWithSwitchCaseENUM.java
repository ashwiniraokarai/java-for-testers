package com.serenitydojo.model;

public class FeederWithSwitchCaseENUM {
    //Replace String input for pet type with ENUM.
    public String feed(PetType pet, Boolean isPremium) {
        //Benefit: Using ENUM type ensures I pass proper values to the switch case in the caller (in this case, the tests)
        String petStringLowerCase = pet.toString().toLowerCase();
        switch (pet) {
            case CAT:
                String catFeed = (isPremium == true) ? "premium " + petStringLowerCase + " was fed premium food - salmon!" : petStringLowerCase + " was fed tuna.";
                return catFeed;
            case DOG:
                return (petStringLowerCase + " was fed bone.");
            case HAMSTER:
                return (petStringLowerCase + " was fed cabbage.");
            default:
                return ("sorry, can't feed " + petStringLowerCase + ".");
        }
    }
}