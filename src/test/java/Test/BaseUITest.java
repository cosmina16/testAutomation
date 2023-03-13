package Test;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class BaseUITest {
    WebDriver driver;
    String url;
    String sigUpPath;
    String browser;
    String signUpPageUrl;

    @BeforeClass
    public void setUp() throws IOException {
        Properties properties = SeleniumUtils.readProperties("src\\test\\resources\\application.properties");

        url = properties.getProperty("url");
        sigUpPath = properties.getProperty("signUpPath");
        browser = properties.getProperty("browser");
        signUpPageUrl = url + sigUpPath;

        System.out.println("Default browser: " + browser);
        System.out.println("Page under test: " + signUpPageUrl);
    }

    @AfterClass
    public void close() {
        // close the browser
//        if(driver != null)
//            driver.quit();
    }

}