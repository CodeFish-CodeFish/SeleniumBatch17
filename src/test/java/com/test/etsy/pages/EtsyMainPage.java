package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBar;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allTitles;

    public void checkingKeyWords(String key1,String key2,String key3){
        for(WebElement title:allTitles){
            String word=BrowserUtils.getText(title).toLowerCase();
            System.out.println(BrowserUtils.getText(title));
            Assert.assertTrue(word.contains(key1) ||word.contains(key2) || word.contains(key3));}
    }

    public void searchItem(String searchItem){
        searchBar.sendKeys(searchItem, Keys.ENTER);
    }
}
