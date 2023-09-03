package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[contains(@onclick,'purchaseOrder')]")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement successMessage;

    @FindBy(css = ".confirm")
    WebElement okButton;

    public void provideCustomerInformation(String name,String country,String city,String card,
                                           String month,String year) throws InterruptedException {
        Thread.sleep(1000);
        this.name.sendKeys(name);
        Thread.sleep(1000);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.card.sendKeys(card);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        Thread.sleep(1000);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(1000);
    }

    public void message(String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedMessage);
        Thread.sleep(1000);
        okButton.click();
    }

}
