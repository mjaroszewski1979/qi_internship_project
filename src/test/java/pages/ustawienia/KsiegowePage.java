 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class KsiegowePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy ksiegowePage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public KsiegowePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlKsiegowe = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=accounting";
    private String poprawnyTytulKsiegowe = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Analityka i skrypty"
     @FindBy(xpath ="//span[contains(text(),'Waluta')]") private WebElement sekcjaWaluta;
     @FindBy(xpath ="//span[contains(text(),'Fakturowanie')]") private WebElement sekcjaFakturowanie;
     @FindBy(xpath ="//span[contains(text(),'API GUS')]") private WebElement sekcjaAPIGUS;

    /***************************Repozytorium webelementów KONIEC ******************************************/



    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Ksiegowe" i wypisuje go w konsoli
    public String getPoprawnyUrlKsiegowe() {
        System.out.println("Poprawny url strony ksiegowe: " + poprawnyUrlKsiegowe);
        return poprawnyUrlKsiegowe;
    }

     // Zwraca aktualny URL przeglądanej strony "Ksiegowe" i wypisuje go w konsoli
    public String getAktualnyUrlKsiegowe() {
        System.out.println("Aktualny url strony ksiegowe: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Ksiegowe" i wypisuje go w konsoli
     public String getPoprawnyTytulKsiegowe() {
         System.out.println("Poprawny tytul strony ksiegowe: " + poprawnyTytulKsiegowe);
         return poprawnyTytulKsiegowe;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Ksiegowe" i wypisuje go w konsoli
     public String getAktualnyTytulKsiegowe() {
         System.out.println("Aktualny tytul strony ksiegowe: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Ksiegowe" są widoczne
     public boolean czyZakladkaKsiegowePosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Waluta", sekcjaWaluta);
         sekcje.put("Fakturowanie", sekcjaFakturowanie);
         sekcje.put("API GUS", sekcjaAPIGUS);

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
