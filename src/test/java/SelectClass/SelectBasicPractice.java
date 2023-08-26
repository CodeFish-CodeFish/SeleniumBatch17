package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectBasicPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/codefish/Desktop/Techtorialhtml%20(1).html");
        //Validate that AS DEFAULT UNITED-STATES Is SELECTED
        WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
        Select countryBox=new Select(country);
        String actualText=countryBox.getFirstSelectedOption().getText().trim();
        String expectedText="UNITED STATES";
        Assert.assertEquals(actualText,expectedText);
        //PRINT OUT ALL COUNTRIES AND COUNT HOW MANY COUNTRIES WE HAVE(SOUT)
        int counter=0;
        List<WebElement> allCountries=countryBox.getOptions();
        for(WebElement cntr:allCountries){
            System.out.println(cntr.getText().trim());
            counter++;
        }
        System.out.println(counter);
        countryBox.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        countryBox.selectByValue("245");
        Thread.sleep(2000);
        countryBox.selectByIndex(5);
    }
      //TASK:CHOOSE YOUR OWN COUNTRY WITH VISIBLE TEXT METHOD
           //CHOOSE YOUR FAVORITE COUNTRY WITH VALUE
           //CHOOSE YOUR TRAVEL COUNTRY WITH INDEX
    //NOTE:PLEASE THREAD.SLEEP between them to see how it changes


}
