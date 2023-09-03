package com.test.blaze.tests;

import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.BlazeMacBookProPage;
import com.test.blaze.pages.BlazeMainPage;
import org.testng.annotations.Test;

public class BlazeMacBookProTest extends BlazeTestBase{

    @Test
    public void validateProductInformation() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseBrand("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.validateProductInformation("MacBook Pro","$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        blazeMacBookProPage.addToCartAndValidate(driver,"Product added");
    }

}
