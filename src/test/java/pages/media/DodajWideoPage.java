package pages.media;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DodajWideoPage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Dodaj wideo"
    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-video-uploader";

    // Poprawny tytuł podstrony "Dodaj wideo"
    private String poprawnyTytulWideo = "‹ Platforma kursów online — WordPress";

    // Zmienna przechowująca lokalną ścieżkę do pliku wideo, który ma być przesłany.
    // Uwaga: Ścieżka jest absolutna i unikalna dla konkretnego użytkownika.
    // Przed uruchomieniem testu należy zmienić ją na własną, poprawną ścieżkę absolutną na swoim komputerze — to bardzo ważne dla poprawnego działania testu.
    private String sciezkaDoPlikuWideo =  PropertiesReader.read("sciezkaPlikWideo");

    // Nagłówek strony "Dodaj wideo" znajdujący się nad oknem do upuszczenia pliku wideo
    @FindBy(xpath = "//h1[text()='Prześlij pliki wideo']")
    private WebElement naglowekPrzeslijPlikWideo;

    // Tekst u samej góry strony informujący o tym, że nie będzie możliwości pobrania wgranych na serwer wideo
    @FindBy(xpath = "//b[text()=' Uwaga! Po wczytaniu plików wideo, nie będzie możliwości pobierania ich z poziomu platformy. ']")
    private WebElement nieBedzieMozliwosciPobraniaText;

    // Button na samym środku ekranu do kliknięcia lub przeciągnięcia na niego plików wideo
    @FindBy(xpath = "//button[text()='Upuść pliki wideo tutaj lub kliknij, aby przesłać je na serwer.']")
    private WebElement upuscPlikiWideoTutajButton;

    // Button "Wróć" znajdujący się w prawym-dolnym rogu strony
    @FindBy(xpath = "//a[text()=' Wróć    ']")
    private WebElement wrocButton;

    // Definicja ukrytego inputa do przesyłania plików
    @FindBy(className ="dz-hidden-input") private WebElement inputPrzeslijWideo;

    // Definicja ikony potwierdzającej poprawne przesłanie pliku
    @FindBy(className ="dz-success-mark") private WebElement ikonaPoprawnegoPrzeslaniaPliku;

    public DodajWideoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPoprawnyUrlStrony() {
        return poprawnyUrlWideo;
    }

    public String getPoprawnyTytulStrony() {
        return poprawnyTytulWideo;
    }

    public WebElement getNaglowekPrzeslijPlikWideo() {
        return naglowekPrzeslijPlikWideo;
    }

    public WebElement getNieBedzieMozliwosciPobraniaText() {
        return nieBedzieMozliwosciPobraniaText;
    }

    public WebElement getUpuscPlikiWideoTutajButton() {
        return upuscPlikiWideoTutajButton;
    }

    public WebElement getWrocButton() {
        return wrocButton;
    }

    // Metoda przesyłająca plik wideo
    public void przeslijWideo() {

        // Odblokowanie ukrytego inputa za pomocą JavaScript (ustawienie jego widoczności, wielkości i pozycji)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.visibility='visible';" +
                        "arguments[0].style.height='1px';" +
                        "arguments[0].style.width='1px';" +
                        "arguments[0].style.opacity='1';" +
                        "arguments[0].style.position='static';",
                inputPrzeslijWideo
        );

        // Przesłanie pliku wideo przez przypisanie ścieżki do inputa
        inputPrzeslijWideo.sendKeys(sciezkaDoPlikuWideo);

        // Oczekiwanie na pojawienie się ikony potwierdzającej przesłanie pliku
        wait.waitForVisibility(ikonaPoprawnegoPrzeslaniaPliku);

        // Kliknięcie przycisku powrotu po poprawnym przesłaniu pliku
        wait.waitForClickability(wrocButton).click();
    }

}
