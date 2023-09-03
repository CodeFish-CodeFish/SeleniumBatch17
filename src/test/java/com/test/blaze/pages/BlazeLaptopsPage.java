package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeLaptopsPage {

    public BlazeLaptopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hrefch")
    List<WebElement> allTitles;

    public void chooseBrand(String brand) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement title:allTitles){
            if(BrowserUtils.getText(title).equals(brand)){
                title.click();
                break;
            }
        }
    }
}
