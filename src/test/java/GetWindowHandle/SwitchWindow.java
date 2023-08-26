package GetWindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchwindow() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        WebElement text = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));//Opening new window
        String mainId = driver.getWindowHandle();
        System.out.println(mainId);
        Set<String> allWindowsID = driver.getWindowHandles();
        for (String id : allWindowsID) {
            if (!id.equals(mainId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        text = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));//New Windows
    }

    @Test
    public void switchWindowPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollIntoView(driver,button2);
        button2.click();
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();

        for(String pageId:allPagesId){
            if(!pageId.equals(mainPageId)){
                driver.switchTo().window(pageId);
                break;
            }
        }
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement alertBox=driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();













    }
}
