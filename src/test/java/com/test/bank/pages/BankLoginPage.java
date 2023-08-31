package com.test.bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "strong")
    WebElement header;

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerButton;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    public String getHeader(){
        return BrowserUtils.getText(header);
    }
    public void clickManagerButton(){
        managerButton.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }

    public void clickCustomerButton(){
        customerLogin.click();
    }
}
