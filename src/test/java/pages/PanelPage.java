package pages;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PanelPage {
    //************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego


    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public PanelPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    //************************Repozytorium webelementów START **********************************************/

    @FindBy(xpath = "//span[contains(text(), 'Moje Publigo')]")
    private WebElement mojePubligoButtonMenuGorne;

    @FindBy(xpath = "//div[contains(text(), 'Testy')]")
    private WebElement zakladkaTestyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Certyfikaty')]")
    private WebElement zakladkaCertyfikatyMenuBoczne;

    @FindBy(xpath ="//div[contains(text(),'Ustawienia')]")
    private WebElement zakladkaUstawienia;

    @FindBy(xpath = "//div[contains(text(), 'Narzędzia')]")
    private WebElement zakladkaNarzedziaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Powiadomienia')]")
    private WebElement zakladkaPowiadomieniaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Logi')]")
    private WebElement zakladkaLogiMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Webhooki')]")
    private WebElement webhookiMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Przekierowania')]")
    private WebElement przekierowaniaMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Raporty')]")
    private WebElement zakladkaRaportyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Media')]")
    private WebElement zakladkaMedia;

    @FindBy(xpath = "//div[contains(text(), 'Komentarze')]")
    private WebElement zakladkaKomentarze;

    @FindBy(xpath = "//div[contains(text(), 'Produkty cyfrowe')]")
    private WebElement zakladkaProduktyCyfrowe;

    @FindBy(xpath ="//div[contains(text(),'Sprzedaż')]" )
    private WebElement sprzedazMenuLista;

    @FindBy(xpath = "//*[contains(text(),'Zamówienia')]")
    private WebElement zamowieniaMenuLista;

    @FindBy(xpath = "//*[contains(text(),'Płatności zaplanowane')]")
    private WebElement platnosciZaplanowaneMenuLista;

    @FindBy(xpath = "//*[contains(text(),'Kody zniżkowe')]")
    private WebElement kodyZnizkoweMenuLista;

    @FindBy(xpath = "//*[contains(text(),'Klienci')]")
    private WebElement klienciMenuLista;

    @FindBy(xpath = "//*[contains(text(),'Historia cen')]")
    private WebElement historiaCenMenuLista;

    @FindBy(xpath = "//div[contains(text(), 'Usługi')]")
    private WebElement zakladkaUslugi;

    @FindBy(xpath = "//div[contains(text(), 'Kursy')]")
    private WebElement zakladkaKursyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Pakiety')]")
    private WebElement zakladkaPakietyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Użytkownicy')]")
    private WebElement zakladkaUzytkownicyMenuBoczne;

   //***************************Repozytorium webelementów KONIEC ******************************************/



    //****************************Operacje na webelementach START **********************************************/

        public boolean weryfikacjaCzyMojePubligoButtonIstnieje(){
            boolean status = false;

            if(wait.waitForVisibility(mojePubligoButtonMenuGorne).isDisplayed()){
                status = true;

                System.out.println("Konto zostalo poprawnie zalogowane.");
            }else{
                System.out.println("Nie udalo sie poprawnie zalogowac.");
            }

            return status;
        }

        public void przejdzDoZakladkiTesty(){
            wait.waitForClickability(zakladkaTestyMenuBoczne).click();
        }

        public void przejdzDoZakladkiCertyfikaty(){
            wait.waitForClickability(zakladkaCertyfikatyMenuBoczne).click();
        }

        public void przejdzDoZakladkiNarzedzia(){
            wait.waitForClickability(zakladkaNarzedziaMenuBoczne).click();
        }

        public void przejdzDoZakladkiRaporty(){
            wait.waitForClickability(zakladkaRaportyMenuBoczne).click();
        }

        //przejście do zakładki 'Kursy'
        public void przejdzDoZakladkiKursy(){
        wait.waitForClickability(zakladkaKursyMenuBoczne).click();
        }

        public void przejdzDoZakladkiUslugi() {
            wait.waitForClickability(zakladkaUslugi).click();
        }

        public void kliknijPrzyciskUstawienia() {
        wait.waitForClickability(zakladkaUstawienia).click();
        }

        public void przejdzDoZakladkaUzytkownicyMenuBoczne() {
        wait.waitForClickability(zakladkaUzytkownicyMenuBoczne).click();
        }

        public void przejdzDoZakladkiPowiadomienia(){
            driver.get("https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-notifications");
        }

        public void przejdzDoZakladkiMedia() {
            wait.waitForClickability(zakladkaMedia).click();
        }

        public void przejdzDoZakladkiKomentarze() {
            zakladkaKomentarze.click();
        }

        public void przejdzDoZakladkiProduktyCyfrowe() {
            zakladkaProduktyCyfrowe.click();
        }

        public void przejdzDoZakladkiLogi(){
            driver.get("https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-logs");
        }

        // Przechodzi do strony "Zamówienia": menu boczne > mouse hover "Sprzedaż" > kliknij "Zamówienia"
        public void kliknijSprzedazZamowieniaMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + zamowieniaMenuLista.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(sprzedazMenuLista).perform();
            wait.waitForVisibility(zamowieniaMenuLista).click();
        }

        // Przechodzi do strony "Płatności zaplanowane": menu boczne > mouse hover "Sprzedaż" > kliknij "Płatności zaplanowane"
        public void kliknijSprzedazPlatnosciZaplanowaneMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + platnosciZaplanowaneMenuLista.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(sprzedazMenuLista).perform();
            wait.waitForVisibility(platnosciZaplanowaneMenuLista).click();
        }

        // Przechodzi do strony "Kody zniżkowe": menu boczne > mouse hover "Sprzedaż" > kliknij "Kody zniżkowe"
        public void kliknijSprzedazKodyZnizkoweMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + kodyZnizkoweMenuLista.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(sprzedazMenuLista).perform();
            wait.waitForVisibility(kodyZnizkoweMenuLista).click();
        }

        // Przechodzi do strony "Klienci": menu boczne > mouse hover "Sprzedaż" > kliknij "Klienci"
        public void kliknijSprzedazKlienciMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + klienciMenuLista.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(sprzedazMenuLista).perform();
            wait.waitForVisibility(klienciMenuLista).click();
        }

        // Przechodzi do strony "Historia cen": menu boczne > mouse hover "Sprzedaż" > kliknij "Historia cen"
        public void kliknijSprzedazHistoriaCenMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + historiaCenMenuLista.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(sprzedazMenuLista).perform();
            wait.waitForVisibility(historiaCenMenuLista).click();
        }

        //przejście do zakładki 'Pakiety'
        public void przejdzDoZakladkiPakiety(){
            wait.waitForClickability(zakladkaPakietyMenuBoczne).click();
    }

        // Przechodzi do strony "Webhooki": menu boczne > mouse hover "Narzędzia" > kliknij "Webhooki"
        public void kliknijNarzedziaWebhookiMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + webhookiMenuBoczne.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(zakladkaNarzedziaMenuBoczne).perform();
            wait.waitForVisibility(webhookiMenuBoczne).click();
        }

        // Przechodzi do strony "Przekierowania": menu boczne > mouse hover "Narzędzia" > kliknij "Przekierowania"
        public void kliknijNarzedziaPrzekierowaniaMenu(){
            System.out.println("Kliknięcie przycisku w menu głównym: " + przekierowaniaMenuBoczne.getText());
            Actions actions = new Actions(driver);
            actions.moveToElement(zakladkaNarzedziaMenuBoczne).perform();
            wait.waitForVisibility(przekierowaniaMenuBoczne).click();
        }







    //**********************************Operacje na webelementach KONIEC ******************************************/

}
