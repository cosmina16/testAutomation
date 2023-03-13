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

    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;

        switch (Objects.requireNonNull(getBrowserEnumFromString(browserType))) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
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


    public static Browser getBrowserEnumFromString(String browserType) {
        for (Browser browser : Browser.values()) {
            if (browserType.equalsIgnoreCase(browser.toString())) {
                return browser;
            }
        }
        return null;
    }

    public static Properties readProperties(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

}