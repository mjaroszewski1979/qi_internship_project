 package pages.uzytkownicy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

 public class UtworzUzytkownikaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    private static final String nowyUzytkownikNazwa = PropertiesReader.read("nowyUzytkownikNazwa");
    private static final String nowyUzytkownikEmail = PropertiesReader.read("nowyUzytkownikEmail");
    private static final String nowyUzytkownikImie = PropertiesReader.read("nowyUzytkownikImie");
    private static final String nowyUzytkownikNazwisko = PropertiesReader.read("nowyUzytkownikNazwisko");


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public UtworzUzytkownikaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    @FindBy(id = "user_login")
    private WebElement nazwaUzytkowkikaInput;

    @FindBy(id = "email")
    private WebElement emailUzytkowkikaInput;

    @FindBy(id = "first_name")
    private WebElement imieUzytkowkikaInput;

    @FindBy(id = "last_name")
    private WebElement nazwiskoUzytkowkikaInput;

    @FindBy(id = "locale")
    private WebElement jezykListaRozwijana;

    @FindBy(xpath = "//*[contains(text(), 'Polski')]")
    private WebElement polskiLista;

    @FindBy(xpath = "//*[contains(text(), 'Generuj hasło')]")
    private WebElement generujHasloButton;

    @FindBy(id = "pass-strength-result")
    private WebElement silaHaslaResult;

    @FindBy(id = "send_user_notification")
    private WebElement wyslijPowiadomienieUzytkownikowiCheckbox;

    @FindBy(id = "createusersub")
    private WebElement utworzUzytkownikaButton;
    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/
    public void wprowadzNazweIEmailUzytkownika(){
        wait.waitForVisibility(nazwaUzytkowkikaInput).clear();
        nazwaUzytkowkikaInput.sendKeys(nowyUzytkownikNazwa);

        emailUzytkowkikaInput.clear();
        emailUzytkowkikaInput.sendKeys(nowyUzytkownikEmail);
    }

    // Wprowadza imię i nazwisko użytkownika do pól formularza
    public void wprowadzImieINazwiskoUzytkownika(){
        wait.waitForVisibility(imieUzytkowkikaInput).clear();
        imieUzytkowkikaInput.sendKeys(nowyUzytkownikImie);
        System.out.println("Wprowadzenie imienia użytkownika: " + nowyUzytkownikImie);

        nazwiskoUzytkowkikaInput.clear();
        nazwiskoUzytkowkikaInput.sendKeys(nowyUzytkownikNazwisko);
        System.out.println("Wprowadzenie nazwiska użytkownika: " + nowyUzytkownikNazwisko);
    }

    // Wybiera język "Polski" z listy rozwijanej
    public void wybierzJezykPolskiUzytkownika(){
        wait.waitForVisibility(jezykListaRozwijana).click();
        wait.waitForVisibility(polskiLista).click();
        System.out.println("Wybranie języka polskiego dla użytkownika.");
    }

    // Klika przycisk "Generuj hasło"
    public void nacisnijGenerujHasloButton(){
        wait.waitForVisibility(generujHasloButton).click();
        System.out.println("Naciśnięcie przycisku 'Generuj hasło'.");
    }

    // Sprawdza, czy hasło ma status "Silne"
    public boolean sprawdzCzyHasloJestSilne(){
        boolean status = false;

        wait.waitForVisibility(silaHaslaResult);

        if (silaHaslaResult.getText().contains("Silne")) {
            status = true;
            System.out.println("Haslo ma status: " + silaHaslaResult.getText());
        } else {
            System.out.println("Haslo ma zły status. Oczekiwany status: Silne. Obecny status: " + silaHaslaResult.getText());
        }

        return status;
    }

    // Sprawdza, czy checkbox "Wyślij powiadomienie użytkownikowi" jest domyślnie zaznaczony
    public boolean sprawdzCzyCheckboxWyslijPowiadomienieUzytkownikowiJestZaznaczony(){
        boolean status = false;

        if (wyslijPowiadomienieUzytkownikowiCheckbox.isSelected()) {
            status = true;
            System.out.println("Checkbox 'Wyślij powiadomienie użytkownikowi' jest domyślnie zaznaczony.");
        } else {
            System.out.println("Checkbox 'Wyślij powiadomienie użytkownikowi' nie jest domyślnie zaznaczony.");
        }

        return status;
    }

    // Klika przycisk "Utwórz użytkownika"
    public void nacisnijPrzyciskUtworzUzytkownika(){
        wait.waitForVisibility(utworzUzytkownikaButton).click();
        System.out.println("Kliknięcie przycisku 'Utwórz użytkownika'.");
    }


     /**********************************Operacje na webelementach KONIEC ******************************************/

}
