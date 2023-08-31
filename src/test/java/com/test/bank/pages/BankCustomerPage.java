package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement nameDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;

    @FindBy(xpath = "//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//strong[3]")
    WebElement currency;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(tagName = "input")
    WebElement amountBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successMessage;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalButton;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement creditAmount;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement debitAmount;

    public void loginWithCustomer(String customer){
        BrowserUtils.selectBy(nameDropDown,customer,"text");
        loginButton.click();
    }

    public void accountGeneralInformation(String expectedHeader,String defaultBalance,String expectedCurrency){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(balance),defaultBalance);//0
        Assert.assertEquals(BrowserUtils.getText(currency),expectedCurrency);
    }

    public void depositProcess(String depositAmount,String expectedMessage,String expectedBalance){
        depositButton.click();
        amountBox.sendKeys(depositAmount);
        submitButton.click();
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedMessage);
        Assert.assertEquals(BrowserUtils.getText(balance),expectedBalance);//500
    }

    public void withdrawalProcess(String withdrawalAmount,String expectedMessage) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(2000);
        amountBox.sendKeys(withdrawalAmount);
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedMessage);
    }

    public void transactionProcess() throws InterruptedException {
        int expectedBalance=Integer.parseInt(BrowserUtils.getText(balance));//200
        Thread.sleep(2000);
        transactionButton.click();
        Thread.sleep(2000);
        int actualBalance=Integer.parseInt(BrowserUtils.getText(creditAmount))
                - Integer.parseInt(BrowserUtils.getText(debitAmount));
        Assert.assertEquals(actualBalance,expectedBalance);
    }

}
