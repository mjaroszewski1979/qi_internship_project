package tests.kursyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import tests.TestBase;


public class KursyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KursyPage kursyPage;


    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPKursyPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony 'Kursy' jest poprawny.
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Kursy'")
    public void weryfikacjaPoprawnegoAdresuStronyKursy() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwrocUrlAktualnejStrony(), kursyPage.zwrocPoprawnyUrlKursow(),
                "Adres url nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony 'Kursy' jest poprawny.
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Kursy'")
    public void weryfikacjaTytuluStronyKursy() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwroctTytulAktualnejStrony(), kursyPage.zwrocPoprawnyTytulStronyKursy(),
                "Tytuł strony nie jest poprawny");
    }

    // Test wetyfikujący, czy na stronie 'Kursy' jest przycisk 'Utwórz nowy kurs'.
    @Test(priority = 30, enabled = true, description = "Wetyfikującja, czy na stronie 'Kursy' jest przycisk 'Utwórz nowy kurs'.")
    public void weryfikacjaPrzyciskuUtworzNowyKurs() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.sprawdzButtonUtworzNowyKurs();

        Assert.assertTrue(kursyPage.sprawdzCzyButtonUtworzNowyKursIstnieje(),
                "Przycisk 'Utwórz nowy kurs' nie jest wyświetlony lub aktywny.");
    }

    // Test wetyfikujący, czy na stronie 'Kursy' jest przycisk 'Typy danych'.
    @Test(priority = 40, enabled = true, description = "Wetyfikującja, czy na stronie 'Kursy' jest przycisk 'Typy danych'.")
    public void weryfikacjaPrzyciskuTypyDanych() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.sprawdzButtonTypyDanych();

        Assert.assertTrue(kursyPage.sprawdzCzyButtonTypyDanychIstnieje(),
                "Przycisk 'Typy danych' nie jest wyświetlony lub aktywny.");
    }

    // Test wetyfikujący, czy na stronie 'Kursy', po naciśnięciu 'Typy danych', istnieje sekcja 'Wybierz, które kolumny mają być widoczne w tabeli'.
    @Test(priority = 50, enabled = true, description = "Wetyfikującja, czy po naciśnięciu 'Typy danych', na stronie 'Kursy', istnieje sekcja 'Wybierz, które kolumny mają być widoczne w tabeli'.")
    public void weryfikacjasekcjaCzySekcjaWybierzKtoreKolumnyMajaBycWidoczne() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.nacisnijButtonTypyDanych();

        Assert.assertTrue(kursyPage.sprawdzCzySekcjaWybierzKtoreElementyMajaBycWidoczneJestWyswietlona(),
                "Sekcja 'Wybierz, które kolumny mają być widoczne w tabeli' nie jest widoczna.");
    }

    // Test weryfikujący, czy w oknie 'Utwórz nowy kurs' znajdują się pola 'Nazwa kursu' i 'Cena'.
    @Test(priority = 60, enabled = true, description = "Weryfikacja, czy w oknie 'Utwórz nowy kurs' znajdują się pola 'Nazwa kursu' i 'Cena'.")
    public void weryfikacjaPolNazwaKursuICena() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.sprawdzPolaNazwaKursuICena();

        Assert.assertTrue(kursyPage.sprawdzCzyPoleNazwaKursuICenaIstnieje(),
                "Pola 'Nazwa kursu' i 'Cena' nie są poprawnie wyświetlone i aktywne.");
    }

    // Test weryfikujący, czy w oknie 'Utwórz nowy kurs' znajduje się przycisk 'Utwórz i edytuj'.
    @Test(priority = 70, enabled = true, description = "Weryfikacja, czy w oknie 'Utwórz nowy kurs' znajdują się przycisk 'Utwórz i edytuj'.")
    public void weryfikacjaPrzyciskuUtworzIEdytuj() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.sprawdzPrzyciskUtworzIEdytuj();

        Assert.assertTrue(kursyPage.sprawdzCzyPrzyciskUtworzIEdytujIstnieje(),
                "Przycisk 'Utwórz i edytuj' nie jest wyświetlony i/lub aktywny.");
    }
}
