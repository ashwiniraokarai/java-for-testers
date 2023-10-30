package com.serenitydojo.people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonsTemporaryDataBase {
    List<Person> listOfPersons;

    public PersonsTemporaryDataBase(List<Person> listOfPersons) {
        this.listOfPersons = listOfPersons;
    }

//    public List<Person> findAllPersonsWho(PersonChecker  personChecker){
//        List<Person> allPersonsUnder26FavColorPurple = new ArrayList<Person>();
//        //PersonUnder26AndLovesPurpleChecker personUnder26AndLovesPurple = new PersonUnder26AndLovesPurpleChecker();
//
//        //go to each person on original list of persons  (loop) and check if they are 26 or under
//        //add that person to new list (don't need to loop because you can do 'newlist.add()')
//        for(Person person : this.listOfPersons) {
//            if(personChecker.checkAgeAndColor(person)){
//                allPersonsUnder26FavColorPurple.add(person);
//            }
//        }
//        return allPersonsUnder26FavColorPurple;
//    }

    //Replace references to PersonChecker Interface with Boolean to match the evolution on Calling Code (Lambda + Predicate):
    // Replace Parameter Type and Name
    // Replace call to personChecker.checkAgeAndColor method of PersonChecker Interface with builtin method called .test that evaluates a Predicate like this: predicatePersonChecker.test
//    public List<Person> findAllPersonsWho(Predicate<Person> predicatePersonChecker){
//        List<Person> allPersonsUnder26FavColorPurple = new ArrayList<Person>();
//        //PersonUnder26AndLovesPurpleChecker personUnder26AndLovesPurple = new PersonUnder26AndLovesPurpleChecker();
//
//        //go to each person on original list of persons  (loop) and check if they are 26 or under
//        //add that person to new list (don't need to loop because you can do 'newlist.add()')
//        for(Person person : this.listOfPersons) {
//            if(predicatePersonChecker.test(person)){
//                allPersonsUnder26FavColorPurple.add(person);
//            }
//        }
//        return allPersonsUnder26FavColorPurple;
//    }

    // Finally, replace the for-loop and if with Streams (forEach + Streams) which inherently favors another usecase of Lambda
    public List<Person> findAllPersonsWho(Predicate<Person> predicatePersonChecker){
        List<Person> allPersonsUnder26FavColorPurple = new ArrayList<Person>();
        //PersonUnder26AndLovesPurpleChecker personUnder26AndLovesPurple = new PersonUnder26AndLovesPurpleChecker();

        //go to each person on original list of persons  (loop) and check if they are 26 or under
        //add that person to new list (don't need to loop because you can do 'newlist.add()')
//        for(Person person : this.listOfPersons) {
//            if(predicatePersonChecker.test(person)){
//                allPersonsUnder26FavColorPurple.add(person);
//            }
//        }

        allPersonsUnder26FavColorPurple = this.listOfPersons.stream()
                .filter(person -> predicatePersonChecker.test(person))
                .collect(Collectors.toList());

        return allPersonsUnder26FavColorPurple;
    }
}
