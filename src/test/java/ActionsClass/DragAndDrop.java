package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDropMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxText= BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxText="... Or here.";
        Assert.assertEquals(actualOrangeBoxText,expectedOrangeBoxText);
        String actualOrangeBoxColor=orangeBox.getCssValue("background-color");
        String expectecOrangeBoxColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualOrangeBoxColor,expectecOrangeBoxColor);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxTextAfter=BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxTextAfter="You did great!";
        Assert.assertEquals(actualOrangeBoxTextAfter,expectedOrangeBoxTextAfter);
    }

    @Test
    public void ClickAndHoldMethods(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBoxText=BrowserUtils.getText(blueBox);
        String expectedBoxText="Drag the small circle here ...";
        Assert.assertEquals(actualBoxText,expectedBoxText);
        String actualColor=blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        WebElement dragger=driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.clickAndHold(dragger).moveToElement(blueBox).release().perform();
        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfter=BrowserUtils.getText(blueBox);
        String expectedMessageAfter="You did great!";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);
    }








}
