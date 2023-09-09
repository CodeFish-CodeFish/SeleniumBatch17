package com.test.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceInventoryPage {

    public SauceInventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> allTitles;

    @FindBy(css = ".inventory_details_name")
    WebElement header;

    @FindBy(css = ".inventory_details_desc")
    WebElement description;

    @FindBy(css = ".inventory_details_price")
    WebElement price;

    public void chooseItem(String item){
        for(WebElement title:allTitles){
            if(BrowserUtils.getText(title).equals(item)){
                title.click();
                break;
            }
        }
    }

    public void productInformation(String expectedHeader,String expectedDesc,String expectedPrice){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDesc));
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
    }
}
