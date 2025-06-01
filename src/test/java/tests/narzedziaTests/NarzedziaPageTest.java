package tests.narzedziaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.narzedzia.NarzedziaPage;
import pages.PanelPage;
import tests.TestBase;

public class NarzedziaPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private NarzedziaPage narzedziaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        narzedziaPage = new NarzedziaPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakladka narzedzia w menu bocznym, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiNarzedzia() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertEquals(narzedziaPage.zwrocAktualnyURLZakladkiNarzedzia(), narzedziaPage.zwrocPoprawnyURLZakladkiNarzedzia());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakladka narzedzia w menu bocznym, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluZakladkiNarzedzia() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertEquals(narzedziaPage.zwrocAktualnyTytulZakladkiNarzedzia(), narzedziaPage.zwrocPoprawnyTytulZakladkiNarzedzia());
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja liczby zakładek w menu bocznym strony NARZĘDZIA")
    public void weryfikacjaLiczbyZakladekMenuBoczneNarzedzia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertEquals(narzedziaPage.zwrocAktualnaLiczbeZakladekMenuBoczneNarzedzia(),
                narzedziaPage.zwrocPoprawnaLiczbeZakladekMenuBoczneNarzedzia(),
                "Niepoprawna liczba zakładek w menu bocznym strony NARZĘDZIA");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja nazw zakładek w menu bocznym strony NARZĘDZIA")
    public void weryfikacjaNazwPozycjiWFormularzuUtworzNowaPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertTrue(narzedziaPage.zweryfikujNazwyZakladekMenuBoczneNarzedzia(),
                "Zakładki w menu bocznym strony NARZĘDZIA są niewidoczne lub mają nieprawidłowe nazwy");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja liczby checkboxów na stronie NARZĘDZIA")
    public void weryfikacjaLiczbyCheckboxowNarzedzia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertEquals(narzedziaPage.zwrocAktualnaLiczbeCheckboxowNarzedzia(),
                narzedziaPage.zwrocPoprawnaLiczbeCheckboxowNarzedzia(),
                "Niepoprawna liczba checkboxów na stronie NARZĘDZIA");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja, czy wszystkie checkboxy są domyślnie niezaznaczone na stronie NARZĘDZIA")
    public void weryfikacjaCheckboxyDomyslnieNiezaznaczneNarzedzia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertTrue(narzedziaPage.zweryfikujCzyCheckboxSaNieznaczoneNarzedzia(),
                "Checkboxy na stronie NARZĘDZIA są zaznaczone");
    }

    @Test(priority = 70, enabled = true, description = "Weryfikacja, czy wszystkie checkboxy są widoczne na stronie NARZĘDZIA")
    public void weryfikacjaWidocznosciCheckboxowNarzedzia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertTrue(narzedziaPage.zweryfikujCzyCheckboxSaWidoczneNarzedzia(),
                "Checkboxy na stronie NARZĘDZIA są zaznaczone");
    }

    @Test(priority = 80, enabled = true, description = "Weryfikacja, czy istnieje przycisk IMPORT KURSANTÓW na stronie NARZĘDZIA")
    public void weryfikacjaWidocznosciPrzyciskuImportKursantow() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertTrue(narzedziaPage.zweryfikujCzyPrzyciskImportKursantowIstnieje(),
                "Nie znaleziono przycisku IMPORT KURSANTÓW na stronie NARZĘDZIA");
    }

    @Test(priority = 90, enabled = true, description = "Weryfikacja, czy w bocznym menu głównym NARZĘDZIA widać wszystkie podpozycje i czy mają zgodne nazwy: Narzędzia, Powiadomienia, Logi, Webhooki, Przekierowania")
    public void weryfikacjaWidocznosciPodpozycjiMenuNarzedzia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();

        Assert.assertTrue(narzedziaPage.zweryfikujWidocznoscINazwyPodpozycjiMenuGlowneNarzedzia(),
                "Nie znaleziono podpozycji w bocznym menu głównym NARZĘDZIA");
    }







}
