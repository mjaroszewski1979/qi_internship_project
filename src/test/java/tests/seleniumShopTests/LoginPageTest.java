package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPageNew;


public class LoginPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPage; //instancja strony logowania

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPage = new LoginPageNew(driver);
    }



    @Test
    public void weryfikacjaLogowaniaDoAplikacji(){
        loginPage.wykonajLogowanie();


        Assert.assertTrue(loginPage.sprawdzCzyTekstWZrodleStronyIstnieje(), "Nie znaleziono tekstu Witaj na stronie");

    }

}
