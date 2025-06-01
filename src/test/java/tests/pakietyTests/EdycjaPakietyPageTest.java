package tests.pakietyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.pakiety.EdycjaPakietyPage;
import pages.pakiety.PakietyPage;
import tests.TestBase;


public class EdycjaPakietyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private PakietyPage pakietyPage;
    private EdycjaPakietyPage edycjaPakietyPage;


    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPEdycjaPakietyPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        pakietyPage = new PakietyPage(driver);
        edycjaPakietyPage = new EdycjaPakietyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony 'Edycja pakietu' jest poprawny.
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Edycja pakietu'")
    public void weryfikacjaPoprawnegoAdresuStronyEdycjaPakietu() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPakiety();
        pakietyPage.przejdzDoDodaniaNowegoPakietu();
        pakietyPage.poczekajNaOknoUtworzNowyPakiet();
        pakietyPage.wpiszNazwePakietu();
        pakietyPage.wpiszCenePakietu();
        pakietyPage.nacisnijPrzyciskUtworzIEdytuj();

        Assert.assertTrue(edycjaPakietyPage.zwrocUrlAktualnejStronyEdycjaPakietu(),
                "Adres url nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony 'Edycja pakietu' jest poprawny.
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Edycja pakietu'")
    public void weryfikacjaTytuluStronyEdycjaPakietu() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPakiety();
        pakietyPage.przejdzDoDodaniaNowegoPakietu();
        pakietyPage.poczekajNaOknoUtworzNowyPakiet();
        pakietyPage.wpiszNazwePakietu();
        pakietyPage.wpiszCenePakietu();
        pakietyPage.nacisnijPrzyciskUtworzIEdytuj();
        edycjaPakietyPage.poczekajNaOknoEdycjaPakietu();


        Assert.assertEquals(edycjaPakietyPage.zwroctTytulAktualnejStrony(), edycjaPakietyPage.zwrocPoprawnyTytulStronyEdycjaPakietu(),
                "Tytuł strony nie jest poprawny");
    }

}
