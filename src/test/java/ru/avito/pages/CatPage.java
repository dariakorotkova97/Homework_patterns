package ru.avito.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatPage {

    public CatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = ".//div[@class='catalog-counts__more']/*/li/span")
    private List <WebElement> sections;

    @FindBy(xpath = ".//span[contains(@class,'pseudo-link')][1]")
    private WebElement openButton;

    @FindBy(xpath = "(.//a[@class='item-description-title-link'])[1]")
    private WebElement firstSection;


    public void clickOpenButton() {
        openButton.click();
    }

    public WebElement getMaxItem() {
        List<Integer> maxitems= new ArrayList<Integer>();
        for (int i=0; i<sections.size(); i++){
            String st= sections.get(i).getAttribute("innerHTML");
            int item = Integer.parseInt(st.replaceAll("\\s+",""));
            maxitems.add(item);
        }
        int cats = maxitems.indexOf(Collections.max(maxitems));
        WebElement search = driver.findElement(By.xpath("(.//div[@class='catalog-counts__more']/*/li/a)["+Integer.toString(cats+1)+"]"));
        System.out.println(search.getText());
        return search;
    }

    public void clickMaxItem(){
        getMaxItem().click();
    }

    public void clickFirstSection(){
        firstSection.click();
    }


 }