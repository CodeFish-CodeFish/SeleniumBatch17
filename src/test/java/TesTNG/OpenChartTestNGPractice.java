package TesTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenChartTestNGPractice {

    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void validateNegativeScenario() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("dssfg");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage=driver.findElement(By.cssSelector("#alert"));
        Thread.sleep(1000);
        String actualMessage=alertMessage.getText().trim();
        String expectedMessage="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton=driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalogButton=driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed() && productButton.isEnabled());
        Assert.assertTrue(productButton.isEnabled());
        driver.quit();
    }

    @Test
    public void validateBoxesFunctionalityInProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton=driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();
        WebElement catalogButton=driver.findElement(By.linkText("Catalog"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        //TIPS:
        //1-Find the all boxes location for the first page
        //2-Use regular loop and start from i=1 because i=0 is choosing all boxes right away
        //3-This box is displayed
        //4-The box is enabled
        //5-The box is not selected(Assert.assertFalse)
        //6-Click
        //7-The box is selected(Assert.AssertTrue)
        //Thread.sleep(1000)
        //sendKeys(Keys.Arrow) -->We did in youtube remember
    }
}
