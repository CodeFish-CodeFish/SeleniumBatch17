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

public class Practice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement alertBoxClick=driver.findElement(By.cssSelector("#alertBox"));
        alertBoxClick.click();
        Alert alert=driver.switchTo().alert();
        String actualBoxText= alert.getText().trim();
        String expectedBoxText="I am an alert box!";
        Assert.assertEquals(actualBoxText,expectedBoxText);
        alert.accept();
        WebElement result=driver.findElement(By.cssSelector("#output"));
        String actualBoxResult=BrowserUtils.getText(result);
        String expectedBoxResult="You selected alert popup";
        Assert.assertEquals(actualBoxResult,expectedBoxResult);
        WebElement confirmBox=driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        String actualJConfirmText=alert.getText().trim();
        String expectedConfirmText="Press a button!";
        Assert.assertEquals(actualJConfirmText,expectedConfirmText);
        alert.dismiss();
        String actualConfirmResult=BrowserUtils.getText(result);
        String expectedConfirmResult="You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualConfirmResult,expectedConfirmResult);
        WebElement jsPrompt=driver.findElement(By.id("promptBox"));
        jsPrompt.click();
        String actualJsPromptText=alert.getText().trim();
        String expectedJSPromptText="Please enter your name:";
        Assert.assertEquals(actualJsPromptText,expectedJSPromptText);
        alert.sendKeys("Ahmet");
        alert.accept();
        String actualJsText=BrowserUtils.getText(result);
        String expectedJsText="You entered text Ahmet in prompt popup";
        Assert.assertEquals(actualJsText,expectedJsText);
        /*
        1-Click First "click me " button and validate text from pop-up
        which is "I am an alert box!" and click OK button then
        validate "You selected alert popup"
        2-Click Second "click me " button and validate text from pop-up
        which is "Press a button!" and click Cancel button then
        validate "You pressed Cancel in confirmation popup"
        3-Click Third "click me" button and validate text from pop-up
        which is "Please enter your name:" and send keys your name
         then click OK button and
         validate "You entered text Yada Giri Reddy in prompt popup"
         message will be with your name.

       NOTE:Last test should fail with mismatching propmt.
         */
    }
}
