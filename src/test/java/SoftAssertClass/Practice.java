package SoftAssertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement alertBoxClick = driver.findElement(By.cssSelector("#alertBox"));
        alertBoxClick.click();
        Alert alert = driver.switchTo().alert();
        String actualBoxText = alert.getText().trim();
        String expectedBoxText = "I am an alert box!sdasds";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualBoxText,expectedBoxText);
     //   Assert.assertEquals(actualBoxText, expectedBoxText);
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#output"));
        String actualBoxResult = BrowserUtils.getText(result);
        String expectedBoxResult = "You selected alert popup";
        softAssert.assertEquals(actualBoxResult,expectedBoxResult);
     //   Assert.assertEquals(actualBoxResult, expectedBoxResult);
        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        String actualJConfirmText = alert.getText().trim();
        String expectedConfirmText = "Press a button!sdsds";
        softAssert.assertEquals(actualJConfirmText,expectedConfirmText);
      //  Assert.assertEquals(actualJConfirmText, expectedConfirmText);
        alert.dismiss();
        String actualConfirmResult = BrowserUtils.getText(result);
        String expectedConfirmResult = "You pressed Cancel in confirmation popup";
        softAssert.assertEquals(actualConfirmResult,expectedConfirmResult);
      //  Assert.assertEquals(actualConfirmResult, expectedConfirmResult);
        WebElement jsPrompt = driver.findElement(By.id("promptBox"));
        jsPrompt.click();
        String actualJsPromptText = alert.getText().trim();
        String expectedJSPromptText = "Please enter your name:";
        softAssert.assertEquals(actualJsPromptText,expectedJSPromptText);
     //   Assert.assertEquals(actualJsPromptText, expectedJSPromptText);
        alert.sendKeys("Ahmet");
        alert.accept();
        String actualJsText = BrowserUtils.getText(result);
        String expectedJsText = "You entered text Ahmet in propmt popup";
        softAssert.assertEquals(actualJsText,expectedJsText);
      //  Assert.assertEquals(actualJsText, expectedJsText);
        softAssert.assertAll();
    }
}
