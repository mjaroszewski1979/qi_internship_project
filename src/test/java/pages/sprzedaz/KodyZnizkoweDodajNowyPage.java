package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class KodyZnizkoweDodajNowyPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public KodyZnizkoweDodajNowyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String kod = "";

    @FindBy(name = "name")
    private WebElement nazwaKodZnizkowyInput;

    @FindBy(name = "code")
    private WebElement kodKodZnizkowyInput;

    @FindBy(name = "type")
    private WebElement typKodZnizkowyLista;

    @FindBy(name = "amount")
    private WebElement kwotaKodZnizkowyInput;

    @FindBy(xpath = "//input[contains(@value, 'Wybierz co najmniej jeden Produkt')]")
    private List<WebElement> wybierzProduktInput;

    @FindBy(xpath = "//li[contains(@class, 'active-result')]")
    private List<WebElement> listaProdukty;

    @FindBy(xpath = "//ul[contains(@class, 'chosen-results')]")
    private List<WebElement> listaWybierzProdukt;

    @FindBy(xpath = "//label[contains(text(),'Produkty wykluczone')]")
    private WebElement sekcjaProduktyWykluczone;

    @FindBy(xpath = "//select[contains(@name, 'product_condition')]")
    private WebElement listaKoszykCoNajmniejJednoZamowienie;

    @FindBy(xpath = "//input[@name= 'not_global' and @value='1']")
    private WebElement zastosujDoWybranychProduktowRadio;

    @FindBy(id = "edd-start")
    private WebElement dataPoczatkowaKodZnizkowyInput;

    @FindBy(id = "edd-min-cart-amount")
    private WebElement minimalnaKwotaInput;

    @FindBy(id = "edd-max-uses")
    private WebElement maksymalnaloscUzycInput;

    @FindBy(id = "edd-use-once")
    private WebElement jednorazowyDlaDanegoKlientaInput;

    @FindBy(xpath = "//input[contains(@value, 'Dodaj kod zniżkowy')]")
    private WebElement dodajKodZnizkowyButton;

    @FindBy(xpath = "//table[contains(@class, 'dynamic-table loaded')]")
    private WebElement zaladowanieTabeliKodyZnizkowe;

    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    //wpisanie nazwy kodu zniżkowego
    public void wpiszNazweKoduZnizkowego() {
        wait.waitForClickability(nazwaKodZnizkowyInput).clear();
        wait.waitForVisibility(nazwaKodZnizkowyInput).sendKeys("Kod zniżkowy Test");
    }

    //wpisanie kodu 'Kodu zniżkowego'
    public String wpiszKodKoduZnizkowego(){
        int losowaLiczba = ThreadLocalRandom.current().nextInt(1,1000);
        wait.waitForVisibility(kodKodZnizkowyInput).clear();
        kodKodZnizkowyInput.sendKeys("TestKodZnizkowy"  + losowaLiczba);
        System.out.println("Kod utworzonego 'Kodu zniżkowego: " + kodKodZnizkowyInput.getAttribute("value"));
        return kodKodZnizkowyInput.getAttribute("value");

    }

    //ustawienie wartości kodu 'Kodu zniżkowego'
    public void ustawienieKoduKoduZnizkowego(){
         kod = wpiszKodKoduZnizkowego();
    }

    //ustawienie 'Stała wartość' w 'Typ' kodu zniżkowego
    public void ustawienieStalejWartosciTypuKoduZnizkowego() {
        Select select = new Select(typKodZnizkowyLista);
        select.selectByValue("flat");
    }

    //wpisanie wielkości zniżki w procentach
    public void wpiszKwoteZnizki() {
        wait.waitForClickability(kwotaKodZnizkowyInput).clear();
        wait.waitForVisibility(kwotaKodZnizkowyInput).sendKeys("15");
    }

    //dodanie produktów wymaganych kodu zniżkowego
    public void wybierzProduktyWymagane() {
        przewinStroneDoSekcjiProduktyWymagane();
        wybierzProdukt1Wymagany();
        wybierzProdukt2wymagany();
        wybierzOpcjeCoNajmniejJedenProdukt();
        wybierzZnizkaDlaWybranychProduktow();
    }

    //przewinięcie strony do sekcji 'Produkty wymagane'
    public void przewinStroneDoSekcjiProduktyWymagane(){
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",wybierzProduktInput.get(0));
    }

    //dodanie pierwszego produktu wymaganego kodu zniżkowego
    public void wybierzProdukt1Wymagany() {
        wybierzProduktInput.get(0).click();
        listaProdukty.get(1).click();
        System.out.println("Produkt 1 dodany do 'Produkty wymagane'.");
    }

    //dodanie drugiego produktu wymaganego kodu zniżkowego
    public void wybierzProdukt2wymagany() {
        wybierzProduktInput.get(0).click();
        listaProdukty.get(2).click();
        System.out.println("Produkt 2 dodany do 'Produkty wymagane'.");
    }

    //wybranie z listy opcji 'Koszyk musi zawierać co najmniej jeden z wybranych Produktów'
    public void wybierzOpcjeCoNajmniejJedenProdukt() {
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",listaKoszykCoNajmniejJednoZamowienie);
        Select select = new Select(listaKoszykCoNajmniejJednoZamowienie);
        select.selectByValue("any");
        System.out.println("Opcja 'Koszyk musi zawierać co najmniej jeden z wybranych Produktów' wybrana.");
    }

    //wybranie radio 'Zastosuj zniżkę tylko do wybranych produktów'
    public void wybierzZnizkaDlaWybranychProduktow() {
        wait.waitForClickability(zastosujDoWybranychProduktowRadio).click();
        System.out.println("Opcja 'Zastosuj zniżkę tylko do wybranych produktów' wybrana.");
    }

    //dodanie produktów wykluczony kodu zniżkowego
    public void wybierzProduktWykluczony() {
        przewinStroneDoSekcjiProduktyWykluczone();
        wybierzProduktWykluczonyKodu();
    }

    //przewinięcie strony do sekcji 'Produkty wykluczone'
    public void przewinStroneDoSekcjiProduktyWykluczone(){
        wait.waitForClickability(sekcjaProduktyWykluczone);
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];", wybierzProduktInput.get(1));
    }

    //dodanie produktu wykluczonego kodu zniżkowego
    public void wybierzProduktWykluczonyKodu()  {
        wait.waitForClickability(wybierzProduktInput.get(1)).click();
        wait.waitForClickability(listaWybierzProdukt.get(1)).click();
        listaProdukty.get(0);
        System.out.println("Produkt dodany do 'Produkty wykluczone'.");
    }

    //wpisanie daty początkowej zniżki
    public void wpiszDatePoczatkowaZnizki() {
        wait.waitForClickability(dataPoczatkowaKodZnizkowyInput).clear();
        wait.waitForVisibility(dataPoczatkowaKodZnizkowyInput).sendKeys("04/01/2025");
    }

    //wpisanie kwoty minimalnej zniżki
    public void wpiszKwoteMinimalnaZnizki() {
        wait.waitForClickability(minimalnaKwotaInput).clear();
        wait.waitForVisibility(minimalnaKwotaInput).sendKeys("100");
    }

    //wpisanie maksymalnej ilości użyć zniżki
    public void wpiszMaksymalnaIloscUzycZnizki() {
        wait.waitForClickability(maksymalnaloscUzycInput).clear();
        wait.waitForVisibility(maksymalnaloscUzycInput).sendKeys("10");
    }

    //wybranie opcję 'Jednorazowy dla danego klienta'
    public void wybierzJednorazowyDlaDanegoKlienta() {
        wait.waitForClickability(jednorazowyDlaDanegoKlientaInput).click();
        System.out.println("Opcja ''Jednorazowy dla danego klienta' wybrana.");
    }

    //wybranie przycisku 'Dodaj kod zniżkowy'
    public void wybierzPrzyciskDodajKodZnizkowy() {
        wait.waitForVisibility(dodajKodZnizkowyButton);
        ((JavascriptExecutor)driver).executeScript("[arguments[0].scrollIntoView(true)];",dodajKodZnizkowyButton);
        dodajKodZnizkowyButton.click();
    }

    //oczekiwanie na okno 'Kody zniżkowe'
    public void poczekajNaZaladowanieTabeliKodyZnizkowe(){
        wait.waitForVisibility(zaladowanieTabeliKodyZnizkowe);
    }

//    //sprawdzenie, komunikatu 'Kod zniżkowy został dodany!'
    public boolean sprawdzKomunikatKodZnizkowyZostalDodany() {
        boolean status = false;
        if(wait.waitForTextInPageSource("Kod zniżkowy został dodany!")){
            status = true;
            System.out.println("Komunikat: 'Kod zniżkowy został dodany!' widoczny.");
        } else {
            System.out.println("Komunikat: 'Kod zniżkowy został dodany!' NIEWIDOCZNY.");
        }
        return status;
    }


    //sprawdzenie, czy kod zniżkowy został utworzony
    public boolean sprawdzKodZnizkowyZostalUtworzony(){
        boolean status = false;
        System.out.println("Kod utworzonego 'Kodu zniżkowego': " + kod);
        if(wait.waitForTextInPageSource(kod)){
            status = true;
            System.out.println( "Kod zniżkowy został utworzony!");
        }
        return status;
    }


    //**********************************Operacje na webelementach KONIEC ******************************************/

}
