package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;


public class WhenWorkingWithExceptions {


    @Test
    public void shouldCountTheWordsInAString(){
        Integer numberOfWords;

        WordCounter wordCounter = new WordCounter();
        numberOfWords = wordCounter.numberOfWordsInText("dang string");

        Assertions.assertThat(numberOfWords).isEqualTo(2);
    }

    @Test
    //Called method handles null values through a simple if condition preventing the exception from triggering
    public void shouldHandleNullValue(){
        Integer numberOfWords;

        WordCounter wordCounter = new WordCounter();
        numberOfWords = wordCounter.numberOfWordsInText(null);

        Assertions.assertThat(numberOfWords).isEqualTo(0);
    }

    @Test
    //test throws the exception forwarded by called method. An expected IO exception (a compile-time exception)
    public void shouldThrowCheckedException() throws IOException {
        String goodFilePath = "src/main/java/resources/forWordCounter.txt";
       // String badFilePath = "src/main/java/resources/notFile.txt";
        Integer wordCount;

        WordCounter wordCounter = new WordCounter();

        //Pass badFilePath in the param below to see IOException coming from numberOfWordsInFileContent when passed a file that does not exist:
        wordCount = wordCounter.numberOfWordsInFileIOExceptionThrown(goodFilePath);

        Assertions.assertThat(wordCount).isEqualTo(2);
    }

    @Test
    public void shouldHandleCheckedException(){
      //  String goodFilePath = "src/main/java/resources/forWordCounter.txt";
        String badFilePath = "src/main/java/resources/notFile.txt";
        Integer wordCount;

        WordCounter wordCounter = new WordCounter();
        wordCount = wordCounter.numberOfWordsInFileIOExceptionHandled(badFilePath);

        //wordCount can contain zero only if the called method in WordCounter returns 0. And that can happens only happen IF it handles the IOException.
        Assertions.assertThat(wordCount).isEqualTo(0);
    }

    @Test
    //Goal: Should throw meaningful exception (sourced from custom exception class) when file has no words
    //Uncomment the following line to pass the test (the expectation to expect the exception hides away the exception)
    //@Test(expected = TextHasNoWordException)
    public  void shouldThrowCustomException() throws Exception{
         String pathToEmptyFile = "src/main/java/resources/emptyFileForWordCounter.txt";

         WordCounter wordCounter = new WordCounter();

        //Pass a file that has no words on purpose in order to get the custom exception to throw
        wordCounter.numberOfWordsInTextThrowsCustomException(pathToEmptyFile);
    }
}
