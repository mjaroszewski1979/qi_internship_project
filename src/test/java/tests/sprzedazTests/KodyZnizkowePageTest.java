package tests.sprzedazTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.sprzedaz.KodyZnizkoweDodajNowyPage;
import pages.sprzedaz.KodyZnizkowePage;
import tests.TestBase;


public class KodyZnizkowePageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/
    //instancja strony logowania
    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KodyZnizkowePage kodyZnizkowePage;
    private KodyZnizkoweDodajNowyPage kodyZnizkoweDodajNowyPage;
    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kodyZnizkowePage = new KodyZnizkowePage(driver);
        kodyZnizkoweDodajNowyPage = new KodyZnizkoweDodajNowyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony KODY ZNIŻKOWE")
    public void weryfikacjaTytuluStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(kodyZnizkowePage.zwrocAktualnyTytulStronyKodyZnizkowe(),
                kodyZnizkowePage.zwrocPoprawnyTytulStronyKodyZnizkowe(),
                "Tytuł strony KODY ZNIŻKOWE nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony KODY ZNIŻKOWE"  )
    public void weryfikacjaPoprawnegoAdresuStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(kodyZnizkowePage.zwrocAktualnyUrlStronyKodyZnizkowe(),
                kodyZnizkowePage.zwrocPoprawnyUrlStronyKodyZnizkowe(),
                "Adres url strony KODY ZNIŻKOWE nie jest poprawny");
    }

    //Test weryfikujący, czy po wygenerowaniu kodu zniżkowego z zadanymi parametrami, jest on widoczny na liście kodów zniżkowych.
    @Test(priority = 30, enabled = true, description = "Weryfikacja poprawności generowania kodów zniżkowych")
    public void weryfikacjaPoprawnegoGenerowaniaKodowZnizkowych()  {

        //logowanie
        loginPageNew.wykonajLogowanie();

        //przejscie do modułu 'Sprzedaż' > 'Kody zniżkowe'
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        //dodanie nowego kodu zniżkowego
        kodyZnizkowePage.kliknijWDodajKodZnizkowy();

        //wpisanie nazwy kodu zniżkowego
        kodyZnizkoweDodajNowyPage.wpiszNazweKoduZnizkowego();

        //wpisanie kodu 'Kodu zniżkowego'
        kodyZnizkoweDodajNowyPage.ustawienieKoduKoduZnizkowego();

        //ustawienie listy 'Typ' na stałą wartość
        kodyZnizkoweDodajNowyPage.ustawienieStalejWartosciTypuKoduZnizkowego();

        //ustawienie kwoty zniżki na 15
        kodyZnizkoweDodajNowyPage.wpiszKwoteZnizki();

        //ustawienie co najmniej jednego produktu wymaganego
        kodyZnizkoweDodajNowyPage.wybierzProduktyWymagane();

        //ustawienie przynajmniej jednego produktu wykluczonego
        kodyZnizkoweDodajNowyPage.wybierzProduktWykluczony();

        //ustawienie daty początkowej na ‘04/01/2025’
        kodyZnizkoweDodajNowyPage.wpiszDatePoczatkowaZnizki();

        //ustawienie kwoty minimalnej na 100
        kodyZnizkoweDodajNowyPage.wpiszKwoteMinimalnaZnizki();

        //ustawienie maksymalnej ilości użyć na 10
        kodyZnizkoweDodajNowyPage.wpiszMaksymalnaIloscUzycZnizki();

        //zaznaczenie checkbox na ‘Jednorazowy dla danego klienta’
        kodyZnizkoweDodajNowyPage.wybierzJednorazowyDlaDanegoKlienta();

        //kliknęcie przycisku ‘Dodaj kod zniżkowy’
        kodyZnizkoweDodajNowyPage.wybierzPrzyciskDodajKodZnizkowy();

        //poczekanie na załadowanie tabeli kodów zniżkowych
        kodyZnizkoweDodajNowyPage.poczekajNaZaladowanieTabeliKodyZnizkowe();

        Assert.assertTrue(kodyZnizkoweDodajNowyPage.sprawdzKomunikatKodZnizkowyZostalDodany() &&
                kodyZnizkoweDodajNowyPage.sprawdzKodZnizkowyZostalUtworzony(),
                "Kod zniżkowy nie został utworzony");

    }









}
