package pages.kursy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KursyPage {

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
    public KursyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLKursow = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-courses";

    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyKursy = "Kursy ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//a[contains(text(), 'Wszyscy uczestnicy')]")
    private WebElement zakladkaKursyWszyscyUczestnicyMenuBoczne;

    @FindBy(xpath = "//button[contains(text(), 'Utwórz nowy kurs')]")
    private WebElement utworzNowyKursButton;

    @FindBy(xpath = "//h2[contains(text(), 'Utwórz nowy kurs')]")
    private WebElement utworzNowyKurs;

    @FindBy(xpath = "//input[contains(@name, 'name')]")
    private WebElement nazwaKursuInput;

    @FindBy(xpath = "//input[contains(@name, 'price')]")
    private WebElement cenaKursuInput;

    @FindBy(xpath = "//button[contains(@id, 'save-courses_popup_editor')]")
    private WebElement utworzIEdytujButton;

    @FindBy(xpath = "//button[contains(text(), 'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(xpath = "//p[contains(text(), 'Wybierz które kolumny mają być widoczne w tabeli')]")
    private WebElement sekcjaWybierzKtoreElementyMajaBycWidoczne;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Kursy' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlKursow() {
        System.out.println("Poprawny URL strony kursów: " + poprawnyURLKursow);
        return poprawnyURLKursow;
    }

    //zwrócenie aktualnego url strony i wypisanie go w konsoli
    public String zwrocUrlAktualnejStrony() {
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwrócenie poprawnego tytułu strony 'Kursy' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyKursy() {
        System.out.println("Poprawny tytuł strony kursów: " + poprawnyTytulStronyKursy);
        return poprawnyTytulStronyKursy;
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    //przejście do zakładki 'Wszyscy uczestnicy'
    public void przejdzDoZakladkiKursyWszyscyUczestnicy() {
        wait.waitForClickability(zakladkaKursyWszyscyUczestnicyMenuBoczne).click();
    }

    //kliknięcie przycisku 'Utwórz nowy kurs'
    public void przejdzDoTworzeniaNowegoKursu() {
        wait.waitForClickability(utworzNowyKursButton).click();
    }

    //oczekiwanie na pojawienie się okna 'Utwórz nowy kurs'
    public void poczekajNaOknoUtworzNowyKurs() {
        wait.waitForVisibility(utworzNowyKurs);
    }

    //wpisanie nazwy kursu
    public void wpiszNazweKursu() {
        wait.waitForVisibility(nazwaKursuInput).clear();
        wait.waitForVisibility(nazwaKursuInput).sendKeys("Test kurs");
    }

    //wpisanie ceny kursu
    public void wpiszCeneKursu() {
        wait.waitForClickability(cenaKursuInput).clear();
        wait.waitForVisibility(cenaKursuInput).sendKeys("100");
    }

    //kliknięcie przcisku 'Utwórz i edytuj'
    public void nacisnijPrzyciskUtworzIEdytuj() {
        wait.waitForClickability(utworzIEdytujButton).click();

    }

    //metoda wypisukąca, gdy przycisk 'Utwórz nowy kurs' nie jest wyświetlony i/lub aktywny
    public void sprawdzButtonUtworzNowyKurs() {
        if (!utworzNowyKursButton.isDisplayed()) {
            System.out.println("Przycisk 'Typy danych' NIE jest WYŚWIETLONY.");
        }
        if (!utworzNowyKursButton.isEnabled()) {
            System.out.println("Przycisk 'Typy danych' NIE jest AKTYWNY.");
        }
    }

    //metoda sprawdzajaca, czy przycisk 'Utwórz nowy kurs' jest wyświetlony i aktywny
    public boolean sprawdzCzyButtonUtworzNowyKursIstnieje() {
        boolean status = false;
        if (wait.waitForVisibility(utworzNowyKursButton).isDisplayed() &&
                wait.waitForVisibility(utworzNowyKursButton).isEnabled()) {
            status = true;
            System.out.println("Przycisk 'Utwórz nowy kurs' jest wyświetlony i aktywny.");
        }
        return status;
    }

    //naciśnięcie przycisku 'Typy danych'
    public void nacisnijButtonTypyDanych() {
        wait.waitForClickability(typyDanychButton).click();
    }

    //metoda wypisukąca, gdy przycisk 'Typy danych' nie jest wyświetlony i/lub aktywny
    public void sprawdzButtonTypyDanych() {
        if (!typyDanychButton.isDisplayed()) {
            System.out.println("Przycisk 'Typy danych' NIE jest WYŚWIETLONY.");
        }
        if (!typyDanychButton.isEnabled()) {
            System.out.println("Przycisk 'Typy danych' NIE jest AKTYWNY.");
        }
    }

    //metoda sprawdzajaca, czy przycisk 'Typy danych' jest wyświetlony i aktywny
    public boolean sprawdzCzyButtonTypyDanychIstnieje() {
        boolean status = false;
        if (wait.waitForVisibility(typyDanychButton).isDisplayed() &&
                wait.waitForVisibility(typyDanychButton).isEnabled()) {
            status = true;
            System.out.println("Przycisk 'Typy danych' jest wyświetlony i aktywny.");
        }
        return status;
    }

    //metoda sprawdzajaca, czy sekcja 'Wybierz, które kolumny mają być widoczne w tabeli' jest wyświetlona
    public boolean sprawdzCzySekcjaWybierzKtoreElementyMajaBycWidoczneJestWyswietlona() {
        boolean status = false;
        if (wait.waitForVisibility(sekcjaWybierzKtoreElementyMajaBycWidoczne).isDisplayed()) {
            status = true;
            System.out.println("Sekcja 'Wybierz, które kolumny mają być widoczne w tabeli' jest wyświetlona.");
        }
        return status;
    }

    //sprawdzenie i wypisanie do konsoli wyświetlenia i aktywności pól 'Nazwa kursu' i 'Cena'
    public void sprawdzPolaNazwaKursuICena() {
        if (!nazwaKursuInput.isDisplayed()) {
            System.out.println("Pole 'Nazwa kursu' NIE jest WYŚWIETLONE.");
        }
        if (!nazwaKursuInput.isEnabled()) {
            System.out.println("Pole 'Nazwa kursu' NIE jest AKTYWNE.");
        }
        if (!cenaKursuInput.isDisplayed()) {
            System.out.println("Pole 'Cena' NIE jest WYŚWIETLONE.");
        }
        if (!cenaKursuInput.isEnabled()) {
            System.out.println("Pole 'Cena' NIE jest AKTYWNE.");
        }
    }

    //metoda sprawdzajaca, czy pola 'Nazwa kursu' i 'Cena' są wyświetlone i aktywne do assercji
    public boolean sprawdzCzyPoleNazwaKursuICenaIstnieje() {
        boolean status = false;

        if (wait.waitForVisibility(nazwaKursuInput).isDisplayed() &&
                wait.waitForVisibility(nazwaKursuInput).isEnabled() &&
                wait.waitForVisibility(cenaKursuInput).isDisplayed() &&
                wait.waitForVisibility(cenaKursuInput).isEnabled()) {
            status = true;
            System.out.println("Pola 'Nazwa kursu' i 'Cena' są wyświetlone i aktywne.");
        }
        return status;
    }

    //metoda wypisukąca do konsoli, gdy przycisk 'Utwórz i edytuj' nie jest widoczny i/lub aktywny
    public void sprawdzPrzyciskUtworzIEdytuj() {
        if (!utworzIEdytujButton.isDisplayed()) {
            System.out.println("Przycisk 'Utwórz i edytuj' NIE jest WYŚWIETLONY.");
        }
        if (!utworzIEdytujButton.isEnabled()) {
            System.out.println("Przycisk 'Utwórz i edytuj' NIE jest AKTYWNY.");
        }
    }

    //metoda sprawdzajaca, czy w oknie 'Utwórz nowy kurs' znajduje się przycisk 'Utwórz i edytuj' do assercji
    public boolean sprawdzCzyPrzyciskUtworzIEdytujIstnieje () {
        boolean status = false;

        if (wait.waitForVisibility(utworzIEdytujButton).isDisplayed() &&
                wait.waitForVisibility(utworzIEdytujButton).isEnabled()) {
            status = true;
            System.out.println("Przycisk 'Utwórz i edytuj' jest wyświetlony i aktywny.");
        }
        return status;
    }

}
/********************************** Operacje na Webelementach KONIEC ******************************************/


