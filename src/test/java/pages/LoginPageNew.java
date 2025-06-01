package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageNew {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public LoginPageNew(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    @FindBy(id = "user_login")
    private WebElement loginInput;

    @FindBy(id = "user_pass")
    private WebElement hasloInput;

    @FindBy(id = "wp-submit")
    private WebElement zalogujSieButton;


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public void wpiszLoginDoPolaNazwaUzytkownika(){
        wait.waitForClickability(loginInput).clear();
        loginInput.sendKeys(login);
    }

    public void wpiszHasloDoPolaHaslo(){
        wait.waitForClickability(hasloInput).clear();
        hasloInput.sendKeys(haslo);
    }

    public void nacisnijPrzyciskZalogujSie(){
        wait.waitForClickability(zalogujSieButton).click();
    }


    public void wykonajLogowanie() {
        wpiszLoginDoPolaNazwaUzytkownika();
        wpiszHasloDoPolaHaslo();
        nacisnijPrzyciskZalogujSie();


    }

    public boolean sprawdzCzyTekstWZrodleStronyIstnieje(){
        boolean status = wait.waitForTextInPageSource("Witaj");
        System.out.println("Szukany tekst: " + "Witaj");
        return status;

    }



    /**********************************Operacje na webelementach KONIEC ******************************************/


}
