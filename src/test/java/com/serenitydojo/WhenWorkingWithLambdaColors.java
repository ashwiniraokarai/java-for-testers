package com.serenitydojo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhenWorkingWithLambdaColors {

    @Test
    //Without Lambda - using modern foreach loop
    public void printingOutColors(){
        List<String> colors = Arrays.asList("peach", "purple", "plum" );
        System.out.println("Calling a print method from modern foreach loop");

        for(String color : colors) {
             printColorOf(color);
        }
    }

    @Test
    //With Iterable.forEach() method that allows Lambda
    //Lambda calls the custom method
    public void printingOfColorsWithLambdaMethodCall(){
        List<String> colors = Arrays.asList("peach", "purple", "plum");
        System.out.println("Calling a print method from forEach method with lambda inside");

        colors.forEach(
                //Lambda expression below. 'color' is an arbitrary variable. It can be anything.
                // Doesn't require explicit mention of the datatype - it appears to be inferred
                color -> printColorOf(color)
        );
    }

    @Test
    //With Iterable.forEach() method that allows Lambda
    //Lambda does not call a custom method but has the print code inside an "inline function"
    public void printingOfColorsWithLambdaConstruct(){
        List<String> colors = Arrays.asList("peach", "purple", "plum");
        System.out.println("Inline code within lambda expression in a  forEach method");

        colors.forEach(
                color -> {
                    System.out.println("Color: " + color);
                }
        );
    }

    //Not a test on its own. Used by other tests - think of it as a helper method
    public void printColorOf(String color){
        System.out.println("Color: " + color);
    }

    @Test
    public void printingOfFilteredColorsWithLambdaConstruct(){
        List<String> colors = Arrays.asList("peach", "plum", "sage", "purple");
        System.out.println("Original List of Colors: " + colors);

        /*
        turn collection (List)  into a Stream
        filter list using lambda expression
        turn Stream back to Collection (List), then print filtered colors
         */
        List<String> filteredPColors = colors.stream()
                .filter(color -> color.startsWith("p"))
                .collect(Collectors.toList());

        System.out.println("New List of Filtered Colors starting with P: " + filteredPColors);
    }

    @Test
    public void printingOfFilteredMappedSortedColorsWithLambdaConstruct(){
        List<String> colors = Arrays.asList("plum", "purple", "peach", "sage");
        System.out.println("Original List of Colors: " + colors);

        /*
        convert List to Stream
        filter
        map
        sort
        convert back to List
        print
         */
        List<String> sortedFilteredPColorsInUppercase = colors.stream()
                .filter(color -> color.startsWith("p"))
                .map(color -> color.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("New Sorted List of Filtered P Colors Upper Cased: " + sortedFilteredPColorsInUppercase);
    }

}
