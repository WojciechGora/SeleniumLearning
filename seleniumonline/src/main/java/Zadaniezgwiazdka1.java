import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Zadaniezgwiazdka1 {


        public static WebDriver driver;

        @Test
        public void lokalizowanieElementow_Test() throws InterruptedException {

            //Konfiguracja początkowa
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("http://www.selenium-shop.pl/");

            //Krok 1
            WebElement sklepMenu = driver.findElement(By.linkText("ANKIETA"));
            sklepMenu.click();

            WebElement imie = driver.findElement(By.id("Imię"));
            imie.sendKeys("Wojciech");

            WebElement radiobutton = driver.findElement(By.xpath("//input[@value='20-29']"));
            radiobutton.click();

            WebElement checkbox = driver.findElement(By.xpath("//input[@value='Koszulka meczowa']"));
            checkbox.click();

            WebElement dodajPlik = driver.findElement(By.id("file"));
            dodajPlik.click();





        }
    }
