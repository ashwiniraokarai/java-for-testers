package com.serenitydojo;
import com.serenitydojo.people.*;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class WhenWorkingWithLambdaPersons {
    Person Monica, Chandler, Joey, Ross, Rachel, Phoebe;
    List<Person> friends;
    PersonsTemporaryDataBase personsDatabase;

    @Before
    public void beforeClass() throws Exception {
        Monica = new Person("Monica", 26, "Female", "Purple" );
        Chandler = new Person("Chandler", 25, "Male", "Peach" );
        Joey = new Person("Joey", 26, "Male", "Peach" );
        Ross = new Person("Ross", 24, "Male", "Plum" );
        Rachel = new Person("Rachel", 28, "Female", "Purple" );
        Phoebe = new Person("Phoebe", 24, "Female", "Purple" );

        //Prepare a List of Persons so you can pass them to a low-tech temporary database of Persons
        friends = new ArrayList<Person>();
        Collections.addAll(friends, Monica, Chandler, Joey, Ross, Rachel, Phoebe);

        //Give me an object that represents a low-tech temporary database of Persons so I can initialize it with my data
        personsDatabase = new PersonsTemporaryDataBase(friends);

        //toString() method is automatically called when something is printed using println method but that String is not very readable (HashCode value of the Object)
        // To get println to print something more meaningful, Person Class overrides the  toString() method to return the NAME of the Person Objects instead of the default HashCode
        System.out.println("Original list of persons: " + friends);

        Assertions.assertThat(friends).contains(Monica, Chandler, Joey, Ross, Rachel, Phoebe);
    }

//    @Test
//    public void canSearchPurpleLovingPersonsUnder26(){
//        PersonUnder26AndLovesPurpleChecker ifUnder26AndLovePurple = new PersonUnder26AndLovesPurpleChecker();
//
//        //To hold the result of calling the method on the persons database that returns the filtered list
//        List<Person> filteredPersons;
//
//        //How to perceive this line in your head: "IN the temporary Persons Database (which is a List), find all the persons who are XYZ
//        filteredPersons = personsDatabase.findAllPersonsWho(ifUnder26AndLovePurple);
//        System.out.println("Persons 26 or under who love Purple: " + filteredPersons);
//        Assertions.assertThat(filteredPersons).containsExactly(Monica, Phoebe);
//    }
//
//    @Test
//    public void canSearchPeachLovingPersonsUnder26(){
//        PersonUnder26AndLovesPeachChecker ifUnder26AndLovePeach = new PersonUnder26AndLovesPeachChecker();
//
//        //To hold the result of calling the method findAllPersonsWho  that returns the filtered list
//        List<Person> filteredPersons;
//
//        filteredPersons = personsDatabase.findAllPersonsWho(ifUnder26AndLovePeach);
//        System.out.println("Persons 26 or under who love Peach: " + filteredPersons);
//        Assertions.assertThat(filteredPersons).containsExactly(Chandler, Joey);
//    }
//
//    @Test
//    public void canSearchPlumLovingPersonsUnder26(){
//        PersonUnder26AndLovesPlumChecker ifUnder26AndLovePlum = new PersonUnder26AndLovesPlumChecker();
//
//        //To hold the result of calling the method that returns the filtered list
//        List<Person> filteredPersons;
//
//        filteredPersons = personsDatabase.findAllPersonsWho(ifUnder26AndLovePlum);
//        System.out.println("Persons 26 or under who love Plum: " + filteredPersons);
//        Assertions.assertThat(filteredPersons).containsExactly(Ross);
//    }
//
//    // ************************With Anonymous Class instead*******************************
//    //A VARIATION/ COMPARISON WITH ANONYMOUS CLASS, NO LAMBDA YET (intermediate step)
//    @Test
//    public void withAnonymousClassCanSearchPurpleLovingPersonsUnder26(){
//        List<Person> filteredPersons;
//
//        //Without Anonymous class, you'd instantiate a previously defined concrete implementation (Class)  as was the convention for decades before functional programming
//        // PersonUnder26AndLovesPurpleChecker checkIfUnder26AndLovePurple =  new PersonUnder26AndLovesPurpleChecker();
//
//        //Anonymous on-the-fly class: You provide the concrete implementation (of a Class w/o a name) beside the call to its abstraction
//        PersonChecker checkIfUnder26AndLovePurple =  new PersonChecker() {
//            @Override
//            public Boolean checkAgeAndColor(Person person){
//                Boolean check = person.getAge() <= 26 && person.getFavoriteColor() == "Purple";
//                return check;
//            }
//        };
//
//        filteredPersons = personsDatabase.findAllPersonsWho(checkIfUnder26AndLovePurple);
//
//        System.out.println("Powered by Anonymous Class");
//        System.out.println("Persons 26 or under who love Purple: " + filteredPersons);
//        Assertions.assertThat(filteredPersons).containsExactly(Monica, Phoebe);
//    }
//
//    // ************************With Lambda instead*******************************
//    //A VARIATION/ COMPARISON WITH LAMBDA
//    @Test
//    public void withLambdaCanSearchPurpleLovingPersonsUnder26(){
//        List<Person> filteredPersons;
//
//        //Without Anonymous class, you'd instantiate a previously defined concrete implementation (Class)  as was the convention for decades before functional programming
//        // PersonUnder26AndLovesPurpleChecker checkIfUnder26AndLovePurple =  new PersonUnder26AndLovesPurpleChecker();
//
//        //Without Lambda, you'd use Anonymous on-the-fly class: You provide the concrete implementation (of a Class w/o a name) beside the call to its abstraction
////        PersonChecker checkIfUnder26AndLovePurple =  new PersonChecker() {
////            @Override
////            public Boolean checkAgeAndColor(Person person){
////                Boolean check = person.getAge() <= 26 && person.getFavoriteColor() == "Purple";
////                return check;
////            }
////        };
//
//        //With LAMBDA instead, you'll compact the Anonymous class code. All the "boilerplate" code is gone
//        PersonChecker checkIfUnder26AndLovePurple = person ->
//            person.getAge() <= 26 && person.getFavoriteColor() == "Purple";
//
//        filteredPersons = personsDatabase.findAllPersonsWho(checkIfUnder26AndLovePurple);
//
//        System.out.println("Powered by Lambda");
//        System.out.println("Persons 26 or under who love Purple: " + filteredPersons);
//        Assertions.assertThat(filteredPersons).containsExactly(Monica, Phoebe);
//    }

    // ************************With Lambda + Predicate instead*******************************
    //A VARIATION/ COMPARISON WITH LAMBDA ALONG WITH A PREDICATE
    //The Predicate replaces the PersonChecker Interface
    @Test
    public void withLambdaAndPredicateCanSearchPurpleLovingPersonsUnder26(){
        List<Person> filteredPersons;

        //Without Anonymous class, you'd instantiate a previously defined concrete implementation (Class)  as was the convention for decades before functional programming
        // PersonUnder26AndLovesPurpleChecker checkIfUnder26AndLovePurple =  new PersonUnder26AndLovesPurpleChecker();

        //Without Lambda, you'd use Anonymous on-the-fly class: You provide the concrete implementation (of a Class w/o a name) beside the call to its abstraction
//        PersonChecker checkIfUnder26AndLovePurple =  new PersonChecker() {
//            @Override
//            public Boolean checkAgeAndColor(Person person){
//                Boolean check = person.getAge() <= 26 && person.getFavoriteColor() == "Purple";
//                return check;
//            }
//        };

        //With LAMBDA instead, you'll compact the Anonymous class code. All the "boilerplate" code is gone
//        PersonChecker checkIfUnder26AndLovePurple = person ->
//                person.getAge() <= 26 && person.getFavoriteColor() == "Purple";


        //With a Predicate you can replace the PersonChecker Interface on the other side of the Lambda Equation
        Predicate<Person> checkIfUnder26AndLovePurple = person ->
                person.getAge() <= 26 && person.getFavoriteColor().equals("Purple");

        filteredPersons = personsDatabase.findAllPersonsWho(checkIfUnder26AndLovePurple);

        System.out.println("Powered by Lambda + Predicate");
        System.out.println("Persons 26 or under who love Purple: " + filteredPersons);
        Assertions.assertThat(filteredPersons).containsExactly(Monica, Phoebe);
    }

    // ************************With Lambda + Predicates for each color: Purple, Peach, Plm*******************************
    //A VARIATION/ COMPARISON WITH LAMBDA ALONG WITH A PREDICATE LIKE BEFORE
    //BUT IMPLEMENTED FOR EVERY COLOR - Purple, Peach, Plum
    @Test
    public void withLambdaAndPredicateCanSearchEveryColorLovingPersonsUnder26(){
       List<Person> filteredPersonsPurpleLovers;
       List<Person> filteredPersonsPeachLovers;
       List<Person> filteredPersonsPlumLovers;

        //All predicates
        Predicate<Person> predicatePurpleColorCheckerForPerson =
                person -> person.getAge() <= 26 && person.getFavoriteColor().equals("Purple");

        Predicate<Person> predicatePeachColorCheckerForPerson =
                person -> person.getAge() <= 26 && person.getFavoriteColor().equals("Peach");

        Predicate<Person> predicatePlumColorCheckerForPerson =
                person -> person.getAge() <= 26 && person.getFavoriteColor().equals("Plum");

        //Send away each Predicate to the method that checks the List of Persons and gives a filtered List
        filteredPersonsPurpleLovers = personsDatabase.findAllPersonsWho(predicatePurpleColorCheckerForPerson);
        filteredPersonsPeachLovers = personsDatabase.findAllPersonsWho(predicatePeachColorCheckerForPerson);
        filteredPersonsPlumLovers = personsDatabase.findAllPersonsWho(predicatePlumColorCheckerForPerson);

        //Assert on filtered list of Persons for each color
        System.out.println("Powered by Lambda and Predicates for each color");
        System.out.println("Young Purple Lovers: " + filteredPersonsPurpleLovers);
        System.out.println("Young Peach Lovers: " + filteredPersonsPeachLovers);
        System.out.println("Young Plum Lovers: " + filteredPersonsPlumLovers);
        Assertions.assertThat(filteredPersonsPurpleLovers).containsExactly(Monica, Phoebe);
        Assertions.assertThat(filteredPersonsPeachLovers).containsExactly(Chandler, Joey);
        Assertions.assertThat(filteredPersonsPlumLovers).containsExactly(Ross);
    }

    @After
    public void clearPersonsAndList(){
        friends.clear();
    }
}
