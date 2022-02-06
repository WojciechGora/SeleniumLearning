import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Asercje_zadaniezgwiazdka1 {
    public static WebDriver driver;

    @Test
    public void Asercjezgwiazdka1() throws InterruptedException {

        String poprawnyTytulStronyGlownej = "Selenium Shop Automatyzacja Testów";
        String poprawnyTytulPodstronyMojeKonto = "Moje konto – Selenium Shop Automatyzacja Testów";

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę główną: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");


        //Z menu wybierz zakładkę SKLEP
        WebElement sklep = driver.findElement(By.linkText("SKLEP"));
        sklep.click();

        //Zweryfikuj tytuł strony. (poprawny tytuł strony to: Produkty – Selenium Shop Automatyzacja Testów)
        Assert.assertEquals(driver.getTitle(),"Produkty – Selenium Shop Automatyzacja Testów");

        //Zweryfikuj czy na stronie prezentowanych jest dokładnie 12 produktów. Wyświetl stosowny komunikat (potwierdzający bądz zaprzeczający)
        List<WebElement> elementy = driver.findElements(By.xpath("//img[@class = 'attachment-shop_catalog size-shop_catalog wp-post-image']"));
        int liczba_elementow = elementy.size();
        Assert.assertTrue(liczba_elementow==12);
       System.out.println("Liczba elementow zgadza się");

        //Zweryfikuj czy na stronie znajduje się lista z sortowaniem produktów. Wypisz stosowną informację.
        WebElement listazsortowaniem =driver.findElement(By.name("orderby"));
        Assert.assertTrue(listazsortowaniem.isDisplayed());
        System.out.println("Lista jest widoczna\n");

        //Wejdz w dowolnie wybrany produkt.

        WebElement koszulka = driver.findElement(By.xpath("//h2[text() = 'Koszulka Arsenal London']"));
        koszulka.click();

        //Zweryfikuj czy na stronie szczegółów produktu – pole z ilością sztuk produktu jest aktywne.
        WebElement poleilosc = driver.findElement(By.xpath("//input[@title='Szt.']"));
        Assert.assertTrue(poleilosc.isEnabled(),"pole nie jest aktywne");

    }
}

