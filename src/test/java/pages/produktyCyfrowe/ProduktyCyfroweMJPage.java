 package pages.produktyCyfrowe;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Utils.generujLiczbeOd1Do100000JakoString;

 public class ProduktyCyfroweMJPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public ProduktyCyfroweMJPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/



     // Sekcje dostępne na stronie "Produkty Cyfrowe"
     @FindBy(xpath ="//button[contains(text(), 'Utwórz nowy produkt cyfrowy')]") private WebElement buttonUtworzProduktCyfrowy;
     @FindBy(id ="name") private WebElement inputNazwaProduktuCyfrowego;
     @FindBy(id ="price") private WebElement inputCenaProduktuCyfrowego;
     @FindBy(id ="save-digital_products_popup_editor") private WebElement buttonUtworzEdytujProduktCyfrowy;




    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Klika przycisk tworzący nowy produkt cyfrowy
    public void kliknijButtonUtworzProduktCyfrowy() {
        wait.waitForClickability(buttonUtworzProduktCyfrowy).click();
    }

     // Wpisuje dynamicznie generowaną nazwę dla nowego produktu cyfrowego
    public void wpiszNazweProduktuCyfrowego() {
        String dynamicznaNazwa = "maciej-produkt" + generujLiczbeOd1Do100000JakoString();
        wait.waitForVisibility(inputNazwaProduktuCyfrowego).clear();
        wait.waitForVisibility(inputNazwaProduktuCyfrowego).sendKeys(dynamicznaNazwa);
    }

     // Wpisuje cenę produktu cyfrowego
     public void wpiszCeneProduktuCyfrowego() {
         wait.waitForVisibility(inputCenaProduktuCyfrowego).clear();
         wait.waitForVisibility(inputCenaProduktuCyfrowego).sendKeys("999");
     }

     // Klika przycisk zapisujący lub aktualizujący produkt cyfrowy
     public void kliknijButtonUtworzEdytujProduktCyfrowy() {
         wait.waitForClickability(buttonUtworzEdytujProduktCyfrowy).click();
     }

     // Tworzy nowy produkt cyfrowy wykonując wszystkie wymagane akcje
     public void utworzProduktCyfrowy() {
        kliknijButtonUtworzProduktCyfrowy();
        wpiszNazweProduktuCyfrowego();
        wpiszCeneProduktuCyfrowego();
        kliknijButtonUtworzEdytujProduktCyfrowy();
     }






















     /**********************************Operacje na webelementach KONIEC ******************************************/

}
