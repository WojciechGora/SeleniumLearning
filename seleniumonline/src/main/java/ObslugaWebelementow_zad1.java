import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ObslugaWebelementow_zad1 {
    public static WebDriver driver;

    @Test
    public void zad1() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");

        //Przejdź do zakładki Ankieta
        WebElement sklepMenu = driver.findElement(By.linkText("ANKIETA"));
        sklepMenu.click();

        //Uzupełnij swoim imieniem pole Imię
        WebElement imieinput = driver.findElement(By.id("Imię"));
        imieinput.clear();
        imieinput.sendKeys("Wojciech");

        //Wybierz odpowiednią dla siebie opcję z sekcji Płeć

        WebElement wybierzplec = driver.findElement(By.xpath("//input[@value='Mężczyzna']"));
        if (!wybierzplec.isSelected()) {
            wybierzplec.click();
        }

        //Wybierz odpowiednią dla siebie opcję z sekcji Podaj wiek
        WebElement wiek = driver.findElement(By.xpath("//input[@value='20-29']"));
        wiek.click();

        //W pole Twój komentarz wpisz miasto w którym mieszkasz
        WebElement komentarz = driver.findElement(By.id("Komentarz"));
        komentarz.sendKeys("Wrocław");

        //Zweryfikuj czy na stronie widoczny jest przycisk Wyślij i wypisz odpowiednią informację (czy jest widoczny czy też nie)
        WebElement wyslijbutton = driver.findElement(By.id("Wyslij"));

        if (wyslijbutton.isDisplayed()) {
            System.out.println("Przycisk jest widoczny");
            wyslijbutton.click();
        } else {
            System.out.println("Przycisk nie jest widoczny");
        }

        //Wypisz w konsoli informacje z sekcji Wysłane dane
        WebElement wyslanedane = driver.findElement(By.id("info"));
        System.out.println(wyslanedane.getText());

        //Zamknij przeglądarkę
        driver.close();




    }
}
