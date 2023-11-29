package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WhenParameterizingTests {

    /*The first few tests process simple "linear" parameters - the entire set of source values are stored in one row
    with a single value received as per iteration as a single argument to the test method*/

    //JUnit 5 test runner executes this test as usual — and consequently, the isOdd method — six times because of the parameter annotation.
    // And each time, it assigns a different value from the @ValueSource array to the number method parameter.
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void shouldDetectOddNumbers(int number){
        boolean isOdd = number % 2 == 1;
        System.out.println("Input from @ValueSource integer array for this iteration is: " + number);
        Assertions.assertThat(isOdd).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void shouldDetectEvenNumbers(int number){
        boolean isEven = number % 2 == 0;
        System.out.println("Input from @ValueSource integer array for this iteration is: " + number);
        Assertions.assertThat(isEven).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Plum", "Purple", "Peach" })
    public void colorIsNotEmpty(String color){
        System.out.println("Input from @ValueSource string array for this iteration is: " + color);
        Assertions.assertThat(color).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Plum", "Purple", "Peach"})
    public void shouldGrabEnumConstantForInputString(String colorAsAString){
        ColorsEnum enumConstant = ColorsEnum.valueOf(colorAsAString);
        Assertions.assertThat(enumConstant).toString().equals(colorAsAString);
    }

    public enum ColorsEnum {
        Plum, Purple, Peach;
    }

    @ParameterizedTest
    @EnumSource(ColorsEnum.class)
    public void shouldConvertEnumToString(ColorsEnum enumConstant){
        String colorEnumAsString = enumConstant.toString();
        Assertions.assertThat(ColorsEnum.valueOf(colorEnumAsString)).isEqualTo(enumConstant);
    }

    /*The next set of tests "step it up" a little and process one "SET of values" for EACH iteration
    * which also means there need to be multiple arguments in the Test method to receive it*/
    @ParameterizedTest(name = "Iteration {index}: Color is {0}, R is {1}, G is {2}, B {3}")
    @CsvSource(
            {
                    //note how each  value within a row is separated by commas but together they are surrounded by quotes (not to be confused with string)
                    //and entire rows are too separated from each other by  commas
                    "Plum,255, 0, 0",
                    "Purple,0, 255, 0",
                    "Peach,0, 0, 255",
            }
    )
    public void canReadMultipleParametersFromSource(String color, int r, int g, int b){
        System.out.println(color  +  r  + g + b);
    }

    //This test compares the csv drawn arguments to enum constants
    //The csv is set up to mimic the data in the enum for comparison
    //The test draws 2 args from csv just like the previous example...
    //BUT when receiving the args, we receive the first arg (color) as a type of the enum called ColorEnumWithArgs (instead of as a String)
    @ParameterizedTest
    @CsvSource({
            "PLUM, 1",
            "PURPLE, 2",
            "PEACH, 3"
    })
    public void compareCSVSourceToEnumValues(ColorEnumWithArgs colorFromCSV, int colorCodeFromCSV){
        int colorCodeFromEnum = colorFromCSV.getColorCode();
        Assertions.assertThat(colorCodeFromEnum).isEqualTo(colorCodeFromCSV);
    }

    public enum ColorEnumWithArgs{
        PLUM(1),
        PURPLE(2),
        PEACH(3);

        private int colorCode;
        private ColorEnumWithArgs(int colorCode){
            this.colorCode = colorCode;
        }

        public int getColorCode(){
            return colorCode;
        }
    }
}
