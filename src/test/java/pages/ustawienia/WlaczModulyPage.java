 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class WlaczModulyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy WlaczModulyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WlaczModulyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlWlaczModuly = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=modules";
    private String poprawnyTytulWlaczModuly = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Wlacz moduly"
     @FindBy(xpath ="//span[contains(text(),'Typy produktów')]") private WebElement sekcjaTypyProduktow;
     @FindBy(xpath ="//span[contains(text(),'Marketing i sprzedaż')]") private WebElement sekcjaMarketingSprzedaz;
     @FindBy(xpath ="//span[contains(text(),'Komunikacja')]") private WebElement sekcjaKomunikacja;
     @FindBy(xpath ="//span[contains(text(),'Pliki')]") private WebElement sekcjaPliki;

    /***************************Repozytorium webelementów KONIEC ******************************************/

    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "WlaczModuly" i wypisuje go w konsoli
    public String getPoprawnyUrlWlaczModuly() {
        System.out.println("Poprawny url strony WlaczModuly: " + poprawnyUrlWlaczModuly);
        return poprawnyUrlWlaczModuly;
    }

     // Zwraca aktualny URL przeglądanej strony "WlaczModuly" i wypisuje go w konsoli
    public String getAktualnyUrlWlaczModuly() {
        System.out.println("Aktualny url strony WlaczModuly: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "WlaczModuly" i wypisuje go w konsoli
     public String getPoprawnyTytulWlaczModuly() {
         System.out.println("Poprawny tytul strony WlaczModuly: " + poprawnyTytulWlaczModuly);
         return poprawnyTytulWlaczModuly;
     }

     // Zwraca aktualny tytuł przeglądanej strony "WlaczModuly" i wypisuje go w konsoli
     public String getAktualnyTytulWlaczModuly() {
         System.out.println("Aktualny tytul strony WlaczModuly: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Wlacz moduly" są widoczne
     public boolean czyZakladkaWlaczModulyPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Typy produktów", sekcjaTypyProduktow);
         sekcje.put("Marketing i sprzedaż", sekcjaMarketingSprzedaz);
         sekcje.put("Komunikacja", sekcjaKomunikacja);
         sekcje.put("Pliki", sekcjaPliki);

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
