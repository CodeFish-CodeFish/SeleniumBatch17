package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        //TASK
        //Please print out all the LINKS with LOOPS
        //AND COUNT HOW MANY LINKS DO WE HAVE AND PRINT IT OUT \
        //I WANT TO SEE ALL THE NAME OF LINKS ON THE CONSOLE
        //I WANT TO SEE HOW MANY LINKS WE HAVE
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//li"));//44
        int counter=0;
        for(WebElement link:allLinks){
            System.out.println(link.getText().trim());
            counter++;
        }
        System.out.println(counter);

        //TASK 2:
        //I want you print out the words that size is more than equal 12
        //USE another loop here
        //Also please count how many

        int counter2=0;
        for(WebElement link:allLinks){
            if(link.getText().trim().length()>=12){
                System.out.println(link.getText().trim());
                counter2++;
            }
        }
        System.out.println(counter2);
    }
}
