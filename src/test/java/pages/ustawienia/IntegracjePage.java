 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class IntegracjePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy integracjePage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public IntegracjePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlIntegracje = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=integrations";
    private String poprawnyTytulIntegracje = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Integracje"
     @FindBy(xpath ="//span[contains(text(),'Systemy fakturujące')]") private WebElement sekcjaSystemyFakturujace;
     @FindBy(xpath ="//span[contains(text(),'Akcje')]") private WebElement sekcjaAkcje;
     @FindBy(xpath ="//span[contains(text(),'Polskojęzyczne')]") private WebElement sekcjaPolskojezyczne;
     @FindBy(xpath ="//span[contains(text(),'Angielskojęzyczne')]") private WebElement sekcjaAngielskojezyczne;
     @FindBy(xpath ="//span[contains(text(),'Społeczności')]") private WebElement sekcjaSpolecznosci;

    /***************************Repozytorium webelementów KONIEC ******************************************/



    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Integracje" i wypisuje go w konsoli
    public String getPoprawnyUrlIntegracje() {
        System.out.println("Poprawny url strony integracje: " + poprawnyUrlIntegracje);
        return poprawnyUrlIntegracje;
    }

     // Zwraca aktualny URL przeglądanej strony "Integracje" i wypisuje go w konsoli
    public String getAktualnyUrlIntegracje() {
        System.out.println("Aktualny url strony integracje: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Integracje" i wypisuje go w konsoli
     public String getPoprawnyTytulIntegracje() {
         System.out.println("Poprawny tytul strony integracje: " + poprawnyTytulIntegracje);
         return poprawnyTytulIntegracje;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Integracje" i wypisuje go w konsoli
     public String getAktualnyTytulIntegracje() {
         System.out.println("Aktualny tytul strony integracje: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Integracje" są widoczne
     public boolean czyZakladkaIntegracjePosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Systemy fakturujące", sekcjaSystemyFakturujace);
         sekcje.put("Akcje", sekcjaAkcje);
         sekcje.put("Polskojęzyczne", sekcjaPolskojezyczne);
         sekcje.put("Angielskojęzyczne", sekcjaAngielskojezyczne);
         sekcje.put("Społeczności", sekcjaSpolecznosci);

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
