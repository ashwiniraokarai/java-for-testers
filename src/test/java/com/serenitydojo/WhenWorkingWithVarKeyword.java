package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class WhenWorkingWithVarKeyword {
        //Java says: cannot resolve symbol var for the commented var assignment below
        //This is because var is only accepted and recognized as local variable - within methods or smaller blocks inside the Class
       // var name = "Babu";
        @Test
        public void useVarForString(){
//            String name = "Babu shona";
//            String herAgain = name;
            var name = "Babu shona";
            var herAgain = name;

            System.out.println(name + " is a type of: " + name.getClass());
            Assertions.assertThat(name).isEqualTo(name);
        }

        @Test
        public void useVarForListAndLoopVariable(){
//            List<String> listOfStrings = new ArrayList<String>();
            var listOfStrings = new ArrayList<String>();
            var name = "Babu shona";
            var herAgain = name;

            Collections.addAll(listOfStrings, name, herAgain);
            Assertions.assertThat(listOfStrings).containsExactly(name, herAgain);

            for(var eachName : listOfStrings){
                System.out.println(eachName);
            }
        }

}
