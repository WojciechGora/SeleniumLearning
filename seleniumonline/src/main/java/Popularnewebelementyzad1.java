import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Popularnewebelementyzad1 {

    public static WebDriver driver;

    @Test
    public void scenariusz() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        Actions builder = new Actions(driver);


        driver.navigate().to("http://www.selenium-shop.pl/");


//    Wejdź na stronę główną: http://www.selenium-shop.pl/o-nas/
        driver.get("http://www.selenium-shop.pl/o-nas/");

//    Wykonaj dwuklik na przycisku: DWUKLIK POKAŻ KOMUNIKAT
        WebElement dwuklikButton = driver.findElement(By.xpath("//input[@value='Dwuklik pokaż komunikat']"));
        builder.doubleClick(dwuklikButton).perform();

//    Zweryfikuj czy komunikat: Przycisk dwuklik został kliknięty, jest wyświetlony na stronie

        WebElement komunikat = driver.findElement(By.id("p-doubleClick"));
        Assert.assertTrue(komunikat.isDisplayed());
        System.out.println("Komunikat jest widoczny");

//    Kliknij prawym przyciskiem myszy na przycisku: KLIKNIJ RIGHT

        WebElement rightclick = driver.findElement(By.id("rightClick"));
        builder.contextClick(rightclick).perform();

//    Zweryfikuj czy komunikat: Przycisk RIGHT został kliknięty, jest wyświetlony na stronie
        WebElement komunikatrightclick = driver.findElement(By.id("p-doubleClick"));
        Assert.assertTrue(komunikatrightclick.isDisplayed());
        System.out.println("Komunikat został wyświetlony");

//    Do pola imię wprowadź swoje imię pisane małymi literami -> z wykorzystaniem metody builder.keyDown() i przekazując jej do kliknięcia przycisk SHIFT tak, aby nasze imię zostało wprowadzone wielkimi literami

        WebElement imieInput = driver.findElement(By.id("Imię")) ;

        Action wielkalitera= builder.keyDown(imieInput, Keys.SHIFT)
                .sendKeys(imieInput, "tomasz")
                .keyUp(imieInput, Keys.SHIFT)
                .build();

        wielkalitera.perform();

//    Zweryfikuj czy imię w polu Imię jest zapisane wielkimi literami
        Assert.assertEquals(imieInput.getAttribute("value"), "TOMASZ");
    }
}

