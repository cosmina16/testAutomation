package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {
    //WebDriver - de la selenium si
    // face interactiunea cu web-ul cu pagina
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();//se executa inainte de fiecare clasa
        //fac set-ul unui browser(chrome)-setez existenta unui driver de chrome
        //exista un driver atunci cand noi dam click
    }

    @Test
    public void SearchGoogleTest() {
        //instantiz driver-ul
        driver = new ChromeDriver();
        driver.get("https://google.com");

        //butoanele = WebElement asa le vede selenium
        //By -e o clasa(sau se poate dupa CSS selesct)

        //iau butonul in variabila acc..
        WebElement acceptCookiesButton = driver.findElement(By.id("L2AGLb"));
        acceptCookiesButton.click();

        //scriem un stir de caractere(ce vrem sa cautam) si ce tasta vrem sa apasam
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Atelierul Digital", Keys.ENTER);
    }
}