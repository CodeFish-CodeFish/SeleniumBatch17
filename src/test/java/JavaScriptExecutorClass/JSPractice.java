package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JSPractice {

     @Test
    public void practice(){
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("https://demoqa.com/radio-button");
         WebElement yesButton=driver.findElement(By.cssSelector("#yesRadio"));
      //   yesButton.click();
//         Actions actions=new Actions(driver);
//         actions.click(yesButton).perform();
         JavascriptExecutor js= (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click()",yesButton);
         WebElement textYes=driver.findElement(By.cssSelector(".mt-3"));
         String actualTextYes= BrowserUtils.getText(textYes);
         String expectedTextYes="You have selected Yes";
         Assert.assertEquals(actualTextYes,expectedTextYes);
         //Impressive is exactly same of Yes Button
          WebElement noRadioButton=driver.findElement(By.cssSelector("#noRadio"));
          Assert.assertFalse(noRadioButton.isEnabled());
     }

     @Test
    public void practiceAllJS() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("https://www.techtorialacademy.com/");
         WebElement copyRight=driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
         BrowserUtils.scrollIntoView(driver,copyRight);
         String actualText=BrowserUtils.getText(copyRight);
         String expectedText="Copyright © 2023";
         Assert.assertEquals(actualText,expectedText);
         WebElement tech=driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
         BrowserUtils.scrollIntoView(driver,tech);
         WebElement applyNowButton=driver.findElement(By.xpath("//strong[.='APPLY NOW']"));
         BrowserUtils.clickWithJS(driver,applyNowButton);
         Thread.sleep(2000);
         String mainPageId=driver.getWindowHandle();//your driver is pointing
          Set<String> allPagesId=driver.getWindowHandles();//2
          for(String id:allPagesId){
               if(!id.equals(mainPageId)){
                    driver.switchTo().window(id);
                    break;
               }
          }
         String actualTitle=driver.getTitle();
         String expectedTitle="Apply Now";
         Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement> allInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91",
                "Chicago & Houston");
        for(int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }
     }

     /*
     1-Navigate to the website
     2-Scroll All the way down to the "CopyRight 2023" and validate "Copyright © 2023
     3-Scroll All the way up to the "Launch a new tech Career".
     4-Click Apply Now button with JS.
     5-Validate the title with JS "Apply Now"
     6-Validate the information at the middle which are "info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston"
     7-close your all browsers(driver.quit)
      */
}
