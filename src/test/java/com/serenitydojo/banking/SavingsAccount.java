package com.serenitydojo.banking;

public class SavingsAccount extends BankAccount implements InterestBearing {
    double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
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
        //1. "who" sends the interestRate (caller) is not usually your concern when building methods unless they are Objects passes as method params
        //2. also notice how you didn't have to gather the input data (balance and interest rate) as params on this method?
        //3.data setting is a separated concern in OOP and happens through constructor or setter instead
        return getBalance() * interestRate/ 12;
    }
}
