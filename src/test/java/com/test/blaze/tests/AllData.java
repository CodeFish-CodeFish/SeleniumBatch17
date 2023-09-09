package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name = "customerInfo")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Turkey","Ankara","23423423","8","2025"},
                {"Mehmet","USA","Chicago","3453454","9","2026"},
                {"Mahmut","Kyrygzstan","Osh","4234434","1","2030"},
                {"Jasmin","Malaysia","johor","3453454","6","2026"},
        };
    }


}
