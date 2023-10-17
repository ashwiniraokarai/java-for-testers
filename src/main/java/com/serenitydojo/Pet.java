package com.serenitydojo;

//Inheritors: CatInheritsFromPet.java and DogInheritsFromPet
//Cats and Dogs both have name and age (common attributes in Pets)
//Cat's special attribute is favoriteFood, therefore best defined in CatInheritsFromPet Class
//Dog's special attribute is favoriteToy, therefore best defined in DogInheritsFromPet Class

public abstract class Pet {
    private String name;
    private Integer age;

//    public Pet(){
//
//    }
    public Pet(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    //This method is overridden in classes CatInheritsFromPet and DoInheritsFromPet
    //..because Cats and Dogs make different noises
    public String makeNoise(){
    //Noise Depends on the Type of Pet. Best left to the Type of Pet to handle on their own
    //If a Pet Type does not define this method, then this method here in the Parent will respond as a fallback mechanism
        return "Can't make a generic Pet noise. Type of Pet should have handled this instead.";
    }

    //This is an abstract method which means its up to the child classes to implement it
    //This Pet Class itself needed to be made abstract due to this abstract method!
    public abstract String goForWalks();
    //Abstract methods have no body
    //Choose not to respond because Nature of walk depends on the Type of Pet. Type of Pet should handle this on their own.";
}