package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CertyfikatyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.PodsumowanieZamowieniaPage;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import pages.pakiety.EdycjaPakietyPage;
import pages.pakiety.GeneratorLinkowPakietyPage;
import pages.pakiety.PakietyPage;
import pages.pakiety.ZawartoscPakietuPage;
import tests.kursyTests.KursyPageTest;

public class PodsumowanieZamowieniaPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private EdytujKursyPage edytujKursyPage;
    private PakietyPage pakietyPage;
    private EdycjaPakietyPage edycjaPakietyPage;
    private ZawartoscPakietuPage zawartoscPakietuPage;
    private GeneratorLinkowPakietyPage generatorLinkowPakietyPage;
    private PodsumowanieZamowieniaPage podsumowanieZamowieniaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPPodsumowanieZamowieniaPage() {
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        edytujKursyPage = new EdytujKursyPage(driver);
        pakietyPage = new PakietyPage(driver);
        edycjaPakietyPage = new EdycjaPakietyPage(driver);
        zawartoscPakietuPage = new ZawartoscPakietuPage(driver);
        generatorLinkowPakietyPage = new GeneratorLinkowPakietyPage(driver);
        podsumowanieZamowieniaPage = new PodsumowanieZamowieniaPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja, czy po stworzeniu kursu z 4 wariantami, dostepnoscia sztuk wieksza niz 1 ale mniejsza niz 10, z typem dostepu do kursu ustawionym na 'Przez określony czas, od określonej daty', z czasem startu 01.07.2025, 07:00 i czasem dostepu 12 miesiecy link z ekranu 'Generator linkow' dziala poprawnie i wygenerowanmy link prowadzi do strony, na ktorej jest przycisk 'ZAMAWIAM I PLACE'.")
    public void weryfikacjaGeneratoraLinkowKursu(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.przewinStroneDoSekcjiSprzedaz();
        edytujKursyPage.wlaczSprzedazWSekcjiSprzedaz();
        edytujKursyPage.przewinStroneDoSekcjiWarianty();
        edytujKursyPage.utworzCzteryWariantyDoTestu();
        edytujKursyPage.przewinStroneDoZakladkiGeneratorLinkow();
        edytujKursyPage.przejdzDoZakladkiGeneratorLinkow();
        edytujKursyPage.pobierzLinkZPolaLinkZakupowy();
        edytujKursyPage.przejdzDoLinkuZPolaLinkZakupowy();

        Assert.assertTrue(podsumowanieZamowieniaPage.weryfikacjaCzyZamawiamIPlaceButtonIstnieje(), "Zamawiam i place button nie istnieje.");
    }
    //Test weryfikujący, czy po stworzeniu pakietu z minimum dwoma produktami, za cenę 1599zł, w promocji 799zł, link z ekranu 'Generator linków' działa poprawnie i prowadzi do strony, na której jest przycisk 'ZAMAWIAM I PLACE'.
    @Test(priority = 20, enabled = true, description = "Weryfikacja, czy po stworzeniu pakietu z minimum dwoma produktami, za cenę 1599zł, w promocji 799zł, link z ekranu 'Generator linków' działa poprawnie i prowadzi do strony, na której jest przycisk 'ZAMAWIAM I PLACE'.")
    public void weryfikacjaGeneratoraLinkowPakietu() {

        //logowanie
        loginPageNew.wykonajLogowanie();

        //przejście do modułu 'Pakiety'
        panelPage.przejdzDoZakladkiPakiety();

        //dodanie nowego pakietu w cenie 1599 zł
        pakietyPage.dodajNowyPakiet();

        //dodanie 3 kategorii do pakietu
        edycjaPakietyPage.poczekajNaOknoEdycjaPakietu();
        edycjaPakietyPage.poczekajNaSekcjeUmiejscowienie();
        edycjaPakietyPage.dodajTrzyKategorie();
        edycjaPakietyPage.sprawdzCzyTekstUstawieniaZostalyZapisaneWZrodleStronyIstnieje();

        //dodanie 3 tagów: 'promocja', 'rabat', nowy'
        edycjaPakietyPage.odswiezenieStrony();
        edycjaPakietyPage.poczekajNaSekcjeUmiejscowienie();
        edycjaPakietyPage.przewinStroneDoSekcjiUmiejscowienie();
        edycjaPakietyPage.dodajTrzyTagiDoPakietu();
        edycjaPakietyPage.sprawdzCzyTekstUstawieniaZostalyZapisaneWZrodleStronyIstnieje();

        //dodanie ceny promocji 799 zł
        edycjaPakietyPage.odswiezenieStrony();
        edycjaPakietyPage.poczekajNaSekcjeCenaEdycjaPakietu();
        edycjaPakietyPage.przewinStroneDoSekcjiCena();
        edycjaPakietyPage.dodajCenePromocyjnaPakietu();
        edycjaPakietyPage.sprawdzCzyTekstUstawieniaZostalyZapisaneWZrodleStronyIstnieje();

        //włączenie sprzedaży
        edycjaPakietyPage.odswiezenieStrony();
        edycjaPakietyPage.poczekajNaSekcjeSprzedaz();
        edycjaPakietyPage.przewinStroneDoSekcjiSprzedaz();
        edycjaPakietyPage.wlaczSprzedazPakiety();

        //dodanie 3 produktów do pakietu
        edycjaPakietyPage.przewinStroneDoZakladkiZawartoscPakietu();
        edycjaPakietyPage.przejdzDoZakladkiZawartoscPakietu();
        zawartoscPakietuPage.poczekajNaPrzyciskDodajProdukt();
        zawartoscPakietuPage.przewinStroneDoDodajProdukt();
        zawartoscPakietuPage.dodajTrzyProduktyDoPakietuWZakladceZawartoscPakietu();
        edycjaPakietyPage.sprawdzCzyTekstUstawieniaZostalyZapisaneWZrodleStronyIstnieje();

        //weryfikacja linku zakupowego
        zawartoscPakietuPage.przewinStroneDoZakladkiGeneratorLinkow();
        zawartoscPakietuPage.przejdzDoZakladkiGeneratorLinkow();
        generatorLinkowPakietyPage.pobierzLinkZPolaLinkZakupowy();
        generatorLinkowPakietyPage.przejdzDoLinkuZPolaLinkZakupowy();

        Assert.assertTrue(podsumowanieZamowieniaPage.weryfikacjaCzyZamawiamIPlaceButtonIstnieje(), "Zamawiam i place button nie istnieje.");
    }


}
