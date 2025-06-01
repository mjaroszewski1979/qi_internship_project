 package pages.seleniumShop;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class SzczegolyKontaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;

    //konstrukotor, który tworzy nową instancję strony logowania
    public SzczegolyKontaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/


    @FindBy(xpath = "//*[contains(text(),'Szczegóły konta')]" )
    private WebElement szczegolyKontaMenuBoczne;

    @FindBy(id = "password_current")
    private WebElement aktualneHasloInput;

    @FindBy(id = "password_1")
    private WebElement noweHasloInput;

    @FindBy(id = "password_2")
    private WebElement potwierdzNoweHasloInput;

    /***************************Repozytorium webelementów KONIEC ******************************************/



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public void przejscieDoSzczegoliKonta(){
        szczegolyKontaMenuBoczne.click();
    }

    public boolean czyFormularzZmianyHaslaPoprawny(){
        boolean status = false;

        if(aktualneHasloInput.isDisplayed() && noweHasloInput.isDisplayed() && potwierdzNoweHasloInput.isDisplayed() ){
            status = true;
        }

        return status;
    }



    /**********************************Operacje na webelementach KONIEC ******************************************/

}
