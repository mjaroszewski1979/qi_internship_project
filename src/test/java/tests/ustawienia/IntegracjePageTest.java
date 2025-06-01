package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.UstawieniaPage;
import pages.ustawienia.IntegracjePage;
import tests.TestBase;


public class IntegracjePageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Integracje"
    private IntegracjePage integracjePage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpIntegracjePage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        integracjePage = new IntegracjePage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Integracje" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony inegracje")
    public void zweryfikujPoprawnyUrlIntegracje() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkIntegracje();
        Assert.assertEquals(integracjePage.getAktualnyUrlIntegracje(), integracjePage.getPoprawnyUrlIntegracje(),  "Url strony inegracje nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Integracje" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony inegracje")
    public void zweryfikujPoprawnyTytulIntegracje() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkIntegracje();
        Assert.assertEquals(integracjePage.getAktualnyTytulIntegracje(), integracjePage.getPoprawnyTytulIntegracje(),  "Tytul strony inegracje nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Integracje"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce integracje")
    public void zweryfikujPoprawnoscSekcjiIntegracje() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkIntegracje();
        Assert.assertTrue(integracjePage.czyZakladkaIntegracjePosiadaWlasciweSekcje(),   "Sekcje w zakladce integracje nie sa poprawne");
    }







}
