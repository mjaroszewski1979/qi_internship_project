package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.UstawieniaPage;
import pages.ustawienia.ZaawansowanePage;
import tests.TestBase;


public class ZaawansowanePageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Zaawansowane"
    private ZaawansowanePage zaawansowanePage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpZaawansowanePage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        zaawansowanePage = new ZaawansowanePage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Zaawansowane" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Zaawansowane")
    public void zweryfikujPoprawnyUrlZaawansowane() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZaawansowane();
        Assert.assertEquals(zaawansowanePage.getAktualnyUrlZaawansowane(), zaawansowanePage.getPoprawnyUrlZaawansowane(),  "Url strony Zaawansowane nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Zaawansowane" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Zaawansowane")
    public void zweryfikujPoprawnyTytulZaawansowane() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZaawansowane();
        Assert.assertEquals(zaawansowanePage.getAktualnyTytulZaawansowane(), zaawansowanePage.getPoprawnyTytulZaawansowane(),  "Tytul strony Zaawansowane nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Zaawamsowane"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce zaawansowane")
    public void zweryfikujPoprawnoscSekcjiZaawansowane() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZaawansowane();
        Assert.assertTrue(zaawansowanePage.czyZakladkaZaawansowanePosiadaWlasciweSekcje(),   "Sekcje w zakladce zaawansowane nie sa poprawne");
    }







}
