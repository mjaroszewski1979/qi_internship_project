package tests.kursyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import tests.TestBase;


public class EdytujKursyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private EdytujKursyPage edytujKursyPage;

    /***************** sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPEdytujKursyPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        edytujKursyPage = new EdytujKursyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony 'Edycja kursu' jest poprawny
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Edycja kursu'")
    public void weryfikacjaPoprawnegoAdresuStronyEdytujKursy() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();

        Assert.assertTrue(edytujKursyPage.zwrocUrlAktualnejStrony(),
                "Adres url nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony 'Edycja kursu' jest poprawny
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Edycja kursu'")
    public void weryfikacjaTytuluStronyEdytujKursy() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();

        Assert.assertEquals(edytujKursyPage.zwroctTytulAktualnejStrony(), edytujKursyPage.zwrocPoprawnyTytulStronyEdytujKursy(),
                "Tytuł strony nie jest poprawny");
    }

    // Test weryfikujący, czy po uzupełnieniu sekcji 'Utwórz nowy kurs' i kliknięciu 'Utwórz i edytuj', przechodzimy do okna 'Edycja kursu'.
    @Test(priority = 30, enabled = true, description = "Weryfikacja przejścia do okna 'Edycja kursu'.")
    public void weryfikacjaPrzejsciaDoOknaEdytujKursy() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();

        Assert.assertTrue(edytujKursyPage.pobranieTekstuOknaEdycjaKursu(),
                "Okno 'Edycja kursu' nie jest widoczne.");
    }

    // Test weryfikujący, czy w oknie 'Edycja kursu' w menu bocznym są 3 pozycje.
    @Test(priority = 40, enabled = true, description = "Weryfikacja istnienia w oknie 'Edycja kursu' 3 pozycji menu bocznego.")
    public void weryfikacjaLiczbyPozycjiWMenuBocznymOknaEdycjaKursow() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();

        Assert.assertEquals(edytujKursyPage.zworcLiczbePozycjiWMenuBocznymOknaEdycjaKursow(),edytujKursyPage.zwrocPoprawnaLiczbePozycjiWMenuBocznymOknaEdycjaKursow(),
                "W oknie 'Edycja kursu' nie znaleziono 3 zakładek menu bocznego");
    }

    // Test weryfikujący, czy w oknie 'Edycja kursu' w menu bocznym są 3 pozycje: 'Podstawowe', 'Struktura', 'Generator linków'.
    @Test(priority = 41, enabled = true, description = "Weryfikacja istnienia w oknie 'Edycja kursu' 3 pozycji menu bocznego: 'Podstawowe', 'Struktura', 'Generator linków'")
    public void weryfikacjaNazwyPozycjiWMenuBocznymOknaEdycjaKursow() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();
        edytujKursyPage.poczekajNaZakladkePodstawoweWMenuBocznymOknaEdycjaKursow();

        Assert.assertEquals(edytujKursyPage.zwrocNazwyPozycjiMenuBocznymOknaEdycjaKursow(),edytujKursyPage.zwrocPoprawneNazywyPozycjiOknaEdycjaKursow(),
                "W oknie 'Edycja kursu' nie znaleziono odpowiednich zakładek menu bocznego");
    }

    // Test weryfikujący, czy w oknie 'Edycja kursu' 'Podstawowe' jest 8 sekcji.
    @Test(priority = 50, enabled = true, description = "Weryfikacja istnienia w oknie 'Edycja kursu' 'Podstawowe' 8 sekcji.")
    public void weryfikacjaLiczbySekcjiPodstawoweWMenuBocznymOknaEdycjaKursow() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();
        edytujKursyPage.kliknijZakladkePodstawoweWMenuBocznymOknaEdycjaKursow();
        edytujKursyPage.poczekajNaSekcjeNazwaIOpis();
        edytujKursyPage.poczekajNaSekcjeSprzedaz();

        Assert.assertEquals(edytujKursyPage.zworcLiczbeSekcjiPodstawoweWMenuBocznymOknaEdycjaKursow(),edytujKursyPage.zwrocPoprawnaLiczbeSekcjiPodstawoweWMenuBocznymOknaEdycjaKursow(),
                "W oknie 'Edycja kursu', w zakładce 'Podstawowe' nie znaleziono 8 sekcji");
    }

    // Test weryfikujący, czy w oknie 'Edycja kursu' w zakładce 'Podstawowe' znajdują się oczekiwane sekcje.
    @Test(priority = 51, enabled = true, description = "Weryfikacja istnienia oczekiwanych sekcji zakładki 'Podstawowe'.")
    public void weryfikacjaSekcjiZakladkiPodstawoweWMenuBocznymOknaEdycjaKursow() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();
        edytujKursyPage.kliknijZakladkePodstawoweWMenuBocznymOknaEdycjaKursow();
        edytujKursyPage.poczekajNaSekcjeNazwaIOpis();
        edytujKursyPage.poczekajNaSekcjeSprzedaz();

        Assert.assertEquals(edytujKursyPage.zwrocNazwySekcjiZakladkiPodstawoweWMenuBocznymOknaEdycjaKursow(),edytujKursyPage.zwrocPoprawneNazywySekcjiZakladkiPodstawoweWMenuBocznymOknaEdycjaKursow(),
                "W oknie 'Edycja kursu', a w zakaładce 'Podstawowe' nie znaleziono odpowiednich sekcji");
    }
}