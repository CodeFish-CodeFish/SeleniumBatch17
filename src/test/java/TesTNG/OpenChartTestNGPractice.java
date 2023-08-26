package TesTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));//11
        for(int i=1;i<allBoxes.size();i++){
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertFalse(allBoxes.get(i).isSelected());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Thread.sleep(500);
            allBoxes.get(i).click();
            Thread.sleep(500);
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }

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
    @Test
     public void validateAscendingOrder() throws InterruptedException {
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
         Thread.sleep(2000);
         List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));
         List<String> expectedProducts=new ArrayList<>();
         List<String> actualProducts=new ArrayList<>();

         for(int i=1;i<allProducts.size();i++){
             actualProducts.add(allProducts.get(i).getText().toLowerCase().trim());
             expectedProducts.add(allProducts.get(i).getText().toLowerCase().trim());
         }
        Collections.sort(expectedProducts);
        System.out.println(actualProducts);
        System.out.println(expectedProducts);
        Assert.assertEquals(actualProducts,expectedProducts);
     }

     @Test
    public void ValidateDescendingOrder() throws InterruptedException {
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
         Thread.sleep(2000);
         WebElement productNameButton=driver.findElement(By.cssSelector(".asc"));
         productNameButton.click();
         Thread.sleep(2000);
         List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));
         List<String> actualProducts=new ArrayList<>();
         List<String> expectedProducts=new ArrayList<>();

         for(int i=1;i<allProducts.size();i++){
             actualProducts.add(allProducts.get(i).getText().toLowerCase().trim());
             expectedProducts.add(allProducts.get(i).getText().toLowerCase().trim());
         }
         Collections.sort(expectedProducts);//ascending order
         Collections.reverse(expectedProducts);//descending order
         System.out.println(expectedProducts);
         System.out.println(actualProducts);
         Assert.assertEquals(actualProducts,expectedProducts);

     }















}
