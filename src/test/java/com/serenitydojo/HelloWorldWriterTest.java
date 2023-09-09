package com.serenitydojo;

import org.junit.Test;

//Test Class naming convention: A vert just like the Application Class under test. Application Class name under test followed by the word "Test"
public class HelloWorldWriterTest {
    //@Test is a junit annotation
    //When you first use the annotation, IntelliJ adds the line at the top of the file to import the junit package and class
    @Test
    //Test Method naming convention: A verb just like the Application Method under test.
    //Similar to Application Method name under test but with some more description of what it's expected to do
    public void shouldWriteHelloWorldToTheConsole(){
        HelloWorldWriter writer = new HelloWorldWriter();
        writer.writeHelloWorld();
    }
}
