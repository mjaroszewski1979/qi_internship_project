package tests.seleniumShopTests;

import org.testng.annotations.BeforeMethod;
import pages.seleniumShop.ZalogowanyPage;
import tests.TestBase;


public class ZalogowanyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private ZalogowanyPage zalogowanyPage; //instancja strony logowania


    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        zalogowanyPage = new ZalogowanyPage(driver);

    }






}
