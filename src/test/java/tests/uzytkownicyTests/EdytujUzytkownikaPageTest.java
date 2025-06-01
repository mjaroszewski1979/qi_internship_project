package tests.uzytkownicyTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.uzytkownicy.EdytujUzytkownikaPage;
import pages.uzytkownicy.UzytkownicyPage;
import tests.TestBase;
import static helpers.Utils.generatePassword;




public class EdytujUzytkownikaPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/



    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UzytkownicyPage uzytkownicyPage;
    private EdytujUzytkownikaPage edytujUzytkownikaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpEdytujUzytkownikaPagePage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uzytkownicyPage = new UzytkownicyPage(driver);
        edytujUzytkownikaPage = new EdytujUzytkownikaPage(driver);
    }



    // Test sprawdzający cały proces zmiany hasla uzytkownika testowego – od logowania po finalną weryfikację
    @Test(priority = 110, enabled = true, description = "Weryfikacja poprawnosci procesu zmiany hasla uzytkownika testowego")
    public void zweryfikujProcesZmianyHAslaUzytkownikaTestowego() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkaUzytkownicyMenuBoczne();
        uzytkownicyPage.kliknijLinkTestUser();
        edytujUzytkownikaPage.aktualizujKontoUzytkownika();
        Assert.assertTrue(edytujUzytkownikaPage.czyZmianaHaslaPoprawna(), "Proces zmiany hasla uzytkownika tetsowego przebiega nieprawidlowo");
    }










}
