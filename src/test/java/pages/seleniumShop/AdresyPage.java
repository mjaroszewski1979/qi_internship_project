 package pages.seleniumShop;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class AdresyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public AdresyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/
    @FindBy(xpath = "//*[contains(text(),'Adres do wysyłki')]/following-sibling::a" )
            private WebElement edytujAdresWysylki;

    @FindBy(id ="shipping_address_1")
            private WebElement ulicaInput;

    @FindBy(name ="save_address")
            private WebElement zapiszAdresButton;

    /***************************Repozytorium webelementów KONIEC ******************************************/



    /***************************Repozytorium webelementów KONIEC ******************************************/



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public void otworzEdycjeAdresuWysylki(){
        edytujAdresWysylki.click();
    }

    public void edytujUlicaAdresuWysylki(){

        ulicaInput.clear();
        ulicaInput.sendKeys("Sloneczka 49");
        zapiszAdresButton.click();
    }
//
//    public boolean sprawdzCzyKomunikatJestWidoczny(){
//        boolean status = false;
//
//        if(wait.waitForTextToBePresent(driver.getPageSource().contains("Adres został zmieniony."))){
//            status = true;
//        }
//
//        return status;
//
//    }




    /**********************************Operacje na webelementach KONIEC ******************************************/

}
