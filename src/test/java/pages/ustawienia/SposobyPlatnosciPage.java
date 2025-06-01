 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class SposobyPlatnosciPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/



    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
     private Waits wait;

     // Konstruktor klasy sposobyPlatnosciPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
     public SposobyPlatnosciPage(WebDriver driver){
         this.driver = driver;
         this.wait = new Waits(driver);
         PageFactory.initElements(driver, this);
     }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlSposobyPlatnosci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=payments";
    private String poprawnyTytulSposobyPlatnosci = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Sposoby platnosci"
     @FindBy(xpath ="//span[contains(text(),'Konfiguracja i testy')]") private WebElement sekcjaKonfiguracjaTesty;
     @FindBy(xpath ="//span[contains(text(),'Płatności elektroniczne bankowe oraz cykliczne')]") private WebElement sekcjaPlatnosciBankoweCykliczne;
     @FindBy(xpath ="//span[text()='Płatności elektroniczne bankowe']") private WebElement sekcjaPlatnosciElektroniczneBankowe;
     @FindBy(xpath ="//span[contains(text(),'Pozostałe typy płatności')]") private WebElement sekcjaPozostaleTypyPlatnosci;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Sposoby Platnosci" i wypisuje go w konsoli
    public String getPoprawnyUrlSposobyPlatnosci() {
        System.out.println("Poprawny url strony sposoby platnosci: " + poprawnyUrlSposobyPlatnosci);
        return poprawnyUrlSposobyPlatnosci;
    }

     // Zwraca aktualny URL przeglądanej strony "Sposoby Platnosci" i wypisuje go w konsoli
    public String getAktualnyUrlSposobyPlatnosci() {
        System.out.println("Aktualny url strony sposoby platnosci: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Sposoby Platnosci" i wypisuje go w konsoli
     public String getPoprawnyTytulSposobyPlatnosci() {
         System.out.println("Poprawny tytul strony sposoby platnosci: " + poprawnyTytulSposobyPlatnosci);
         return poprawnyTytulSposobyPlatnosci;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Sposoby Platnosci" i wypisuje go w konsoli
     public String getAktualnyTytulSposobyPlatnosci() {
         System.out.println("Aktualny tytul strony sposoby platnosci: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Sposoby platnosci" są widoczne
     public boolean czyZakladkaSposobyPlatnosciPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Konfiguracja i testy", sekcjaKonfiguracjaTesty);
         sekcje.put("Płatności elektroniczne bankowe oraz cykliczne", sekcjaPlatnosciBankoweCykliczne);
         sekcje.put("Płatności elektroniczne bankowe", sekcjaPlatnosciElektroniczneBankowe);
         sekcje.put("Pozostałe typy płatności", sekcjaPozostaleTypyPlatnosci);

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
