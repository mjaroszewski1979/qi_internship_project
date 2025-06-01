package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PakietyPage {

    /************************ Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstruktor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public PakietyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLStronyPakiety = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-packages";

    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyPakiety = "Pakiety ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//button[contains(text(), 'Dodaj pakiet')]")
    private WebElement utworzNowyPakietButton;

    @FindBy(xpath = "//h2[contains(text(), 'Utwórz nowy pakiet')]")
    private WebElement utworzNowyPakiet;

    @FindBy(xpath = "//input[contains(@name, 'name')]")
    private WebElement nazwaPakietuInput;

    @FindBy(xpath = "//input[contains(@name, 'price')]")
    private WebElement cenaPakietuInput;

    @FindBy(xpath = "//button[contains(@id, 'save-bundles_popup_editor')]")
    private WebElement utworzIEdytujButton;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Pakiety' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlPakiety() {
        System.out.println("Poprawny URL strony pakietów: " + poprawnyURLStronyPakiety);
        return poprawnyURLStronyPakiety;
    }

    //zwrócenie aktualnego url strony i wypisanie go w konsoli
    public String zwrocUrlAktualnejStrony() {
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwrócenie poprawnego tytułu strony 'Pakiety' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyPakiety() {
        System.out.println("Poprawny tytuł strony pakietów: " + poprawnyTytulStronyPakiety);
        return poprawnyTytulStronyPakiety;
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    //utworzenie nowego pakietu
    public void dodajNowyPakiet(){
        przejdzDoDodaniaNowegoPakietu();
        poczekajNaOknoUtworzNowyPakiet();
        wpiszNazwePakietu();
        wpiszCenePakietu();
        nacisnijPrzyciskUtworzIEdytuj();
    }

    //kliknięcie przycisku 'Dodaj pakiet'
    public void przejdzDoDodaniaNowegoPakietu() {
        wait.waitForClickability(utworzNowyPakietButton).click();
    }

    //oczekiwanie na pojawienie się okna 'Utwórz nowy pakiet'
    public void poczekajNaOknoUtworzNowyPakiet() {
        wait.waitForVisibility(utworzNowyPakiet);
    }

    //wpisanie nazwy pakietu
    public void wpiszNazwePakietu() {
        wait.waitForClickability(nazwaPakietuInput).clear();
        wait.waitForVisibility(nazwaPakietuInput).sendKeys("Test pakiet");
    }

    //wpisanie ceny pakietu
    public void wpiszCenePakietu() {
        wait.waitForClickability(cenaPakietuInput).clear();
        wait.waitForVisibility(cenaPakietuInput).sendKeys("1599");
    }

    //kliknięcie przcisku 'Utwórz i edytuj'
    public void nacisnijPrzyciskUtworzIEdytuj() {
        wait.waitForClickability(utworzIEdytujButton).click();
    }

/********************************** Operacje na Webelementach KONIEC ******************************************/

}
