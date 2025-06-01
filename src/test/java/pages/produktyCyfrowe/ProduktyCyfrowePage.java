package pages.produktyCyfrowe;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProduktyCyfrowePage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Wideo
    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-digital-products";

    // Poprawny tytuł podstrony "Wideo"
    private String poprawnyTytulWideo = "Produkty cyfrowe ‹ Platforma kursów online — WordPress";

    // Button "Utwórz nowy produkt cyfrowy" znajdujący się pod nagłówkiem strony
    @FindBy(xpath = "//button[text()='Utwórz nowy produkt cyfrowy']")
    private WebElement utworzNowyProduktButton;

    // Button "Typy danych" znajdujący się w prawym-górnym rogu strony
    @FindBy(xpath = "//button[text()='Typy danych']")
    private WebElement typyDanychButton;

    public ProduktyCyfrowePage(WebDriver driver) {
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

    public WebElement getUtworzNowyProduktButton() {
        return utworzNowyProduktButton;
    }

    public WebElement getTypyDanychButton() {
        return typyDanychButton;
    }

    // Czeka na pojawienie się okna i dopiero szuka elementu
    public WebElement getPodajNazweProduktuCyfrowegoPole() {
        return wait.waitForPresent(By.xpath("//input[@id='name']"));
    }

    // Czeka na pojawienie się okna i dopiero szuka elementu
    public WebElement getCenaPole() {
        return wait.waitForPresent(By.xpath("//input[@id='price']"));
    }

    // Czeka na pojawienie się okna i dopiero szuka elementu
    public WebElement getUtworzIEdytujButton() {
        return wait.waitForPresent(By.xpath("//button[text()='Utwórz i edytuj']"));
    }

    // Checkboxy pojawiające się dopiero po kliknięciu przycisku "Typy danych"
    public List<WebElement> getCheckboxyKolumnTabeli() {
        return driver.findElements(By.className("checkbox-replacement"));
    }

    public void kliknijUtworzNowyProduktButton() {
        utworzNowyProduktButton.click();
    }

    public void kliknijTypyDanychButton() {
        typyDanychButton.click();
    }

    // Wypełnia pole "Nazwa produktu cyfrowego podanym argumentem String
    public void wypelnijPoleNazwaProduktuCyfrowego(String nazwa) {
        getPodajNazweProduktuCyfrowegoPole().clear();
        getPodajNazweProduktuCyfrowegoPole().sendKeys(nazwa);
    }

    // Wypełnia pole "Nazwa produktu cyfrowego podanym argumentem String
    public void wypelnijPoleCena(float cena) {
        getCenaPole().clear();
        getCenaPole().sendKeys(Float.toString(cena));
    }

    // Wykonuje cały proces utworzenia nowego produktu cyfrowego
    public void utworzNowyProduktCyfrowy(String nazwa, float cena) {
        kliknijUtworzNowyProduktButton();
        wypelnijPoleNazwaProduktuCyfrowego(nazwa);
        wypelnijPoleCena(cena);
        getUtworzIEdytujButton().click();
    }

    // Wybiera pierwszy produkt z listy produktów cyfrowych i w niego wchodzi
    // W przypadku nieznalezienia wyrzuca NoSuchElementException
    public void wejdzWPierwszyProduktCyfrowyZListy() {
        try {
            wait.waitForPresent(By.xpath("//tr[1]/td[@class='type-id']/a")).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Nie można odnaleźć pierwszego elementu w liście produktów cyfrowych");
        }
    }

}
