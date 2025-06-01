package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EdytujTestPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.TestyPage;

public class EdytujTestPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private TestyPage testyPage;
    private EdytujTestPage edytujTestPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        testyPage = new TestyPage(driver);
        edytujTestPage = new EdytujTestPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy strona edycji testow zlokalizowana po nacisnieciu w test w zakladce testy, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLStronyEdytujTest() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();
        testyPage.nacisnijPierwszyZakonczonyTestWZakladceTesty();

        Assert.assertEquals(edytujTestPage.zwrocAktualnyURLStronyEdytujTest(), edytujTestPage.zwrocPoprawnyURLStronyEdytujTest());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy strona edycji testow zlokalizowana po nacisnieciu w test w zakladce testy, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluStronyEdytujTest() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();
        testyPage.nacisnijPierwszyZakonczonyTestWZakladceTesty();

        Assert.assertEquals(edytujTestPage.zwrocPoprawnyTytulStronyEdytujTest(), edytujTestPage.zwrocAktualnyTytulStronyEdytujTest());
    }
}
