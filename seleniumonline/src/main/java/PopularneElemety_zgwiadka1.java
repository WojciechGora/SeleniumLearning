import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class PopularneElemety_zgwiadka1 {


    public static WebDriver driver;

    @BeforeTest
    public void scenariusz() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);

//NoAlertPresentException
        driver.navigate().to("http://www.selenium-shop.pl/");
    }

    @Test
    public void NoAlertPresentException() {

//        Wejdź na stronę główną: http://www.selenium-shop.pl/moje-konto/
        driver.get("http://www.selenium-shop.pl/moje-konto/");


        driver.findElement(By.name("register")).click();
        driver.switchTo().alert().accept();


    }

    @Test
    public void NoSuchElementException() {
        driver.findElement(By.name("register")).click();


    }

    public void TimeoutException() {
    }

    @Test
    public void NotFoundException() {
        driver.get("http://www.selenssium-shop.pl/moje-konto/");
    }

    @Test
    public void ElementNotInteractableException() {
        driver.findElement(By.xpath("//h1[text()='Selenium Shop']")).click();
}
}