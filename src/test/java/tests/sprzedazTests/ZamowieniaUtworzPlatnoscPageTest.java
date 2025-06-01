package tests.sprzedazTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.sprzedaz.ZamowieniaUtworzPlatnoscPage;
import pages.sprzedaz.ZamowieniaPage;
import tests.TestBase;


public class ZamowieniaUtworzPlatnoscPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private ZamowieniaPage zamowieniaPage;
    private ZamowieniaUtworzPlatnoscPage zamowieniaUtworzPlatnoscPage;


    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        zamowieniaPage = new ZamowieniaPage(driver);
        zamowieniaUtworzPlatnoscPage = new ZamowieniaUtworzPlatnoscPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony UTWÓRZ PŁATNOŚĆ")
    public void weryfikacjaTytuluStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(zamowieniaUtworzPlatnoscPage.zwrocAktualnyTytulStronyUtworzPlatnosc(),
                zamowieniaUtworzPlatnoscPage.zwrocPoprawnyTytulStronyUtworzPlatnosc(),
                "Tytuł strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony UTWÓRZ PŁATNOŚĆ"  )
    public void weryfikacjaPoprawnegoAdresuStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(zamowieniaUtworzPlatnoscPage.zwrocAktualnyUrlStronyUtworzPlatnosc(),
                zamowieniaUtworzPlatnoscPage.zwrocPoprawnyUrlStronyUtworzPlatnosc(),
                "Adres url strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja, czy po kliknięciu przycisku DODAJ ZAMÓWIENIE pojawia się ekran UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaWyswietleniaEkranuUtworzNowaPlatnosc(){
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zwrocSekcjeTytulowaUtworzNowaPlatnosc(),
                "Nie wyświetla się ekran UTWÓRZ NOWĄ PŁATNOŚĆ po kliknięciu przycisku DODAJ ZAMÓWIENIE");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja, czy lista WYBIERZ PRODUKTY jest widoczna")
    public void weryfikacjaWidocznosciListyWybierzProdukty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujCzyListaProduktowIstnieje(),
                "Lista WYBIERZ PRODUKTY nie jest widoczna");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja, czy lista dla 'Status płatności' jest widoczna")
    public void weryfikacjaWidocznosciListyDlaStatusPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujCzyListaDlaStatusPlatnosciIstnieje(),
                "Lista dla 'Status płatności' nie jest widoczna");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja, czy przycisk DODAJ KOLEJNY jest widoczny")
    public void weryfikacjaWidocznosciPrzyciskuDodajKolejny() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujCzyPrzyciskDodajKolejnyIstnieje(),
                "Przycisk DODAJ KOLEJNY nie jest widoczny");
    }

    @Test(priority = 70, enabled = true, description = "Weryfikacja, czy przycisk UTWÓRZ PŁATNOŚĆ jest widoczny")
    public void weryfikacjaWidocznosciPrzyciskuUtworzPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujCzyPrzyciskUtworzPlatnoscIstnieje(),
                "Przycisk UTWÓRZ PŁATNOŚĆ nie jest widoczny");
    }


    @Test(priority = 80, enabled = true, description = "Weryfikacja liczby pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaLiczbyPozycjiWFormularzuUtworzNowaPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(zamowieniaUtworzPlatnoscPage.zwrocAktualnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(),
                zamowieniaUtworzPlatnoscPage.zwrocPoprawnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(),
                "Niepoprawna liczba pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ");
    }

    @Test(priority = 90, enabled = true, description = "Weryfikacja nazw pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaNazwPozycjiWFormularzuUtworzNowaPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujNazwyPozycjiFormularzaUtworzNowaPlatnosc(),
                "Pozycje w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ są niewidoczne lub mają nieprawidłowe nazwy");
    }

    @Test(priority = 100, enabled = true, description = "Weryfikacja, czy checkbox 'Wyślij potwierdzenie zakupu' jest widoczny i zaznaczony")
    public void weryfikacjaWidocznosciCheckboxWyślijPotwierdzenieZakupu() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        zamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(zamowieniaUtworzPlatnoscPage.zweryfikujCzyCheckboxWyslijPotwierdzenieZakupuIstniejeIJestZaznaczony(),
                "Checkbox 'Wyślij potwierdzenie zakupu' nie jest widoczny lub nie jest zaznaczony");
    }











}
