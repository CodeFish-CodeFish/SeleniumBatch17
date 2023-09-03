package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OpenChartCustomersPage {

    public OpenChartCustomersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewButton;

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public void validateCustomersButtonLimitationFunctionality(String firstName,String lastName,String email,String password){
        addNewButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        confirmPassword.sendKeys(password);
        saveButton.click();
    }

    public void validateMessageAndColors(String expectedErrorMessage,String expectedColor,String expectedBackgroundColor){
        Assert.assertEquals(BrowserUtils.getText(errorMessage),expectedErrorMessage);
        Assert.assertEquals(errorMessage.getCssValue("color"),expectedColor);
        Assert.assertEquals(errorMessage.getCssValue("background-color"),expectedBackgroundColor);
    }
}
