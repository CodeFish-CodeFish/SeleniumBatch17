package com.test.spruce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceMainPage {

    public SpruceMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;

    @FindBy(xpath = "//li[@class='global-nav__sub-list-item']//a[contains(text(),'Fish & Seafood')]")
    WebElement seaFood;


    public void chooseSeaFood(WebDriver driver){
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        actions.click(seaFood).perform();
    }
}
