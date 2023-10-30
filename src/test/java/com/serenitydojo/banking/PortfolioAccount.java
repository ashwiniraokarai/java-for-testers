package com.serenitydojo.banking;

import java.util.ArrayList;
import java.util.List;

public class PortfolioAccount implements InterestBearing {
    private List<InterestBearing> listOfInterestBearingInstruments = new ArrayList<InterestBearing>();

    //store Objects that have ability to calculate interest
    public void addAccount(InterestBearing interestBearingInstrument ){
        listOfInterestBearingInstruments.add(interestBearingInstrument);
    }

    public double calculateMonthlyInterest(){
        //consolidated sum of  interests from all eligible accounts
       double sumOfInterests = 0.00;
       for (InterestBearing interestBearingInstrument : listOfInterestBearingInstruments) {
           sumOfInterests = sumOfInterests + interestBearingInstrument.calculateMonthlyInterest();
        }
        return sumOfInterests;
    }
}
