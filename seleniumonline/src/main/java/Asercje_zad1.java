import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asercje_zad1 {

    public static WebDriver driver;

    @Test
    public void Asercjezad() throws InterruptedException {

        String poprawnyTytulStronyGlownej = "Selenium Shop Automatyzacja Testów";
        String poprawnyTytulPodstronyMojeKonto = "Moje konto – Selenium Shop Automatyzacja Testów";

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę główną: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");

        //Zweryfikuj tytuł strony. (poprawny tytuł strony to: Selenium Shop Automatyzacja Testów )
        Assert.assertEquals(driver.getTitle(),"Selenium Shop Automatyzacja Testów","niepoprawny adres url");

        //Przejdź do podstrony: MOJE KONTO

        WebElement mojekonto = driver.findElement(By.linkText("MOJE KONTO"));
        mojekonto.click();

        //Zweryfikuj tytuł strony. (poprawny tytuł strony to: Moje konto – Selenium Shop Automatyzacja Testów)
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Moje konto – Selenium Shop Automatyzacja Testów"),"tytul strony jest niepoprawny");


        //Zweryfikuj czy na stronie wyświetlone jest pole login
        WebElement loginInput = driver.findElement(By.id("username"));
        Assert.assertTrue(loginInput.isDisplayed(),"pole login nie jest wyswietlone");

        //Zweryfikuj czy checkbox Zapamiętaj mnie nie jest zaznaczony
        WebElement zapamietajMnieCheckbox = driver.findElement(By.id("rememberme"));
        Assert.assertFalse(zapamietajMnieCheckbox.isSelected(),"checkbox jest zaznaczony");

        //Zamknij przeglądarkę
        driver.quit();
    }
}