package com.serenitydojo;

public class CatInheritsFromPet extends Pet {

    //name and age are both now defined in parent Class Pet, so we don't need them defined again here:
    //public String name;

    //public Integer age;

    public String favoriteFood;

    //This is a default constructor that you don't need to define explicitly UNLESS
    //You have another constructor that's parameterized which is true in my case here below
    public CatInheritsFromPet() {

    }
    public CatInheritsFromPet(String name, Integer age, String favoriteFood) {
        //don't need to set name and age here anymore now that I have parent Pet Class constructor that can handle the assignment for me:
        //this.name = name;
        //this.age = age;

        //call the parent Pet Class's constructor
        super(name, age);
        this.favoriteFood = favoriteFood;
    }


/* Don't need the getters and setters for name and age defined here because they belong in Pet Class (parent)
//    public String getName() {
//        return this.name;
//    }

//    public Integer getAge() {
//        return this.age;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setAge(int age) {
//        this.age = age;
//    }
*/

    public String getFavoriteFood() {
        return this.favoriteFood;
    }
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    //automatically oevrrides makeNoise() method defined in Parent Pet Class
    //..because of the same method name and parameter pattern
    public String makeNoise(){
        return "meow";
    }

    //Implements the abstract method declared in Parent Pet Class
    public String goForWalks(){
        return "enjoying a stroll alone";
    }
}
