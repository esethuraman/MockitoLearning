package com.esethuraman.learning.unitTests.unitTestPractise;

import com.esethuraman.learning.unitTests.business.BusinessImpl;
import com.esethuraman.learning.unitTests.business.DataService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BusinessTestsWithMock {

    @Test
    public void calculateSum_usingMockito(){
        BusinessImpl business = new BusinessImpl();
        DataService mockedDataService = Mockito.mock(DataService.class);
        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{1,2,3,4,5});

        int actual = business.calculateSum(mockedDataService.retrieveIntArray());
        int expected = 15;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateSum_oneElementArrayusingMockito(){
        BusinessImpl business = new BusinessImpl();
        DataService mockedDataService = Mockito.mock(DataService.class);
        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{2});

        int actual = business.calculateSum(mockedDataService.retrieveIntArray());
        int expected = 2;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateSum_emptyArrayusingMockito(){
        BusinessImpl business = new BusinessImpl();
        DataService mockedDataService = Mockito.mock(DataService.class);
        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{});

        int actual = business.calculateSum(mockedDataService.retrieveIntArray());
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }
}
