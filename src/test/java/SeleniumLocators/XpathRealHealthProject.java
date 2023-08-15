package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {

     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
           */
     public static void main(String[] args) throws InterruptedException {
         WebDriverManager.chromedriver().setup();
         ChromeDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
         WebElement makeAppointment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
         makeAppointment.click();
         WebElement username=driver.findElement(By.xpath("//input[@id='txt-username']"));
         username.sendKeys("John Doe");
         WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
         password.sendKeys("ThisIsNotAPassword");
         WebElement loginButton=driver.findElement(By.xpath("//button"));
         loginButton.click();
         WebElement facility=driver.findElement(By.xpath("//select[@name='facility']"));
         facility.sendKeys("Hongkong CURA Healthcare Center");
         WebElement readmission=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
         if(readmission.isDisplayed()&&!readmission.isSelected()){
             readmission.click();
         }
         System.out.println(readmission.isSelected() ? "CHECKED" : "NOT CHECKED");
         WebElement program=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
         program.click();
         Thread.sleep(2000);
         WebElement date=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
         date.sendKeys("03/05/2024");
         WebElement textArea=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
         textArea.sendKeys("I LOVE SELENIUM");
         WebElement bookAppointment=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
         bookAppointment.click();
         WebElement header=driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
         System.out.println(header.getText().trim());
         WebElement fclity=driver.findElement(By.xpath("//p[.='Medicaid']"));
         System.out.println(fclity.getText().trim());
         driver.close();
     }

}
