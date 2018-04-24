package ru.avito.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.avito.pages.CatItemPage;
import ru.avito.pages.CatPage;
import ru.avito.pages.MainPage;
import java.util.concurrent.TimeUnit;



public class FirstTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static CatPage catPage;
    public static CatItemPage catItemPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        catPage = new CatPage(driver);
        catItemPage = new CatItemPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/rossiya");
    }

    @Test
     public void testMax(){
        System.out.println("Элемент раздела \"Порода кошек\" по которому больше всего предложений...");
        mainPage.selectSection("Кошки");
        mainPage.clickSearchButton();
        catPage.clickOpenButton();
        catPage.clickMaxItem();
    }

    @Test
    public void testFirstBreed(){
        System.out.println("Первая в поиске...");
        mainPage.selectSection("Кошки");
        mainPage.clickSearchButton();
        catPage.clickFirstSection();
        System.out.println(catItemPage.getCatBreed());

    }


    @After
    public void afterTest(){
        driver.quit();
    }
}
