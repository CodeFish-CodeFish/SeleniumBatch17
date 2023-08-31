package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement customer;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBar;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    public void customerInformation(WebDriver driver,String firstName,String lastName,String zipCode,
                                    String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        submitAddCustomer.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();
    }

    public void openAccountInformation(WebDriver driver,String customerName,String currency,
                                       String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        BrowserUtils.selectBy(customer,customerName,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        Thread.sleep(2000);
        alert.accept();
    }

    public void customerData(String firstName,String lastName,String zipCode){
        customersButton.click();
        searchBar.sendKeys(firstName);
        List<String> expectedData= Arrays.asList(firstName,lastName,zipCode);
        for(int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedData.get(i));
        }
    }
}
