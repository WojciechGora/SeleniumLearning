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

public class Zad2_oczekiwanie {

    public static WebDriver driver;

    @Test
    public void zad2oczekiwanie() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Wejdź na stronę główną: http://www.selenium-shop.pl i poczekaj aż tytuł strony będzie równy: Selenium Shop Automatyzacja Testów
        driver.get("http://www.selenium-shop.pl/");
        wait.until(ExpectedConditions.titleIs("Selenium Shop Automatyzacja Testów"));
        //skrolowanie
        js.executeScript("window.scrollBy(0,1200)");
        //Poczekaj aż element umieszczony na dole strony: SEE ALL PRODUCTS, zostanie wyświetlony. //Kliknij element SEE ALL PRODUCTS
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See all')]"))).click();

        //Poczekaj aż produkt Koszulka Arsenal London zostanie wyświetlona
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Koszulka Arsenal London')]"))).click();

        //Kliknij produkt: Koszulka Arsenal London //Poczekaj aż przycisk DODAJ DO KOSZYKA będzie klikalny.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@name='add-to-cart']"))).click();

        //POCZEKAJ na wyświetlenie komunikatu : “Koszulka Arsenal London” został dodany do koszyka”
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));

        //Zamknij przeglądarkę
        driver.close();
    }
}