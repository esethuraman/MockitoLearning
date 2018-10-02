package com.esethuraman.learning.unitTests.unitTestPractise;

import com.esethuraman.learning.unitTests.business.BusinessImpl;
import com.esethuraman.learning.unitTests.business.DataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessTestsWithStub {


    DataService dataServiceStub, dataServiceForOneElementArray, dataServiceForEmptyArray;
    @Before
    public void setUp(){
        dataServiceStub = new DataServiceStub();
        dataServiceForOneElementArray = new DataServiceStubForOneElementArray();
        dataServiceForEmptyArray = new DataServiceStubForEmptyArray();

    }

    @Test
    public void calculateSum_usingStub(){
        BusinessImpl business = new BusinessImpl();
        int actual = business.calculateSum(dataServiceStub.retrieveIntArray());
        int expected = 15;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateSum_noValueUsingStub(){
        BusinessImpl business = new BusinessImpl();
        int actual = business.calculateSum(dataServiceForEmptyArray.retrieveIntArray());
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateSum_oneValueUsingStub(){
        BusinessImpl business = new BusinessImpl();
        int actual = business.calculateSum(dataServiceForOneElementArray.retrieveIntArray());
        int expected = 2;

        Assert.assertEquals(actual, 2);
    }


}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveIntArray() {
        return new int[]{1,2,3,4,5};
    }
}


class DataServiceStubForOneElementArray implements DataService {

    @Override
    public int[] retrieveIntArray() {
        return new int[]{2};
    }
}


class DataServiceStubForEmptyArray implements DataService {

    @Override
    public int[] retrieveIntArray() {
        return new int[]{};
    }
}