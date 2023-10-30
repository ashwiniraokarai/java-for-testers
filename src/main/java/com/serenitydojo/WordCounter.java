package com.serenitydojo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCounter {

    public Integer numberOfWordsInText(String text){
        String[] arrayOfSplitStrings;

        //To bypass null pointer exception: return 0 for null text; do not pass along to split method that will produce a null pointer exception
        if(text == null){
            return 0;
        } else if  (text.length() == 0){
            return 0;
        } else {
            arrayOfSplitStrings = text.split("\\s");
            if(arrayOfSplitStrings.length >= 1){
                System.out.println("First word:" + arrayOfSplitStrings[0] + "Length:" + arrayOfSplitStrings.length );
            }
            return arrayOfSplitStrings.length;
        }
    }

    public Integer numberOfWordsInFileIOExceptionThrown(String filePath) throws IOException {
        String fileContent = Files.readString(Path.of(filePath));
        System.out.println(("File contents: " +fileContent));
        return numberOfWordsInText(fileContent);
    }

    public Integer numberOfWordsInFileIOExceptionHandled(String filePath)  {
        try{
            String fileContent = Files.readString(Path.of(filePath));
            System.out.println(("File contents: " +fileContent));
            return numberOfWordsInText(fileContent);
        } catch(IOException fileDoesNotExist) {
            return 0;
        } finally {
            System.out.println("The finally block is not necessary. I added it to show that it runs no matter the outcome");
        }
    }

    public Integer numberOfWordsInTextThrowsCustomException(String pathToFile) throws  TextHasNoWordException {
        Integer wordCount;
        String text;

        //handle the builtin IOException automatically thrown by Java when file does not exist
        try {
            text = Files.readString(Path.of(pathToFile));
        } catch (IOException fileDoesNotExist) {
            return -1;
        }

        //Read the text on an existent file otherwise. Throw your custom exception if  text in the file is empty
        System.out.println("Received  text: " + text + " for processing with length: " + text.length());
       wordCount = numberOfWordsInText(text);
        if (wordCount == 0) {
            throw new TextHasNoWordException("Custom exception triggered: Received  text but no words in file: " +pathToFile);
        }
        return wordCount;
    }
}
