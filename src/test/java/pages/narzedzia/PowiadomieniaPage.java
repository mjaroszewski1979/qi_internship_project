package pages.narzedzia;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PowiadomieniaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public PowiadomieniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // URL strony "Powiadomienia"
    String poprawnyURLZakladkiPowiadomienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-notifications";
    // Tytuł strony "Powiadomienia"
    String poprawnyTytulZakladkiPowiadomienia = "Powiadomienia ‹ Platforma kursów online — WordPress";


    // ELEMENTY NA STRONIE:




    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiPowiadomienia(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiPowiadomienia(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiPowiadomienia);
        return poprawnyURLZakladkiPowiadomienia;
    }

    public String zwrocAktualnyTytulZakladkiPowiadomienia(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiPowiadomienia(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiPowiadomienia);
        return poprawnyTytulZakladkiPowiadomienia;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
