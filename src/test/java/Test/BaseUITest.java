package Test;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

//paret de incarcare a driverului
    //si parte de inchidere browser
public class BaseUITest {
    //prin relatie de mostenire
    //test de baza care contine ce se intampla la inceput si
        //ce se intampla la final= inchisul browserului

    //am atributele astea ca testul sa mearga pt
        // orice driver,orice site, oirce link de inregistrare...
    WebDriver driver;
    String url;
    String sigUpPath;
    String browser;
    String signUpPageUrl; //link complet

    @BeforeClass
    //daca path-ul nu exista intorc o exceptie(input ouput exception)
        //semnalizeaza ca nu exista fisierul
    public void setUp() throws IOException {
        //properties e o lcasa care e in java utils

        //"\" dupa de t - tab
        //"\\" anuleaza ce e mai sus(de aia am pus 2*\)
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