package com.esethuraman.learning.unitTests.unitTestPractise;

import com.esethuraman.learning.unitTests.business.BusinessImpl;
import com.esethuraman.learning.unitTests.business.DataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BusinessTestsWithMock {

    BusinessImpl business;
    DataService mockedDataService;
    @Before
    public void setUp(){
        business = new BusinessImpl();
        mockedDataService = Mockito.mock(DataService.class);
        business.setDataService(mockedDataService);
    }

    @Test
    public void calculateSum_usingMockito(){

        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{1,2,3,4,5});
        Assert.assertEquals(business.calculateSumFromDataService(), 15);
    }

    @Test
    public void calculateSum_oneElementArrayUsingMockito(){
        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{2});
        Assert.assertEquals(business.calculateSumFromDataService(), 2);
    }

    @Test
    public void calculateSum_emptyArrayUsingMockito(){
        Mockito.when(mockedDataService.retrieveIntArray()).thenReturn(new int[]{});
        Assert.assertEquals(business.calculateSumFromDataService(), 0);
    }
}
