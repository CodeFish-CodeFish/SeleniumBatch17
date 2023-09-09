package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{
    @Parameters({"name","lastName","zipCode","expectedMessage"})
    @Test
    public void validateAddCustomerFunctionality(String name,String lastName,String zipcode,String expectedMessage){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.customerInformation(driver,name,lastName,zipcode,expectedMessage);
    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.customerInformation(driver,"Ahmet","Baldir","34534",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountInformation(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
    }

    @Test
    public void validateCustomersInformation() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.customerInformation(driver,"Ahmet","Baldir","34534",
                "Customer added successfully with customer id");
        bankManagerPage.openAccountInformation(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customerData("Ahmet","Baldir","34534");
    }
}
