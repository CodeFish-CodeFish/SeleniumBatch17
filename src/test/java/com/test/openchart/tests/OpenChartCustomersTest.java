package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartCustomersPage;
import com.test.openchart.pages.OpenChartLoginPage;
import com.test.openchart.pages.OpenChartMainPage;
import org.testng.annotations.Test;

public class OpenChartCustomersTest extends OpenChartTestBase{

    @Test
    public void ValidateCustomersButtonLimitationFunction() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.login("demo","demo");
        OpenChartMainPage openChartMainPage=new OpenChartMainPage(driver);
        openChartMainPage.clickCloseButton();
        openChartMainPage.clickCustomersButton();
        openChartMainPage.clickSubCustomersButton();
        OpenChartCustomersPage openChartCustomersPage=new OpenChartCustomersPage(driver);
        openChartCustomersPage.validateCustomersButtonLimitationFunctionality("Ahmet","Baldir",
                "ahmet@gmail.com","ahmet123");
        openChartCustomersPage.validateMessageAndColors("Warning: You do not have permission to modify customers!"
        ,"rgba(136, 48, 37, 1)","rgba(249, 220, 216, 1)");
    }


}
