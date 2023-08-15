package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttributeMethod {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        //TASK:
        //PLEASE PRINT OUT JOHN DOE
        //PLEASE PRINT OUT ThisIsNotPassword
        WebElement username=driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(username.getText().trim());//this will not work since there is no text
        System.out.println(username.getAttribute("value"));
        System.out.println(username.getAttribute("type"));//text
    }

}
