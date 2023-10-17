package com.serenitydojo;

import org.junit.Assert;
import org.junit.Test;

//Just like WhenCreatingObjectsTest.java, this is not actually a Test.
//This is the Application code created under Tests for convenience of execution.
//This class primarily interacts with the various Pet classes (derived classes from the Pet class: CatInheritsFromPet.java
//and DogInheritsFromPet.java)
public class WhenCreatingPetObjectsTest {
    @Test
    public void creating_a_cat_from_derived_class(){
        System.out.println("creating_a_cat_from_derived_class");
        CatInheritsFromPet kitty = new CatInheritsFromPet("kitty", 1, "hilsa");
        //name and age should come from getters defined in Pet Class (parent)
        System.out.println(kitty.getName() + ", aged " + kitty.getAge());
        Assert.assertEquals(kitty.getName(), kitty.getName(), "kitty");
        Assert.assertEquals("Aged " + kitty.getAge(), kitty.getAge(), Integer.valueOf("1"));

        //favoriteFood should come from explicit getter defined in Cat Class itself
        System.out.println("Loves feeding on " + kitty.getFavoriteFood());
        Assert.assertEquals("Loves feeding on " + kitty.getFavoriteFood(), kitty.getFavoriteFood(),"hilsa");
    }

    @Test
    public void creating_a_dog_from_derived_class(){
        System.out.println("creating_a_dog_from_derived_class");
        DogInheritsFromPet doggy = new DogInheritsFromPet("doggy", 1, "fetch toy");
        //name and age should come from getters defined in Pet Class (parent)
        System.out.println(doggy.getName() + ", aged " + doggy.getAge());
        Assert.assertEquals(doggy.getName(), doggy.getName(), "doggy");
        Assert.assertEquals("Aged " + doggy.getAge(), doggy.getAge(), Integer.valueOf("1"));

        //favoriteFood should come from explicit getter defined in Dog Class itself
        System.out.println("Loves playing with " + doggy.getFavoriteToy());
        Assert.assertEquals("Loves feeding on " + doggy.getFavoriteToy(), doggy.getFavoriteToy(),"fetch toy");
    }

    @Test
    public void creating_hamster_from_derived_class(){
        System.out.println("creating_hamster_from_derived_class");
        HamsterInheritsFromPet hamsy = new HamsterInheritsFromPet("hamsy", 1, "wheel");
        //name and age should come from getters defined in Pet Class (parent)
        System.out.println(hamsy.getName() + ", aged " + hamsy.getAge());
        Assert.assertEquals(hamsy.getName(), hamsy.getName(), "hamsy");
        Assert.assertEquals("Aged " + hamsy.getAge(), hamsy.getAge(), Integer.valueOf("1"));

        //favoriteFood should come from explicit getter defined in Dog Class itself
        System.out.println("Loves playing the " + hamsy.getFavoriteGame());
        Assert.assertEquals("Loves playing the " + hamsy.getFavoriteGame(), hamsy.getFavoriteGame(),"wheel");
    }


    //Demo: When methods are overriden in child classes vs when are they aren't
    @Test
    public void pets_make_noise(){
        Pet kitty = new CatInheritsFromPet("kitty", 5, "tuna");
        Pet doggy = new DogInheritsFromPet("doggy", 3, "ball");
        Pet hamsy = new HamsterInheritsFromPet("hampy", 2, "wheel");

        //comes from the overriden method in CatInheritsFromPet class
        System.out.println("Kitty says: " + kitty.makeNoise());

        //comes the overriden method in DogInheritsFromPet class
        System.out.println("Doggy says: " + doggy.makeNoise());

        //method not defined (and therefore not overridden) in HamsterInheritsFromPet , therefore comes from the Parent Pet Class
        System.out.println("Pet says for Hampy: " + hamsy.makeNoise());
    }


    //Demo: Abstract method in parent Pet class. Concrete methods in Child classes.
    @Test
    public void pets_go_for_walks(){
        Pet kitty = new CatInheritsFromPet("kitty", 5, "tuna");
        Pet doggy = new DogInheritsFromPet("doggy", 3, "ball");
        Pet hamsy = new HamsterInheritsFromPet("hampy", 2, "wheel");

        System.out.println("Kitty: " + kitty.goForWalks());
        System.out.println("Doggy: " + doggy.goForWalks());
        System.out.println("Hamsy: " + hamsy.goForWalks());
    }
}
