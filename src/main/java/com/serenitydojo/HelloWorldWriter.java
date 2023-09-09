package com.serenitydojo;

//Class naming convention: noun
public class HelloWorldWriter {
    //Method naming convention: verb
    void writeHelloWorld() {
        //print a line to the system output
        System.out.println("Hello World!");
    }

    void declaringNumberVariables() {
        //int: a primitive type
        int agePrimitiveType= 70;
        agePrimitiveType = agePrimitiveType+1;
        System.out.println(agePrimitiveType);

        //An more powerful type - a type of Object that wraps the primitive int type
        Integer ageObjectTypeWrapperForPrimitiveType = 42;
    }
}
