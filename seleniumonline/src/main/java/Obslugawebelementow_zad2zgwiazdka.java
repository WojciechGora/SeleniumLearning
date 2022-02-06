import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Obslugawebelementow_zad2zgwiazdka  {

    public static WebDriver driver;

    @Test
    public void zad3gwiazdka() throws InterruptedException {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();



        //Wejdź w wyszukiwarkę google ( https://www.google.pl/ )
        driver.get("http://www.google.pl/");

        //zatwierdzenie
        WebElement zatwierzenie = driver.findElement(By.id("L2AGLb"));
        zatwierzenie.click();

        //Wpisz w pole wyszukiwarki tekst: „od laika do automatyka„
        WebElement wyszukiwanie = driver.findElement(By.name("q"));
        wyszukiwanie.sendKeys("od laika do automatyka");

        WebElement szukajwgoogleclick = driver.findElement(By.xpath("//input[@class = 'gNO89b']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", szukajwgoogleclick);


        //Z listy wyszukiwań kliknij pozycję odlaikadoautomatyka.pl

        WebElement wejsciwlink = driver.findElement(By.xpath("//h3[@class= 'LC20lb MBeuO DKV0Md']"));
        wejsciwlink.click();

        //Zweryfikuj tytył strony. Wypisz odpowiednią informację
        WebElement tytul = driver.findElement(By.xpath("//h1[text()='Testy automatyczne']"));
        System.out.println("Tytuł strony to: " + tytul.getText());

        //Kliknij w zakładkę FAQ

        WebElement faq = driver.findElement(By.linkText("FAQ"));
        faq.click();
        Thread.sleep(1000);


        //Rozwiń sekcję „DLA KOGO DEDYKOWANY JEST KURS?”
        WebElement dlakogo = driver.findElement(By.xpath("//h5[text() = 'DLA KOGO DEDYKOWANY JEST KURS?']"));
        dlakogo.click();
        Thread.sleep(1000);

        //Pobierz rozwinięty tekst i wypisz go do konsoli

        WebElement litania = dlakogo.findElement(By.xpath("//*[@style='display: block;']"));
        System.out.println(litania.getText());

    }
}