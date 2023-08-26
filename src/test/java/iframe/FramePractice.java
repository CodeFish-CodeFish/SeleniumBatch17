package iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class FramePractice {

    @Test
    public void frame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.tagName("p"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();//mainhtml
        WebElement elemental=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(BrowserUtils.getText(elemental));
    }

    @Test
    public void practiceTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchWindow(driver,"qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumPhyton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        actions.click(seleniumPhyton).perform();
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));
        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        System.out.println(allLinks.size());
        BrowserUtils.switchWindow(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchWindow(driver,"SeleniumTesting Archives");
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader,expectedHeader);
        Thread.sleep(3000);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for(WebElement headerr:allHeaders){
            System.out.println(BrowserUtils.getText(headerr));
        }
        BrowserUtils.switchWindow(driver,"iframes");
        driver.switchTo().frame("Framename1");
        WebElement textFrame=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(textFrame));
        driver.switchTo().parentFrame();//main html
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchWindow(driver,"SoftwareTesting Archives");
        WebElement headerlast=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(headerlast));
        /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links)
         */
        /*
        TASK2:
        1-Click the category 1 button
        2-Validate the header is "Category Archives: SeleniumTesting"
        3-Print out the top of the each box(text). I showed you during manual steps
         */
        /*
        TASK3:
        1-Go to the iframe tab
        2-print out "I am inside Frame"
        3-Click category 3
        4-print out the header "Category Archives: SoftwareTesting"
         */
    }
}
