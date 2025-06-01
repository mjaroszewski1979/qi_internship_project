package tests.sprzedazTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.sprzedaz.PlatnosciZaplanowanePage;
import tests.TestBase;


public class PlatnosciZaplanowanePageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private PlatnosciZaplanowanePage platnosciZaplanowanePage; //instancja strony logowania

    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        platnosciZaplanowanePage = new PlatnosciZaplanowanePage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony PŁATNOŚCI ZAPLANOWANE")
    public void weryfikacjaTytuluStronyPlatnosciZaplanowane(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazPlatnosciZaplanowaneMenu();

        Assert.assertEquals(platnosciZaplanowanePage.zwrocAktualnyTytulStronyPlatnosciZaplanowane(),
                platnosciZaplanowanePage.zwrocPoprawnyTytulStronyPlatnosciZaplanowane(),
                "Tytuł strony PŁATNOŚCI ZAPLANOWANE nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony PŁATNOŚCI ZAPLANOWANE"  )
    public void weryfikacjaPoprawnegoAdresuStronyPlatnosciZaplanowane(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazPlatnosciZaplanowaneMenu();

        Assert.assertEquals(platnosciZaplanowanePage.zwrocAktualnyUrlStronyPlatnosciZaplanowane(),
                platnosciZaplanowanePage.zwrocPoprawnyUrlStronyPlatnosciZaplanowane(),
                "Adres url strony PŁATNOŚCI ZAPLANOWANE nie jest poprawny");
    }









}
