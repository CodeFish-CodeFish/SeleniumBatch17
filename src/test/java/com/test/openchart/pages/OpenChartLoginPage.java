package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#input-username")
    WebElement username;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public void login(String username,String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Thread.sleep(2000);
    }

    public void errorMessage(String expectedMessage,String expectedBackgroundColor) throws InterruptedException {
       Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(errorMessage),expectedMessage);
        Thread.sleep(2000);
        Assert.assertEquals(errorMessage.getCssValue("background-color"),
               expectedBackgroundColor);
    }
}
