package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    //LOCATORS:Is a way to locate(find) the element and manipulate on it.

    public static void main(String[] args) {
        //ID LOCATOR
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/codefish/Desktop/Techtorialhtml%20(1).html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());//Techtorial Academy
        String actualHeader=header.getText();
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed":"Failed");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("132312312");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("ahmet@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("2200 midway");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("42354");

        //CLASSNAME LOCATOR:
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "SELECTED" : "NOT SELECTED");
        WebElement seleniumBox=driver.findElement(By.id("cond2"));

        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }

        System.out.println(seleniumBox.isSelected() ? "SELECTED" : "NOT SELECTED");

        WebElement testNGBox=driver.findElement(By.id("cond3"));
        if(testNGBox.isDisplayed() && !testNGBox.isSelected()){
            testNGBox.click();
        }
        System.out.println(testNGBox.isSelected() ? "SELECTED" : "NOT SELECTED");

        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        if(cucumberBox.isDisplayed() && !cucumberBox.isSelected()){
            cucumberBox.click();
        }
        System.out.println(cucumberBox.isSelected() ? "SELECTED" : "NOT SELECTED");

    }
}
