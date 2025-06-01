package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.WygladPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class WygladPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/



    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Wygląd"
    private WygladPage wygladPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpWygladPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        wygladPage = new WygladPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Wygląd" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony wyglad")
    public void zweryfikujPoprawnyUrlWyglad() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWyglad();
        Assert.assertEquals(wygladPage.getAktualnyUrlWyglad(), wygladPage.getPoprawnyUrlWyglad(),  "Url strony wyglad nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Wygląd" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja url strony wyglad")
    public void zweryfikujPoprawnyTytulWyglad() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWyglad();
        Assert.assertEquals(wygladPage.getAktualnyTytulWyglad(), wygladPage.getPoprawnyTytulWyglad(),  "Tytul strony wyglad nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Wyglad"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce wyglad")
    public void zweryfikujPoprawnoscSekcjiWyglad() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWyglad();
        Assert.assertTrue(wygladPage.czyZakladkaWygladPosiadaWlasciweSekcje(),   "Sekcje w zakladce wyglad nie sa poprawne");
    }







}
