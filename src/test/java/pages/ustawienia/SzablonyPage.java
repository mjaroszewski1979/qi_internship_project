 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class SzablonyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
     private Waits wait;

     // Konstruktor klasy szablonyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
     public SzablonyPage(WebDriver driver){
         this.driver = driver;
         this.wait = new Waits(driver);
         PageFactory.initElements(driver, this);
     }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlSzablony = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-templates";
    private String poprawnyTytulSzablony = "Szablony ‹ Platforma kursów online — WordPress";


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Szablony" i wypisuje go w konsoli
    public String getPoprawnyUrlSzablony() {
        System.out.println("Poprawny url strony szablony: " + poprawnyUrlSzablony);
        return poprawnyUrlSzablony;
    }

     // Zwraca aktualny URL przeglądanej strony "Szablony" i wypisuje go w konsoli
    public String getAktualnyUrlSzablony() {
        System.out.println("Aktualny url strony szablony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Szablony" i wypisuje go w konsoli
     public String getPoprawnyTytulSzablony() {
         System.out.println("Poprawny tytul strony szablony: " + poprawnyTytulSzablony);
         return poprawnyTytulSzablony;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Szablony" i wypisuje go w konsoli
     public String getAktualnyTytulSzablony() {
         System.out.println("Aktualny tytul strony szablony: " + driver.getTitle());
         return driver.getTitle();
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
