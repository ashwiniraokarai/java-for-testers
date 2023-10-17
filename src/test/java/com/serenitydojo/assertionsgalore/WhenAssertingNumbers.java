package com.serenitydojo.assertionsgalore;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class WhenAssertingNumbers {

   //junit's Assert is pretty basic
   @Test
    public void assertOnNumbersUsingJunitAssertions(){
       Integer a = 1;
       Integer b = 3;
       Integer sum = a + b;

       Assert.assertEquals((Integer)4, sum);
   }

   @Test
   //AssertJ assertion library is far more intuitive, has a wider range of methods, has meaningful error messages
   // than junit's assertions
   public void assertOnNumbersUsingAssertJ(){
      Integer a = 1;
      Integer b = 2;
      Integer sum = 1 + 2;

      Assertions.assertThat(sum).isEqualTo(3 );
      Assertions.assertThat(sum).isBetween(1,10);
      Assertions.assertThat(sum).isGreaterThan(0);
      Assertions.assertThat(sum).isLessThanOrEqualTo(9);
   }
}
