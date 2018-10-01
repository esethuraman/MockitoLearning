package com.esethuraman.learning.unitTests.business;

public class BusinessImpl {

    public int calculateSum(int[] data){
        int sum = 0;
        for(int a : data){
            sum += a;
        }
        return sum;
    }
}
