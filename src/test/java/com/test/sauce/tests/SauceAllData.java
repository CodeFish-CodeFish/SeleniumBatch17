package com.test.sauce.tests;

import org.testng.annotations.DataProvider;

public class SauceAllData {


    @DataProvider(name = "positiveLogin")
    public Object[][] getDataPositive() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
        };
    }

    @DataProvider(name = "negativeLogin")
    public Object[][] getDataNegative() {
        return new Object[][]{
                {"wrongusername", "wrongpassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "wrongpassword", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }

    @DataProvider(name = "productInformation")
    public Object[][] getProductInfo() {
        return new Object[][]{
                {"Sauce Labs Backpack", "Sauce Labs Backpack", "Sly Pack", "$29.99"},
                {"Sauce Labs Bike Light", "Sauce Labs Bike Light", "3 lighting", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "Sauce Labs Bolt T-Shirt", "bolt T-shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "Sauce Labs Fleece Jacket", "fleece jacket", "$49.99"},
                {"Sauce Labs Onesie", "Sauce Labs Onesie", "two-needle", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Test.allTheThings() T-Shirt (Red)", "Super-soft", "$15.99"},
        };
    }
}
