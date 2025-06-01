package tests.ustawienia;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.ustawienia.CertyfikatyPage;
import pages.ustawienia.UstawieniaPage;
import tests.TestBase;

public class CertyfikatyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private CertyfikatyPage certyfikatyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        certyfikatyPage = new CertyfikatyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony "Certyfikaty" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Certyfikaty")
    public void zweryfikujPoprawnyUrlCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertEquals(certyfikatyPage.getAktualnyUrlCertyfikaty(), certyfikatyPage.getPoprawnyUrlCertyfikaty(),  "Url strony Certyfikaty nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Certyfikaty" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Certyfikaty")
    public void zweryfikujPoprawnyTytulCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertEquals(certyfikatyPage.getAktualnyTytulCertyfikaty(), certyfikatyPage.getPoprawnyTytulCertyfikaty(),  "Tytul strony Certyfikaty nie jest poprawny");
    }

    // Test weryfikujący poprawność widocznych sekcji w zakładce "Certyfikaty"
    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce certyfikaty")
    public void zweryfikujPoprawnoscSekcjiCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertTrue(certyfikatyPage.czyZakladkaCertyfikatyPosiadaWlasciweSekcje(),   "Sekcje w zakladce certyfikaty nie sa poprawne");
    }
}
