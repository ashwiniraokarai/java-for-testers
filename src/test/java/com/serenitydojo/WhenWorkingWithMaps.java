package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WhenWorkingWithMaps {
     @Test
     public void creatingAMapOfColoredBalls(){
          // A Map that Maps  Colors of (Tennis) Balls to their Quantities (Count)
          Map<String, Integer> numberOfBallsByColor = new HashMap<>();

          //Storing values
          numberOfBallsByColor.put("purple", 3);
          numberOfBallsByColor.put("plum", 4);
          numberOfBallsByColor.put("yellow", 5);

          //Reading stored values
          System.out.println(numberOfBallsByColor.get("purple")  + "\n" +
                  numberOfBallsByColor.get("plum") + "\n" +  numberOfBallsByColor.get("yellow") );

          System.out.println(numberOfBallsByColor.keySet());
     }

     @Test
     public void copyBetweenMaps(){
          //Combine/ Merge  two maps (copy over from one Map to Another using putAll)
          Map<String, Integer> numberOfBallsByColor = new HashMap<String, Integer>();
          numberOfBallsByColor.put("purple", 3);
          System.out.println("Before adding more colors: " + numberOfBallsByColor);

          Map<String, Integer> moreColors = new HashMap<String, Integer>();
          moreColors.put("plum", 4);
          moreColors.put("peach", 5);

          numberOfBallsByColor.putAll(moreColors);
          System.out.println("After adding more colors: " + numberOfBallsByColor);
     }
     @Test
     //Only works with Java 9 and +. Reminds me of the Ruby Hash used popularly for creating backend data  (Model with Properties)
     public void shortcutForCreatingAMap(){
//          Map<String, Integer> numberOfBallsByColor = Map.of("purple",3,"plum",4,"yellow",5);
     }

     @Test
     //return default value of choice when key does not have any entry - using .getOrDefault
     public void returnDefaultValue(){
          Map<String, Integer> numberOfBallsByColor = new HashMap<String, Integer>();

          //purple is a key that has an entry but a default value is set in case it had not had an entry
          numberOfBallsByColor.put("purple", 3);
          Integer getPurplesOrDefault = numberOfBallsByColor.getOrDefault("purple", 0);
          System.out.println("Are there any purple balls?" + numberOfBallsByColor.containsKey("purple") );
          System.out.println("How many  purple  balls? " + getPurplesOrDefault);

          //white does not have an entry, so setting a default value will return that default instead of null
          System.out.println("Are there any white  balls?" + numberOfBallsByColor.containsKey("white") );
          //if default is not set, you get null
          System.out.println("How many  white balls? " + numberOfBallsByColor.get("white"));
          //set a default value of choice to return when white key does not exist
          Integer getWhitesOrDefault = numberOfBallsByColor.getOrDefault("white",0);
          System.out.println("How many  white balls? " + getWhitesOrDefault);
     }

     //Update/ replace Map value by simply using .get a second time
     @Test
     public void updateMapValue(){
          Map<String, Integer> numberOfBallsByColor = new HashMap<String, Integer>();
          numberOfBallsByColor.put("purple", 3);
          numberOfBallsByColor.put("plum", 4);
          numberOfBallsByColor.put("peach", 5);

          System.out.println("Original value of plum balls (key): " + numberOfBallsByColor.get("plum"));
          numberOfBallsByColor.put("plum", 10);
          System.out.println("Updated value of plum balls (key): " + numberOfBallsByColor.get("plum"));
     }

     //Update/ replace Map value IF IT EXISTS by using .replace
     @Test
     public void replaceMapValueIfKeyExists(){
         //Empty HashMap (no keys)
        Map<String, Integer> numberOfBallsByColor = new HashMap<String, Integer>();
        System.out.println("Original value of non-existing Key: " + numberOfBallsByColor.get("purple") );

        //Try replace on a Key that does not exist
        numberOfBallsByColor.replace("purple", 11);
        System.out.println("Replacing the Value of  a Key that does not exist still gives you: " + numberOfBallsByColor.get("purple"));

        //Replace a Value after making the Key available
          numberOfBallsByColor.put("purple", 3);
          System.out.println("Added a 'Purple'  Key with Value: " + numberOfBallsByColor.get("purple"));
          numberOfBallsByColor.replace("purple", 11);
          System.out.println("Replaced Value of  'Purple' Key: " + numberOfBallsByColor.get("purple"));
     }

     //Iterating over all entries (thro Key Set or Entry Set) to do something with them
     @Test
     public void iterateOverMap(){
          Map<String, Integer> numberOfBallsByColor  = new HashMap<String, Integer>();
          //Add entries
          numberOfBallsByColor.put("purple", 3);
          numberOfBallsByColor.put("plum", 4);
          numberOfBallsByColor.put("peach", 5);

          //Iterate over the Key Set to access each Key one by one
          System.out.println(" Key Set =  " +numberOfBallsByColor.keySet());
          for(String key : numberOfBallsByColor.keySet() ) {
               //do something - typically grab the Value of each Key
               Integer numberOfBalls = numberOfBallsByColor.get(key);
               System.out.println(key + " : " + numberOfBalls );
          }

          //Iterate over the Entry Set (Key - Value pair)
          //Getting a feel for the return type and structure before iterating over the entrySet of the Map (testing the waters)
          Set<Map.Entry<String, Integer>> entries = numberOfBallsByColor.entrySet();
          System.out.println("Entry Set = " + entries);

          //.entrySet() returned a "Set" structure that holds many of "Map.Entry" type. Each entry holds String Key and Integer Value
          // Ready to iterate now over each Map.Entry
          for (Map.Entry<String, Integer> entry : numberOfBallsByColor.entrySet()) {
               System.out.println( entry.getKey() + " : " + entry.getValue());
          }
     }

     @Test
     //Created a separate helper method to display map entries before and after removals
     public void removeEntriesFromMap(){
          //Create a Map and add entries
          Map<String, Integer>  numberOfBallsByColor = new HashMap<String, Integer>();
          numberOfBallsByColor.put("purple", 3);
          numberOfBallsByColor.put("plum", 4);
          numberOfBallsByColor.put("peach", 5);

          //Call helper method to iterate over map entry set to display original map entries : key - value pairs
          printMapHelper(numberOfBallsByColor);

          //Remove a single entry from Map
          numberOfBallsByColor.remove("purple");

          //Iterate over map to display updated map entries : key - value pair
          System.out.println("===========\nAfter Key 'purple' was removed:");
          printMapHelper(numberOfBallsByColor);

          //Clear the Map - remove all entries
          numberOfBallsByColor.clear();
          System.out.println("===========\nAfter the Map was cleared altogether:");
          printMapHelper(numberOfBallsByColor);
     }

     //Helper method to iterate over map entry set and display key - value pair
     //Typical use-case: Called to display before and after states of a mutated Map
     //Note how there is no @Test annotation on helper methods
     public void printMapHelper(Map<String, Integer> mapObject){
          //Getting a feel for the return type before iterating over the entrySet of the Map (testing the waters)
          Set<Map.Entry<String, Integer>> entries = mapObject.entrySet();
          System.out.println("Set of entries to iterate through: " +  entries);

          //Iterate over map entry set to display map entries : key - value pairs
          System.out.println("Looping through:");
          for(Map.Entry<String, Integer> entry : entries){
               System.out.println(entry.getKey() + " : " + entry.getValue());
          }
     }
}
