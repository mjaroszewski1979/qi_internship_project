package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.ExtentReportManager;
import config.PropertiesReader;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import java.lang.reflect.Method;

import java.util.Base64;


public class TestBase {

    //Tworzenie instancji przeglądarki
    public WebDriver driver = null;
    //tworzymy juz instacje raportu ExtentReports
    private static ExtentReports extent = ExtentReportManager.getInstance();
    protected ExtentTest test;


    private static final String url =  PropertiesReader.read("url");
    private static final String browser =  PropertiesReader.read("browser");

  //Tutaj znajdują się operacje ktore zostaną wykonane przed każdym testem
@BeforeMethod
public void setUp(Method method) {
    test = extent.createTest(method.getName());

        // Ustawienia, konfiguracja przeglądarki Chrome
     ChromeOptions options = new ChromeOptions();
     EdgeOptions edgeOptions = new EdgeOptions();

     //włącza tryb maxymalizacji okna - maxymalizuje okno przeglądarki
     options.addArguments("--start-maximized");

     //wyłaczenie pytania o domyslna przelgadarke i wyszukiwarkę, typowa linia techniczna
     options.addArguments("–disable-search-engine-choice-screen");

     //włącza tryb bezpieczeństwa (incognito) - przeglądarka nie będzie przechowywana w pamięci klienckie
     //options.addArguments("--incognito");

        // wyłącza przechowywanie pamięci podręcznej - nie przechowuje pamięci podręcznej przeglądarki
        options.addArguments("--disable-application-cache");

        edgeOptions.addArguments("--start-maximized");


        //uruchominie przeglądarki Chrome z opcjami, ktore ustawilismy wyżej


        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(edgeOptions);
        }


        //Wchodzimy na strone selenium-shop.pl
        driver.get(url);


    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test NIEPOWODZENIE: " + result.getThrowable());
            test.addScreenCaptureFromBase64String(takeScreenshot(), "Zrzut ekranu z błędem");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test zakończył się sukcesem");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test został pominięty: " + result.getThrowable());
        }

        driver.quit();
        extent.flush(); // 🔹 Zapisujemy raport HTML po każdym teście
    }

    private String takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return Base64.getEncoder().encodeToString(screenshot);
    }

}
