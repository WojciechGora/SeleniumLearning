import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wypelnienie_ankiety {
    public static WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("http://www.selenium-shop.pl/");
        driver.manage().window().maximize();


        //krok 1 wchodzimy do ankiety
        WebElement ankieta_enter = driver.findElement(By.linkText("ANKIETA"));
        ankieta_enter.click();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");



        //krok 2 wypelniamy imie i nazwisko
        WebElement imieInput = driver.findElement(By.id("Imię"));
        imieInput.clear();
        imieInput.sendKeys("Wojciech");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");

        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Denys");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");

        //krok 3 zaznaczamy mezczyzne - sprawdzamy czy cos juz nie jest zaznaczone
        WebElement facetButton = driver.findElement(By.xpath("//input[@value='Mężczyzna']"));

        if (!facetButton.isSelected()) {
            facetButton.click();
        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");

        //krok4 zaznaczamy przedzial wiekowy
        WebElement wiekButton = driver.findElement(By.xpath("//input[@value='20-29']"));

        if (!wiekButton.isSelected()) {
            wiekButton.click();

        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");

        //krok5 zaznaczamy torbe
        WebElement produktcheckbox = driver.findElement(By.xpath("//input[@value='Torba sportowa']"));

        if (!produktcheckbox.isSelected()) {
            produktcheckbox.click();
        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("After Sleeping");

        //krok6 wybieramy z listy jaki sport uprawiamy

        Select listazesportami = new Select(driver.findElement(By.name("Sport")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", listazesportami);
        listazesportami.selectByVisibleText("Siatkówka");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        //krok7 wybieramy marke

        Select listamarek = new Select(driver.findElement(By.id("Marki")));
        listamarek.deselectAll();
        listamarek.selectByVisibleText("Kappa");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        //8 klikamy wyslij
        WebElement wyslij = driver.findElement(By.id("Wyslij"));
        wyslij.click();
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        //9 sprawdzamy czy pojawi sie komunikat
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        //Krok 10
        WebElement wysłaneDane_Komunikat = driver.findElement(By.xpath("//*[contains(text(),'Wysłane dane')]"));
        Assert.assertTrue(wysłaneDane_Komunikat.isDisplayed());
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        WebElement wyslaneinfo = driver.findElement(By.id("info"));
        System.out.println(wyslaneinfo.getText());
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Problem ze sleeping");
        }

        System.out.println("After Sleeping");

        driver.quit();


    }
}