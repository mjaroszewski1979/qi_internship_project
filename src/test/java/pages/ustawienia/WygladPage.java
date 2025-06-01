 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class WygladPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

    // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

    // Konstruktor klasy WygladPage
    // Inicjalizuje driver oraz obiekt klasy Waits
    // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WygladPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlWyglad = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=design";
    private String poprawnyTytulWyglad = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Wyglad"
     @FindBy(xpath ="//span[contains(text(),'Ustawienia widoku kursu')]") private WebElement sekcjaUstawieniaWidokuKursu;
     @FindBy(xpath ="//span[contains(text(),'Ustawienia katalogu')]") private WebElement sekcjaUstawieniaKatalogu;
     @FindBy(xpath ="//span[contains(text(),'Ustawienia widoku oferty')]") private WebElement sekcjaUstawieniaWidokuOferty;


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Wygląd" i wypisuje go w konsoli
    public String getPoprawnyUrlWyglad() {
        System.out.println("Poprawny url strony wyglad: " + poprawnyUrlWyglad);
        return poprawnyUrlWyglad;
    }

     // Zwraca aktualny URL przeglądanej strony "Wygląd" i wypisuje go w konsoli
    public String getAktualnyUrlWyglad() {
        System.out.println("Aktualny url strony wyglad: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Wygląd" i wypisuje go w konsoli
     public String getPoprawnyTytulWyglad() {
         System.out.println("Poprawny tytul strony wyglad: " + poprawnyTytulWyglad);
         return poprawnyTytulWyglad;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Wygląd" i wypisuje go w konsoli
     public String getAktualnyTytulWyglad() {
         System.out.println("Aktualny tytul strony wyglad: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Wyglad" są widoczne
     public boolean czyZakladkaWygladPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Ustawienia widoku kursu", sekcjaUstawieniaWidokuKursu);
         sekcje.put("Ustawienia katalogu", sekcjaUstawieniaKatalogu);
         sekcje.put("Ustawienia widoku oferty", sekcjaUstawieniaWidokuOferty);

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
