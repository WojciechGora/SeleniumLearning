import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZadaniaLokalizowanieWebelementow {

    public static WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("http://www.selenium-shop.pl/");
        driver.manage().window().maximize();
/*

        //1. PRZYCISK ZAREJESTRUJ SIĘ -> ZA POMOCĄ SELEKTORA NAME
        WebElement mojekonto = driver.findElement(By.linkText("MOJE KONTO"));
        mojekonto.click();

        WebElement zarejestrujSie = driver.findElement(By.name("register"));
        zarejestrujSie.click();

        //2.      INPUT ADRES E-EMAIL -> ZA POMOCĄ SELEKTORA ID
        WebElement inputemail = driver.findElement(By.id("reg_email"));

        //3.POLE ILOŚĆ -> ZA POMOCĄ SELEKTORA CLASS
        WebElement poleilosc = driver.findElement(By.className("input-text"));

        //4. LINK KOSZULKI – > ZA POMOCĄ SELEKTORA LINKTEXT
        WebElement linkkoszulki = driver.findElement(By.linkText("Koszulki"));
*/
        //5. LINK SEE ALL PRODUCTS – > ZA POMOCĄ SELEKTORA PARTIALLINKTEXT
        WebElement seeallproducs = driver.findElement(By.partialLinkText("ALL"));
        seeallproducs.click();

    }
}
