package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.UstawieniaPage;
import pages.ustawienia.ZakupyNaPrezentPage;
import tests.TestBase;


public class ZakupyNaPrezentPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Zakupy Na Prezent"
    private ZakupyNaPrezentPage zakupyNaPrezentPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpZakupyNaPrezentPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        zakupyNaPrezentPage = new ZakupyNaPrezentPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Zakupy Na Prezent" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Zakupy Na Prezent")
    public void zweryfikujPoprawnyUrlZakupyNaPrezent() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZakupyNaPrezent();
        Assert.assertEquals(zakupyNaPrezentPage.getAktualnyUrlZakupyNaPrezent(), zakupyNaPrezentPage.getPoprawnyUrlZakupyNaPrezent(),  "Url strony Zakupy Na Prezent nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Zakupy Na Prezent" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Zakupy Na Prezent")
    public void zweryfikujPoprawnyTytulZakupyNaPrezent() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZakupyNaPrezent();
        Assert.assertEquals(zakupyNaPrezentPage.getAktualnyTytulZakupyNaPrezent(), zakupyNaPrezentPage.getPoprawnyTytulZakupyNaPrezent(),  "Tytul strony Zakupy Na Prezent nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Zakupy na prezent"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce zakupy na prezent")
    public void zweryfikujPoprawnoscSekcjiZakupyNaPrezent() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkZakupyNaPrezent();
        Assert.assertTrue(zakupyNaPrezentPage.czyZakladkaZakupyNaPrezentPosiadaWlasciweSekcje(),   "Sekcje w zakladce zakupy na prezent nie sa poprawne");
    }







}
