import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.WEmbeddedFrame;

public class Warsztat_webelementy {

    public static WebDriver driver;

    @Test
    public void lokalizowanieElementow_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        //Krok 1
        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        Select listaProduktow = new Select(driver.findElement(By.name("orderby")));

        listaProduktow.selectByVisibleText("Sortuj od najnowszych");

        WebElement trzecinajnowszy = driver.findElement(By.xpath("//ul[contains(@class,'products')]/li[3]"));
        trzecinajnowszy.click();

        String nazwa_produktuNa = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
        //String cena_produktu = driver.findElement(By.xpath("//*[@class='summary entry-summary']/p/span")).getText();
        String cena_produktu = driver.findElement(By.xpath("//*[@class='woocommerce-Price-amount amount']")).getText();
        System.out.println("Item name: " + nazwa_produktuNa);
        System.out.println("Item price: " + cena_produktu);

        WebElement quantity = driver.findElement(By.xpath("//input[starts-with(@id,'quantity')]"));
        quantity.clear();
        quantity.sendKeys("2");

        WebElement dodajdokoszyka = driver.findElement(By.name("add-to-cart"));
        dodajdokoszyka.click();

        WebElement zobaczkoszyk = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczkoszyk.click();

        String Nazwaproduktu = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        String Cenaproduktow = driver.findElement(By.xpath("//td[@class='product-subtotal']/span")).getText();

        System.out.println("Item name: " + Nazwaproduktu);
        System.out.println("Item price: " + Cenaproduktow);

        String poprawnacenakoszyka = "240,00 ZŁ";

        Assert.assertEquals(nazwa_produktuNa,Nazwaproduktu);
        Assert.assertEquals(Cenaproduktow,poprawnacenakoszyka);

    }
}