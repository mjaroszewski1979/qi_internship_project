package pages.media;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WideoPage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Wideo
    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-videos";

    // Zmienna przechowująca oczekiwaną nazwę pliku wideo
    private String poprawnaNAzwaPlikuWideo = "fajny_piesek.mp4";

    // Poprawny tytuł podstrony "Wideo"
    private String poprawnyTytulWideo = "Wideo ‹ Platforma kursów online — WordPress";

    // Lista checkboxów pojawiających się w menu po kliknięciu buttona "Typy danych"
    @FindBy(linkText = "Dodaj wideo")
    private WebElement dodajWideoButton;

    // Button "Typy danych" znajdujący się w prawym-górnym rogu strony "Wideo"
    @FindBy(xpath = "//button[text()='Typy danych']")
    private WebElement typyDanychButton;

    // Definicja elementu reprezentującego nazwę przesłanego pliku wideo w tabeli
    @FindBy(xpath ="//td[@class='type-default' and text()='fajny_piesek.mp4']") private WebElement nazwaPlikuWideo;


    public WideoPage(WebDriver driver) {
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

    public WebElement getDodajWideoButton() {
        return dodajWideoButton;
    }

    public WebElement getTypyDanychButton() {
        return typyDanychButton;
    }

    // Checkboxy pojawiające się dopiero po kliknięciu przycisku "Typy danych" (łącznie 5 elementów)
    public List<WebElement> getCheckboxyKolumnTabeli() {
        return driver.findElements(By.className("checkbox-replacement"));
    }

    public void kliknijDodajWideoButton() {
        dodajWideoButton.click();
    }

    public void kliknijTypyDanychButton() {
        typyDanychButton.click();
    }

    // Metoda zwracająca oczekiwaną (poprawną) nazwę pliku wideo
    public String zwrocNazwePlikuWideo() {
        String rzeczywsitaNazwaWideo = wait.waitForVisibility(nazwaPlikuWideo).getText();
        System.out.println("Rzeczywista nazwa pliku wideo: " + rzeczywsitaNazwaWideo);
        return rzeczywsitaNazwaWideo;
    }

    // Metoda zwracająca rzeczywistą nazwę pliku wideo po jego przesłaniu
    public String zwrocPoprawnaNAzwaPlikuWideo() {
        System.out.println("Oczekiwana nazwa pliku wideo: " + poprawnaNAzwaPlikuWideo);
        return poprawnaNAzwaPlikuWideo;
    }

}
