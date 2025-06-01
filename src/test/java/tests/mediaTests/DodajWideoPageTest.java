package tests.mediaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.media.DodajWideoPage;
import pages.media.WideoPage;
import tests.TestBase;

public class DodajWideoPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private WideoPage wideoPage;
    private DodajWideoPage dodajWideoPage;

    @BeforeMethod
    public void setUpWideoPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        wideoPage = new WideoPage(driver);
        dodajWideoPage = new DodajWideoPage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do strony "Dodaj wideo"
    private void przejdzDoStronyDodajWideo() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiWideo();
        wideoPage.kliknijDodajWideoButton();
    }

    // Sprawdza czy adres URL strony "Dodaj wideo" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Dodaj wideo'")
    public void weryfikacjaAdresuUrlStronyDodajWideoTest() {
        przejdzDoStronyDodajWideo();
        Assert.assertEquals(driver.getCurrentUrl(), dodajWideoPage.getPoprawnyUrlStrony(),
                "Adres URL strony jest niepoprawny");
    }

    // Sprawdza czy tytuł strony "Dodaj wideo" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Dodaj wideo'")
    public void weryfikacjaTytuluStronyDodajWideoTest() {
        przejdzDoStronyDodajWideo();
        Assert.assertEquals(driver.getTitle(), dodajWideoPage.getPoprawnyTytulStrony(),
                "Tytuł strony jest niepoprawny");
    }

    // Sprawdza czy button "Upuść pliki wideo tutaj..." istnieje
    @Test(priority = 120, enabled = true, description = "Weryfikacja czy button 'Upuść pliki wideo tutaj...' istnieje")
    public void weryfikacjaCzyIstniejeButtonUpuscPlikiWideoTutaj() {
        przejdzDoStronyDodajWideo();
        Assert.assertTrue(dodajWideoPage.getUpuscPlikiWideoTutajButton().isDisplayed(),
                "Nie znaleziono buttona 'Upuść pliki wideo tutaj...'");
    }

    // Sprawdza czy button "Wróć" istnieje na stronie
    @Test(priority = 130, enabled = true, description = "Weryfikacja czy button 'Wróć' istnieje")
    public void weryfikacjaCzyIstniejeButtonWroc() {
        przejdzDoStronyDodajWideo();
        Assert.assertTrue(dodajWideoPage.getWrocButton().isDisplayed(),
                "Nie znaleziono buttona 'Wróć'");
    }

}
