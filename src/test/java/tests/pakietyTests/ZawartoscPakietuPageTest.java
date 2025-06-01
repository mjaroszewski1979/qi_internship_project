package tests.pakietyTests;


import org.testng.annotations.BeforeMethod;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.pakiety.PakietyPage;
import pages.pakiety.ZawartoscPakietuPage;
import tests.TestBase;


public class ZawartoscPakietuPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private PakietyPage pakietyPage;
    private ZawartoscPakietuPage zawartoscPakietuPage;

    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPZawartoscPakietuPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        pakietyPage = new PakietyPage(driver);
        zawartoscPakietuPage = new ZawartoscPakietuPage(driver);
    }


}
