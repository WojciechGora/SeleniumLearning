import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asercje_zadaniezgwiazdka2 {
    public static WebDriver driver;

    @Test
    public void Asercjezgwiazdka2() throws InterruptedException {

        String poprawnyTytulStronyGlownej = "Selenium Shop Automatyzacja Testów";
        String poprawnyTytulPodstronyMojeKonto = "Moje konto – Selenium Shop Automatyzacja Testów";

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę główną: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");


        //Przejdź do zakładki MOJE KONTO
        WebElement sklep = driver.findElement(By.linkText("MOJE KONTO"));
        sklep.click();

        //Zweryfikuj czy na stronie znajduje się przycisk ZALOGUJ SIĘ

        WebElement zalogujsie = driver.findElement(By.name("login"));
        Assert.assertTrue(zalogujsie.isDisplayed(),"nie ma takiego przycisku");

        //Zweryfikuj czy na stronie znajduje się przycisk ZAREJESTRUJ SIĘ
        WebElement zarejestrujsie = driver.findElement(By.name("register"));
        Assert.assertTrue(zarejestrujsie.isDisplayed(),"nie ma takiego przycisku");

        //Wypisz właściwą informację do konsoli
        System.out.println("Test przebiegl pomyslnie");

        //Zamknij przeglądarkę
        driver.quit();


    }
}