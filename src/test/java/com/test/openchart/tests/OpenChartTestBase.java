package com.test.openchart.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class OpenChartTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("opencharturl"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"OpenChart");
        }
          driver.quit();
    }
}
