package tests.uslugiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.uslugi.EdycjaUslugiPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.uslugi.UslugiPage;
import tests.TestBase;

public class EdycjaUslugiPageTest extends TestBase {

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UslugiPage uslugiPage;
    private EdycjaUslugiPage edycjaUslugiPage;

    @BeforeMethod
    public void setUpEdycjaUslugiPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uslugiPage = new UslugiPage(driver);
        edycjaUslugiPage = new EdycjaUslugiPage(driver);
    }

    //metoda pomocnicza, ktora loguje, odsyla do strony 'Uslugi' i czeka na zaladowanie tabeli uslug
    private void logowanieIPrzejscieDoStronyUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
    }

//    @Test(priority = 10, enabled = true, description = "Weryfikacja czy strona Edycja usługi posiada prawidłowy adres URL.")
//    public void weryfikacjaAdresuURLStronyEdycjaUslugi() {
//      loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
//      loginPageNew.wpiszHasloDoPolaHaslo();
//      loginPageNew.nacisnijPrzyciskZalogujSie();
//        panelPage.przejdzDoZakladkiUslugi();
//        uslugiPage.przejdzDoStronyEdycjaUslugi();
//
//       Assert.assertEquals(edycjaUslugiPage.zwrocAktualnyURLStronyEdycjaUslugi(), edycjaUslugiPage.zwrocPoprawnyURLStronyEdycjaUslugi(), "Adres Url strony Edycja usługi nie jest poprawny");
//}


    //test po przejsciu do edycji uslugi poprzez wybranie pierwszej uslugi z listy
    //weryfikuje czy pobrany tytul strony 'Edycja uslugi' odpowiada tytulowi wzorowemu
    @Test(priority = 20, enabled = true,
            description = "Weryfikacja czy strona 'Edycja usługi' posiada prawidłowy tytuł.")
    public void weryfikacjaTytuluStronyEdycjaUslugi() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.przejdzDoPierwszejUslugiZListy();

        Assert.assertEquals(edycjaUslugiPage.zwrocAktualnyTytulStronyEdycjaUslugi(),
                edycjaUslugiPage.zwrocPoprawnyTytulStronyEdycjaUslugi(), "Tytul strony 'Edycja usługi' nie jest poprawny.");
    }

    //test weryfikuje czy po procesie utworzenia nowej uslugi nastepuje przekierowanie do strony 'Edycja uslugi' poprzez
    //znalezienie na stronie tekstu 'Edycja usługi:'
    @Test(priority = 30, enabled = true,
            description = "Weryfikacja czy po utworzeniu nowej uslugi nastepuje przejscie do strony 'Edycja uslugi'.")
    public void weryfikacjaCzyPoUtworzeniuNowejUslugiNastepujePrzejscieDoEdycjiUslugi() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.utworzNowaUsluge();
        edycjaUslugiPage.poczekajNaUstawienia();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyOtwartaStronaToEdycjaUslugi(),
                "Po utworzeniu uslugi nie nastąpiło przejscie do strony 'Edycja usługi'.");
    }

    //test weryfikuje obecnosc zakladek 'Podstawowe' i 'Generator linkow' po przejsciu na strone edycji uslugi
    //poprzez klikniecie w pierwsza usluge w tabeli uslug
    @Test(priority = 40, enabled = true,
            description = "Weryfikacja czy na stronie Edycja usługi istnieja zakladki 'Podstawowe' i 'Generator linkow'.")
    public void weryfikacjaCzyIstniejaZakladkiPodstawoweIGeneratorLinkow() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.przejdzDoPierwszejUslugiZListy();
        edycjaUslugiPage.poczekajNaUstawienia();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyWMenuBocznymIstniejaPodstawoweIGeneratorLinkow(),
                "Sekcje 'Podstawowe' i/lub 'Generator linkow' nie istnieja.");
    }
    //test weryfikuje obecnosc przycisku 'Zobacz usługę' po przejsciu na strone edycji uslugi
    //poprzez klikniecie w pierwsza usluge w tabeli uslug
    @Test(priority = 50, enabled = true,
            description = "Weryfikacja czy na stronie 'Edycja usługi' istnieje przycisk 'Zobacz usługę'.")
    public void weryfikacjaCzyIstniejaPrzyciskZobaczUsluge() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.przejdzDoPierwszejUslugiZListy();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyIstniejeZobaczUslugeButton(), "Przycisk 'Zobacz usługę' nie istnieje.");
    }

    //test weryfikuje obecnosc wszystkich 6 sekcji ustawien przez zebranie WebElementow do listy i wyrzuceniu ich tekstow do nowej listy
    //nastepnie nowo utworzona liste porownuje z lista wzorowa
    @Test(priority = 60, enabled = true,
            description = "Weryfikacja czy na stronie Edycja usługi istnieja wszystkie sekcje ustawień.")
    public void weryfikacjaCzyIstniejaSekcjeUstawien() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.przejdzDoPierwszejUslugiZListy();
        edycjaUslugiPage.poczekajNaUstawienia();

        Assert.assertEquals(edycjaUslugiPage.zwrocAktualneSekcje(),
                edycjaUslugiPage.zwrocPoprawneSekcje(), "Nie wszystkie sekcje ustawien istnieja.");
    }

    // Utworzyć usługę na kwotę 2999 zł. Dodać krótki opis na 120 znaków. Dodać 10 kategorii oraz 5 tagów (obojętnie jakie) musi zgadzać się tylko ich liczba.
    // Następnie ustalić cenę promocyjną (sekcja Cena). Cenę promocyjną ustalić na 499 zł. Rozpoczęcie promocji od 16.06.2025.
    // Zakończenie promocji 02.07.2025. Łączna liczba dostępnych sztuk  (powinno być losowo od 1 do 50).
    // Na końcu sprawdzić czy link zakupowy (ekran „Generator linków”) działa poprawnie –
    // trzeba sprawdzić czy po uruchomieniu linku dostajemy się na ekran, na którym jest przycisk „ZAMAWIAM I PŁACĘ”.
    @Test(priority = 70, enabled = true,
            description = "Weryfikacja czy po stworzeniu usługi z konkretnymi danymi wejsciowymi na stronie 'Zamowienia' pojawia sie przycisk 'Zamawiam i płacę'.")
    public void weryfikacjaCzyIstniejePrzyciskZamawiamIPlace() {
        logowanieIPrzejscieDoStronyUslugi();
        uslugiPage.utworzNowaUslugeZadanie();
        edycjaUslugiPage.poczekajNaUstawienia();
        edycjaUslugiPage.ustawLiczbeSztukDoZakupu();

        //aby usługa była dostępna do sprzedaży to poza liczbą sztuk do zakupu trzeba też wprowadzić ilość pozostałych sztuk do zakupu
        edycjaUslugiPage.ustawLiczbePozostalychSztuk();

        //włączenie sprzedaży jest konieczne aby na ostatniej stronie pojawił sie przycisk 'Zamawiam i płacę'
        edycjaUslugiPage.wlaczSprzedaz();

        edycjaUslugiPage.ustawKrotkiOpis();
        edycjaUslugiPage.ustaw10Kategorii();
        edycjaUslugiPage.ustaw5Tagow();
        edycjaUslugiPage.ustawCeneOrazDatePromocji();
        edycjaUslugiPage.kliknijGeneratorLikow();
        edycjaUslugiPage.poczekajNaUstawieniaGeneratorLinkow();
        edycjaUslugiPage.przejdzDoZakupuUslugi();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyIstniejeZamawiamIPlaceButton(), "Przycisk 'Zamawiam i płacę' nie jest widoczny.");
    }


}
