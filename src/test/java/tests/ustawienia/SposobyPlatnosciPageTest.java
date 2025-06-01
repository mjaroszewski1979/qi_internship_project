package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.SposobyPlatnosciPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class SposobyPlatnosciPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private SposobyPlatnosciPage sposobyPlatnosciPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpSposobyPlatnosciPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        sposobyPlatnosciPage = new SposobyPlatnosciPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Sposoby platnosci" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony sposoby Platnosci")
    public void zweryfikujPoprawnyUrlSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertEquals(sposobyPlatnosciPage.getAktualnyUrlSposobyPlatnosci(), sposobyPlatnosciPage.getPoprawnyUrlSposobyPlatnosci(),  "Url strony sposoby Platnosci nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Sposoby platnosci" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony sposoby Platnosci")
    public void zweryfikujPoprawnyTytulSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertEquals(sposobyPlatnosciPage.getAktualnyTytulSposobyPlatnosci(), sposobyPlatnosciPage.getPoprawnyTytulSposobyPlatnosci(),  "Tytul strony sposoby Platnosci nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Sposoby platnosci"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce sposoby platnosci")
    public void zweryfikujPoprawnoscSekcjiZakladkaSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertTrue(sposobyPlatnosciPage.czyZakladkaSposobyPlatnosciPosiadaWlasciweSekcje(),   "Sekcje w zakladce sposoby platnosci nie sa poprawne");
    }







}
