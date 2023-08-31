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
                "rgba(0, 0, 0, 0)");
    }

    @Test
    public void happyPath() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
    }
}
