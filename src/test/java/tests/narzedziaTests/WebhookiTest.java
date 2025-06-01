package tests.narzedziaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.narzedzia.LogiPage;
import pages.narzedzia.NarzedziaPage;
import pages.narzedzia.WebhookiPage;
import tests.TestBase;

public class WebhookiTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private NarzedziaPage narzedziaPage;
    private WebhookiPage webhookiPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        narzedziaPage = new NarzedziaPage(driver);
        webhookiPage = new WebhookiPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony WEBHOOKI")
    public void weryfikacjaTytuluStronyWebhooki(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijNarzedziaWebhookiMenu();

        Assert.assertEquals(webhookiPage.zwrocAktualnyTytulStronyWebhooki(),
                        webhookiPage.zwrocPoprawnyTytulStronyWebhooki(),
                "Tytuł strony WEBHOOKI nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony WEBHOOKI"  )
    public void weryfikacjaPoprawnegoAdresuStronyWebhooki(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijNarzedziaWebhookiMenu();

        Assert.assertEquals(webhookiPage.zwrocAktualnyUrlStronyWebhooki(),
                webhookiPage.zwrocPoprawnyUrlStronyWebhooki(),
                "Adres url strony WEBHOOKI nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja przejścia do strony WEBHOOKI z poziomu strony NARZĘDZIA")
    public void weryfikacjaPrzejsciaDoStronyWebhookiZPoziomuNarzedzia() {

        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiNarzedzia();
        narzedziaPage.przejdzDoZakladkiNarzedziaWebhookiMenuBoczne();

        Assert.assertEquals(webhookiPage.zwrocAktualnyTytulStronyWebhooki(),
                webhookiPage.zwrocPoprawnyTytulStronyWebhooki(),
                "Tytuł strony WEBHOOKI nie jest poprawny");

        Assert.assertEquals(webhookiPage.zwrocAktualnyUrlStronyWebhooki(),
                webhookiPage.zwrocPoprawnyUrlStronyWebhooki(),
                "Adres url strony WEBHOOKI nie jest poprawny");
    }

}
