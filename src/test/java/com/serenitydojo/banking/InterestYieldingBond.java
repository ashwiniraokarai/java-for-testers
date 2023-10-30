package com.serenitydojo.banking;

public class InterestYieldingBond implements InterestBearing {
    private double interestRate;

    public InterestYieldingBond( double interestRate){
        this.interestRate = interestRate;
    }

    //not in active use in my code logic but available
    public double getInterestRate() {
        return interestRate;
    }

    //not in active use in my code logic but available
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateMonthlyInterest(){
/*        we aren't too worried about how interest is calculated for IYB
        what we are interested in is: 1) that IYBs yield interest just like SavingsAccount would
         2) but (also) unlike SavingsAccount interest calculation does not depend on BankAccount for balance
        which makes for a case for building an Interface: the common functionality of calculating interest but with varying implementation underneath
*/
        return 200.00 * interestRate / 12 ;       //return something
    }
}
