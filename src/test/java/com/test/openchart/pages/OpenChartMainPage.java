package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartMainPage {

    public OpenChartMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn-close")
    WebElement closeButton;

    @FindBy(linkText = "Customers")
    WebElement customersButton;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement subCustomersButton;

    public void clickCloseButton(){
        closeButton.click();
    }

    public void clickCustomersButton(){
        customersButton.click();
    }

    public void clickSubCustomersButton(){
        subCustomersButton.click();
    }
}
