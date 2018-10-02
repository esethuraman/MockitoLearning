package com.esethuraman.learning.unitTests.unitTestPractise;

import com.esethuraman.learning.unitTests.business.BusinessImpl;
import com.esethuraman.learning.unitTests.business.DataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// when shorthand Mock annotations are used, this annotation must be used
@RunWith(MockitoJUnitRunner.class)
public class BusinessTestsWithMock {

    // when shorthand @Mock is used, this annotation should be used for enabling
    // the mocked object to be injected
    @InjectMocks
    BusinessImpl business;

    // @Mock is the shorthand for mockedDataService = Mockito.mock(DataService.class);
    @Mock
    DataService mockedDataService;

    @Before
    public void setUp(){
        business = new BusinessImpl();
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
