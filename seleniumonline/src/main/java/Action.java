import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Action {


    public static WebDriver driver;

    @Test
    public void nawigacja_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);

        driver.navigate().to("http://www.selenium-shop.pl/");


        //Z menu wybierz link „Ankieta”
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //Wykonaj akcję dwu-kliku na przycisku: „DWUKLIK POKAŻ KOMUNIKAT” i zweryfikuj czy został wyświetlony komunikat: „Przycisk dwuklik został kliknięty”
        WebElement przyciskdwuklik = driver.findElement(By.xpath("//*[@value='Dwuklik pokaż komunikat']"));
        builder.doubleClick(przyciskdwuklik).perform();

        String expectedMessage ="Przycisk dwuklik został kliknięty";
        String actualmessage = driver.findElement(By.id("p-doubleClick")).getText();

        Assert.assertEquals(actualmessage,expectedMessage);
        System.out.println(actualmessage);

        //Kliknij prawym przyciskiem myszki na przycisk „KLIKNIJ RIGHT” i zweryfikuj czy został wyświetlony komunikat: „Przycisk RIGHT został kliknięty”
        WebElement klikniecieprawym = driver.findElement(By.id("rightClick"));
        builder.contextClick(klikniecieprawym).perform();

        String spodziewana ="Przycisk RIGHT został kliknięty";
        String aktualna = driver.findElement(By.id("rightClickInfo")).getText();

        Assert.assertEquals(aktualna,spodziewana);

        System.out.println(spodziewana);


        //Wprowadź w pole nazwisko: wartość tekstową: „NOWAK” i zweryfikuj czy jest obecny w polu.
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();

        //Tekst: „NOWAK” obecny w polu Nazwisko
    }
}
