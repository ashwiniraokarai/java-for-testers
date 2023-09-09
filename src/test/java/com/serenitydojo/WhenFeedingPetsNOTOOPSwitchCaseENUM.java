package com.serenitydojo;

import com.serenitydojo.model.FeederWithSwitchCaseENUM;
import com.serenitydojo.model.FeederWithSwitchCaseENUM;
import com.serenitydojo.model.PetType;
import org.junit.Assert;
import org.junit.Test;

/*
Demo: Operating on methods with simple conditional logic.
Although this example does call the feeder object, nothing about it is OOP.
The method within the feeder class simply feeds a pet based on the string passed to it.
Although the naming scheme and theme might suggest otherwise, this does NOT build on the Pet class and child class concept from previous examples.
Those worked off of inheritance and abstract classes eliminating the need for conditional logic
 */
public class WhenFeedingPetsNOTOOPSwitchCaseENUM {
    @Test
    public void shouldFeedCatWithCatFood() {
        FeederWithSwitchCaseENUM feeder = new FeederWithSwitchCaseENUM();

        String cat_food = feeder.feed(PetType.CAT, false);
        System.out.println(cat_food);
        Assert.assertEquals("cat was fed tuna.", cat_food);
    }

    @Test
    public void shouldFeedDogWithDogFood() {
        FeederWithSwitchCaseENUM feeder = new FeederWithSwitchCaseENUM();
        String dog_food = feeder.feed(PetType.DOG, false);
        System.out.println(dog_food);
        Assert.assertEquals("dog was fed bone.", dog_food);
    }

    @Test
    public void shouldFeedHamsterWithHamsterFood() {
        FeederWithSwitchCaseENUM feeder = new FeederWithSwitchCaseENUM();
        String hamster_food = feeder.feed(PetType.HAMSTER, false);
        System.out.println(hamster_food);
        Assert.assertEquals("hamster was fed cabbage.", hamster_food);
    }

    @Test
    public void shouldNotBeAbleToFeedOthers() {
        FeederWithSwitchCaseENUM feeder = new FeederWithSwitchCaseENUM();
        String skunk_food = feeder.feed(PetType.SKUNK,false);
        System.out.println(skunk_food);
        Assert.assertEquals("sorry, can't feed skunk.", skunk_food);
    }

    @Test
    public void shouldFeedPremiumCatsPremiumFood(){
        FeederWithSwitchCaseENUM feeder = new FeederWithSwitchCaseENUM();

        String premium_cat_food = feeder.feed(PetType.CAT, true);
        System.out.println(premium_cat_food);
        Assert.assertEquals("premium cat was fed premium food - salmon!", premium_cat_food);
    }
}

