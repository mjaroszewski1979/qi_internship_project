package pages.ustawienia;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CertyfikatyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;
    // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

    // Konstruktor klasy AnalitykaSkryptyPage
    // Inicjalizuje driver oraz obiekt klasy Waits
    // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public CertyfikatyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony
    private String poprawnyUrlCertyfikaty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=certificate";
    private String poprawnyTytulCertyfikaty = "Ustawienia ‹ Platforma kursów online — WordPress";

    // Sekcje dostępne w zakładce "Certyfikaty"
    @FindBy(xpath ="//span[contains(text(),'Certyfikaty')]") private WebElement sekcjaCertyfikaty;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    // Zwraca oczekiwany (poprawny) URL strony "Certyfikaty" i wypisuje go w konsoli
    public String getPoprawnyUrlCertyfikaty() {
        System.out.println("Poprawny url strony Certyfikaty: " + poprawnyUrlCertyfikaty);
        return poprawnyUrlCertyfikaty;
    }

    // Zwraca aktualny URL przeglądanej strony "Certyfikaty" i wypisuje go w konsoli
    public String getAktualnyUrlCertyfikaty() {
        System.out.println("Aktualny url strony Certyfikaty: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Certyfikaty" i wypisuje go w konsoli
    public String getPoprawnyTytulCertyfikaty() {
        System.out.println("Poprawny tytul strony Certyfikaty: " + poprawnyTytulCertyfikaty);
        return poprawnyTytulCertyfikaty;
    }

    // Zwraca aktualny tytuł przeglądanej strony "Certyfikaty" i wypisuje go w konsoli
    public String getAktualnyTytulCertyfikaty() {
        System.out.println("Aktualny tytul strony Certyfikaty: " + driver.getTitle());
        return driver.getTitle();
    }

    // Sprawdza, czy wszystkie sekcje w zakładce "Certyfikaty" są widoczne
    public boolean czyZakladkaCertyfikatyPosiadaWlasciweSekcje() {
        Map<String, WebElement> sekcje = new LinkedHashMap<>();
        sekcje.put("Certyfikaty", sekcjaCertyfikaty);

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
