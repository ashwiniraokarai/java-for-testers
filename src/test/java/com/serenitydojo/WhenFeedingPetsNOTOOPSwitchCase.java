package com.serenitydojo;

import com.serenitydojo.model.FeederWithSwitchCase;
import org.junit.Assert;
import org.junit.Test;

/*
Demo: Operating on methods with simple conditional logic.
Although this example does call the feeder object, nothing about it is OOP.
The method within the feeder class simply feeds a pet based on the string passed to it.
Although the naming scheme and theme might suggest otherwise, this does NOT build on the Pet class and child class concept from previous examples.
Those worked off of inheritance and abstract classes eliminating the need for conditional logic
 */
public class WhenFeedingPetsNOTOOPSwitchCase {
    @Test
    public void shouldFeedCatWithCatFood() {
        FeederWithSwitchCase feeder = new FeederWithSwitchCase();

        String cat_food = feeder.feed("cat", false);
        System.out.println(cat_food);
        Assert.assertEquals("cat was fed tuna.", cat_food);
    }

    @Test
    public void shouldFeedDogWithDogFood() {
        FeederWithSwitchCase feeder = new FeederWithSwitchCase();
        String dog_food = feeder.feed("dog", false);
        System.out.println(dog_food);
        Assert.assertEquals("dog was fed bone.", dog_food);
    }

    @Test
    public void shouldFeedHamsterWithHamsterFood() {
        FeederWithSwitchCase feeder = new FeederWithSwitchCase();
        String hamster_food = feeder.feed("hamster", false);
        System.out.println(hamster_food);
        Assert.assertEquals("hamster was fed cabbage.", hamster_food);
    }

    @Test
    public void shouldNotBeAbleToFeedOthers() {
        FeederWithSwitchCase feeder = new FeederWithSwitchCase();
        String skunk_food = feeder.feed("skunk", false);
        System.out.println(skunk_food);
        Assert.assertEquals("sorry, can't feed skunk.", skunk_food);
    }

    @Test
    public void shouldFeedPremiumCatsPremiumFood(){
        FeederWithSwitchCase feeder = new FeederWithSwitchCase();

        String premium_cat_food = feeder.feed("cat", true);
        System.out.println(premium_cat_food);
        Assert.assertEquals("premium cat was fed premium food - salmon!", premium_cat_food);
    }
}

