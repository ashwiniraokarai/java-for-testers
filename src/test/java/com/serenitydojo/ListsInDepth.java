package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

/*

These tests dig deeper into Lists
Demonstrates:
- Untyped vs Typed lists. Untyped lists don't have the generic or <> formats since they don't have a type specification
- The use of assertj library - has assertions which suit Lists and anything Collections that need to peek into the data structure for actual value(s)
- Adding multiple elements in one shot via Collections.addAll() after declaring the List
- Adding multiple elements in one shot using another technique: using Arrays.asList() to create the List. DOWNSIDE: Arrays.asList like Arrays are fixed and immutable. UGH.
- removing element from List using .remove()
- finding the indexOf() of an element from its value, so you can then assert on the index instead of element value
- extracting a sublist() - a subset of elements from the List
- getting the size() of a List.
- clear() a List and assert that the List isEmpty(). Idea: You can collect a sublist and clear it! Whoosh!
- converting a List to a Set
- sorting through a List
- finding the maximum and minimum
*/


public class ListsInDepth {
    @Test
    //A List with no "type" - the way it was done in early days of Java
    //You can store any "type" of element on this List if you wanted to. But that isn't a typical usecase
    public void simpleUntypedList() {
        List untypedList = new ArrayList();
        untypedList.add("a string value");
        untypedList.add(123);

        //MAJOR NOTE: This uses the assertj library which is different than the junit built in Assert library I've been using so far
        Assertions.assertThat(untypedList).contains("a string value", 123);
    }

    //A List of String type (all elements in the list are expected to be of String "type")
    //Also shows how you can add multiple elements in one shot using Collections.allAll() method or Arrays.asList
    @Test
    public void simpleTypedList() {
        //ArrayList of Strings
        List<String> typedList = new ArrayList<String>();

        //Adding multiple elements to the ArrayList in one shot
        Collections.addAll(typedList, "Rangeela", "Tamasha");

        //adding 123 is not allowed. I am trying to store an integer - a non-String type in a List that expects Strings only
        //typedList.add(123);

        Assertions.assertThat(typedList).containsExactly("Rangeela", "Tamasha");

        //---------------------------------------------------------------------------
        //ArrayList of Integers
        List<Integer> typedIntegerList = new ArrayList<Integer>();

        //Adding multiple elements to the ArrayList in one shot
        Collections.addAll(typedIntegerList, 123, 456);

        Assertions.assertThat(typedIntegerList).containsExactly(123, 456);

        //---------------------------------------------------------------------------
        //Create ArrayList of Integers using Arrays.asList(). Lets you add values as you declare the "Array as list"
        //The DOWNSIDE is that while ArrayList is mutable, Arrays.asList() like arrays are immutable. You can't add more or remove elements.
        List<Integer> typedIntegerArraysAsList = Arrays.asList(123, 456);

        Assertions.assertThat(typedIntegerArraysAsList).containsExactly(123, 456);
    }

    //Remove items from array list
    @Test
    public void removeElementsFromArrayList(){
        //create a List
        //add elements
        //remove an element
        List<String> removeListElement = new ArrayList<String>();

        Collections.addAll(removeListElement, "apple", "banana");
        removeListElement.remove("apple");

        Assertions.assertThat(removeListElement).containsExactly("banana");
    }

    //Finding index on an element from its value
    //Benefit: You can then assert on index of element instead of directly asserting on value
    @Test
    public void findIndexOfListElement(){
        List<String> assertUsingIndex = new ArrayList<String>();

        Collections.addAll(assertUsingIndex, "Garima","Babita", "Nupur");

        int indexOfGarima = assertUsingIndex.indexOf("Garima");

        //Essentially you are comparing two integers
        Assertions.assertThat(indexOfGarima).isEqualTo(0);
    }

    //extracting a sublist() - a subset of elements from the List
    //NOTE: Although I "extract" the sublist to a list of its own, the subList is a "View" of the original list...
    // ...so if I were to wipe off the sublist, counterintuitively the original List DOES lose NOT those elements!
    @Test
    public void findSubList() {
        List<String> couplesList = new ArrayList<String>();
        Collections.addAll(couplesList, "paul", "sarah", "allison", "brian");

        //NOTE: element at toIndex is NOT INCLUDED in the subList (element at index 3: "brian" is eliminated!)
        List<String> womenOnlyList = couplesList.subList(1,3);
        Assertions.assertThat(womenOnlyList).containsExactly("sarah", "allison");

        Assertions.assertThat(couplesList).containsExactly("paul", "sarah", "allison", "brian");
    }

    //clear() a List:
    //To make things interesting, I first extract a subList and then clear that subList.
    //This wipes out the subList itself of course AND affects the original array too! So I assert on the sublist (that its fully empty)...
    //...and that the original List is partially empty (because it lost the subList items I cleared!)

    @Test
    public void clearTheWholeList(){
        List<String> couplesList = new ArrayList<String>();
        Collections.addAll(couplesList,"paul", "sarah", "allison", "brian");

        List<String> womenOnlyList = couplesList.subList(1,3);
        Assertions.assertThat(womenOnlyList).containsExactly("sarah", "allison");
        Assertions.assertThat(couplesList).containsExactly("paul", "sarah", "allison", "brian");

        //Let's clear all the women in the subList!
        womenOnlyList.clear();

        //Ensure that the sublist is empty whereas the original list is not empty
        Assertions.assertThat(womenOnlyList).isEmpty();
        Assertions.assertThat(couplesList).isNotEmpty();

        //Also check that the original array DID get affected - it should no longer contains the elements from the subList that was cleared
        Assertions.assertThat(couplesList).containsExactly("paul", "brian");
    }


    //getting the size() of a List
    @Test
    public void getListSize(){
        List<String> couplesList = new ArrayList<String>();
        Collections.addAll(couplesList,"paul", "sarah", "allison", "brian");

        int sizeOfCouplesList = couplesList.size();
        Assertions.assertThat(sizeOfCouplesList).isEqualTo(4);
    }

    //converting a List to a Set
    //recall that Lists maintain an order whereas Sets do, so it makes sense to use the .containsExactlyInOrder method in assertions
    //Process: Create a List. Then create a Set while passing along the List as an argument
    @Test
    public void convertListToSet(){
        List<String> listToBecomeSet = new ArrayList<String>();
        Collections.addAll(listToBecomeSet, "paul", "sarah", "allison", "brian", "brian", "paul");
        System.out.println("List: " + listToBecomeSet);

        Set<String> setOfNames = new HashSet<String>(listToBecomeSet);

        //Curious to see what the order would look like!
        System.out.println("Set: " + setOfNames);

        //Ensure characteristics of a Set - only unique elements stay; elements appear in random order,
        //Notice how I used .containsExactlyInAnyOrder as opposed to .containsExactly? And that I switched up the sequence in my expected "Set" of values on purpose?
        Assertions.assertThat(setOfNames).containsExactlyInAnyOrder("paul", "brian", "allison", "sarah");
    }

    //Sorting through a List
    @Test
    public void sortAList(){
        List<String> listToSort = new ArrayList<String>();
        Collections.addAll(listToSort, "paul", "sarah", "allison", "brian", "brian", "paul");

        //Sorts the List (mutates it) BUT surprisingly does not return anything, not even the modified List (void. No new List or a modified List is returned)
        Collections.sort(listToSort);

        //Can't do System.out.println(Collections.sort(listToSort)) because Collections.sort(listToSort) returns a void!
        //System.out.println(Collections.sort(listToSort));
        System.out.println(listToSort);

        //Checking the ALPHABETICAL order because we are ensuring the sort operated as expected
        Assertions.assertThat(listToSort).containsExactly("allison","brian", "brian", "paul", "paul", "sarah");
    }

    //Finding the Maximum and Minimum values in a List
    @Test
    public void findMaxAndMin(){
        List<Integer> listOfNumbers = new ArrayList<Integer>();

        Collections.addAll(listOfNumbers,10,30,50,20,15);
        Assertions.assertThat(Collections.min(listOfNumbers)).isEqualTo(10);
        Assertions.assertThat(Collections.max(listOfNumbers)).isEqualTo(50);
    }

    @Test
    public void combiningLists(){
        //Create 2 different ArrayLists and combine them using the .addAll method
        //You call the .addAll method on one list while passing the other list to be combined with as an argument
        //The list you call the .addAll method on, is the list to which the list you pass as argument gets added onto...
        //..thus resulting in the fist list now becoming the "combined list"

        List<String> listOne = new ArrayList<String>();
        Collections.addAll(listOne, "Rakshit Shetty", "777 Charlie");

        //before combining list one with list two
        Assertions.assertThat(listOne).containsExactly("Rakshit Shetty", "777 Charlie");

        List<String> listTwo = new ArrayList<String>();
        Collections.addAll(listTwo, "Rishab Shetty", "Kantara");
        Assertions.assertThat(listTwo).containsExactly("Rishab Shetty", "Kantara");

        //this method mutates listOne
        listOne.addAll(listTwo);

        //after combining list one with list two, listOne got mutated (sacrificed itself to become the resultant combined list)
        Assertions.assertThat(listOne).containsExactly("Rakshit Shetty", "777 Charlie", "Rishab Shetty", "Kantara");

        //listTwo stays unaffected
        Assertions.assertThat(listTwo).containsExactly("Rishab Shetty", "Kantara");
    }

    @Test
    public void separatingLists(){
        //Begin by combining two lists so you can separate them after in order to restore to original state

        List<String> listOne = new ArrayList<String>();
        Collections.addAll(listOne,"BabuShona", "BabuShoni");

        List<String> listTwo = new ArrayList<String>();
        Collections.addAll(listTwo,"MeriBachhi", "MeriBeti");

        //Combine the two lists and ensure the first list is now a combined list
        listOne.addAll(listTwo);
        Assertions.assertThat(listOne).containsExactly("BabuShona", "BabuShoni", "MeriBachhi", "MeriBeti");
        System.out.println(listOne);

        //Separate the lists and ensure the first list no longer contains the second list
        listOne.removeAll(listTwo);
        System.out.println(listOne);
        Assertions.assertThat(listOne).containsExactlyInAnyOrder("BabuShona", "BabuShoni");
    }
}


