package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseButton.sendKeys("/Users/codefish/Desktop/usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        // uploadButton.click();
        uploadButton.submit();
        WebElement text = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "usa.png";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void practice2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseButton = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseButton.sendKeys("/Users/codefish/Desktop/ahmetstyle.css");
        WebElement text = driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText, expectedText);
        WebElement checkBox = driver.findElement(By.cssSelector("#terms"));
        if (checkBox.isEnabled() && checkBox.isDisplayed() && !checkBox.isSelected()) {
            checkBox.click();
        }
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        WebElement validationText = driver.findElement(By.xpath("//h3[@id='res']"));
        String actualResult = BrowserUtils.getText(validationText);
        String expectedResult = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
