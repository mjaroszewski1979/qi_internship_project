package tests.mediaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.media.PozostaleMediaPage;
import tests.TestBase;

public class PozostaleMediaPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private PozostaleMediaPage pozostaleMediaPage;


    @BeforeMethod
    public void setUpPozostaleMediaPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        pozostaleMediaPage = new PozostaleMediaPage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy
    // od panelu logowania przenosząc nas do strony "Pozostałe wideo"
    private void przejdzDoZakladkiPozostaleMedia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiPozostaleMedia();
    }

    // Sprawdza czy adres URL strony "Pozostałe media" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Pozostałe media'")
    public void weryfikacjaAdresuUrlZakladkiWideoTest() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertEquals(driver.getCurrentUrl(), pozostaleMediaPage.getPoprawnyUrlStrony(),
                "Adres URL strony jest niepoprawny");
    }

    // Sprawdza czy tytuł strony "Pozostałe media" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Pozostałe media'")
    public void weryfikacjaTytuluZakladkiWideoTest() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertEquals(driver.getTitle(), pozostaleMediaPage.getPoprawnyTytulStrony(),
                "Tytuł strony jest niepoprawny");
    }

    // Sprawdza czy na stronie istnieje button "Dodaj nowy plik multimedialny"
    @Test(priority = 120, enabled = true,
            description = "Weryfikacja czy istnieje button 'Dodaj nowy plik multimedialny'")
    public void weryfikacjaCzyButtonDodajNowyPlikMultimedialnyIstniejeTest() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertTrue(pozostaleMediaPage.getDodajNowyPlikMultimedialnyButton().isDisplayed(),
                "Nie znaleziono buttona 'Dodaj nowy plik multimedialny'");
    }

    // Sprawdza czy na stronie znajduje się komunikat "'Uwaga! Jeśli chcesz przesłać pliki wideo...'"
    @Test(priority = 130, enabled = true,
            description = "Weryfikacja czy tekst 'Uwaga! Jeśli chcesz przesłać pliki wideo...' jest widoczny")
    public void weryfikacjaCzyKomunikatJesliChceszPrzeslacPlikiWideoJestWidocznyTest() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertTrue(pozostaleMediaPage.getJestChceszPrzeslacPlikiWideoText().isDisplayed(),
                "Nie znaleziono komunikatu 'Uwaga! Jeśli chcesz przesłać pliki wideo...'");
    }

    // Sprawdza czy po kliknięciu buttona "Dodaj nowy plik multimedialny" pojawia się menu z buttonem "Wybierz pliki"
    @Test(priority = 140, enabled = true,
            description = "Weryfikacja czy tekst 'Uwaga! Jeśli chcesz przesłać pliki wideo...' jest widoczny")
    public void weryfikacjaCzyPoKliknieciuDodajNowyPlikMultimedialnyPojawiaSieButtonWybierzPlikiTest() {
        przejdzDoZakladkiPozostaleMedia();

        pozostaleMediaPage.getDodajNowyPlikMultimedialnyButton().click();

        Assert.assertTrue(pozostaleMediaPage.getWybierzPlikiButton().isDisplayed(),
                "Nie znaleziono buttona 'Wybierz pliki'");
    }

    // Sprawdza czy pod buttonem "Wybierz pliki" znajduje się tekst "Maksymalna wielkość dodawanych plików: 3 GB."
    @Test(priority = 150, enabled = true,
            description = "Weryfikacja czy tekst 'Maksymalna wielkość dodawanych plików: 3 GB.' jest widoczny")
    public void weryfikacjaCzyTekstMaksymalnaWielkoscDodawanychPlikowJestWidocznyTest() {
        przejdzDoZakladkiPozostaleMedia();

        pozostaleMediaPage.getDodajNowyPlikMultimedialnyButton().click();

        Assert.assertTrue(pozostaleMediaPage.getMaksymalnaWielkoscPlikowText().isDisplayed(),
                "Nie znaleziono tekstu 'Maksymalna wielkość dodawanych plików: 3 GB.'");
    }

    @Test(priority = 160, enabled = true, description = "")
    public void weryfikacjaCzyDodanyPlikJestWidocznyNaLisciePlikowMultimedialnych(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiPozostaleMedia();
        pozostaleMediaPage.nacisnijDodajNowyPlikMultimedialnyButton();
        pozostaleMediaPage.przeslijPlikPng();

        Assert.assertTrue(pozostaleMediaPage.weryfikacjaCzyPrzeslanyPlikJestWidoczny(), "Przeslany plik nie jest widoczny w bibliotece mediow.");

    }

}
