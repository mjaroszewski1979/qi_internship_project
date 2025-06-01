package tests.narzedziaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.narzedzia.LogiPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.narzedzia.NarzedziaPage;
import tests.TestBase;

public class LogiPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private NarzedziaPage narzedziaPage;
    private LogiPage logiPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        narzedziaPage = new NarzedziaPage(driver);
        logiPage = new LogiPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakladka logi w menu bocznym, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiLogi() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiLogi();

        Assert.assertEquals(logiPage.zwrocAktualnyURLZakladkiLogi(), logiPage.zwrocPoprawnyURLZakladkiLogi());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakladka logi w menu bocznym, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluZakladkiLogi() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiLogi();

        Assert.assertEquals(logiPage.zwrocAktualnyTytulZakladkiLogi(), logiPage.zwrocPoprawnyTytulZakladkiLogi());
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja przejścia do strony LOGI z poziomu strony NARZĘDZIA")
    public void weryfikacjaPrzejsciaDoStronyLogiZPoziomuNarzedzia() {

        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();
        narzedziaPage.przejdzDoZakladkiNarzedziaLogiMenuBoczne();

        Assert.assertEquals(logiPage.zwrocAktualnyTytulZakladkiLogi(), logiPage.zwrocPoprawnyTytulZakladkiLogi(),
                "Tytuł strony LOGI nie jest poprawny");

        Assert.assertEquals(logiPage.zwrocAktualnyURLZakladkiLogi(), logiPage.zwrocPoprawnyURLZakladkiLogi(),
                "Adres url strony LOGI nie jest poprawny");
    }


}
