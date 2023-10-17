package com.serenitydojo.assertionsgalore;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WhenAssertingStrings {
    @Test
    public void equalityOfStrings(){
        String lowerCaseRed = "red";
        String upperCaseRed = "RED";
        String lowerCaseRedWithSpaces =  "red ";
        String mixedCaseRed =  "Red ";

        Assertions.assertThat(lowerCaseRed).isEqualTo("red");
        Assertions.assertThat(lowerCaseRed).isEqualToIgnoringCase(upperCaseRed);
        Assertions.assertThat(lowerCaseRed).isEqualToIgnoringWhitespace(lowerCaseRedWithSpaces);
    }

    @Test
    public void comparePartsOfStrings(){
        String colorsInASingleString = "purple, plum, peach";

        Assertions.assertThat(colorsInASingleString).contains("plum");
        Assertions.assertThat(colorsInASingleString).startsWith("purple");
        Assertions.assertThat(colorsInASingleString).endsWithIgnoringCase("peach");
        Assertions.assertThat(colorsInASingleString).containsPattern("[p|P]urple");
    }
}

