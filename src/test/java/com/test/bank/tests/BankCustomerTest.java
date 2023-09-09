package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{

    @Parameters({"name","lastName","zipCode","expectedMessage","customerName","currency",
    "expectedAccountMessage","expectedHeaderLogin","defaultBalance","depositAmount","expectedDepositMessage",
    "expectedBalance","withdrawalAmount","expectedTransactionMessage"})
    @Test
    public void validateTransactionProcess(String firstName,String lastName,String zipCode,
                                           String expectedMessage,String customerName,String currency,
                                           String expectedAccountMessage,String expectedHeader,
                                           String defaultBalance,String depositAmount,String expectedDepositMessage,
                                           String expectedBalance,String withdrawalAmount,String expectedTransactionMessage) throws InterruptedException {
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.customerInformation(driver,firstName,lastName,zipCode,expectedMessage);
        bankManagerPage.openAccountInformation(driver,customerName,currency, expectedAccountMessage);
        bankManagerPage.customerData(firstName,lastName,zipCode);
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerButton();
        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer(customerName);
        bankCustomerPage.accountGeneralInformation(expectedHeader, defaultBalance, currency);
        bankCustomerPage.depositProcess(depositAmount,expectedDepositMessage,expectedBalance);
        bankCustomerPage.withdrawalProcess(withdrawalAmount,expectedTransactionMessage);
        bankCustomerPage.transactionProcess();
    }

    /*
    1-Navigate to the https://www.thespruceeats.com/
    2-Under Ingredients tab -->Choose Fish&SeaFood option
    3-ScrollDown to the search bar (Use JS method)
    4-Send data "Fish for dinner" but this data should come from xml file with parameter
    5-On the left side choose 4 star up option
    6-From popular : Choose the Editor's choice option
    7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
    8-Driver.quit
     */














}
