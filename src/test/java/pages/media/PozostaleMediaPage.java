package pages.media;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PozostaleMediaPage {

    private WebDriver driver;
    private Waits wait;

    private static final String sciezkaDoPlikuMedia = PropertiesReader.read("sciezkaDoPlikuMedia");
    private static final String nazwaPlikuMultimedia = PropertiesReader.read("nazwaPlikuMultimedia");

    // Poprawny URL podstrony "Pozostałe media"
    private String poprawnyUrlPozostaleMedia = "https://mmrmqpr585.publigo.onl/wp-admin/upload.php";

    // Poprawny tytuł podstrony "Pozostałe media"
    private String poprawnyTytulPozostaleMedia = "Biblioteka mediów ‹ Platforma kursów online — WordPress";


    // Button znajdujący się pod nagłówkiem strony
    @FindBy(xpath = "//a[text()='Dodaj nowy plik multimedialny']")
    private WebElement dodajNowyPlikMultimedialnyButton;

    // Tekst znajdujący się pod przyciskiem "Dodaj nowy plik multimedialny"
    @FindBy(xpath = "//b[text()='Uwaga! Jeśli chcesz przesłać pliki wideo do platformy, skorzystaj z zakładki ']")
    private WebElement jestChceszPrzeslacPlikiWideoText;

    // Button pojawiający się po kliknięciu buttona "Dodaj nowy plik multimedialny"
    @FindBy(xpath = "//button[text()='Wybierz pliki']")
    private WebElement wybierzPlikiButton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement przeslijPlikMultimedialnyInput;

    // Tekst znajdujący się pod buttonem "Wybierz pliki"
    @FindBy(xpath = "//p[contains(text(), 'Maksymalna wielkość dodawanych plików: 3 GB.')]")
    private WebElement getMaksymalnaWielkoscPlikuText;

    @FindBy(xpath = "//div[contains(@class, 'centered')]/img")
    private List<WebElement> multimedia;

    @FindBy(className = "media-uploader-status")
    private WebElement szukajMediowInput;



    public PozostaleMediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPoprawnyUrlStrony() {
        return poprawnyUrlPozostaleMedia;
    }

    public String getPoprawnyTytulStrony() {
        return poprawnyTytulPozostaleMedia;
    }

    public WebElement getDodajNowyPlikMultimedialnyButton() {
        return dodajNowyPlikMultimedialnyButton;
    }

    public WebElement getJestChceszPrzeslacPlikiWideoText() {
        return jestChceszPrzeslacPlikiWideoText;
    }

    public WebElement getWybierzPlikiButton() {
        return wybierzPlikiButton;
    }

    public WebElement getMaksymalnaWielkoscPlikowText() {
        return getMaksymalnaWielkoscPlikuText;
    }

    public void nacisnijDodajNowyPlikMultimedialnyButton() {
        wait.waitForVisibility(dodajNowyPlikMultimedialnyButton).click();
    }

    public void przeslijPlikPng(){

        wait.waitForPresent(By.xpath("//input[@type='file']"));
        przeslijPlikMultimedialnyInput.sendKeys(sciezkaDoPlikuMedia);
    }

    public boolean weryfikacjaCzyPrzeslanyPlikJestWidoczny(){

        boolean status = false;

        wait.waitForAttributeToBe(szukajMediowInput, "style", "display: none;");

        String URLPliku = multimedia.get(0).getAttribute("src");

        if(URLPliku.contains(nazwaPlikuMultimedia)){
            status = true;
            System.out.println("Przeslany plik jest widoczny w bibliotece mediow.");
        }

      return status;
    }
}
