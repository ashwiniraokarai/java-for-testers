package com.serenitydojo;

import org.junit.Test;

//Test Class naming convention: A vert just like the Application Class under test. Application Class name under test followed by the word "Test"
public class DataTypesTest {
    /* NOTE: These are not really tests that typically test application code methods - just demo java features written on the Test file because these are easier to run via the IDE's Run button
    vs running application code
     */
    @Test
    //Demonstrate numeric types
    public void declaringNumberVariables() {

        /* *********** INTEGERS ************ */
        //Integers are WHOLE numbers that are not terribly long
        //int: a primitive type
        final int agePrimitiveIntType = 70;

        //Java complains because you can't modify/ reassign a value to variable that's been declared "final"
        //"java: cannot assign a value to final variable agePrimitiveIntType"
        //agePrimitiveIntType = agePrimitiveIntType + 1;

        //Good practice: Use a new variable to indicate your intent vs modifying the existing one
        int agePrimitiveIntTypeNextYear = agePrimitiveIntType + 1;
        System.out.println("Age using Primitive Type 'int': " + agePrimitiveIntTypeNextYear);

        //A more powerful type - a type of Object that wraps the primitive int type
        Integer ageIntegerObjectType = 42;
        Integer ageIntegerObjectTypeNextYear = ageIntegerObjectType + 1;
        System.out.println("Age using Modern Object Type 'Integer': " + ageIntegerObjectTypeNextYear);

        /* *********** LONG ************ */
        //Long: think of LONG as a Loooooong integer that a regular Integer or int type cannot accommodate

        //Starting 10 billion, your number won't fit in integer type no more
        //Java also needs to you denote your Longs with an L toward the end
        Long starsInTheGalaxy = 10000000000L;
        System.out.println(starsInTheGalaxy + " (10 million) stars in the galaxy are too Loooong (big) to count as integers");

        /* *********** FLOATS and DOUBLES ************ */
        //Floats or Doubles: Think of FLOAT as a "floating" integers because they couldn't be WHOLE. So they were broken and hence "floated"
        //Double is easier to use vs float because you don't have to worry about specifying precision

        Double weight = 135.4;
        System.out.println("Weights are best represented as Double types because they don't always measure whole. " +
                "For example, Poppy and I together weigh 135.5 pounds!");
    }

    @Test
    /* *********** STRINGS ************
    Strings are ALWAYS OBJECTS, NEVER primitive types!
    */
    public void workingWithStrings(){
        String name = "Sarah Jane-Thomas";

        String upperCaseName = name.toUpperCase();
        System.out.println("String " + name + " when uppercased reads: " + upperCaseName);

        String replaceFirstName = name.replace("Sarah", "Mary");
        System.out.println("String " + name + " with their firstname replaced becomes their sister's name: " + replaceFirstName);

        System.out.println("Extra spaces surrounding ' Poppy ' when trimmed out reads: " + " Poppy ".trim() );
    }
}
