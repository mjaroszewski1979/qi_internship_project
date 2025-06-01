package tests.mediaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.MediaPage;
import pages.PanelPage;
import pages.media.DodajWideoPage;
import pages.media.WideoPage;
import tests.TestBase;

public class WideoPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private WideoPage wideoPage;
    private DodajWideoPage dodajWideoPage;

    @BeforeMethod
    public void setUpWideoPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        wideoPage = new WideoPage(driver);
        dodajWideoPage = new DodajWideoPage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do strony "Wideo"
    private void przejdzDoZakladkiWideo() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiWideo();
    }

    // Sprawdza czy adres URL strony "Wideo" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Wideo'")
    public void weryfikacjaAdresuUrlZakladkiWideoTest() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getCurrentUrl(), wideoPage.getPoprawnyUrlStrony(),
                "Adres URL strony jest niepoprawny");
    }

    // Sprawdza czy tytuł strony "Wideo" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Wideo'")
    public void weryfikacjaTytuluZakladkiWideoTest() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getTitle(), wideoPage.getPoprawnyTytulStrony(),
                "Tytuł strony jest niepoprawny");
    }

    // Sprawdza czy button "Dodaj wideo" istnieje
    @Test(priority = 120, enabled = true, description = "Weryfikacja czy button 'Dodaj wideo' istnieje")
    public void weryfikacjaCzyButtonDodajWideoIstniejeTest() {
        przejdzDoZakladkiWideo();
        Assert.assertTrue(wideoPage.getDodajWideoButton().isDisplayed(), "Nie znaleziono buttona 'Dodaj Wideo'");
    }

    // Sprawdza czy button "Typy danych" istnieje
    @Test(priority = 130, enabled = true, description = "Weryfikacja czy button 'Typy danych' istnieje")
    public void weryfikacjaCzyButtonTypyDanychIstniejeTest() {
        przejdzDoZakladkiWideo();
        Assert.assertTrue(wideoPage.getTypyDanychButton().isDisplayed(), "Nie znaleziono buttona 'Typy danych'");
    }

    // Sprawdza czy po kliknięciu buttona "Typy danych"
    // pojawia się menu z checkboxami elementów, które mają być widoczne w tabeli
    @Test(priority = 140, enabled = true, description =
            "Weryfikacja czy button 'Typy danych' rozwija menu wyboru checkboxów")
    public void weryfikacjaCzyButtonTypyDanychRozwijaMenuWyboruCheckboxowTest() {
        przejdzDoZakladkiWideo();

        wideoPage.kliknijTypyDanychButton();

        int oczekiwanaIloscCheckboxow = 5;
        int aktualnaIloscCheckboxow = wideoPage.getCheckboxyKolumnTabeli().size();

        Assert.assertEquals(aktualnaIloscCheckboxow, oczekiwanaIloscCheckboxow,
                "Nie można poprawnie zweryfikować checkboxów w menu 'Typy danych'");
    }

    // Sprawdza czy po kliknięciu buttona "Dodaj wideo" otwiera się ekran "Prześlij plik wideo"
    @Test(priority = 150, enabled = true,
            description = "Weryfikacja czy button 'Dodaj wideo' otwiera stronę 'Prześlij plik wideo'")
    public void weryfikacjaCzyButtonDodajWideoOtwieraStronePrzeslijPlikWideoTest() {
        przejdzDoZakladkiWideo();

        wideoPage.kliknijDodajWideoButton();

        Assert.assertTrue(dodajWideoPage.getNaglowekPrzeslijPlikWideo().isDisplayed(),
                "Nie znaleziono nagłówka strony 'Prześlij plik wideo'");
    }

    // Sprawdza czy po kliknięciu buttona "Dodaj wideo" komunikat "Uwaga! Po wczytaniu plików wideo..." jest widoczny "
    @Test(priority = 160, enabled = true,
            description = "Weryfikacja czy komunikat 'Uwaga! Po wczytaniu plików wideo...' jest widoczny'")
    public void weryfikacjaCzyPoKliknieciuDodajWideoButtonPojawiSieTekstOPobieraniuWideoTest() {
        przejdzDoZakladkiWideo();

        wideoPage.kliknijDodajWideoButton();

        Assert.assertTrue(dodajWideoPage.getNieBedzieMozliwosciPobraniaText().isDisplayed(),
                "Nie znaleziono tekstu 'Uwaga! Po wczytaniu plików wideo...'");
    }

    // Test sprawdzający proces dodawania pliku wideo – od logowania po finalną weryfikację
    @Test(priority = 110, enabled = true, description = "Weryfikacja poprawnosci procesu dodawania pliku wideo")
    public void zweryfikujProcesDodawaniaPlikuWideo() {
        przejdzDoZakladkiWideo();
        wideoPage.kliknijDodajWideoButton();
        dodajWideoPage.przeslijWideo();
        Assert.assertEquals(wideoPage.zwrocNazwePlikuWideo(), wideoPage.zwrocPoprawnaNAzwaPlikuWideo(), "Proces dodawania pliku wideo przebiega nieprawidlowo");
    }

}
