package com.serenitydojo;

import org.junit.Test;

import java.util.EnumMap;

public class WhenWorkingWithEnums {
@Test
//.valueOf method is helpful to caller who can conveniently pass strings to fetch the enum constants
    public void getEnumConstantBasedOnString(){
        LevelEnum HIGH = LevelEnum.valueOf("HIGH");
        System.out.println("valueOf fetches the Enum constant for the string representation you provide");
        System.out.println("Enum constant for the String \"High\" is: " +HIGH );
    }


@Test
//create an Enum class called Label
//extract a value
// compare it to a value passed as if it were passed as an argument to the test method
    public void compareEnumValueWithSomethingElseUsingIFELSE(){
    //Imagine this value came from elsewhere via an argument to this test method
        LevelEnum high = LevelEnum.HIGH;

    //Compare the provided value with the actual value extracted from the Enum
        if(high == LevelEnum.HIGH) {
            System.out.println("Provided value matched the enum constant");
        } else {
            System.out.println("Provided value DID NOT match the enum constant");
        }
        System.out.println("Value: " + high + " was compared with  enum constant: " +  LevelEnum.HIGH);
    }

    @Test
    public void compareEnumValuesWithSomethingElseUsingSWITCHCASE() {
        //Imagine this value came from elsewhere via an argument to this test method
        LevelEnum high = LevelEnum.HIGH;

        //The value of this text should be set by the code base on the outcome/ match coming from the switch-case comparison below
        String levelAsText;

        //Compare the provided value with the actual value extracted from the Enum
        //Note how within the case statements, unlike in if-else you write the "unqualified" enum constant:
        //You write High instead of Level.High
        switch (high) {
            case HIGH:
                System.out.println("Provided value matched the enum constant called HIGH");
                levelAsText = "HIGH";
                break;
            case MEDIUM:
                System.out.println("Provided value matched the enum constant called MEDIUM");
                levelAsText = "MEDIUM";
                break;
            case LOW:
                System.out.println("Provided value matched the enum constant called LOW");
                levelAsText = "LOW";
                break;
            default:
                System.out.println("Provided value does NOT match any of the enum constants");
                levelAsText = "Don't know, don't care";
        }
        System.out.println("Value of String levelAsText has now been set accordingly to: " + levelAsText);
    }

    @Test
    //Compare this test to the previous one with switch-case. It's same logic but achieved with an EnumMap
    // EnupMap is preferred over the switch-case approach due to its cleanliness and readability
    //Through its nature of Key-Value pair, EnumMap enables you to store a String as a Value (equivalent) for each Key (Enum Constants)
    //This comes handy when you need to set another String to an equivalent value of the Enum
    public void canNavigateEnumUsingEnumMap(){
        String levelAsText;

        //An EnumMap stores Key-Value pairs just as normal Maps
        //The Key is the Enum LevelEnum which already contains Enum Constants
        //The Value is a String representation of each Enum Constant
        EnumMap<LevelEnum, String>  enumMapForLevelEnum = new EnumMap<LevelEnum, String>(LevelEnum.class);

        enumMapForLevelEnum.put(LevelEnum.HIGH, "High!");
        enumMapForLevelEnum.put(LevelEnum.MEDIUM, "Medium!");
        enumMapForLevelEnum.put(LevelEnum.LOW, "Low!");
        System.out.println(enumMapForLevelEnum);

        LevelEnum levelToSetTheStringTo = LevelEnum.HIGH;
        levelAsText = enumMapForLevelEnum.get(levelToSetTheStringTo);

        System.out.println("String levelAsText's value is now set to an Enum constant's String representation: " + levelAsText + " via EnumMap");
    }

    //For use in the following test canNavigateEnumUsingSTATICEnumMap()
    //Enum values are preset remain constant so will any String representation set through EnumMaps
    //Plus Enums are very likely to be accesses throughout the codebase irl
    //So, it makes sense to make the EnumMap Static
    //A static variable can only be used inside a static enclosure. You can use what's called a static block to operate on static variables and objects.
    //Static variables are global and have to be declared directly inside the Class, not in methods
    static EnumMap<LevelEnum, String> staticEnumMapForLevelEnum = new EnumMap<LevelEnum, String>(LevelEnum.class);
    static {
        staticEnumMapForLevelEnum.put(LevelEnum.HIGH, "High!");
        staticEnumMapForLevelEnum.put(LevelEnum.MEDIUM, "Medium!");
        staticEnumMapForLevelEnum.put(LevelEnum.LOW, "Low!");
    }

    @Test
    public void canNavigateEnumUsingSTATICEnumMap(){
        System.out.println(staticEnumMapForLevelEnum);
        String levelAsText = staticEnumMapForLevelEnum.get(LevelEnum.HIGH);
        System.out.println("String levelAsText's value is set to an Enum constant's String representation: " + levelAsText + " via Static EnumMap");
    }

    @Test
    public void enumCanBeLikeFullBlownClass(){
        Integer levelCodeForMedium = LevelEnumLikeAClass.MEDIUM.getLevelCode();
        System.out.println("Code for Level Medium defined in Enum: " + levelCodeForMedium);

        Boolean isLevelHighEnough = LevelEnumLikeAClass.MEDIUM.isLevelHighEnoughTo(4);
        System.out.println("Is level of " + LevelEnumLikeAClass.MEDIUM + " high enough? " +  isLevelHighEnough);
    }

    @Test
    //LevelEnumLikeAClass implements an Interface called CompareHeightWith that has a single method isLevelHighEnoughTo()
    public void enumMethodsCanBeCalledOnInterfaceType(){
        Integer expectedLevel = 4;

        //call the method isLevelHighEnoughTo() on an Enum Constant as usual
       Boolean comparedLevelHighToFour = LevelEnumLikeAClass.HIGH.isLevelHighEnoughTo(expectedLevel);
       System.out.println("Is LevelEnumLikeAClass.HIGH as high as expected value of 4?");
       System.out.println("When comparison method is called on the Enum Constant as usual, the result is: " + comparedLevelHighToFour);

       // This is to demonstrate that just like we can with Objects, even with Enum Constants, their methods such as isLevelHighEnoughTo() can be called on the Interface Type..
       //..vs calling them on the Enum Constant directly
        CompareHeightWith enumConstantSetToInterfaceType  = LevelEnumLikeAClass.HIGH;
        Boolean comparedLevelHighToFourOnInterfaceType  = enumConstantSetToInterfaceType.isLevelHighEnoughTo(expectedLevel);

        System.out.println("Comparison method can also be called on the Interface Type implemented by the Enum. The result is: " + comparedLevelHighToFourOnInterfaceType);
    }

@Test
//The point of this test is to show a common pattern, a handy trick to achieve polymorphism (shared code w/o maintenance nightmare)
public void canPassArgumentOfAnyImplementingTypeToInterfaceTypeParameter(){
  /*  Receiving Method intermediaryMethodThatCallsMethodIsLevelHighEnoughTo() welcomes ANY implementing Type of CompareHeightWith Interface)
    Which means we can pass either an Enum Constant or an Object because
    Both the Enum and another Class implement the expected Interface Type*/

    //Pass EnumConstant from Interface-implementing-Enum
    System.out.println("Pass EnumConstant from Interface-implementing-Enum");
    intermediaryMethodThatCallsMethodIsLevelHighEnoughTo(LevelEnumLikeAClass.HIGH, 4);

    //Pass Object from Interface-implementing-Class instead
    System.out.println("Pass Object from Interface-implementing-Class instead");
    Ladder tallLadder = new Ladder(4);
    intermediaryMethodThatCallsMethodIsLevelHighEnoughTo(tallLadder, 4);
}

//Helper method for Test method above: intermediaryMethodCanAcceptInterfaceType
   public void intermediaryMethodThatCallsMethodIsLevelHighEnoughTo(CompareHeightWith actualHeight, Integer expectedLevel){
        Boolean comparedActualLevelToExpectedLevel = actualHeight.isLevelHighEnoughTo(expectedLevel);
       System.out.println("Received Actual Value: " + actualHeight );
       System.out.println("Received Expected Value: " + expectedLevel);
       System.out.println("Does actual value match expected value? The answer is: " + comparedActualLevelToExpectedLevel);
    }
}
