import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Nowe_okno {


    public static WebDriver driver;

    @Test
    public void Noweokno() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);

        driver.navigate().to("http://www.selenium-shop.pl/");

        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();


        System.out.println("Tutuł strony: " + driver.getTitle());
        System.out.println("Id strony: " + driver.getWindowHandle());

        WebElement przycisknoweokno = driver.findElement(By.xpath("//input[@value = 'Otwórz nowe okno']"));
        przycisknoweokno.click();

        Set<String> idcontainer = driver.getWindowHandles();

        System.out.println("Liczba wszystkich okien: " + idcontainer.size());
//petla foreach
        for (String elementlisty : idcontainer) {

            System.out.println("Okno: " + elementlisty);
        }

        Iterator<String> iterator_z_id = idcontainer.iterator();

        String pierwszastrona = iterator_z_id.next();
        String drugastrona = iterator_z_id.next();

        driver.switchTo().window(drugastrona);

        WebElement input = driver.findElement(By.id("imie_nazwisko"));
        input.sendKeys("Wojciech");


        System.out.println("Tutuł strony :" + driver.getTitle());
        System.out.println("Id stronby to: " + driver.getWindowHandle());

        driver.close();

        driver.quit();
    }
}

