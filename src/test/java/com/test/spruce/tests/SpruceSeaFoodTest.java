package com.test.spruce.tests;

import com.test.spruce.pages.SpruceFIshPage;
import com.test.spruce.pages.SpruceMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceSeaFoodTest extends SpruceTestBase{

    @Parameters({"searchItem","productName"})
    @Test
    public void validateRecipeFromSeaFood(String searchItem,String productName) throws InterruptedException {
        SpruceMainPage spruceMainPage=new SpruceMainPage(driver);
        spruceMainPage.chooseSeaFood(driver);
        SpruceFIshPage spruceFIshPage=new SpruceFIshPage(driver);
        spruceFIshPage.searchRecipe(driver,searchItem);
        spruceFIshPage.chooseSpecialRates();
        Assert.assertEquals(spruceFIshPage.productInformation(),productName);
    }
}
