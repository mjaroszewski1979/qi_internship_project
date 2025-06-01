 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class WiadomosciPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy WiadomosciPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WiadomosciPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlWiadomosci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=messages";
    private String poprawnyTytulWiadomosci = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Wiadomosci"
     @FindBy(xpath ="//span[contains(text(),'Nadawca')]") private WebElement sekcjaNadawca;
     @FindBy(xpath ="//span[contains(text(),' Wiadomość wysyłana po zakupie')]") private WebElement sekcjaWiadomoscWysylanaPoZakupie;
     @FindBy(xpath ="//span[contains(text(),' Wiadomość wysyłana po założeniu konta')]") private WebElement sekcjaWiadomoscWysylanaPoZalozeniuKonta;
     @FindBy(xpath ="//span[contains(text(),'Kody rabatowe')]") private WebElement sekcjaKodyRabatowe;
     @FindBy(xpath ="//span[contains(text(),'Raporty')]") private WebElement sekcjaRaporty;
     @FindBy(xpath ="//span[contains(text(),'Przypomnienia')]") private WebElement sekcjaPrzypomnienia;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Wiadomosci" i wypisuje go w konsoli
    public String getPoprawnyUrlWiadomosci() {
        System.out.println("Poprawny url strony Wiadomosci: " + poprawnyUrlWiadomosci);
        return poprawnyUrlWiadomosci;
    }

     // Zwraca aktualny URL przeglądanej strony "Wiadomosci" i wypisuje go w konsoli
    public String getAktualnyUrlWiadomosci() {
        System.out.println("Aktualny url strony Wiadomosci: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Wiadomosci" i wypisuje go w konsoli
     public String getPoprawnyTytulWiadomosci() {
         System.out.println("Poprawny tytul strony Wiadomosci: " + poprawnyTytulWiadomosci);
         return poprawnyTytulWiadomosci;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Wiadomosci" i wypisuje go w konsoli
     public String getAktualnyTytulWiadomosci() {
         System.out.println("Aktualny tytul strony Wiadomosci: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Wiadomosci" są widoczne
     public boolean czyZakladkaWiadomosciPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Nadawca", sekcjaNadawca);
         sekcje.put("Wiadomość wysyłana po zakupie", sekcjaWiadomoscWysylanaPoZakupie);
         sekcje.put("Wiadomość wysyłana po założeniu konta", sekcjaWiadomoscWysylanaPoZalozeniuKonta);
         sekcje.put("Kody rabatowe", sekcjaKodyRabatowe);
         sekcje.put("Raporty", sekcjaRaporty);
         sekcje.put("Przypomnienia", sekcjaPrzypomnienia);

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
