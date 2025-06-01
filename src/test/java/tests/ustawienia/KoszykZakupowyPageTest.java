package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ustawienia.KoszykZakupowyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class KoszykZakupowyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/




    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Koszyk Zakupowy"
    private KoszykZakupowyPage koszykZakupowyPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpKoszykZakupowyPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        koszykZakupowyPage = new KoszykZakupowyPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Koszyk Zakupowy" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony koszyk Zakupowy")
    public void zweryfikujPoprawnyUrlKoszykZakupowy() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkKoszykZakupowy();
        Assert.assertEquals(koszykZakupowyPage.getAktualnyUrlKoszykZakupowy(), koszykZakupowyPage.getPoprawnyUrlKoszykZakupowy(),  "Url strony koszyk Zakupowy nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Koszyk Zakupowy" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony koszyk Zakupowy")
    public void zweryfikujPoprawnyTytulKoszykZakupowy() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkKoszykZakupowy();
        Assert.assertEquals(koszykZakupowyPage.getAktualnyTytulKoszykZakupowy(), koszykZakupowyPage.getPoprawnyTytulKoszykZakupowy(),  "Tytul strony koszyk Zakupowy nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Koszyk zakupowy"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce koszyk zakupowy")
    public void zweryfikujPoprawnoscSekcjiKoszykZakupowy() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkKoszykZakupowy();
        Assert.assertTrue(koszykZakupowyPage.czyZakladkaKoszykZakupowyPosiadaWlasciweSekcje(),   "Sekcje w zakladce koszyk zakupowy nie sa poprawne");
    }







}
