package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr//td")
    List<WebElement> productTable;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void validateProductInformation(String expectedBrand,String expectedPrice){
        List<String> expectedValues= Arrays.asList("",expectedBrand,expectedPrice,"");
                //expectedValues="","","",""
        //actualValues="picture","brand","price","delete"
        for(int i=1;i<productTable.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(productTable.get(i)),expectedValues.get(i));
        }
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
