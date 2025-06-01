package tests.narzedziaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.narzedzia.NarzedziaPage;
import pages.narzedzia.PrzekierowaniaPage;
import pages.narzedzia.WebhookiPage;
import tests.TestBase;

public class PrzekierowaniaTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private NarzedziaPage narzedziaPage;
    private PrzekierowaniaPage przekierowaniaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        narzedziaPage = new NarzedziaPage(driver);
        przekierowaniaPage = new PrzekierowaniaPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony PRZEKIEROWANIA")
    public void weryfikacjaTytuluStronyPrzekierowania(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijNarzedziaPrzekierowaniaMenu();

        Assert.assertEquals(przekierowaniaPage.zwrocAktualnyTytulStronyPrzekierowania(),
                przekierowaniaPage.zwrocPoprawnyTytulStronyPrzekierowania(),
                "Tytuł strony PRZEKIEROWANIA nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony PRZEKIEROWANIA"  )
    public void weryfikacjaPoprawnegoAdresuStronyPrzekierowania(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijNarzedziaPrzekierowaniaMenu();

        Assert.assertEquals(przekierowaniaPage.zwrocAktualnyUrlStronyPrzekierowania(),
                przekierowaniaPage.zwrocPoprawnyUrlStronyPrzekierowania(),
                "Adres url strony PRZEKIEROWANIA nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja przejścia do strony PRZEKIEROWANIA z poziomu strony NARZĘDZIA")
    public void weryfikacjaPrzejsciaDoStronyPrzekierowaniaZPoziomuNarzedzia() {

        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();
        narzedziaPage.przejdzDoZakladkiNarzedziaPrzekierowaniaMenuBoczne();

        Assert.assertEquals(przekierowaniaPage.zwrocAktualnyTytulStronyPrzekierowania(),
                przekierowaniaPage.zwrocPoprawnyTytulStronyPrzekierowania(),
                "Tytuł strony PRZEKIEROWANIA nie jest poprawny");

        Assert.assertEquals(przekierowaniaPage.zwrocAktualnyUrlStronyPrzekierowania(),
                przekierowaniaPage.zwrocPoprawnyUrlStronyPrzekierowania(),
                "Adres url strony PRZEKIEROWANIA nie jest poprawny");
    }

}
