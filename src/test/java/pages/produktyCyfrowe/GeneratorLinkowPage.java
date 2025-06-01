 package pages.produktyCyfrowe;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class GeneratorLinkowPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public GeneratorLinkowPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony


     // Sekcje dostępne w zakładce "Analityka i skrypty"
     @FindBy(id ="bpmj-eddcm-add-to-cart-link") private WebElement inputLinkZakupowy;
     @FindBy(id ="edd-purchase-button") private WebElement buttonZamawiamPlace;




    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/



    // Pobiera link zakupowy z pola input, wypisuje go w konsoli i przechodzi do tej strony
    public void przejdzDoLinkuZakupowego() {
        String linkZakupowy = wait.waitForVisibility(inputLinkZakupowy).getAttribute("value");
        System.out.println("Link zakupowy: " + linkZakupowy);
        driver.get(linkZakupowy);
    }

     // Sprawdza, czy przycisk "Zamawiam i płacę" jest widoczny i możliwy do kliknięcia
     public boolean czyButtonZamawiamPlaceJestWidoczny() {
         return wait.waitForClickability(buttonZamawiamPlace).isDisplayed();
     }






















     /**********************************Operacje na webelementach KONIEC ******************************************/

}
