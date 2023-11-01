package com.serenitydojo;

import com.serenitydojo.people.Person;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WhenWorkingWithStreams {
    Person Monica, Chandler, Joey, Ross, Rachel, Phoebe, Mike, Gunther, Janice ;
    List<Person> friends;

    @Before
    public void createPersons(){
        Monica = new Person("Monica", 26, "Female", "Purple" );
        Chandler = new Person("Chandler", 25, "Male", "Peach" );
        Joey = new Person("Joey", 26, "Male", "Peach" );
        Ross = new Person("Ross", 24, "Male", "Plum" );
        Rachel = new Person("Rachel", 28, "Female", "Purple" );
        Phoebe = new Person("Phoebe", 24, "Female", "Purple" );
        Mike = new Person("Mike", 25, "Male", "Turquoise" );
        Gunther = new Person("Gunther", 23, "Male", "Sage" );
        Janice = new Person("Janice", 22, "Female", "Burgundy" );

        friends = new ArrayList<Person>();
        Collections.addAll(friends, Monica, Chandler, Joey, Ross, Rachel, Phoebe, Mike, Gunther, Janice);
    }

    @Test
    //Loop using .forEach() to set data values on List Objects without Streams in the picture
    public void peopleCanEarnPoints(){
        friends.forEach(
                person -> person.setPoints(100)
        );

        friends.forEach(
                person -> System.out.println("POINTS FOR " + person.getName() + " : " + person.getPoints())
        );
    }

    @Test
    //Loop using .forEach but on parallelStream()
    // Helpful when you have many elements on your List and don't want to loop sequentially
    //Parallel Streams indicate Java to create many threads for parallel processing
    public void peopleCanEarnPointsInParallel(){
        friends.parallelStream().forEach(
                person -> person.setPoints(100)
        );

        friends.stream().forEach(
                person -> System.out.println("POINTS FOR " + person.getName() + " : " + person.getPoints())
        );
    }

    @Test
    //Use .map to access each element without forEach() looping
    //.map() takes a FUNCTION which means it has to RETURN something (like a getter does, for e.g, but a setter won't)
    //A lambda fits the definition of this function
    public void canAccessElementsWithoutLooping(){
       List<String> favoriteColorOfEachFriend =  friends.stream()
                .map(person -> person.getFavoriteColor())
                .collect(Collectors.toList());

        System.out.println(favoriteColorOfEachFriend);
    }

    @Test
    //Use .sorted() w/o passing any parameters for natural order
    // To define a sort based on what you'd like, you'll need to pass along a comparator
    //Let's define a sort to be based on the length of  favorite color of each friend
    public void canSortBasedOnSpecifiedCriteria(){
        List<String> sortedOnLengthOfFavoriteColorOfEachFriend = friends.stream()
                .map(person -> person.getFavoriteColor())
                .sorted(Comparator.comparing((favColor) -> favColor.length()))
                .collect(Collectors.toList());

        System.out.println(sortedOnLengthOfFavoriteColorOfEachFriend);
    }

    @Test
    //Same sort as previous example but chained with a .distinct to retain unique values only
    public void canExtractDistinctValues(){
        List<String> uniqueFavoriteColors = friends.stream()
                .map(person -> person.getFavoriteColor())
                .sorted(Comparator.comparing((favColor) -> favColor.length()))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueFavoriteColors);
    }

    @Test
    //From List to Stream to Integer
    public void canExtractIntegersReturnedFromStringOperations(){
        Integer sumOfLengthOfAllFavoriteColors = friends.stream()
                .map(person -> person.getFavoriteColor())
                .sorted(Comparator.comparing((favColor) -> favColor.length()))
                .distinct()
                .mapToInt(color -> color.length())
                .sum();  //or .min() or .max(), etc

        System.out.println(sumOfLengthOfAllFavoriteColors);
    }

    @After
    public void clearListOfPersons(){
        friends.clear();
    }
}
