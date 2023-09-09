package com.test.sauce.tests;

import com.test.sauce.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends SauceTestBase{

    @Test(dataProvider = "positiveLogin",dataProviderClass = SauceAllData.class)
    public void validatePositiveLogin(String username,String password,String expectedUrl){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass = SauceAllData.class)
    public void validateNegativeLogin(String username,String password,String expectedMessage){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(sauceLoginPage.errorMessage(),expectedMessage);
    }

}
