package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumUtils {
//ca sa nu am o instanta de tipul seleniumutils o fac statica
    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
    //in functie de tipul de browser sa am un alt driver
        //fortez sa nu primesc ceva null
        switch (Objects.requireNonNull(getBrowserEnumFromString(browserType))) {
            case CHROME:
                //din bonigarcia desccarca driverul necesar
                WebDriverManager.chromedriver().setup();
                //din selenuim si porneste mecanisumul prin care comunic cu o pagina
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }

        return driver;
    }

    public static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        //Create instance of matcher
        Matcher matcher = pattern.matcher(email);


        System.out.println("IS EAMIL VALID: " + matcher.matches() + "email : " + email);
        return matcher.matches();
    }

    //daca cnv imi da de ex chrome(cu litera mica) el totusi sa imi returneszze un browser din enum-uri
    public static Browser getBrowserEnumFromString(String browserType) {
        //brousew.values() e un array cu toate elem din enum
        for (Browser browser : Browser.values()) {
            if (browserType.equalsIgnoreCase(browser.toString())) {
                return browser;
            }
        }
        return null;
    }

    //iau un fisier creez un obiect de tip properties
        //incarc in obiecr continutul acelui fisier(cheie valoare)
    public static Properties readProperties(String path) throws IOException {
        //modalitatea de a citi din fisier
        InputStream inputStream = new FileInputStream(path);
        //luam proprietatile din fisier
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

}