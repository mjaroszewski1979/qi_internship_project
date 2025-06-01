 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class ZakupyNaPrezentPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy Zakupy Na Prezent Page
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public ZakupyNaPrezentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlZakupyNaPrezent = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=gift";
    private String poprawnyTytulZakupyNaPrezent = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Zakupy na prezent"
     @FindBy(xpath ="//span[contains(text(),'Zakupy na prezent')]") private WebElement sekcjaZakupyNaPrezent;
     @FindBy(xpath ="//span[contains(text(),'Voucher jako PDF')]") private WebElement sekcjaVoucherJakoPDF;

    /***************************Repozytorium webelementów KONIEC ******************************************/

    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Zakupy Na Prezent" i wypisuje go w konsoli
    public String getPoprawnyUrlZakupyNaPrezent() {
        System.out.println("Poprawny url strony Zakupy Na Prezent: " + poprawnyUrlZakupyNaPrezent);
        return poprawnyUrlZakupyNaPrezent;
    }

     // Zwraca aktualny URL przeglądanej strony "Zakupy Na Prezent" i wypisuje go w konsoli
    public String getAktualnyUrlZakupyNaPrezent() {
        System.out.println("Aktualny url strony Zakupy Na Prezent: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Zakupy Na Prezent" i wypisuje go w konsoli
     public String getPoprawnyTytulZakupyNaPrezent() {
         System.out.println("Poprawny tytul strony Zakupy Na Prezent: " + poprawnyTytulZakupyNaPrezent);
         return poprawnyTytulZakupyNaPrezent;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Zakupy Na Prezent" i wypisuje go w konsoli
     public String getAktualnyTytulZakupyNaPrezent() {
         System.out.println("Aktualny tytul strony Zakupy Na Prezent: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Zakupy na prezent" są widoczne
     public boolean czyZakladkaZakupyNaPrezentPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Zakupy na prezent", sekcjaZakupyNaPrezent);
         sekcje.put("Voucher jako PDF", sekcjaVoucherJakoPDF);

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
