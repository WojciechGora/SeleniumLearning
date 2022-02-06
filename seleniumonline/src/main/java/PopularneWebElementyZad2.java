
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class PopularneWebElementyZad2 {


    public static WebDriver driver;

    @Test
    public void scenariusz() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);


        driver.navigate().to("http://www.selenium-shop.pl/");


//        Wejdź na stronę główną: http://www.selenium-shop.pl/moje-konto/
        driver.get("http://www.selenium-shop.pl/moje-konto/");


//        Wykonaj akcję kliknięcia w przycisk ZAREJESTRUJ SIĘ. Wykonaj zabezpieczenia w postaci bloku try catch, który będzie obsługiwał trzy następujące wyjatki:


        try {
            driver.findElement(By.name("register")).click();
        } catch (NoSuchElementException e1) {

            System.out.println("Przycisku ZAREJESTRUJ SIĘ nie ma na stronie!");
            driver.navigate().refresh();

        } catch (ElementNotVisibleException e2) {

            System.out.println("Przycisk ZAREJESTRUJ SIĘ nie jest widoczny na stronie");
            driver.navigate().refresh();

        } catch (ElementNotInteractableException e3) {
            System.out.println("Nie można wykonać akcji kliknięcia na elemencie ZAREJESTRUJ SIĘ");
            driver.navigate().refresh();
        }
//        NoSuchElementException

//        ElementNotVisibleException

//        ElementNotInteractableException

//        W przypadku wyjątku NoSuchElementException wyświetl komunikat: Przycisku ZAREJESTRUJ SIĘ nie ma na stronie! ORAZ ODŚWIEŻ STRONĘ.

//       W przypadku wyjątku ElementNotVisibleException wyświetl komunikat: Przycisk ZAREJESTRUJ SIĘ nie jest widoczny na stronie ORAZ ODŚWIEŻ STRONĘ.

//                W przypadku wyjątku ElementNotInteractableException wyświetl komunikat: Nie można wykonać akcji kliknięcia na elemencie ZAREJESTRUJ SIĘ ORAZ ODŚWIEŻ STRONĘ.

        driver.quit();

    }
}
