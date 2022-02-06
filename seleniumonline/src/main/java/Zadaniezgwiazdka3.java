import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Zadaniezgwiazdka3 {


    public static WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        //System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");

        //chromedriver
        driver = new ChromeDriver();

        //1 Wejdz na stronę : http://www.selenium-shop.pl/
        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

        //2 Kliknij zakładkę MOJE KONTO
        WebElement mojekonto = driver.findElement(By.linkText("MOJE KONTO"));
        mojekonto.click();

        //3 Zweryfikuj czy na stronie jest widoczna prawidłowa liczba przycisków (elementów button)

        List<WebElement> listaprzyciskow = driver.findElements(By.xpath("//button"));
        int liczbaprzyciskow = listaprzyciskow.size();
        System.out.println("Liczba przycisków na stronie wynosi: " + liczbaprzyciskow);

        Assert.assertEquals(liczbaprzyciskow, 2);

        //4 Wypisz do konsoli co to za przyciski (skorzystaj z atrybutu „value”)

        for (int i = 0; i < liczbaprzyciskow; i++) {
            System.out.println(listaprzyciskow.get(i).getAttribute("value"));
        }


    }
}