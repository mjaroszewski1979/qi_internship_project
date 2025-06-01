package tests.sprzedazTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.sprzedaz.HistoriaCenPage;
import tests.TestBase;


public class HistoriaCenPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private HistoriaCenPage historiaCenPage; //instancja strony logowania

    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        historiaCenPage = new HistoriaCenPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony HISTORIA CEN")
    public void weryfikacjaTytuluStronyHistoriaCen(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazHistoriaCenMenu();

        Assert.assertEquals(historiaCenPage.zwrocAktualnyTytulStronyHistoriaCen(),
                historiaCenPage.zwrocPoprawnyTytulStronyHistoriaCen(),
                "Tytuł strony HISTORIA CEN nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony HISTORIA CEN"  )
    public void weryfikacjaPoprawnegoAdresuStronyHistoriaCen(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazHistoriaCenMenu();

        Assert.assertEquals(historiaCenPage.zwrocAktualnyUrlStronyHistoriaCen(),
                historiaCenPage.zwrocPoprawnyUrlStronyHistoriaCen(),
                "Adres url strony HISTORIA CEN nie jest poprawny");
    }









}
