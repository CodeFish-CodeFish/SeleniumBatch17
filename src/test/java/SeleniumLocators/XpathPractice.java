package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {

   /*
   1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
   2-Provide First name,LastName,Email,Telephone,password,confirm password
   and click privacy policy button.(isDisplayed and notSelected then click)
   3-Click Continue Button
   4-Validate message (Your Account Has Been Created!) -->if statement
   5-Click Continue Button
   6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
   7-Close your browser
   NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
    */
   public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
       WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
       firstName.sendKeys("Ahmet");
       WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
       lastName.sendKeys("Baldir");
       WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
       email.sendKeys("Ahmet989ks@gmail.com");
       WebElement phone=driver.findElement(By.xpath("//input[@placeholder='Telephone']"));
       phone.sendKeys("31452454");
       WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
       password.sendKeys("Ahmet123");
       WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='input-confirm']"));
       confirmPassword.sendKeys("Ahmet123");
       WebElement privacyBox=driver.findElement(By.xpath("//input[@name='agree']"));
       if(privacyBox.isDisplayed() && !privacyBox.isSelected()){
           privacyBox.click();
       }
       System.out.println(privacyBox.isSelected() ? "CHECKED" : "NOT CHECKED");
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement successMessage=driver.findElement(By.xpath("//h1[contains(text(),' Created')]"));
        String actualMessage=successMessage.getText().trim();
        String expectedMessage="Your Account Has Been Created!";
       System.out.println(actualMessage.equals(expectedMessage) ? "HEADER PASSED" : "Header FAILED");
       WebElement finalContinueButton=driver.findElement(By.xpath("//a[.='Continue']"));
       finalContinueButton.click();
       String actualUrl=driver.getCurrentUrl();
       String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
       System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");
       driver.close();
   }
}
