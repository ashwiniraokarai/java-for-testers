package com.serenitydojo.builderpattern;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class WhenWeCreateANewDog {
    private static final LocalDateTime FOURTH_OF_JULY = LocalDateTime.of(2023, Month.JULY, 4,0, 0);

 /*   @Test
    public void can_create_a_dog(){
        *//*instantiate a dog object with 3 params - name, breed, and dateOfBirth
        * assert that the qualities set on the dog are the same as those returned by the getter
        * *//*
        Dog cloud =  new Dog("cloud", "poodle", FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getName()).isEqualTo("cloud");
        Assertions.assertThat(cloud.getBreed()).isEqualTo("poodle");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }*/

    @Test
    public void can_create_a_dog_with_required_fields(){
        //Design tips:
        //write the structure for builder in calling code. Construct it like simple talking language.
        //write the first method (static method in Dog) to set a field and pass and return the DogBuilder instance
        //write the other builder methods
        //finish with the last method and return a Dog instance

            Dog fido = Dog.named("Fido")   //implicitly required field/ method - needed to trigger DogBreeder object
                .ofBreed("Labrador")    //field/method made explicitly required thro interface type object
                .ofColor("black")   //field/method made explicitly required thro interface type object
                .bornOn(FOURTH_OF_JULY);    //implicitly required field - needed to trigger Dog object

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_set_optional_fields(){
        Dog cloud = Dog.named("cloud")
                .ofBreed("poodle")
                .ofColor("gray")
                .likesToEat("biscuits")        //set optional field
                .enjoysPlayingWith("ball")        //set optional field
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getName()).isEqualTo("cloud");
        Assertions.assertThat(cloud.getBreed()).isEqualTo("poodle");
        Assertions.assertThat(cloud.getColor()).isEqualTo("gray");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isNotNull();
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isNotNull();
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_skip_optional_fields(){
        Dog cloud = Dog.named("cloud")
                .ofBreed("poodle")
                .ofColor("gray")
//                .likesToEat("biscuits")        //skip optional field
//                .enjoysPlayingWith("ball")        //skip optional field
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getName()).isEqualTo("cloud");
        Assertions.assertThat(cloud.getBreed()).isEqualTo("poodle");
        Assertions.assertThat(cloud.getColor()).isEqualTo("gray");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isNull();
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isNull();
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }
}
