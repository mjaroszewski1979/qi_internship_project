package tests;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CertyfikatyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private CertyfikatyPage certyfikatyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        certyfikatyPage = new CertyfikatyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakladka certyfikaty w menu bocznym, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiCeretyfikaty() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertEquals(certyfikatyPage.zwrocAktualnyURLZakladkiCertyfikatyt(), certyfikatyPage.zwrocPoprawnyURLZakladkiCertyfikaty());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakladka certyfikaty w menu bocznym, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluZakladkiCeretyfikaty() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertEquals(certyfikatyPage.zwrocAktualnyTytulZakladkiCertyfikatyt(), certyfikatyPage.zwrocPoprawnyTytulZakladkiCertyfikaty());
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja czy lista 'Wynikow na strone' wyswietla sie z zakladce certyfikaty znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyListaWynikowNaStroneJestWZakldaceCertyfikaty() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzyNapisWynikowNaStroneIstniejeWZakladceCertyfikaty());

    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja czy przycisk 'Typy danych' wyswietla sie z zakladce certyfikaty znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyWZakladceCertyfikatyJestButtonTypyDanych() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzyButtonTypyDanychIstniejeWZakladceCertyfikaty());

    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja czy sekcja 'Wybierz które kolumny mają być widoczne w tabeli' pojawia sie po nacisnieciu przycisku 'Typy danych' w zakladce certyfikaty znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyPoKliknieciuTypyDanychButtonPojawiaSieSekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeli() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();;
        certyfikatyPage.nacisnijPrzyciskTypyDanychWZakladceCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzySekcjaWybierzKtoreKolumnyMajaBycWidoczneWTabeliIstniejeWZakladceCertyfikaty());

    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja czy po nacisnieciu przycisku 'Typy danych' pojawia sie poprawna liczba checkboxow w zakladce certyfikaty znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyPoKliknieciuTypyDanychButtonPojawiaSiePoprawnaLiczbaCheckboxow() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();
        certyfikatyPage.nacisnijPrzyciskTypyDanychWZakladceCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzyPoNacisnieciuTypyDanychButtonPojawiaSiePoprawnaLiczbaCheckboxow());

    }

    @Test(priority = 70, enabled = true, description = "Weryfikacja czy po nacisnieciu przycisku 'Typy danych' w zakladce certyfikaty w menu bocznym, liczba zaznaczonych checkboxow jest prawidlowa.")
    public void weryfikacjaCzyPoKliknieciuTypyDanychLiczbaNiezaznaczonychCheckboxowJestPoprawna() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();
        certyfikatyPage.nacisnijPrzyciskTypyDanychWZakladceCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzyLiczbaZaznaczonychCheckboxowJestPoprawna());

    }

    @Test(priority = 80, enabled = true, description = "Weryfikacja czy tabela w zakladce certyfikaty posiada wszystkie kolumny.")
    public void weryfikacjaCzyTabelaWZakladceTestyPosiadaPoprawneKolumny() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertTrue(certyfikatyPage.zweryfikujCzyTabelaWZakladceCertyfikatyPosiadaPoprawneKolumny(), "Tabela w zakladce certyfikaty nie posiada wszystkich kolumn.");

    }
}
