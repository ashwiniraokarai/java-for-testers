package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WhenWorkingWithRecordClasses {
    @Test
    //Compare two Objects the conventional way first to establish the use case for Records in a later test
    public void comparingTwoCarObjects(){
       Car modelS2018 = new Car("Tesla","S", 2018, "poppy 2.0");
       Car modelS2018Again = new Car("Tesla", "S", 2018, "poppy 2.0");

        //Assertion fails because technically and memory location wise they are two different objects
        //In reality however you may have wanted these two to pass because they contain the same information
        //Assertions.assertThat(modelS2018).isEqualTo(modelS2018Again);
    }

    //With Records instead of a Car Objects you can drive the comparison the way it makes sense to you..
    //...such that these two records are recognized as the same
    //NOTE: "record" construct works with Java 14 or higher. I created and ran this with Java 17.
//    @Test
//    public void comparingTwoVehicleRecords(){
//        Vehicle modelS2018 = new Vehicle("Tesla","S", 2018, "poppy 2.0");
//        Vehicle modelS2018Again = new Vehicle("Tesla", "S", 2018, "poppy 2.0");
//
//        //Passes now. Aha!
//        Assertions.assertThat(modelS2018).isEqualTo(modelS2018Again);
//    }
}
