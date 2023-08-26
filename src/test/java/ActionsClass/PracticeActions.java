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

public class PracticeActions {

    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropHereBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualText= BrowserUtils.getText(dropHereBox);
        String expectedText="Drop here";
        Assert.assertEquals(actualText,expectedText);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,dropHereBox).perform();
        String actualTextAfter=BrowserUtils.getText(dropHereBox);
        String expectedTextAfter="Dropped!";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
        String actualColor=dropHereBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        Actions actions=new Actions(driver);
        actions.click(acceptButton).perform();
        Thread.sleep(3000);
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualText=BrowserUtils.getText(dropBox);
        String expectedText="Drop here";
        Assert.assertEquals(actualText,expectedText);
        WebElement notAcceptableButton=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        actions.clickAndHold(notAcceptableButton).moveToElement(dropBox).release().perform();
        //actions.dragAndDrop(notAccaptableButton,dropBox).perform
        String actualTextAfter=BrowserUtils.getText(dropBox);
        String expectedTextAfter="Drop here";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);







    }
}
