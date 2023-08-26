package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevel {

    @Test
    public void validateOrderFunctionality(){
    /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger=new Select(passengerBox);
        passenger.selectByVisibleText("4");
        WebElement fromPortBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPort=new Select(fromPortBox);
        String actualText=fromPort.getFirstSelectedOption().getText().trim();
        String expectedText="Acapulco";
        Assert.assertEquals(actualText,expectedText);
        fromPort.selectByValue("Paris");
        WebElement fromMonthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonth=new Select(fromMonthBox);
        fromMonth.selectByIndex(7);
        WebElement fromDayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDay=new Select(fromDayBox);
        fromDay.selectByVisibleText("15");
        WebElement toPortBox=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPort=new Select(toPortBox);
        toPort.selectByValue("San Francisco");
        WebElement toMonthBox=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonth=new Select(toMonthBox);
        toMonth.selectByIndex(11);
        WebElement toDayBox=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay=new Select(toDayBox);
        toDay.selectByVisibleText("15");
        WebElement classOption=driver.findElement(By.xpath("//input[@value='First']"));
        classOption.click();
        WebElement airlinesBox=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlinesBox);
        List<WebElement> allAirlines=airline.getOptions();
        List<String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0;i<allAirlines.size();i++){
            Assert.assertEquals(allAirlines.get(i).getText().trim(),expectedAirlines.get(i));
        }

        airline.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement orderMessage=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=orderMessage.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void shortCutAutomation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerBox,"4","text");
//        Select passenger=new Select(passengerBox);
//        passenger.selectByVisibleText("4");
        WebElement fromPortBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPort=new Select(fromPortBox);
        String actualText=fromPort.getFirstSelectedOption().getText().trim();
        String expectedText="Acapulco";
        Assert.assertEquals(actualText,expectedText);
        BrowserUtils.selectBy(fromPortBox,"Paris","value");
//        fromPort.selectByValue("Paris");
        WebElement fromMonthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonthBox,"7","index");
//        Select fromMonth=new Select(fromMonthBox);
//        fromMonth.selectByIndex(7);
        WebElement fromDayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDayBox,"15","text");
//        Select fromDay=new Select(fromDayBox);
//        fromDay.selectByVisibleText("15");
        WebElement toPortBox=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPort=new Select(toPortBox);
        toPort.selectByValue("San Francisco");
        WebElement toMonthBox=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonth=new Select(toMonthBox);
        toMonth.selectByIndex(11);
        WebElement toDayBox=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay=new Select(toDayBox);
        toDay.selectByVisibleText("15");
        WebElement classOption=driver.findElement(By.xpath("//input[@value='First']"));
        classOption.click();
        WebElement airlinesBox=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlinesBox);
        List<WebElement> allAirlines=airline.getOptions();
        List<String> expectedAirlines= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0;i<allAirlines.size();i++){
            Assert.assertEquals(allAirlines.get(i).getText().trim(),expectedAirlines.get(i));
        }

        airline.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement orderMessage=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=BrowserUtils.getText(orderMessage);
        //orderMessage.getText().trim()
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
