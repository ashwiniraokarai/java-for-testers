package com.serenitydojo.banking;

public class CurrentAccount {
    private double overdraft;

    public CurrentAccount(double overdraft){
        this.overdraft = overdraft;
    }

    //not in active use in my code logic but available
    public double getOverdraft(){
        return overdraft;
    }

    public void setOverdraft(double overdraft){
        this.overdraft = overdraft;
    }
}
