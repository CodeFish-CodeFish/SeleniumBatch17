package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeMacBookProPage {

    public BlazeMacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement priceTax;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement productDescription;

    @FindBy(partialLinkText = "Add to")
    WebElement addToCartButton;

    public void validateProductInformation(String expectedHeader,String expectedPriceTax,
                                           String expectedProductDesc){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(priceTax),expectedPriceTax);
        Assert.assertEquals(BrowserUtils.getText(productDescription),expectedProductDesc);
    }

    public void addToCartAndValidate(WebDriver driver,String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedMessage);
        alert.accept();
    }


}
