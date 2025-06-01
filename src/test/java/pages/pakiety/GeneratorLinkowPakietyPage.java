package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GeneratorLinkowPakietyPage {

    /************************ Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstruktor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public GeneratorLinkowPakietyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/

    @FindBy(xpath = "//input[@id='bpmj-eddcm-add-to-cart-link']")
    private WebElement linkZakupowyInput;

    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //pobranie linku zakupowego
    public String pobierzLinkZPolaLinkZakupowy(){
        wait.waitForVisibility(linkZakupowyInput);
        return linkZakupowyInput.getAttribute("value");
    }

    //przejście do strony z linku zakupowego
    public void przejdzDoLinkuZPolaLinkZakupowy(){
        String link = pobierzLinkZPolaLinkZakupowy();
        driver.get(link);
    }

/********************************** Operacje na Webelementach KONIEC ******************************************/

}
