package tests.produktyCyfroweTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.produktyCyfrowe.EdytujProduktCyfrowyPage;
import pages.produktyCyfrowe.ProduktyCyfrowePage;
import tests.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class ProduktyCyfroweTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private ProduktyCyfrowePage produktyCyfrowePage;
    private EdytujProduktCyfrowyPage edytujProduktCyfrowyPage;

    @BeforeMethod
    public void setUpWideoPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        produktyCyfrowePage = new ProduktyCyfrowePage(driver);
        edytujProduktCyfrowyPage = new EdytujProduktCyfrowyPage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do strony "Produkty Cyfrowe"
    private void przejdzDoZakladkiProduktyCyfrowe() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiProduktyCyfrowe();
    }

    // Sprawdza czy adres URL strony "Produkty Cyfrowe" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Produkty Cyfrowe'")
    public void weryfikacjaAdresuUrlZakladkiProduktyCyfroweTest() {
        przejdzDoZakladkiProduktyCyfrowe();
        Assert.assertEquals(driver.getCurrentUrl(), produktyCyfrowePage.getPoprawnyUrlStrony(),
                "Adres URL strony jest niepoprawny");
    }

    // Sprawdza czy tytuł strony "Produkty Cyfrowe" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Produkty Cyfrowe'")
    public void weryfikacjaTytuluZakladkiProduktyCyfroweTest() {
        przejdzDoZakladkiProduktyCyfrowe();
        Assert.assertEquals(driver.getTitle(), produktyCyfrowePage.getPoprawnyTytulStrony(),
                "Tytuł strony jest niepoprawny");
    }

    // Sprawdza czy button "Utwórz nowy produkt cyfrowy" istnieje
    @Test(priority = 120, enabled = true, description = "Weryfikacja czy button 'Utwórz nowy produkt cyfrowy' istnieje")
    public void weryfikacjaCzyButtonUtworzNowyProduktCyfrowyIstniejeTest() {
        przejdzDoZakladkiProduktyCyfrowe();
        Assert.assertTrue(produktyCyfrowePage.getUtworzNowyProduktButton().isDisplayed(),
                "Nie znaleziono buttona 'Utwórz nowy produkt cyfrowy'");
    }

    // Sprawdza czy button "Typy danych" istnieje
    @Test(priority = 130, enabled = true, description = "Weryfikacja czy button 'Typy danych' istnieje")
    public void weryfikacjaCzyButtonTypyDanychIstniejeTest() {
        przejdzDoZakladkiProduktyCyfrowe();
        Assert.assertTrue(produktyCyfrowePage.getTypyDanychButton().isDisplayed(),
                "Nie znaleziono buttona 'Typy danych'");
    }

    // Sprawdza czy po kliknięciu buttona "Typy danych"
    // pojawia się menu z checkboxami elementów, które mają być widoczne w tabeli
    @Test(priority = 140, enabled = true, description =
            "Weryfikacja czy button 'Typy danych' rozwija menu wyboru checkboxów")
    public void weryfikacjaCzyButtonTypyDanychRozwijaMenuWyboruCheckboxowTest() {
        przejdzDoZakladkiProduktyCyfrowe();

        produktyCyfrowePage.kliknijTypyDanychButton();

        int oczekiwanaIloscCheckboxow = 4;
        int aktualnaIloscCheckboxow = produktyCyfrowePage.getCheckboxyKolumnTabeli().size();

        Assert.assertEquals(aktualnaIloscCheckboxow, oczekiwanaIloscCheckboxow,
                "Nie można poprawnie zweryfikować checkboxów w menu 'Typy danych'");
    }

    // Sprawdza czy po kliknięciu buttona "Utwórz nowy produkt cyfrowy"
    // pojawiają się pola "Nazwa produktu cyfrowego" oraz "Cena"
    @Test(priority = 150, enabled = true,
            description = "Weryfikacja czy button 'Dodaj wideo' wyświetla pola 'Nazwa produktu cyfrowego' oraz 'Cena'")
    public void weryfikacjaCzyButtonDodajWideoWyswietlaOdpowiedniePolaTest() {
        przejdzDoZakladkiProduktyCyfrowe();

        produktyCyfrowePage.kliknijUtworzNowyProduktButton();

        // Domyślna wiadomość asercji w przypadku gdyby nie można było odnaleźć obu elementów
        String wiadomoscBledu = "Nie znaleziono obu pól";

        // Domyślnie zakładamy, że pola nie są widoczne
        boolean poleNazwaProduktuWidoczne = false;
        boolean poleCenaWidoczne = false;


        // Sprawdza czy pole "Nazwa produktu cyfrowego" jest widoczne i wychwytuje wyjątek jeśli nie
        try {
            poleNazwaProduktuWidoczne = produktyCyfrowePage.getPodajNazweProduktuCyfrowegoPole().isDisplayed();
        } catch (Exception e) {
            // Pole nie zostało znalezione, pozostaje false
        }

        // Sprawdza czy pole "Cena" jest widoczne i wychwytuje wyjątek jeśli nie
        try {
            poleCenaWidoczne = produktyCyfrowePage.getCenaPole().isDisplayed();
        } catch (Exception e) {
            // Pole nie zostało znalezione, pozostaje false
        }

        // Instrukcja sprawdza, które z dwóch elementów są widoczne
        // i na podstawie wyniku ustawia zmienną "wiadomoscBledu" do asercji
        if(poleNazwaProduktuWidoczne && !poleCenaWidoczne) {
            wiadomoscBledu = "Nie znaleziono pola 'Cena'";
        } else if(!poleNazwaProduktuWidoczne && poleCenaWidoczne) {
            wiadomoscBledu = "Nie znaleziono pola 'Nazwa produktu cyfrowego'";
        }

        Assert.assertTrue(poleNazwaProduktuWidoczne && poleCenaWidoczne,
                wiadomoscBledu);
    }

    // Sprawdza czy po wypełnieniu sekcji "Utwórz nowy produkt cyfrowy"
    // i kliknięciu "Utwórz i edytuj" przechodzimy do okna "Edycja produktu cyfrowego"
    @Test(priority = 160, enabled = true,
            description = "Weryfikacja czy po utworzeniu produktu cyfrowego przechodzimy do panelu jego edycji")
    public void weryfikacjaCzyPoStworzeniuProduktuPrzechodzimyDoJegoEdycjiTest() {
        przejdzDoZakladkiProduktyCyfrowe();

        produktyCyfrowePage.utworzNowyProduktCyfrowy("Produkt testowy247", 247);

        Assert.assertTrue(edytujProduktCyfrowyPage.getEdycjaProduktuCyfrowegoNaglowek().isDisplayed(),
                "Nie znaleziono nagłówka ze strony 'Edycja produktu cyfrowego'");
    }

    // Sprawdza czy na stronie edycji produktu cyfrowego znajdują
    // się zakładki "Podstawowe", "Pliki" oraz "Generator linków"
    @Test(priority = 170, enabled = true,
            description = "Weryfikacja czy na stronie edycji kursu istnieją 3 pozycje w menu bocznym")
    public void weryfikacjaCzyWEdycjiProduktuIstniejaWszystkieZakladkiMenuBocznegoTest() {
        przejdzDoZakladkiProduktyCyfrowe();

        produktyCyfrowePage.wejdzWPierwszyProduktCyfrowyZListy();
        Assert.assertTrue(
                edytujProduktCyfrowyPage.getZakladkaPodstawowe().isDisplayed() &&
                        edytujProduktCyfrowyPage.getZakladkaPliki().isDisplayed() &&
                        edytujProduktCyfrowyPage.getZakladkaGeneratorLinkow().isDisplayed(),
                "Nie znaleziono wszystkich zakładek z menu bocznego");
    }

    // Sprawdza czy na stronie edycji produktu cyfrowego znajdują się sekcje:
    // "Nazwa i opis", "Umiejscowienie", "Cena", "Dostępne ilości", "Graficzne" i "Sprzedaż"
    @Test(priority = 180, enabled = true,
            description = "Weryfikacja czy na stronie edycji kursu istnieją wszystkie sekcje")
    public void weryfikacjaCzyWEdycjiProduktuIstniejaWszystkieSekcjeTest() {
        przejdzDoZakladkiProduktyCyfrowe();

        produktyCyfrowePage.wejdzWPierwszyProduktCyfrowyZListy();

        // Stream wyciągający tekst z każdego WebElementu do listy Stringów
        List<String> faktyczneNazwy = edytujProduktCyfrowyPage.getNaglowkiSekcji().stream()
                .map(WebElement::getText)
                .toList();

        // Oczekiwane nazwy każdej z sekcji
        List<String> oczekiwaneNazwy = Arrays.asList(
                "Nazwa i opis",
                "Umiejscowienie",
                "Cena",
                "Dostępne ilości",
                "Graficzne",
                "Sprzedaż"
        );

        Assert.assertEquals(faktyczneNazwy, oczekiwaneNazwy, "Nazwy w menu komentarzy są inne niż oczekiwane");
    }

}
