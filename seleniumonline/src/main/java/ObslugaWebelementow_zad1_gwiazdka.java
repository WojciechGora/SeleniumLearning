import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObslugaWebelementow_zad1_gwiazdka {
    public static WebDriver driver;

    @Test
    public void zad1gwiazdka() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");

        //Przejdź do zakładki Ankieta
        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        //Posortuj produkty według popularności

        Select sortowanie = new Select(driver.findElement(By.name("orderby")));
        sortowanie.selectByValue("popularity");

        //sprawdzenie nazwy
        String nazwa = driver.findElement(By.xpath("//h2[text()='Piłka nożna KIPSTA F100']")).getText();
        System.out.println("Nazwa produktu to: " + nazwa);

        //Kliknij Dodaj do koszyka na pierwszym produkcie
        WebElement pierwszyprodukt = driver.findElement(By.xpath("//ul[@class = 'products columns-4']/li[1]/a/div/div/div/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", pierwszyprodukt);
        Thread.sleep(3000);


        //Z menu wybierz zakładkę KOSZYK
        //WebElement koszyczek = driver.findElement(By.xpath("//*[@title= 'View your shopping cart']/span"));

        WebElement koszyczek = driver.findElement(By.xpath("//*[@class = 'icon-basket']"));


        js.executeScript("arguments[0].click();", koszyczek);


        //Zweryfikuj czy nazwa produkty widocznego w koszyku to nazwa produktu, którą wybrałeś z punkcie 4. W przypadku, gdy nazwa produktu jest inna – wypisz komunikat: „Nazwa produktu jest nieprawidłowa!„
        String nazwaproduktuwkoszyku = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();

        Assert.assertEquals(nazwa, nazwaproduktuwkoszyku);

        //Zweryfikuj czy ilość poroduktów w koszyku = 1. W przypadku, gdy ilość produtów jest większa od 1 – wypisz komunikat: „W koszyku jest za dużo produktów! „

        String itemsquantity = driver.findElement(By.xpath("//input[@type='number']")).getText();

        if (itemsquantity == "1") {
            System.out.println("Liczba produktów jest równa od 1");
        } else {
            System.out.println("Liczba produktow jest wieksza od 1");


        }

    }
}
