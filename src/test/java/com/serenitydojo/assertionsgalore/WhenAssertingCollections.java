package com.serenitydojo.assertionsgalore;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhenAssertingCollections {
    @Test
    //type of List and size of List
    public void assertOnListTypeAndSize() {
        List<String> listOfColors = new ArrayList<String>();
        Collections.addAll(listOfColors, "purple","plum", "peach");

        Assertions.assertThat(listOfColors).isExactlyInstanceOf(ArrayList.class);
        Assertions.assertThat(listOfColors).hasSize(3);
    }

    private void compareListWithSimpleStrings(List<String> listOfColors) {
        //contains..or not. Use- case: comparing List with another  Iterable
        Assertions.assertThat(listOfColors).containsExactlyElementsOf(Arrays.asList("purple", "plum", "peach"));
        Assertions.assertThat(listOfColors).containsExactlyInAnyOrderElementsOf(Arrays.asList("peach", "plum", "purple"));
        Assertions.assertThat(listOfColors).containsAnyElementsOf(Arrays.asList("purple"));
        Assertions.assertThat(listOfColors).doesNotContainAnyElementsOf(Arrays.asList("yellow", "sage"));
    }

    @Test
    //contains..or not. Use-case: Compare List with simple String values
    private void compareListWithAnother(List<String> listOfColors) {
        Assertions.assertThat(listOfColors).contains("plum");
        Assertions.assertThat(listOfColors).containsExactly("purple", "plum", "peach");
        Assertions.assertThat(listOfColors).containsExactlyInAnyOrder("peach", "purple", "plum");
        Assertions.assertThat(listOfColors).doesNotContain("lavender", "violet", "burgundy");
    }
}
