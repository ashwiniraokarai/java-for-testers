package com.serenitydojo;

public class Car {
    private String make;
    private String model;
    private Integer year;
    private String licensePlate;

    public Car(String make, String model, Integer year, String licensePlate){
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public String getMake(){
        return make;
    }

}
