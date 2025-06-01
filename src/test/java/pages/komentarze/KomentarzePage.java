package pages.komentarze;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KomentarzePage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Komentarze"
    private String poprawnyUrlPozostaleMedia = "https://mmrmqpr585.publigo.onl/wp-admin/edit-comments.php";

    // Poprawny tytuł podstrony "Komentarze"
    private String poprawnyTytulPozostaleMedia = "Komentarze (1) ‹ Platforma kursów online — WordPress";

    // Pole tekstowe po prawej stronie ekranu obok buttona "Szukaj komentarzy"
    @FindBy(id = "comment-search-input")
    private WebElement poleSzukajKomentarza;

    // Button po prawej stronie ekranu obok pola tekstowego
    @FindBy(id = "search-submit")
    private WebElement szukajKomentarzyButton;

    // Lista rozwijana "Działania Masowe" znajdująca się po lewej stronie od buttona "Zastosuj"
    @FindBy(id = "bulk-action-selector-top")
    private WebElement dzialaniaMasoweLista;

    // Lista rozwijana "Wszystkie typy komentarzy" znajdująca się między buttonami "Zastosuj" oraz "Przefiltruj"
    @FindBy(id = "filter-by-comment-type")
    private WebElement wszystkieTypyKomentarzyLista;

    // Button "Zastosuj" między dwiema rozwijanymi listami
    @FindBy(xpath = "//input[@id='doaction']")
    private WebElement zastosujButton;

    // Button "Przefiltruj" nam listą komentarzy
    @FindBy(xpath = "//input[@id='post-query-submit' and @value='Przefiltruj']")
    private WebElement przefiltrujButton;

    // Elementy menu znajdujące się pod nagłówkiem "Komentarze"
    @FindBy(xpath = "//ul[@class='subsubsub']/li/a")
    private List<WebElement> elementyMenu;

    // Wszystkie komentarze na stronie
    @FindBy(xpath = "//td[@data-colname='Komentarz']")
    private List<WebElement> komentarze;

    // Wszystkie checkboxy do komentarzy na stronie
    @FindBy(xpath = "//input[@name='delete_comments[]']")
    private List<WebElement> checkboxyKomentarzy;

    public KomentarzePage(WebDriver driver) {
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

    public WebElement getPoleSzukajKomentarza() {
        return poleSzukajKomentarza;
    }

    public WebElement getSzukajKomentarzyButton() {
        return szukajKomentarzyButton;
    }

    public WebElement getZastosujButton() {
        return zastosujButton;
    }

    public WebElement getPrzefiltrujButton() {
        return przefiltrujButton;
    }

    public WebElement getDzialaniaMasoweLista() {
        return dzialaniaMasoweLista;
    }

    public WebElement getWszystkieTypyKomentarzyLista() {
        return wszystkieTypyKomentarzyLista;
    }

    public List<WebElement> getElementyMenu() {
        return elementyMenu;
    }

    public List<WebElement> getKomentarze() {
        return komentarze;
    }

    public List<WebElement> getCheckboxyKomentarzy() {
        return checkboxyKomentarzy;
    }
}
