package tests.pakietyTests;


import org.testng.annotations.BeforeMethod;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.pakiety.GeneratorLinkowPakietyPage;
import pages.pakiety.PakietyPage;
import pages.pakiety.ZawartoscPakietuPage;
import tests.TestBase;


public class GeneratorLinkowPakietyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private PakietyPage pakietyPage;
    private ZawartoscPakietuPage zawartoscPakietuPage;
    private GeneratorLinkowPakietyPage generatorLinkowPakietyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPGeneratorLinkowPakietyPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        pakietyPage = new PakietyPage(driver);
        zawartoscPakietuPage = new ZawartoscPakietuPage(driver);
        generatorLinkowPakietyPage = new GeneratorLinkowPakietyPage(driver);
    }


}
