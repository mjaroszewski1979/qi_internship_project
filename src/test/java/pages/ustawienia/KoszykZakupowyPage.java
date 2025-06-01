 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

 public class KoszykZakupowyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy koszykZakupowyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public KoszykZakupowyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlKoszykZakupowy = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=cart";
    private String poprawnyTytulKoszykZakupowy = "Ustawienia ‹ Platforma kursów online — WordPress";

     // Sekcje dostępne w zakładce "Koszyk zakupowy"
     @FindBy(xpath ="//span[contains(text(),'Widok koszyka')]") private WebElement sekcjaWidokKoszyka;
     @FindBy(xpath ="//span[contains(text(),'Dane w formularzu')]") private WebElement sekcjaDaneFormularz;
     @FindBy(xpath ="//span[contains(text(),'Dodatkowe checkboxy')]") private WebElement sekcjaDodatkoweCheckboxy;
     @FindBy(xpath ="//span[contains(text(),'Regulamin')]") private WebElement sekcjaRegulamin;
     @FindBy(xpath ="//span[contains(text(),'Dodatkowe ustawienia')]") private WebElement sekcjaDodatkoweUstawienia;
     @FindBy(xpath ="//span[contains(text(),'Sidebar | stopka (koszyk ofertowy)')]") private WebElement sekcjaSidebarStopka;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Koszyk Zakupowy" i wypisuje go w konsoli
    public String getPoprawnyUrlKoszykZakupowy() {
        System.out.println("Poprawny url strony koszyk Zakupowy: " + poprawnyUrlKoszykZakupowy);
        return poprawnyUrlKoszykZakupowy;
    }

     // Zwraca aktualny URL przeglądanej strony "Koszyk Zakupowy" i wypisuje go w konsoli
    public String getAktualnyUrlKoszykZakupowy() {
        System.out.println("Aktualny url strony koszyk Zakupowy: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Koszyk Zakupowy" i wypisuje go w konsoli
     public String getPoprawnyTytulKoszykZakupowy() {
         System.out.println("Poprawny tytul strony koszyk Zakupowy: " + poprawnyTytulKoszykZakupowy);
         return poprawnyTytulKoszykZakupowy;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Koszyk Zakupowy" i wypisuje go w konsoli
     public String getAktualnyTytulKoszykZakupowy() {
         System.out.println("Aktualny tytul strony koszyk Zakupowy: " + driver.getTitle());
         return driver.getTitle();
     }

     // Sprawdza, czy wszystkie sekcje w zakładce "Koszyk zakupowy" są widoczne
     public boolean czyZakladkaKoszykZakupowyPosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Widok koszyka", sekcjaWidokKoszyka);
         sekcje.put("Dane w formularzu", sekcjaDaneFormularz);
         sekcje.put("Dodatkowe checkboxy", sekcjaDodatkoweCheckboxy);
         sekcje.put("Regulamin", sekcjaRegulamin);
         sekcje.put("Dodatkowe ustawienia", sekcjaDodatkoweUstawienia);
         sekcje.put("Sidebar | stopka (koszyk ofertowy)", sekcjaSidebarStopka);

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
