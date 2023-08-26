package iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        /*
        TASK 1:Validate the "LEFT" from website
         */
        WebElement topFrame=driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-left");
        WebElement left=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualLeft= BrowserUtils.getText(left);
        String expectedLeft="LEFT";
        Assert.assertEquals(actualLeft,expectedLeft);
        /*
        TASK 2:Validate the "MIDDLE" and "RIGHT" website
         */
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        String actualMiddle= BrowserUtils.getText(middle);
        String expectedMiddle="MIDDLE";
        Assert.assertEquals(actualMiddle,expectedMiddle);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String actualRight=BrowserUtils.getText(right);
        String expectedRight="RIGHT";
        Assert.assertEquals(actualRight,expectedRight);

        /*
        TASK 3:Validate the "BOTTOM"
         */
//        driver.switchTo().parentFrame();//TOP FRAME
//        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().defaultContent();//MAIN HTML (where ever you are, it does not matter)
        driver.switchTo().frame(1);//BOTTOM FRAME
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottom=BrowserUtils.getText(bottom);
        String expectedBottom="BOTTOM";
        Assert.assertEquals(actualBottom,expectedBottom);
    }
}
