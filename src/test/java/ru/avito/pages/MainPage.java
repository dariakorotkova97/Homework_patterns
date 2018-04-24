package ru.avito.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//div[@class='search-form__submit']")
    private WebElement searchButton;

    public void clickSearchButton() {
       searchButton.click();
    }

    public void selectSection(String value) {
        WebElement selectField = driver.findElement(By.xpath(".//option[text()='"+value+"']"));
        selectField.click();
    }
}


