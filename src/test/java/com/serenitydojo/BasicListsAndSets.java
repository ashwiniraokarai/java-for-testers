package com.serenitydojo;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Collections Framework: Made of Lists, Sets, and Maps. Why do we need them? Due to limitations of Arrays in Java:
//Java arrays are fixed in size, can't add more or remove elements! You'll need an ArrayList in order to do that.
//Arrays are rarely and barely ever used in modern Java. Collections are preferred (such as Lists, Sets, and Maps)
//Lists: Sequence is followed (they appear in the order they were entered). List can have repeat elements.
//Sets: Sequence is not maintained. Elements gotta be unique.
public class BasicListsAndSets {
    //Earlier I created an Array of colors. I'll maintain the same theme in List and Set.
    @Test
    public void Lists(){
        //Let's create an ArrayList of colors
        List<String> listOfColors = new ArrayList<String>();

        //Add elements to the List
        listOfColors.add("mustard");
        listOfColors.add("teal");
        listOfColors.add("purple");
        listOfColors.add("aRepeatColor");

        //Add a repeat element (to show that its accepted as its own element in Lists)
        listOfColors.add("aRepeatColor");

        //Loop through the list using an iterator and read the values
        System.out.println("loop over ArrayList using special for-loop:");
        for(String color: listOfColors) {
            System.out.println(color);
        }

        //Of course, you can use the standard for-loop using indices but its rudimentary and less readable
        System.out.println(("\nloop over list using the less preferred style - using standard index based for-loop and get(i) method:"));
        for(int i=0; i<5; i++){
            System.out.println(listOfColors.get(i));
        }

    }

    @Test
    public void Sets(){
        //Create a HashSet of Colors
        Set<String> setOfColors = new HashSet<String>();

        //Add some Colors to the Set (similar to List)
        setOfColors.add("mauve");
        setOfColors.add("pink");
        setOfColors.add("peach");
        setOfColors.add("aRepeatColor");

        //Add the repeat color (won't error but will not add the repeat element (dissimilar to List_
        setOfColors.add("aRepeatColor");

        //Loop through the list using an iterator and read the values
        System.out.println("loop over HashSet using special for-loop:");
        System.out.println("Notice that elements do not stick to the order in which they were added. " +
                "Also notice how aRepeatColor did not get added to the Set a second time");
        for(String color: setOfColors) {
            System.out.println(color);
        }
        //NOTE: You don't NEED to loop thro the Collection to display its elements but it's helpful to know how to loop through it when you need to
    }
}
