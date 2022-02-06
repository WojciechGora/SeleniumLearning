import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Obslugawebelementow_zad3 {
    public static WebDriver driver;

    @Test
    public void zad3() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");

        //Przejdź do zakładki Ankieta
        WebElement sklepMenu = driver.findElement(By.linkText("ANKIETA"));
        sklepMenu.click();

        //Do pola kalendarz wprowadź datę Twoich urodzin
        WebElement kalendarz = driver.findElement(By.xpath("//*[@id='datepicker']/input"));
        kalendarz.clear();
        kalendarz.sendKeys("19-05-1994");

        //Weryfikacja wartości (daty urodzin) jaka jest obecna w polu kalendarz
        Assert.assertEquals(kalendarz.getAttribute("value"),"19-05-1994");




    }
}




