import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Obsługa_list_rozwijalnych {
    public static WebDriver driver;

    @Test
    public void listaRozwijanaSport_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();


        //Przejście do podstrony: Ankieta
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //krok3
        Select sportlista = new Select(driver.findElement(By.name("Sport")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportlista);
        Thread.sleep(1000);

        if (sportlista.isMultiple()) {
            System.out.println("Lista jest wielokrotnego wyboru");
        } else
            System.out.println("Lista jest jednokrotnego wyboru");

        //krok4
        int liczbapozycjinaliscie = sportlista.getOptions().size();
        System.out.println("Liczba pozycji w liście wynosi: " + liczbapozycjinaliscie);
        //krok5
        System.out.println("Zaznaczona pozycja na liście: " + sportlista.getFirstSelectedOption().getText());

        //krok5
        for (int i = 0; i < liczbapozycjinaliscie; i++) {
            System.out.println("Pozycja: " + sportlista.getOptions().get(i).getText());
        }

        //krok6
        sportlista.selectByValue("bieganie");
        Thread.sleep(1000);
        Assert.assertEquals(sportlista.getFirstSelectedOption().getText(),"Bieganie");
        System.out.println("Aktualnie zaznaczona opcja to: " + sportlista.getFirstSelectedOption().getText());

        driver.quit();

    }
}