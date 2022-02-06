import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Zadanie_alerty {
    public static WebDriver driver;

    @Test
    public void zadanie_alerty() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
//Wejdź na stronę: http://www.selenium-shop.pl/o-nas/
        driver.get("http://www.selenium-shop.pl/o-nas");


        //Krok 1
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //Kliknij przycisk PROMPT ALERT
        WebElement promptalert = driver.findElement(By.id("promtAlertPrzycisk"));
        promptalert.click();

        Thread.sleep(2000);

        //Uzupełnij pole tekstowe z okna Alert i zaakceptuj Alert
        driver.switchTo().alert().sendKeys("Wrocław");
        driver.switchTo().alert().accept();

        //Kliknij przycisk CONFIRM ALERT
        WebElement confirmbutton =driver.findElement(By.id("confimationAlertPrzycisk"));
        confirmbutton.click();

        //Pobierz komunikat z okna Alert, wyświetl go w konsoli i zaakceptuj Alert

        System.out.println("Komunikat alertu: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Zamknij przeglądarkę
        driver.close();
    }
}
