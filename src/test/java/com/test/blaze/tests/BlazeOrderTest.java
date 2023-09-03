package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
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











}
