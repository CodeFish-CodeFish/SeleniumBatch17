package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/codefish/Desktop/Techtorialhtml%20(1).html");
        //TAG NAME LOCATOR
        WebElement version=driver.findElement(By.tagName("u"));
        String actualVersion=version.getText();
        String expectedVersion="Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion) ? "Passed":"Failed");
        //LINK TEXT LOCATOR
        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed":"Failed");
                /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
        driver.navigate().back();
        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader=seleniumHeader.getText();
        String expectedSeleniumHeader="Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedSeleniumHeader) ? "PASSED" : "FAILED");
        driver.navigate().back();
        javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click();
        driver.navigate().back();
        WebElement testNGLink=driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader=driver.findElement(By.tagName("h2"));
        String actualTestNGHeader=testNGHeader.getText();
        String expectedTestNGHeader="TestNG";
        System.out.println(actualTestNGHeader.equals(expectedTestNGHeader) ? "PASSED" : "FAILED");
        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="file:///Users/codefish/Desktop/Techtorialhtml%20(1).html";
        System.out.println(actualUrl.equals(expectedUrl) ? "PASSED URL":"FAILED URL");

         //PARTIAL LINK TEXT:
        WebElement rest_api=driver.findElement(By.partialLinkText("Rest"));
        rest_api.click();
        System.out.println(driver.getTitle());


    }
}
