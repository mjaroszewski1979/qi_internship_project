 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class ZaawansowanePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy ZaawansowanePage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public ZaawansowanePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlZaawansowane = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=advanced";
    private String poprawnyTytulZaawansowane = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Zaawansowane"
     @FindBy(xpath ="//span[contains(text(),'Zaawansowane')]") private WebElement sekcjaZaawansowane;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Zaawansowane" i wypisuje go w konsoli
    public String getPoprawnyUrlZaawansowane() {
        System.out.println("Poprawny url strony Zaawansowane: " + poprawnyUrlZaawansowane);
        return poprawnyUrlZaawansowane;
    }

     // Zwraca aktualny URL przeglądanej strony "Zaawansowane" i wypisuje go w konsoli
    public String getAktualnyUrlZaawansowane() {
        System.out.println("Aktualny url strony Zaawansowane: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Zaawansowane" i wypisuje go w konsoli
     public String getPoprawnyTytulZaawansowane() {
         System.out.println("Poprawny tytul strony Zaawansowane: " + poprawnyTytulZaawansowane);
         return poprawnyTytulZaawansowane;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Zaawansowane" i wypisuje go w konsoli
     public String getAktualnyTytulZaawansowane() {
         System.out.println("Aktualny tytul strony Zaawansowane: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Zaawansowane" są widoczne
     public boolean czyZakladkaZaawansowanePosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Zaawansowane", sekcjaZaawansowane);

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
