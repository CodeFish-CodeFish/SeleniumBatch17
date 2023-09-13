package WaitTimes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {

    @Test
    public void validateText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button=driver.findElement(By.xpath("//button"));
        button.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']//h4"));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        System.out.println(text.getText().trim());
    }

    @Test
    public void validatetext2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        //Find more examples for Explicitly Wait.
        WebElement Button=driver.findElement(By.xpath("//button"));
        Button.click();
        Thread.sleep(10000);
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']//h4"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }
}
