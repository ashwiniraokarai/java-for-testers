package com.serenitydojo;

import org.junit.Test;

public class WhenCreatingObjectsTest {
    //Not actually a Test. This is the Application code created under Tests for convenience of execution.
    //This class primarily interacts with the Cat class
    @Test
    public void creating_a_cat() {
        //Possible attribute values for a Cat expressed in procedural programming style
        String name = "Felix";
        String favoriteFood = "Tuna";
        Integer age = 4;

        //vs Create a Cat Object with attribute values by invoking a Cat class where attributes are pre-listed (lives under the src/main dir) closer to OOP style
        Cat felix = new Cat();
        felix.name = "Felix";
        felix.favoriteFood = "Tuna";
        felix.age = 4;

        //Create another Cat Object with a different set of values for the attributes
        Cat spot = new Cat();
        spot.name = "Spot";
        //You can skip any attribute. I am gonna skip the favorite food because Spot the Cat can't pick one :)
        spot.age = 2;

        // Setting attribute values directly as in the previous examples is frowned upon so we call dedicated methods referred to as "setters"
        // ..defined on the Cat Class instead to achieve this
        // Create a new Cat called "Marka" but by setting values via "setters" defined on the Cat Class
        Cat marla = new Cat();
        marla.setName("Marla");
        marla.setFavoriteFood("Eggs");
        marla.setAge(3);

        //In a similar fashion, we'll call special methods referred to as "getters" defined on the Cat class to read back the values of Marla the Cat
        //we just finished setting!
        marla.getName();
        marla.getAge();
        marla.getFavoriteFood();

        System.out.println("Cat " + marla.getName() + " is ");
        System.out.println(marla.getAge() + " year(s) old.");
        System.out.println("Their favorite food is " + marla.getFavoriteFood() +".");

        //There's an even more concise approach to setting attribute value as you create your Cat Object
        //..via special method called Constructor defined on the Class

        Cat geck = new Cat("Geck", 1);
        System.out.println("Geck was created via a Constructor:");
        System.out.println(geck.getName());
        System.out.println(geck.getAge());
        //getFavoriteFood() below reports null because we haven't set a value. Good to be aware of what to expect!
        System.out.println(geck.getFavoriteFood());
    }

    //Demo: Calling methods beyond Constructors, getters and setters defined in Cat Class
    //Methods: Define behavior
    @Test
    public void stuff_cats_do(){
        Cat felix = new Cat("Felix", 4);
        System.out.println(felix.makeNoise());
        felix.feed("tuna");
        felix.groom();
    }

    //Demo: Calling Static variable of Cat Class
    //Values of a Static variable remains the same for ALL objects of the Class.
    //Felix, Spot, Marla all have the same values stored in Static variable  - they are not unique to each Object no more
    //Cat noise "meow" is a great candidate to be stored in a Static variable because the sound is unique to All cats unlike their food choices that can differ
    @Test
    public void all_cats_make_the_same_noise(){
        Cat felix = new Cat("Felix", 4);
        Cat spot = new Cat("Spot", 3);
        Cat marla = new Cat("Marla", 2);

        felix.makeCommonNoise();
        spot.makeCommonNoise();
        marla.makeCommonNoise();

        //Change the value of the Static variable of the Cat Class right here (it's public), and then see them apply to ALL objects equally
        Cat.COMMON_CAT_NOISE = "big meow!";
        felix.makeCommonNoise();
        spot.makeCommonNoise();
        marla.makeCommonNoise();
    }


    //Demo: Calling Static variable of a Cat Class which is also a final
    // A static variable which is also a final (preassigned value cannot be overridden anywhere else within or outside Cat Class)
    @Test
    public void all_cats_make_the_same_small_noise(){
        Cat felix = new Cat("Felix", 4);
        Cat spot = new Cat("Spot", 3);
        Cat marla = new Cat("Marla", 2);

        felix.makeCommonSmallNoise();
        spot.makeCommonSmallNoise();
        marla.makeCommonSmallNoise();

        //Trying to change the value of the final variable of the Cat Class right here (it's public) results in an error even before you compile your code
        //"Cannot assign a value to final variable 'COMMON_CAT_NOISE_SMALL"
        //Cat.COMMON_CAT_NOISE_SMALL = "big meow!";
    }

    //Demo: Calling a Static method of Cat Class directly
    //Note: The called Static method does not set any values. It simply returns the food as a String
    @Test
    public void food_that_all_cats_like(){
        System.out.println(Cat.usualFavoriteFood());
    }

    @Test
    //Demo: Calling a regular method of Cat Class that functions as a Setter for common favorite food for all Cats
    //This is different from the standard Setter "setFavoriteFood" which expects the Object to pass along the favorite food and sets it accordingly
    //That setter method in turn calls a Static method of the Cat Class
    public void set_usual_favorite_food_for_felix_the_cat(){
        Cat felix = new Cat("Felix", 5);
        felix.setUsualFavoriteFood();
        System.out.println(felix.getFavoriteFood());
    }
}
