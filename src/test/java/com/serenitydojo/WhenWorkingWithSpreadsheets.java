package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class WhenWorkingWithSpreadsheets {
    List<List<String>> shrekTrio;
    @Test
    public void writeAListOfListsToExcel() throws IOException {
        //We structure our data in a List of Lists because this mimics a common use-case of where data is read from to feed into spreadsheet
        //Typically a cucumber feature file is the sender of data and StepDefinition is the receiver:
        //  The sender data is structured as a Table which translates to a List of Lists in the consuming StepDefinition

        List<String> shrek = new ArrayList<String>();
        Collections.addAll(shrek, "Shrek", "27", "green");

        List<String> donkey = new ArrayList<String>();
        Collections.addAll(donkey, "Donkey", "12", "gray");

        List<String> pussInBoots = new ArrayList<String>();
        Collections.addAll(pussInBoots, "Puss", "6", "orange");

        //Form a "shrekTrio" outer List that holds all 3 characters (inner Lists)
       // List<List<String>> shrekTrio = new ArrayList<List<String>>();
        shrekTrio = new ArrayList<List<String>>();
        Collections.addAll(shrekTrio, shrek, donkey, pussInBoots);

        Assertions.assertThat(shrekTrio).hasSize(3);
        Assertions.assertThat(shrekTrio.get(0).get(0)).contains("Shrek");
        Assertions.assertThat(shrekTrio.get(1).get(0)).contains("Donkey");
        Assertions.assertThat(shrekTrio.get(2).get(0)).contains("Puss");

        //Pass the List to a consumer who can process the List and feed to a spreadsheet to get stored
        FileOutputStream fileOutputStream   = new FileOutputStream("mySpreadsheet.xls");

        SpreadsheetStorage spreadsheetHandler = new SpreadsheetStorage();
        spreadsheetHandler.saveDataToSpreadsheet(fileOutputStream, shrekTrio);

        Assertions.assertThat(fileOutputStream).isNotNull();
    }

        @Test
        public void canReadFromSpreadsheetAndVerifyData() throws IOException {
//Imagine expected data was tabled in gherkin cucumber feature file
//        name           | age     | favoriteColor
//        "Shrek"       | "27"   | "green"
//        "Donkey"   | "12"   | "gray"
//        "Puss"          | "6"      | "orange"

//Mimic gherkin tabled data arriving to a stepdef file automatically as a List Of Maps
        Map mapOfShrek = new HashMap<String, String>();
        mapOfShrek.put("name", "Shrek");
        mapOfShrek.put("age", "27");
        mapOfShrek.put("favoriteColor", "green");

        Map mapOfDonkey = new HashMap<String, String>();
        mapOfDonkey.put("name", "Donkey");
        mapOfDonkey.put("age", "12");
        mapOfDonkey.put("favoriteColor", "gray");

        Map mapOfPuss = new HashMap<String, String>();
        mapOfPuss.put("name", "Puss");
        mapOfPuss.put("age", "6");
        mapOfPuss.put("favoriteColor", "orange");

        //This is how step-def receives tabled data from cucumber feature file - as a List of Maps
        List<Map> listOfMapsOfShrekTrio = new ArrayList<Map>();
        Collections.addAll(listOfMapsOfShrekTrio, mapOfShrek, mapOfDonkey, mapOfPuss);

        //Mimic the behind-the-scenes function of @DataTableType annotation use in stepdef file to convert the list of Maps to a List of AnimatedCharacter Object
        List<AnimatedCharacter> expectedCharacters = new ArrayList<AnimatedCharacter>();

        for(Map<String, String> mapForACharacter : listOfMapsOfShrekTrio){
            expectedCharacters.add(new AnimatedCharacter(mapForACharacter.get("name"),  mapForACharacter.get("age"),  mapForACharacter.get("favoriteColor")));
        }

        System.out.println("Expected characters: " + expectedCharacters );

       SpreadsheetStorage spreadsheetHandler = new SpreadsheetStorage();

        //no longer relevant because upon refactor data saves a List of Character Records instead
        //List<List<String>> wrapperList = spreadsheetHandler.readDataFromSpreadsheetIntoList("mySpreadsheet.xls");

        List<AnimatedCharacter> actualCharacters = spreadsheetHandler.readDataFromSpreadsheetIntoListOfCharacters("mySpreadsheet.xls");
        System.out.println("Actual Characters" + actualCharacters);

        Assertions.assertThat(actualCharacters).isEqualTo(expectedCharacters);
        }
    }

