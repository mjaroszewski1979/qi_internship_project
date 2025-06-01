package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustawienia.AnalitykaSkryptyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class AnalitykaSkryptyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/



    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "AnalitykaSkrypty"
    private AnalitykaSkryptyPage avalitykaSkryptyPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpAnalitykaSkryptyPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        avalitykaSkryptyPage = new AnalitykaSkryptyPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "AnalitykaSkrypty" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony AnalitykaSkrypty")
    public void zweryfikujPoprawnyUrlAnalitykaSkrypty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkAnalitykaSkrypty();
        Assert.assertEquals(avalitykaSkryptyPage.getAktualnyUrlAnalitykaSkrypty(), avalitykaSkryptyPage.getPoprawnyUrlAnalitykaSkrypty(),  "Url strony AnalitykaSkrypty nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "AnalitykaSkrypty" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony AnalitykaSkrypty")
    public void zweryfikujPoprawnyTytulAnalitykaSkrypty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkAnalitykaSkrypty();
        Assert.assertEquals(avalitykaSkryptyPage.getAktualnyTytulAnalitykaSkrypty(), avalitykaSkryptyPage.getPoprawnyTytulAnalitykaSkrypty(),  "Tytul strony AnalitykaSkrypty nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Analityka Skrypty"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce analityka skrypty")
    public void zweryfikujPoprawnoscSekcjiAnalitykaSkrypty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkAnalitykaSkrypty();
        Assert.assertTrue(avalitykaSkryptyPage.czyZakladkaAnalitykaSkryptyPosiadaWlasciweSekcje(), "Sekcje w zakladce analityka skrypty nie sa poprawne");
    }







}
