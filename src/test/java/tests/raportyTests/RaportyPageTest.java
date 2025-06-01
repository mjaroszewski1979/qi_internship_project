package tests.raportyTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.raporty.RaportyPage;
import tests.TestBase;


public class RaportyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private RaportyPage raportyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPRaportyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        raportyPage = new RaportyPage(driver);

    }
    // Test weryfikujący, czy adres URL strony 'Raporty' jest poprawny
    public void weryfikacjaPoprawnegoAdresuStronyRaporty(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiRaporty();

        Assert.assertEquals(raportyPage.zwrocUrlAktualnejStrony(), raportyPage.zwrocPoprawnyUrlRaportow(), "Adres url nie jest poprawny");
    }
    // Test weryfikujący, czy tytuł strony 'Raporty' jest poprawny
    public void weryfikacjaTytuluStronyRaporty(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiRaporty();

        Assert.assertEquals(raportyPage.zwroctTytulAktualnejStrony(), raportyPage.zwrocPoprawnyTytulStronyRaporty(), "Tytuł strony nie jest poprawny" );
    }

}
