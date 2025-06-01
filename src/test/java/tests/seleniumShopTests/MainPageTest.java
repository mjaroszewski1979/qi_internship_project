package tests.seleniumShopTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.seleniumShop.MainPage;
import tests.TestBase;


public class MainPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private MainPage mainPage; //instancja strony logowania

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        mainPage = new MainPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony głównej")
    public void weryfikacjaTytuluStronyKoszyka(){
        mainPage.przejdzDoKoszyka();

        Assert.assertEquals(mainPage.zwroctytulAktualnejStrony(), mainPage.zwrocPoprawnyTytulStronyKoszyk(), "Tytuł strony koszyka nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja liczby pozycji w menu głównym"  )
   public void weryfikacjaLiczyPozycjiWMenuGlownym()  {

        Assert.assertEquals(mainPage.zworcLiczbePozycjiWMenuGlownym(), 9, "Liczba pozycji w menu główym nie jest poprawna");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja poprawnego adresu strony koszyka"  )
    public void weryfikacjaPoprawnegoAdresuStronyKoszyka(){
        mainPage.przejdzDoKoszyka();

        Assert.assertEquals(mainPage.zwrocaktualnyUrlStronyNaKtorejJestes(), mainPage.zwrocPoprawnyUrlKoszyka(), "Adres url nie jest poprawny");
    }

    @Test
    public void weryfikacjaNazwPozycjiWMenuGlownym(){

        Assert.assertEquals(mainPage.zwrocNazwyPozycjiMenuGlownego(), mainPage.zwrocPoprawneNazywyPozycjiMenuGlownego(), "Nazwy pozycji w menu głównego nie są poprawne" );
    }


}
