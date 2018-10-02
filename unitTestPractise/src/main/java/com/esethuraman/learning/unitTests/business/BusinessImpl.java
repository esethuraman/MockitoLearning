package com.esethuraman.learning.unitTests.business;

public class BusinessImpl {

    private DataService dataService;

    public void setDataService(DataService dataService){
        this.dataService = dataService;
    }

    public int calculateSum(int[] data){
        int sum = 0;
        for(int a : data){
            sum += a;
        }
        return sum;
    }

    public int calculateSumFromDataService(){
        int[] data = dataService.retrieveIntArray();
        int sum = 0;
        for(int a : data){
            sum += a;
        }
        return sum;
    }
}
