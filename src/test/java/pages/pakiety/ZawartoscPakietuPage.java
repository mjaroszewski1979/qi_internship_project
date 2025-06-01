package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;

public class ZawartoscPakietuPage {

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
    public ZawartoscPakietuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/


    @FindBy(xpath = "//button[contains(@class,'big-button add-row')]")
    private WebElement dodajProduktButton;

    @FindBy(xpath = "//td[contains(@class, 'sc-bxivhb')]/select")
    private List<WebElement> listaWybierzProdukt;

    @FindBy(xpath = "//button[contains(text(),'Zapisz')]")
    private WebElement zapiszButton;

    @FindBy(xpath = "//a[contains(text(), 'Generator linków')]")
    private WebElement generatorLinkowZakladka;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //oczekiwanie na przycisk 'Dodaj produkt' w zakładce 'Zawartość pakietu'
    public void poczekajNaPrzyciskDodajProdukt(){
        wait.waitForClickability(dodajProduktButton);
    }

    //przewiniecie strony do buttona 'Dodaj produkt'
    public void przewinStroneDoDodajProdukt(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",dodajProduktButton);
    }

    //dodanie trzech produktów do pakietu
    public void dodajTrzyProduktyDoPakietuWZakladceZawartoscPakietu(){
        kliknijWDodajProduktWZakladceZawartoscPakietu();
        wybierzProdukt1ZawartoscPakietu();
        kliknijWDodajProduktWZakladceZawartoscPakietu();
        wybierzProdukt2ZawartoscPakietu();
        kliknijWDodajProduktWZakladceZawartoscPakietu();
        wybierzProdukt3ZawartoscPakietu();
        kliknijWZapiszZawartoscPakietu();
    }

    //kliknięcie w przycisk 'Dodaj produkt' w zakładce 'Zawartość pakietu'
    public void kliknijWDodajProduktWZakladceZawartoscPakietu(){
        wait.waitForClickability(dodajProduktButton).click();
    }

    //dodanie pierwszego produktu do pakietu
    public void wybierzProdukt1ZawartoscPakietu() {
        listaWybierzProdukt.get(0).click();
        WebElement produkt1 = listaWybierzProdukt.get(0);
        Select select = new Select(produkt1);
        select.selectByIndex(1);
        System.out.println("Produkt 1 dodany do pakietu");
    }

    //dodanie drugiego produktu do pakietu
    public void wybierzProdukt2ZawartoscPakietu() {
        listaWybierzProdukt.get(1).click();
        WebElement produkt2 = listaWybierzProdukt.get(1);
        Select select = new Select(produkt2);
        select.selectByIndex(2);
        System.out.println("Produkt 2 dodany do pakietu");
    }

    //dodanie trzeciego produktu do pakietu
    public void wybierzProdukt3ZawartoscPakietu() {
        listaWybierzProdukt.get(2).click();
        WebElement produkt3 = listaWybierzProdukt.get(2);
        Select select = new Select(produkt3);
        select.selectByIndex(3);
        System.out.println("Produkt 3 dodany do pakietu");
    }

    //kliknięcie w przycisk 'Zapisz' w zakładce 'Zawartość pakietu'
    public void kliknijWZapiszZawartoscPakietu(){
        wait.waitForClickability(zapiszButton).click();
    }

    //przewinięcie strony do zakładki generator linków
    public void przewinStroneDoZakladkiGeneratorLinkow(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",generatorLinkowZakladka);
    }

    //przejście do zakładki 'Generator linków'
    public void przejdzDoZakladkiGeneratorLinkow(){
        wait.waitForClickability(generatorLinkowZakladka).click();
    }

/********************************** Operacje na Webelementach KONIEC ******************************************/

}
