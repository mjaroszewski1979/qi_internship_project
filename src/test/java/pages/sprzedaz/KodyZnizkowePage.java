package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KodyZnizkowePage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public KodyZnizkowePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Kody zniżkowe"
    String poprawnyTytulStronyKodyZnizkowe = "Kody zniżkowe ‹ Platforma kursów online — WordPress";
    // URL strony "Kody zniżkowe"
    String poprawnyURLStronyKodyZnizkowe = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-discounts";


    // ELEMENTY NA STRONIE:

    // Przyciski:
    @FindBy(xpath = "//a[contains(text(),'Dodaj kod zniżkowy')]")
    private WebElement dodajKodZnizkowyButton;


    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Kody zniżkowe" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyKodyZnizkowe(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Kody zniżkowe" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyKodyZnizkowe(){
        System.out.println("Poprawny tytuł strony KODY ZNIŻKOWE: " + poprawnyTytulStronyKodyZnizkowe);
        return poprawnyTytulStronyKodyZnizkowe;
    }

    // Zwraca aktualny adres URL strony "Kody zniżkowe" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyKodyZnizkowe(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Kody zniżkowe" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyKodyZnizkowe() {
        System.out.println("Poprawny URL strony KODY ZNIŻKOWE: " + poprawnyURLStronyKodyZnizkowe);
        return poprawnyURLStronyKodyZnizkowe;
    }

    //kliknięcie w przycisk 'Dodaj kod zniżkowy'
    public void kliknijWDodajKodZnizkowy(){
        wait.waitForClickability(dodajKodZnizkowyButton).click();
    }

    //**********************************Operacje na webelementach KONIEC ******************************************/

}
