import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Zadanie1_oczekiwanie {

    public static WebDriver driver;

    @Test
    public void zad1oczekiwanie(){


//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Wejdź na stronę główną: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");


        //Przejdź do podstrony: Ankieta
        WebElement mojeKontoMenu = driver.findElement(By.linkText("ANKIETA"));
        mojeKontoMenu.click();

        //Kliknij przycisk PROCES
        WebElement procesButton = driver.findElement(By.id("proces"));
        procesButton.click();

        //Poczekaj na wyświetlenie się napisu: Element Proces został wyświetlony
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Element Proces został wyświetlony')]")));
        //Zweryfikuj czy napis Element Proces został wyświetlony jest wyświetlony na stronie
        WebElement komunikat = driver.findElement(By.xpath("//span[contains(text(),'Element Proces został wyświetlony')]"));
        Assert.assertTrue(komunikat.isDisplayed(), "Komunikat nie jest widoczny na stronie");

        //Zamknij przeglądarkę
        driver.quit();


    }
}