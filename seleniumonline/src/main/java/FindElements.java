import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {

    public static WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        WebElement sklep = driver.findElement(By.linkText("SKLEP"));
        sklep.click();

        List<WebElement> listaObrazków = driver.findElements(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
        int liczbagrafik = listaObrazków.size();

        System.out.println("Liczba grafik na stronie = " + liczbagrafik);

        Assert.assertEquals(liczbagrafik, 12);

        for (int i = 0; i < liczbagrafik; i++) {
            System.out.println(listaObrazków.get(i).getAttribute("src"));

        }
        driver.quit();
    }
}
