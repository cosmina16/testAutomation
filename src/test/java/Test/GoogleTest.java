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
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void SearchGoogleTest() {
        driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement acceptCookiesButton = driver.findElement(By.id("L2AGLb"));
        acceptCookiesButton.click();

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Atelierul Digital", Keys.ENTER);
    }
}