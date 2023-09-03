package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase{

    @Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login("demo","sgsdfgf");
        openChartLoginPage.errorMessage("No match for Username and/or Password.",
                "rgba(249, 220, 216, 1)");
    }

    @Test
    public void happyPath() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
    }
    /*
    STEPS:
1-Login successfully which is "demo" username and "demo" password
2-Handle the HTML pop-up
3-Click Customers from left side of screen
4-Click sub Customers under Customers Button
5-Click Add New button top right
6_fill the necessary information
7-Click Save Button and Validate the message "Warning: You do not have permission to modify customers!"
8-Validate the color and background color of the error message
NOTE:We found the error message with Id=Alert and it got something weird for CSSvalue. Can you try to find the element with class=alert-danger. I believe you will be able to get correct rgb color. Let me know
     */


}
