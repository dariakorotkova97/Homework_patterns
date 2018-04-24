package ru.avito.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatItemPage {

    public CatItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = ".//div[@class='item-params']/span")
    private WebElement catBreed;

    public String getCatBreed(){
        return catBreed.getText();
    }
}
