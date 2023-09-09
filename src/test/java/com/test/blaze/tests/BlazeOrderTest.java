package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.addToCartAndValidate(driver,"Product added");
        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validateProductInformation("MacBook Pro","1100");
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.provideCustomerInformation("Ahmet","Turkey","Ankara",
                "1232345235","12","2026");
        blazeOrderPage.message("Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");
    }

//    @DataProvider(name = "customerInfo")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Ahmet","Turkey","Ankara","23423423","8","2025"},
//                {"Mehmet","USA","Chicago","3453454","9","2026"},
//                {"Mahmut","Kyrygzstan","Osh","4234434","1","2030"},
//                {"Jasmin","Malaysia","johor","3453454","6","2026"},
//        };
//    }

    @Test(dataProvider = "customerInfo",dataProviderClass = AllData.class)
    public void validateOrderFunctionalityWithDataProvider(String firstname,String country,String city,
                                                           String card,String month,String year) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.addToCartAndValidate(driver,"Product added");
        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.validateProductInformation("MacBook Pro","1100");
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.provideCustomerInformation(firstname,country,city, card,month,year);
        blazeOrderPage.message("Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");
    }











}
