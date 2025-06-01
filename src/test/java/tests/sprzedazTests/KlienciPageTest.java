package tests.sprzedazTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.sprzedaz.KlienciPage;
import tests.TestBase;


public class KlienciPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KlienciPage klienciPage; //instancja strony logowania

    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        klienciPage = new KlienciPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony KLIENCI")
    public void weryfikacjaTytuluStronyKlienci(){

        loginPageNew.wykonajLogowanie();;
        panelPage.kliknijSprzedazKlienciMenu();

        Assert.assertEquals(klienciPage.zwrocAktualnyTytulStronyKlienci(),
                klienciPage.zwrocPoprawnyTytulStronyKlienci(),
                "Tytuł strony KLIENCI nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony KLIENCI"  )
    public void weryfikacjaPoprawnegoAdresuStronyKlienci(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKlienciMenu();

        Assert.assertEquals(klienciPage.zwrocAktualnyUrlStronyKlienci(),
                klienciPage.zwrocPoprawnyUrlStronyKlienci(),
                "Adres url strony KLIENCI nie jest poprawny");
    }






}
