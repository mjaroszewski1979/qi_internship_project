package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.WlaczModulyPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class WlaczModulyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "WlaczModuly"
    private WlaczModulyPage wlaczModuly;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpWlaczModulyPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        wlaczModuly = new WlaczModulyPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "WlaczModuly" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony WlaczModuly")
    public void zweryfikujPoprawnyUrlWlaczModuly() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWlaczModuly();
        Assert.assertEquals(wlaczModuly.getAktualnyUrlWlaczModuly(), wlaczModuly.getPoprawnyUrlWlaczModuly(),  "Url strony WlaczModuly nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "WlaczModuly" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony WlaczModuly")
    public void zweryfikujPoprawnyTytulWlaczModuly() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWlaczModuly();
        Assert.assertEquals(wlaczModuly.getAktualnyTytulWlaczModuly(), wlaczModuly.getPoprawnyTytulWlaczModuly(),  "Tytul strony WlaczModuly nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Wlacz moduly"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce wlacz moduly")
    public void zweryfikujPoprawnoscSekcjiWlaczModuly() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWlaczModuly();
        Assert.assertTrue(wlaczModuly.czyZakladkaWlaczModulyPosiadaWlasciweSekcje(),   "Sekcje w zakladce wlacz moduly nie sa poprawne");
    }







}
