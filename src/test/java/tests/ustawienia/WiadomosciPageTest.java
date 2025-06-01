package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.WiadomosciPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class WiadomosciPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Wiadomosci"
    private WiadomosciPage wiadomosciPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpWiadomosciPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        wiadomosciPage = new WiadomosciPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Wiadomosci" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Wiadomosci")
    public void zweryfikujPoprawnyUrlWiadomosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWiadomosci();
        Assert.assertEquals(wiadomosciPage.getAktualnyUrlWiadomosci(), wiadomosciPage.getPoprawnyUrlWiadomosci(),  "Url strony Wiadomosci nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Wiadomosci" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Wiadomosci")
    public void zweryfikujPoprawnyTytulWiadomosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWiadomosci();
        Assert.assertEquals(wiadomosciPage.getAktualnyTytulWiadomosci(), wiadomosciPage.getPoprawnyTytulWiadomosci(),  "Tytul strony Wiadomosci nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Wiadomosci"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce wiadomosci")
    public void zweryfikujPoprawnoscSekcjiWiadomosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWiadomosci();
        Assert.assertTrue(wiadomosciPage.czyZakladkaWiadomosciPosiadaWlasciweSekcje(),   "Sekcje w zakladce wiadomosci nie sa poprawne");
    }







}
