package com.serenitydojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class WhenWorkingWithDates {

    @Test
  //Today date without a time-zone in the ISO-8601 calendar system, in the default format such as 2023-11-01
    public void howToGetTodayDateWithoutTimezone(){
       LocalDate todayDate = LocalDate.now();
        System.out.println("Today's date without a time-zone in the ISO-8601 calendar system: " + todayDate);
    }

@Test
    public void howToCreateAnotherDayDate(){
        LocalDate fourthOfJuly = LocalDate.of(2023, 06, 04);
    System.out.println("Fourth of July: " + fourthOfJuly);
}

@Test
//using parse() you can convert a Date in another form to Date
//here Date that's provided as a String Object is converted to a Date Object
    public void convertingStringToDateUsingParse(){
        String firstOfNovember2023AsAString = "2023-11-01"; //November 01 2023
        LocalDate firstOfNovemberAsADateObject = LocalDate.parse(firstOfNovember2023AsAString);
        System.out.println("Received date as a String Object  \" " + firstOfNovember2023AsAString + " \" was converted to Date Object " +  firstOfNovemberAsADateObject);
}

@Test
//using parse() you can convert a Date in another form to Date
//here Date is again provided as a String Object is converted to a Date Object
//Except the String Object is formatted differently than what Date Object would expect (YYYY-MM-DD). So a formatter parameter is used to describe the og format the String came with
    public void convertingStringToFormattedDateUsingParse(){
    String firstOfNovember2023AsAString = "11/01/2023"; //November 01 2023
    LocalDate firstOfNovemberAsAFormattedDateObject = LocalDate.parse(firstOfNovember2023AsAString, DateTimeFormatter.ofPattern("MM/dd/uuuu"));

    System.out.println(firstOfNovemberAsAFormattedDateObject);
}

 @Test
// Doing arithmetic on current date to arrive at Dates like yesterday and tomorrow
    public void howToGetYesterdayDate(){
        LocalDate today = LocalDate.now();
        LocalDate yesterdayDate =  today.minus(1, ChronoUnit.DAYS );
        //Alternative: today.minusDays(1);

        System.out.println("Today is " + today + ", therefore yesterday must have been " + yesterdayDate);
    }

    @Test
//Extracting day month and year components from a Date Object
    public void howToExtractDetailsFromDate(){
        LocalDate today = LocalDate.now();
        System.out.println(today. getMonth());
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getYear());
    }

    @Test
    public void howToAssertOnDates(){
        LocalDate tenthOfApril2023 = LocalDate.of(2023,04,10);
        LocalDate eleventhOfApril2023 = LocalDate.of(2023,04,11);
        LocalDate ninthOfApril2023 = LocalDate.of(2023,04,9);

        System.out.println("You can conveniently compare a Date with its String counterpart for Assertions");
        Assertions.assertThat(tenthOfApril2023).isEqualTo( "2023-04-10");
        Assertions.assertThat(tenthOfApril2023).isAfter(ninthOfApril2023);
        Assertions.assertThat(tenthOfApril2023).isBefore(eleventhOfApril2023);
        Assertions.assertThat(tenthOfApril2023).isBetween(ninthOfApril2023,eleventhOfApril2023 );
    }

    @Test
    public void howToWorkWithTime(){
        LocalTime timeNow = LocalTime.now();
        LocalTime fiveHoursAgo = timeNow.minus(5, ChronoUnit.HOURS);

        System.out.println("If the time now is " +  timeNow + " then five hours ago must have been " +  fiveHoursAgo);
    }
}
