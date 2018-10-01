package com.esethuraman.learning.unitTests.unitTestPractise;

import com.esethuraman.learning.unitTests.business.BusinessImpl;
import org.junit.*;

public class BusinessTest {

    @Test
    public void calculateSum_basic(){
        BusinessImpl business = new BusinessImpl();
        int actual = business.calculateSum(new int[]{1,2,3,4,5});
        int expected = 15;

        Assert.assertEquals(actual, expected);
    }
}
