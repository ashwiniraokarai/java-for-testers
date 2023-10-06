package com.serenitydojo;

public class Cat {
    //Ideally these variables should be PRIVATE so Class "WhenCreatingObjectsTest.java" can't manipulate these values directly
    //Instead, any calling Class will need to go via the getter methods
    public String name;
    public String favoriteFood;
    public Integer age;

    //This variable belongs to the Class, so ALL objects get the same value unless the calling code change it first
    public static String COMMON_CAT_NOISE = "meow";

    //Another static variable that belongs to the Class, so ALL objects get the same value as usual
    //Additionally because of the "final" keyword, neither the calling code nor any method within THIS class can override the value
    public static final String COMMON_CAT_NOISE_SMALL = "small meow";

    //This is a default constructor that you don't need to define explicitly UNLESS
    //You have another constructor that's parameterized - which is true in my case here below
    public Cat() {

    }
    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getFavoriteFood() {
        return this.favoriteFood;
    }

    public Integer getAge() {
        return this.age;
    }

    //defining methods beyond Constructors, getters and setters defined in Cat Class
    public String makeNoise(){
        return "meow";
    }

    public void feed(String food){
        System.out.println(this.name + " says " + food + " was yummm!");
    }

    public void groom(){
        //Call private methods that do specific type of cleaning to accomplish "grooming"
        lickPaws();
        cleanFur();
    }

    private void lickPaws(){
        System.out.println("My paws are all nice and fresh now!");
    }

    private void cleanFur(){
        System.out.println("My coat is shiny clean now!");
    }

    //This method references a static variable (a Class variable) whose value is preassigned in the Class
    public void makeCommonNoise(){
        System.out.println("Every cat says " + COMMON_CAT_NOISE);
    }

    //This method references a static variable (a Class variable) which is also a final variable whose value is preassigned in the Class
    public void makeCommonSmallNoise(){
        //Trying to change the value of the final variable even within the same Class results in an error even before you compile your code
        //"Cannot assign a value to final variable 'COMMON_CAT_NOISE_SMALL"
        //COMMON_CAT_NOISE_SMALL = "big meow!";
        System.out.println("Every cat says " + COMMON_CAT_NOISE_SMALL + " and that's final!");

        //Trying to change the value of the final variable even within the same Class results in an error even before you compile your code
        //"Cannot assign a value to final variable 'COMMON_CAT_NOISE_SMALL"
        //COMMON_CAT_NOISE_SMALL = "big meow!";
    }

    //A static method that returns food that all Cats usually like. NOTE: This method does NOT SET any variable values, simply returns a String.
    public static String usualFavoriteFood(){
        //not allowed because "this" cannot be referenced from Static content:
        //this.favoriteFood = "catnip";

        //also not possible because Non-static field 'favoriteFood' cannot be referenced from a static context:
        //Cat.favoriteFood = "catnip";

        return "catnip";

        //now you can create a non-static method that can call this Static method to do some "setting"
    }

    //A non-static (regular) method that calls the Static method and does the job of a Setter
    //Although it looks similar to standard Setter "setFavoriteFood", it is slightly different
    // ..Here, the Object doesn't have to bother passing along the favorite food to be set
    //Instead, the code takes care of choosing the favorite food to set for the Object (for the Cat :) )
    public void setUsualFavoriteFood(){
        //You don't need to prefix "Cat." when calling Static methods, but it's good practice and makes for better readability imo
        this.favoriteFood = Cat.usualFavoriteFood();
    }
}
