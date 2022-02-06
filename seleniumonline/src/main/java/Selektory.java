import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selektory {
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

        //Krok 2

        WebElement koszulkaChelsea  = driver.findElement(By.xpath("//h2[text()='Koszulka Chelsea London']"));
        //WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[contains(text(),'Chelsea')]"));
        koszulkaChelsea.click();
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[starts-with(text(),'Koszulka Chelsea')]"));
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[ends-with(text(),'Chelsea London')]"));
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//*[starts-with(@class,'products')]/li[2]/a/h2"));


        //Krok 3

        WebElement quantityField = driver.findElement(By.className("input-text"));
        //WebElement quantityField = driver.findElement(By.xpath("//input[@class='input-text qty text']"));
        //WebElement quantityField = driver.findElement(By.xpath("//*[starts-with(@id,'quantity_')]"));
        quantityField.clear();
        quantityField.sendKeys("6");
        // WebElement quantityField = driver.findElement(By.xpath("//*[@class='quantity']/input"));
        // WebElement quantityField = driver.findElement(By.xpath(" //*[starts-with(@id,'quantity_')]"));
        // WebElement quantityField = driver.findElement(By.xpath("//input[@title='Szt.']"));

        //Krok 4
        WebElement dodajdokoszyka = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        dodajdokoszyka.click();
        //krok 5
        WebElement zobaczkoszyk = driver.findElement(By.className("wc-forward"));
        //WebElement zobaczkoszyk = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczkoszyk.click();

        //krok 5
        WebElement kodkuponu = driver.findElement(By.xpath("//input[@name='coupon_code']"));
        kodkuponu.clear();
        kodkuponu.sendKeys("Wiosna2020");

        //krok 6
        //WebElement zastosujkupon = driver.findElement(By.xpath("//button[text()='Zastosuj kupon']"));
        WebElement zastosujkupon = driver.findElement(By.xpath("//button[@value='Zastosuj kupon']"));
        zastosujkupon.click();

    }
}
