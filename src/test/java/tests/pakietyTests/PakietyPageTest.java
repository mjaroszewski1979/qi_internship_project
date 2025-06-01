package tests.pakietyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.kursy.KursyPage;
import pages.pakiety.PakietyPage;
import tests.TestBase;


public class PakietyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private PakietyPage pakietyPage;


    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPPakietyPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        pakietyPage = new PakietyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony 'Pakiety' jest poprawny.
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Pakiety'")
    public void weryfikacjaPoprawnegoAdresuStronyPakiety() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPakiety();

        Assert.assertEquals(pakietyPage.zwrocUrlAktualnejStrony(), pakietyPage.zwrocPoprawnyUrlPakiety(),
                "Adres url nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony 'Pakiety' jest poprawny.
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Pakiety'")
    public void weryfikacjaTytuluStronyPakiety() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPakiety();

        Assert.assertEquals(pakietyPage.zwroctTytulAktualnejStrony(), pakietyPage.zwrocPoprawnyTytulStronyPakiety(),
                "Tytuł strony nie jest poprawny");
    }

}
