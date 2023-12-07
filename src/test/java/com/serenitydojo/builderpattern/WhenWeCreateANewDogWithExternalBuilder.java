package com.serenitydojo.builderpattern;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class WhenWeCreateANewDogWithExternalBuilder {
    private static final LocalDateTime FOURTH_OF_JULY = LocalDateTime.of(2023, Month.JULY, 4,0, 0);

    //All fields are back to being optional now. We don't care about mandates for this code to keep things simple.
    //Instead we focus on making the builder external with an entry point of its own for the caller (test)
    @Test
    public void can_create_a_dog_from_external_builder(){
        DogOnly cloud = ExternalDogBuilder.aDog()
                .named("cloud")
                .ofBreed("spaniel")
                .ofColor("gray")
                .likesToEat("biscuits")
                .enjoysPlayingWith("ball")
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getName()).isEqualTo("cloud");
        Assertions.assertThat(cloud.getBreed()).isEqualTo("spaniel");
        Assertions.assertThat(cloud.getColor()).isEqualTo("gray");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("biscuits");
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_create_a_generic_dog_from_external_builder_prototype_method() {
        DogOnly cloud = ExternalDogBuilder.aStandardDog()
                .named("goldie locks")
             //   .ofBreed("golden retriever")  //skip calling this because is now built in to the prototype method: aStandardDog()
                .ofColor("golden")
                .likesToEat("biscuits")
                .enjoysPlayingWith("ball")
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getBreed()).isEqualTo("Golden retriever");
        Assertions.assertThat(cloud.getName()).isEqualTo("goldie locks");
        Assertions.assertThat(cloud.getColor()).isEqualTo("golden");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("biscuits");
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_create_a_small_dog_from_external_builder_prototype_method() {
        DogOnly cloud = ExternalDogBuilder.aSmallDog()
                .named("charlie")
                //   .ofBreed("golden retriever")  //skip calling this because is now built in to the prototype method: aSmallDog()
                .ofColor("white")
                .likesToEat("biscuits")
                .enjoysPlayingWith("ball")
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getBreed()).isEqualTo("poodle");
        Assertions.assertThat(cloud.getName()).isEqualTo("charlie");
        Assertions.assertThat(cloud.getColor()).isEqualTo("white");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("biscuits");
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_create_a_large_dog_from_external_builder_prototype_method() {
        DogOnly cloud = ExternalDogBuilder.aLargeDog()
                .named("bollo")
                //   .ofBreed("golden retriever")  //skip calling this because is now built in to the prototype method: aLargeDog()
                .ofColor("white")
                .likesToEat("biscuits")
                .enjoysPlayingWith("ball")
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getBreed()).isEqualTo("husky");
        Assertions.assertThat(cloud.getName()).isEqualTo("bollo");
        Assertions.assertThat(cloud.getColor()).isEqualTo("white");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("biscuits");
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }

    @Test
    public void can_create_a_guard_dog_from_external_builder_prototype_method() {
        DogOnly cloud = ExternalDogBuilder.aGuardDog()
                .named("Atlas")
                //   .ofBreed("golden retriever")  //skip calling this because is now built in to the prototype method: aGuardDog()
                .ofColor("black")
                .likesToEat("biscuits")
                .enjoysPlayingWith("ball")
                .bornOn(FOURTH_OF_JULY);

        Assertions.assertThat(cloud.getBreed()).isEqualTo("german shepherd");
        Assertions.assertThat(cloud.getName()).isEqualTo("Atlas");
        Assertions.assertThat(cloud.getColor()).isEqualTo("black");
        Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("biscuits");
        Assertions.assertThat(cloud.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(cloud.getDateOfBirth()).isEqualTo(FOURTH_OF_JULY);
    }
}
