package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia.SzablonyPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;


public class SzablonyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private SzablonyPage szablonyPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpSzablonyPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        szablonyPage = new SzablonyPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Szablony" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony szablony")
    public void zweryfikujPoprawnyUrlUSzablony() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSzablony();
        Assert.assertEquals(szablonyPage.getAktualnyUrlSzablony(), szablonyPage.getPoprawnyUrlSzablony(),  "Url strony szablony nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Szablony" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony szablony")
    public void zweryfikujPoprawnyTytulUSzablony() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSzablony();
        Assert.assertEquals(szablonyPage.getAktualnyTytulSzablony(), szablonyPage.getPoprawnyTytulSzablony(),  "Tytul strony szablony nie jest poprawny");
    }







}
