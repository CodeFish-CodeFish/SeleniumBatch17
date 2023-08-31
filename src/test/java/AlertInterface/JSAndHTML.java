package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAndHTML {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement JSPreview=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        JSPreview.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText().trim();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement htmlPreview=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlPreview.click();
        Thread.sleep(3000);
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

        /*
        1-Navigate to the website
        2-Click preview button under Normal Alert
        3-Validate the text from JS which is "Oops, something went wrong!"
        and click OK button
        4-Click preview button under Sweetalert and click OK button

         */
    }
}
