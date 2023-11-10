package com.serenitydojo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpreadsheetStorage {
    public void saveDataToSpreadsheet(FileOutputStream fileOutputStream, List<List<String>> listOfLists) throws IOException {
        //See word doc for evolution of how I designed this code

        Workbook newExcelWorkbook = new HSSFWorkbook();
        Sheet excelSheet = newExcelWorkbook.createSheet();

        //Originally wrote the two loops and iterated the excel to populate the same value on the 3 cells of first 3 rows
        //The loop variables were named accordingly when the loop dealt with the excel alone (rowNumber, cellNumber, cellData. etc)
        //Then figured out the same loops can be used to navigate the 3 inner Lists and their elements
        //Loop variables were renamed to more accurately represent the ListOfLists' components (rowNumber became innerList,
        //cellNumber became elementOfCurrentInnerList)

        //Both loops help navigate the ListOfLists AND the Excel in parallel, so the indexes help point to both entities at the same time
        //Using the indexes, the entities from both these worlds are pulled (from ListOfLists world and Excel world)
        // loop variable on the outer for-loop holds the indexes of the Inner Lists AND holds indexes Rows of Excel (because each Inner List occupies one row of excel)
        // loop variable on the inner for-loop holds the indexes of the elements of each Inner Lists AND holds indexes of Cells/ Columns of Excel (because each element of every Inner List occupies  one cell of excel)

        //Fetch one excel row and one inner List at a time
        for (Integer indexOuterListAndRow = 0; indexOuterListAndRow < listOfLists.size(); indexOuterListAndRow++) {
            Row row = excelSheet.createRow(indexOuterListAndRow);
            List<String> currentInnerList = listOfLists.get(indexOuterListAndRow);

            //With one  inner List and its mapping potential Excel Row already nailed in the outer loop, 
            // now fetch one element from an inner List at a time and set it to the cell in excel
            for (Integer indexInnerListAndCol = 0; indexInnerListAndCol < currentInnerList.size(); indexInnerListAndCol++) {
                Cell cell = row.createCell(indexInnerListAndCol);
                String currentElementOfCurrentInnerList = currentInnerList.get(indexInnerListAndCol);
                cell.setCellValue(currentElementOfCurrentInnerList);
            }
        }
        newExcelWorkbook.write(fileOutputStream);
    }

    public List<AnimatedCharacter> readDataFromSpreadsheetIntoListOfCharacters(String fileName) throws IOException {
        List<AnimatedCharacter> listOfAnimatedCharactersFromSheet = new ArrayList<AnimatedCharacter>();

        POIFSFileSystem fileSystem = new POIFSFileSystem(new File(fileName));
        HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
        Sheet sheet = workBook.getSheetAt(0);
        Integer numberOfRows = sheet.getLastRowNum() + 1;
        System.out.println(numberOfRows);
        for(Integer rowNumber = 0; rowNumber < numberOfRows; rowNumber++){
            Row currentRow = sheet.getRow(rowNumber);
            String name = currentRow.getCell(0).getStringCellValue();
            String age = currentRow.getCell(1).getStringCellValue();
            String favoriteColor = currentRow.getCell(2).getStringCellValue();

            AnimatedCharacter animatedCharacter = new AnimatedCharacter(name, age, favoriteColor);
            listOfAnimatedCharactersFromSheet.add(animatedCharacter);
        }

        fileSystem.close();
        return listOfAnimatedCharactersFromSheet;
    }

/*************************************************************************************************/
    /*The following and rest of the methods are no longer relevant because upon refactor data saves a List of AnimatedCharacter Records instead*/
    //no longer relevant because upon refactor data saves a List of AnimatedCharacter Records instead

/*member variables no longer relevant because upon refactor data saves a List of AnimatedCharacter Records instead */
    List<String> listA = new ArrayList<String>();
    List<String> listB = new ArrayList<String>();
    List<String> listC = new ArrayList<String>();
    List<List<String>>wrapperList = new ArrayList<List<String>>();

public  List<List<String>> readDataFromSpreadsheetIntoList(String fileName) throws IOException {
        //Saving a List of my own defined Object type is probably to better organize the data. Maybe I can deal with that later

        //Focus on reading data from sheet
        POIFSFileSystem fileSystem = new POIFSFileSystem(new File(fileName));
        HSSFWorkbook excelWorkbook = new HSSFWorkbook(fileSystem.getRoot(), true);
        String checkSheetName = excelWorkbook.getWorkbook().getSheetName(0);
        System.out.println(checkSheetName);

        //DataFormatter formatter = new DataFormatter();
        Sheet defaultSheet = excelWorkbook.getSheetAt(0);
        Integer counter = 1;
        for (Row row : defaultSheet) {
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());

                //no longer relevant because upon refactor data saves a List of AnimatedCharacter Records instead
                saveSpreadsheetDataAsListOfLists(cell.getStringCellValue(), counter);
                counter = counter + 1;
            }
            fileSystem.close();
        }
         wrapAllListsOfStringsInAList();
         return wrapperList;
    }

    //no longer relevant because upon refactor data saves a List of AnimatedCharacter Records instead
    public void saveSpreadsheetDataAsListOfLists(String listElement, Integer counter) {
        if (counter > 3 && counter <= 6) {
            listB.add(listElement);
        } else if (counter > 6 && counter <= 9) {
            listC.add(listElement);
        } else {
            listA.add(listElement);
        }
    }

    //no longer relevant because after refactor to save data into a List of Customer Records instead
    private void  wrapAllListsOfStringsInAList(){
        Collections.addAll(wrapperList, listA, listB, listC);
    }
}

