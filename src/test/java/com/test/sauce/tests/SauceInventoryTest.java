package com.test.sauce.tests;

import com.test.sauce.pages.SauceInventoryPage;
import com.test.sauce.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceInventoryTest extends SauceTestBase{

    @Test(dataProvider = "productInformation",dataProviderClass = SauceAllData.class)
    public void validateProductInformation(String item,String expectedHeader,String expectedDesc,String expectedPrice){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(ConfigReader.readProperty("sauceUsername"),
                             ConfigReader.readProperty("saucePassword"));
        SauceInventoryPage sauceInventoryPage=new SauceInventoryPage(driver);
        sauceInventoryPage.chooseItem(item);
        sauceInventoryPage.productInformation(expectedHeader,expectedDesc,expectedPrice);
    }
}
