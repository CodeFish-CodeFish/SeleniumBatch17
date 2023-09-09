package com.test.etsy.tests;

import com.test.etsy.pages.EtsyMainPage;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase{

    @Test
    public void validateSearchFunctionality(){
        EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
        etsyMainPage.searchItem("iphone 13 case");
        etsyMainPage.checkingKeyWords("iphone","13","case");
    }
}
