package com.serenitydojo.people;

public class PersonUnder26AndLovesPlumChecker implements PersonChecker {

   public Boolean checkAgeAndColor(Person person){
       Boolean trueOrFalse;

       trueOrFalse = person.getAge() <= 26 && person.getFavoriteColor().equals("Plum");
        return trueOrFalse;
    }
}
