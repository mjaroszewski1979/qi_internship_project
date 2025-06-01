package pages.seleniumShop;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.seleniumShop.LoginPage;
import pages.seleniumShop.MainPage;
import tests.TestBase;


public class SzczegolyKontaTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private MainPage mainPage;//instancja strony logowania
    private SzczegolyKontaPage szczegolyKontaPage;
    private LoginPage loginPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpSzczegolyKonta(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        mainPage = new MainPage(driver);
        szczegolyKontaPage = new SzczegolyKontaPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void werfikacjaFormularzaZamianyhasla(){
        mainPage.przejdzDoEkranuLogowania();
        loginPage.wpiszLoginDoPolaLogin();
        loginPage.wpiszHasloDoPolaHaslo();
        loginPage.nacisnijPrzyciskZalogujSie();
        szczegolyKontaPage.przejscieDoSzczegoliKonta();


        Assert.assertTrue(szczegolyKontaPage.czyFormularzZmianyHaslaPoprawny(), "Formularz zmiany hasła nie jest poprawny");

    }


}
