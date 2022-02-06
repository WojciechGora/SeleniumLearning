import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class ObslugaWebelementow_zad2 {
    public static WebDriver driver;

    @Test
    public void zad2() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Wejdź na stronę: http://www.selenium-shop.pl
        driver.get("http://www.selenium-shop.pl/");

        //Przejdź do zakładki Ankieta
        WebElement sklepMenu = driver.findElement(By.linkText("ANKIETA"));
        sklepMenu.click();

        //Z listy Jaki uprawiasz sport wybierz pozycję z dyscypliną sportu, którą najbardziej lubisz
        Select listasportow = new Select(driver.findElement(By.name("Sport")));
        listasportow.selectByVisibleText("Bieganie");

        //Wypisz w konsoli jaka pozycja jest wybrana
        System.out.println("Wybrana opcja z listy sportów to: " + listasportow.getFirstSelectedOption().getText());

        //Ponownie z listy Jaki uprawiasz sport wybierz pozycję z dyscypliną sportu, którą tym razem lubisz najmniej (wybierz pozycję inną metodą niż poprzednio
        listasportow.selectByValue("pilkaNozna");

        //Wypisz w konsoli jaka pozycja jest wybrana
        System.out.println("Nowa wybrana opcja to: " + listasportow.getFirstSelectedOption().getText());

        //Wypisz do konsoli wszystkie pozycje z listy Jaki uprawiasz sport
        for (int i = 0; i < listasportow.getOptions().size(); i++) {
            System.out.println("Nazwa sportu: " + listasportow.getOptions().get(i).getText());

        }
        driver.close();


    }
}
