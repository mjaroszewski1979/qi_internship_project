package tests.kursyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.kursy.KursyPage;
import pages.kursy.WszyscyUczestnicyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import tests.TestBase;


public class WszyscyUczestnicyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private WszyscyUczestnicyPage wszyscyUczestnicyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPWszyscyUczestnicyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        wszyscyUczestnicyPage = new WszyscyUczestnicyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony 'Wszyscy uczestnicy' jest poprawny
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Wszyscy uczestnicy'")
    public void weryfikacjaPoprawnegoAdresuStronyWszyscyUczestnicy(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoZakladkiKursyWszyscyUczestnicy();

        Assert.assertEquals(wszyscyUczestnicyPage.zwrocUrlAktualnejStrony(), wszyscyUczestnicyPage.zwrocPoprawnyUrlKursyWszyscyUczestnicy(),
                "Adres url nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony 'Wszyscy uczestnicy' jest poprawny
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Wszyscy uczestnicy'")
    public void weryfikacjaTytuluStronyWszyscyUczestnicy(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoZakladkiKursyWszyscyUczestnicy();

        Assert.assertEquals(wszyscyUczestnicyPage.zwroctTytulAktualnejStrony(), wszyscyUczestnicyPage.zwrocPoprawnyTytulStronyKursyWszyscyUczestnicy(),
                "Tytuł strony nie jest poprawny" );
    }

}
