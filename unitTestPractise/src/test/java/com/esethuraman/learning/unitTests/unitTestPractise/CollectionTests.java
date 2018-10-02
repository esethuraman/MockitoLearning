package com.esethuraman.learning.unitTests.unitTestPractise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CollectionTests {

    @Mock
    List<String> mockedList;

    @Spy
    List<String> spiedList;

    @Test
    public void testList(){
        when(mockedList.get(2)).thenReturn("two");
        Assert.assertEquals("two", mockedList.get(2));
        Assert.assertEquals(null, mockedList.get(0));
        Assert.assertEquals(null, mockedList.get(4));

        verify(mockedList).get(2);
        verify(mockedList, times(3)).get(anyInt());
    }

    @Test
    public void testListOnSpy(){
        when(spiedList.get(2)).thenReturn("two");

        Assert.assertEquals("two", spiedList.get(2));

        spiedList.add(2, "two");
        Assert.assertEquals("two", spiedList.get(2));

        Assert.assertEquals(null, spiedList.get(0));
        Assert.assertEquals(null, spiedList.get(4));
    }
}
