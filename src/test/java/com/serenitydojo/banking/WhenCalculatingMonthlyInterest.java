package com.serenitydojo.banking;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WhenCalculatingMonthlyInterest {
    @Test
    public void forSavingsAccount(){
        double monthlyInterest;

        SavingsAccount  poppyCollegeFund = new SavingsAccount(100.00, 1.2);
        monthlyInterest = poppyCollegeFund.calculateMonthlyInterest();

        Assertions.assertThat(monthlyInterest).isEqualTo(10.00);
    }

    @Test
    public void forInterestYieldingBonds(){
        double monthlyInterest;

        InterestYieldingBond myGovernmentBond = new InterestYieldingBond(1.2);
        monthlyInterest = myGovernmentBond.calculateMonthlyInterest();

        Assertions.assertThat(monthlyInterest).isEqualTo(20.00);
    }

    @Test
    public void forPortfolioAccount(){
        PortfolioAccount myPortfolio = new PortfolioAccount();
        myPortfolio.addAccount(new SavingsAccount(100, 1.2));
        myPortfolio.addAccount(new SavingsAccount(100, 1.2));
        myPortfolio.addAccount(new InterestYieldingBond(1.2));
        double portfolioInterest = myPortfolio.calculateMonthlyInterest();

        //Expected interest: 10  for each SavingsAccount (so 10*2 = 20)  + 20 for 1 IYB => 40
        Assertions.assertThat(portfolioInterest).isEqualTo(40.00);
    }
}
