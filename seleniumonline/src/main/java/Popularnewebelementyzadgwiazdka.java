import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Popularnewebelementyzadgwiazdka {

    public void takeScreenShot() {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + System.currentTimeMillis() + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }





    public static WebDriver driver;

    @Test
    public void scenariusz() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);






        //Wejdź na stronę główną: http://www.selenium-shop.pl
        driver.navigate().to("http://www.selenium-shop.pl/");



        //Zweryfikuj tytuł strony (poprawny tytuł strony to:  Selenium Shop Automatyzacja Testów)

        Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");
        System.out.println("Tutuł jest poprawny");

        //Wykonaj screenshota i zapisz go.
        takeScreenShot();


        //Z menu wybierz zakładkę SKLEP
        driver.findElement(By.linkText("SKLEP")).click();

        //Zweryfikuj tytuł strony (poprawny tytuł strony to:  Produkty – Selenium Shop Automatyzacja Testów)
        Assert.assertEquals(driver.getTitle(),"Produkty – Selenium Shop Automatyzacja Testów");
        System.out.println("Kolejny tytuł jest poprawny");


        //Wykonaj screenshota i zapisz go.
        takeScreenShot();

        //Z menu wybierz zakładkę KOSZYK
        driver.findElement(By.linkText("KOSZYK")).click();


        //Zweryfikuj tytuł strony (poprawny tytuł strony to:  Koszyk – Selenium Shop Automatyzacja Testów)
        Assert.assertEquals(driver.getTitle(),"Koszyk – Selenium Shop Automatyzacja Testów");
        System.out.println("Tytuł jest poprawny");


        //Wykonaj screenshota i zapisz go.
        takeScreenShot();

    }
}
