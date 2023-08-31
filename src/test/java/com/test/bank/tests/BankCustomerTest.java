package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{

    @Test
    public void validateTransactionProcess() throws InterruptedException {
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.customerInformation(driver,"Ahmet","Baldir","34534",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountInformation(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customerData("Ahmet","Baldir","34534");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerButton();
        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer("Ahmet Baldir");
        bankCustomerPage.accountGeneralInformation("Welcome Ahmet Baldir !!", "0", "Dollar");
        bankCustomerPage.depositProcess("500","Deposit Successful","500");
        bankCustomerPage.withdrawalProcess("300","Transaction successful");
        bankCustomerPage.transactionProcess();
    }
}
