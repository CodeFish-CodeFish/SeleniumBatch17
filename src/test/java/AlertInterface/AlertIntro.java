package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert(); //This is for only JS pop-ups which is not inspectable
        String actualMessage=alert.getText().trim();
        String expectedMessage="I am a JS Alert";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();//it clicks "OK" button
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualResult= BrowserUtils.getText(message);
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void Dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();//it clicks cancel button from JS pop-up.
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualResult= BrowserUtils.getText(message);
        String expectedResult="You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void SendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("I love Selenium");
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualResult= BrowserUtils.getText(message);
        String expectedResult="You entered: I love Selenium";
        Assert.assertEquals(actualResult,expectedResult);
    }














}
