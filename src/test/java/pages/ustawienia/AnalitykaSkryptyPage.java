 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class AnalitykaSkryptyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy AnalitykaSkryptyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public AnalitykaSkryptyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlAnalitykaSkrypty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=analytics";
    private String poprawnyTytulAnalitykaSkrypty = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Analityka i skrypty"
     @FindBy(xpath ="//span[contains(text(),'Google')]") private WebElement sekcjaGoogle;
     @FindBy(xpath ="//span[contains(text(),'Facebook')]") private WebElement sekcjaFacebook;
     @FindBy(xpath ="//span[contains(text(),'Dodatkowe skrypty')]") private WebElement sekcjaDodatkoweSkrypty;


    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "AnalitykaSkrypty" i wypisuje go w konsoli
    public String getPoprawnyUrlAnalitykaSkrypty() {
        System.out.println("Poprawny url strony AnalitykaSkrypty: " + poprawnyUrlAnalitykaSkrypty);
        return poprawnyUrlAnalitykaSkrypty;
    }

     // Zwraca aktualny URL przeglądanej strony "AnalitykaSkrypty" i wypisuje go w konsoli
    public String getAktualnyUrlAnalitykaSkrypty() {
        System.out.println("Aktualny url strony AnalitykaSkrypty: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "AnalitykaSkrypty" i wypisuje go w konsoli
     public String getPoprawnyTytulAnalitykaSkrypty() {
         System.out.println("Poprawny tytul strony AnalitykaSkrypty: " + poprawnyTytulAnalitykaSkrypty);
         return poprawnyTytulAnalitykaSkrypty;
     }

     // Zwraca aktualny tytuł przeglądanej strony "AnalitykaSkrypty" i wypisuje go w konsoli
     public String getAktualnyTytulAnalitykaSkrypty() {
         System.out.println("Aktualny tytul strony AnalitykaSkrypty: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "AnalitykaSkrypty" są widoczne
     public boolean czyZakladkaAnalitykaSkryptyPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Google", sekcjaGoogle);
         sekcje.put("Facebook", sekcjaFacebook);
         sekcje.put("Dodatkowe skrypty", sekcjaDodatkoweSkrypty);

         boolean wszystkieWidoczne = true;

         for (Map.Entry<String, WebElement> entry : sekcje.entrySet()) {
             String nazwaSekcji = entry.getKey();
             WebElement elementSekcji = entry.getValue();

             try {
                 WebElement widocznyElement = wait.waitForVisibility(elementSekcji);

                 boolean czyWidoczny = widocznyElement.isDisplayed();
                 boolean czyTekstZgodny = widocznyElement.getText().trim().equals(nazwaSekcji);

                 if (!czyWidoczny || !czyTekstZgodny) {
                     if (!czyWidoczny) {
                         System.out.println("Sekcja niewidoczna: " + nazwaSekcji);
                     }
                     if (!czyTekstZgodny) {
                         System.out.println("Tekst sekcji niezgodny: oczekiwano \"" + nazwaSekcji + "\", znaleziono \"" + widocznyElement.getText().trim() + "\"");
                     }
                     wszystkieWidoczne = false;
                 } else {
                     System.out.println("Sekcja widoczna i tekst zgodny: " + nazwaSekcji);
                 }
             } catch (Exception e) {
                 System.out.println("Błąd podczas sprawdzania sekcji: " + nazwaSekcji);
                 e.printStackTrace();
                 wszystkieWidoczne = false;
             }
         }

         return wszystkieWidoczne;
     }














     /**********************************Operacje na webelementach KONIEC ******************************************/

}
