package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EdytujTestPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public EdytujTestPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLStronyEdytujTest = "https://mmrmqpr585.publigo.onl/wp-admin/post.php?post=1121&action=edit";
    String poprawnyTytulStronyEdytujTest = "Edytuj test „Nazwa quizu: Matematyka – test wielu okien w przeglądarce” ‹ Platforma kursów online — WordPress";

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLStronyEdytujTest(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLStronyEdytujTest(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLStronyEdytujTest);
        return poprawnyURLStronyEdytujTest;
    }

    public String zwrocAktualnyTytulStronyEdytujTest(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyEdytujTest(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulStronyEdytujTest);
        return poprawnyTytulStronyEdytujTest;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
