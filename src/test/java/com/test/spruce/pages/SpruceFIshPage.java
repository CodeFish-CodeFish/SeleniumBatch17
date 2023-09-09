package com.test.spruce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SpruceFIshPage {

    public SpruceFIshPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#search-form-input")
    WebElement searchBar;

    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement star4;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorBox;

    @FindBy(xpath = "//span[contains(text(),'Roasted Salmon Fillets')]")
    WebElement productName;


    public void searchRecipe(WebDriver driver,String searchItem) throws InterruptedException {
        BrowserUtils.scrollIntoView(driver,searchBar);
        Thread.sleep(3000);
        searchBar.sendKeys(searchItem, Keys.ENTER);
    }

    public void chooseSpecialRates(){
        star4.click();
        if(editorBox.isDisplayed() && !editorBox.isSelected()){
            editorBox.click();
        }
    }

    public String productInformation(){
        return BrowserUtils.getText(productName);
    }
}
