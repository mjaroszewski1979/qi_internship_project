 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class MenuPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
     private Waits wait;

     // Konstruktor klasy menuPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
     public MenuPage(WebDriver driver){
         this.driver = driver;
         this.wait = new Waits(driver);
         PageFactory.initElements(driver, this);
     }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/


    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlMenu = "https://mmrmqpr585.publigo.onl/wp-admin/nav-menus.php";
    private String poprawnyTytulMenu = "Menu ‹ Platforma kursów online — WordPress";



    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Menu" i wypisuje go w konsoli
    public String getPoprawnyUrlMenu() {
        System.out.println("Poprawny url strony menu: " + poprawnyUrlMenu);
        return poprawnyUrlMenu;
    }

     // Zwraca aktualny URL przeglądanej strony "Menu" i wypisuje go w konsoli
    public String getAktualnyUrlMenu() {
        System.out.println("Aktualny url strony menu: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Menu" i wypisuje go w konsoli
     public String getPoprawnyTytulMenu() {
         System.out.println("Poprawny tytul strony menu: " + poprawnyTytulMenu);
         return poprawnyTytulMenu;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Menu" i wypisuje go w konsoli
     public String getAktualnyTytulMenu() {
         System.out.println("Aktualny tytul strony menu: " + driver.getTitle());
         return driver.getTitle();
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
