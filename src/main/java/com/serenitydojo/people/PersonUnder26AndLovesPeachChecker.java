package com.serenitydojo.people;

public class PersonUnder26AndLovesPeachChecker implements PersonChecker {

   public Boolean checkAgeAndColor(Person person){
       Person personUnder26AndLovePeach;
       Boolean trueOrFalse;

       trueOrFalse = person.getAge() <= 26 && person.getFavoriteColor().equals("Peach");
        return trueOrFalse;
    }
}
