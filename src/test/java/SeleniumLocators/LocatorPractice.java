package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {
        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Baldir");
        Thread.sleep(3000);
        WebElement gender=driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement experience=driver.findElement(By.id("exp-1"));
        experience.click();
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("8/4/2023");
        Thread.sleep(3000);
        WebElement profession=driver.findElement(By.id("profession-1"));
        if(profession.isDisplayed()&&!profession.isSelected()){
            profession.click();
        }
        WebElement tool=driver.findElement(By.id("tool-2"));
        tool.click();
        WebElement continent=driver.findElement(By.id("continents"));
        continent.sendKeys("South America");
        WebElement button=driver.findElement(By.id("submit"));
        button.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
        driver.close();
    }
}
