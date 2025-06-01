package pages.narzedzia;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebhookiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public WebhookiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Webhooki"
    String poprawnyTytulStronyWebhooki = "Webhooki ‹ Platforma kursów online — WordPress";
    // URL strony "Webhooki"
    String poprawnyURLStronyWebhooki = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-webhooks";


    // ELEMENTY NA STRONIE:




    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Webhooki" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyWebhooki() {
        System.out.println("Aktualny tytuł strony WEBHOOKI: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Webhooki" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyWebhooki() {
        System.out.println("Poprawny tytuł strony WEBHOOKI: " + poprawnyTytulStronyWebhooki);
        return poprawnyTytulStronyWebhooki;
    }

    // Zwraca aktualny adres URL strony "Webhooki" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyWebhooki() {
        System.out.println("Aktualny URL strony WEBHOOKI: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Webhooki" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyWebhooki() {
        System.out.println("Poprawny URL strony WEBHOOKI: " + poprawnyURLStronyWebhooki);
        return poprawnyURLStronyWebhooki;
    }





    /**********************************Operacje na webelementach KONIEC ******************************************/
}
