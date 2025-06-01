 package pages.seleniumShop;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class ZalogowanyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;

    //konstrukotor, który tworzy nową instancję strony logowania
    public ZalogowanyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/
    @FindBy(xpath = "//*[contains(text(),'Adresy')]" )
            private WebElement adresyMenuBoczne;


    /***************************Repozytorium webelementów KONIEC ******************************************/



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public void przejscieDoAdresow(){
        adresyMenuBoczne.click();
    }


    /**********************************Operacje na webelementach KONIEC ******************************************/

}
