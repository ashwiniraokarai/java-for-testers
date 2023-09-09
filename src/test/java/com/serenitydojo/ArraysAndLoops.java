package com.serenitydojo;

import org.junit.Test;

//Arrays are no longer commonly used in modern Java! Other classes in the Collections Framework are more popular now.
public class ArraysAndLoops {

    //Interesting fact about Arrays in Java:
    //Java arrays are fixed in size, can't add more or remove elements! You'll need an ArrayList in order to do that.
    //Arrays are rarely and barely ever used in modern Java. Collections are preferred (such as Lists, Sets, and Maps)
    @Test
    public void arrayOfColors(){
        //When you know the array's exact content (each element value) at the time of declaration
        String[] colors = {"red", "green", "yellow"};

        //When you know the overall concept of the array elements but DON'T YET know the exact content at the time of declaration
        String[] colorsToBeFilled = new String[3];
        colorsToBeFilled[0] = "blue";
        colorsToBeFilled[1] = "orange";
        colorsToBeFilled[2] = "violet";

        System.out.println(colors[2]);
        System.out.println(colorsToBeFilled[2]);
    }

    @Test
    public void loopThroArray(){
        String[] colorsToBeFilled = new String[3];
        colorsToBeFilled[0] = "blue";
        colorsToBeFilled[1] = "orange";
        colorsToBeFilled[2] = "violet";

        //Employ a rudimentary for-loop to print the array contents instead of souting them individually 3x times
        for(int i=0; i<3; i++){
            System.out.println(colorsToBeFilled[i]);
        }
    }
}
