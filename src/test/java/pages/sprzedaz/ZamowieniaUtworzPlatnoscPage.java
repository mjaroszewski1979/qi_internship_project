package pages.sprzedaz;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ZamowieniaUtworzPlatnoscPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public ZamowieniaUtworzPlatnoscPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************Repozytorium webelementów START **********************************************/

    // STAŁE POPRAWNE ELEMENTY STRONY:

    // Tytuł strony "Utwórz płatność"
    private String poprawnyTytulStronyUtworzPlatnosc = "Utwórz płatność ‹ Platforma kursów online — WordPress";
    // URL strony "Utwórz płatność"
    private String poprawnyURLStronyUtworzPlatnosc = "https://mmrmqpr585.publigo.onl/wp-admin/options.php?page=edd-manual-purchase";
    // Liczba pozycji w formularzu "Utwórz nową płatność"
    private int prawidlowaLiczbaPozycjiFormularza = 8;


    // ELEMENTY NA STRONIE:

    //Tytuł:
    @FindBy(xpath = "//*[contains(text(),'Utwórz nową płatność')]")
    private WebElement sekcjaTytulowaUtworzNowaPlatnosc;


    // Listy rozwijalne:
    @FindBy(xpath = "//select[contains(@class,'edd-mp-download-select')]")
    private WebElement listaWybierzProdukty;

    @FindBy(xpath = "//select[contains(@class,'edd-select')]")
    private WebElement listaStatusPlatnosci;


    // Przyciski:
    @FindBy(xpath = "//*[contains(text(),'Dodaj kolejny')]")
    private WebElement dodajKolejnyButton;

    @FindBy(xpath = "//*[contains(@id,'submit')]")
    private WebElement utworzPlatnoscButton;

    @FindBy(xpath = "//input[contains(@id,'edd-mp-receipt')]")
    private WebElement checkboxWyslijPotwierdzenieZakupu;


    // Nazwy pól formularza:
    @FindBy(xpath = "//*[contains(@class, 'form-field')]")
    private List<WebElement> pozycjeFormularzaUtworzNowaPlatnosc;

    @FindBy(xpath = "//label[contains(text(),'Produkt')]")
    private WebElement pozycjaProdukt;

    @FindBy(xpath = "//label[contains(text(),'Email lub ID kupującego')]")
    private WebElement pozycjaEmailLubIDKupujacego;

    @FindBy(xpath = "//input[@id='edd-mp-user']")
    private WebElement poleWpiszAdresEmail;

    @FindBy(xpath = "//label[contains(text(),'Imię')]")
    private WebElement pozycjaImie;

    @FindBy(xpath = "//label[contains(text(),'Nazwisko')]")
    private WebElement pozycjaNazwisko;

    @FindBy(xpath = "//label[contains(text(),'Kwota')]")
    private WebElement pozycjaKwota;

    @FindBy(xpath = "//th[contains(text(),'Status płatności')]")
    private WebElement pozycjaStatusPlatnosci;

    @FindBy(xpath = "//th[contains(text(), 'Wyślij potwierdzenie zakupu')]")
    private WebElement pozycjaWyslijPotwierdzenieZakupu;

    @FindBy(xpath = "//label[contains(text(),'Data')]")
    private WebElement pozycjaData;


    // Edytowalne pola formularza (tekstowe i kalendarz):
    @FindBy(xpath = "//input[@id='edd-mp-date']")
    private WebElement poleData;














    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyUtworzPlatnosc(){
        System.out.println("Aktualny tytuł strony UTWÓRZ PŁATNOŚĆ: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyUtworzPlatnosc(){
        System.out.println("Poprawny tytuł strony UTWÓRZ PŁATNOŚĆ: " + poprawnyTytulStronyUtworzPlatnosc);
        return poprawnyTytulStronyUtworzPlatnosc;
    }

    // Zwraca aktualny adres URL strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyUtworzPlatnosc(){
        System.out.println("Aktualny URL strony UTWÓRZ PŁATNOŚĆ: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyUtworzPlatnosc() {
        System.out.println("Poprawny URL strony UTWÓRZ PŁATNOŚĆ: " + poprawnyURLStronyUtworzPlatnosc);
        return poprawnyURLStronyUtworzPlatnosc;
    }

    // Sprawdza, czy sekcja tytułowa "Utwórz nową płatność" jest widoczna
    public boolean zwrocSekcjeTytulowaUtworzNowaPlatnosc(){
        boolean status = false;

        if (sekcjaTytulowaUtworzNowaPlatnosc.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje sekcja tytułowa UTWÓRZ NOWĄ PŁATNOŚĆ");
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma sekcji tytułowej UTWÓRZ NOWĄ PŁATNOŚĆ");
        }

        return status;
    }

    // Sprawdza, czy lista "Wybierz produkty" jest widoczna
    public boolean zweryfikujCzyListaProduktowIstnieje(){
        boolean status = false;

        if (listaWybierzProdukty.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje lista: " + listaWybierzProdukty.getText());
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma listy WYBIERZ PRODUKTY");
        }

        return status;
    }

    // Sprawdza, czy lista dla "Status płatności" jest widoczna
    public boolean zweryfikujCzyListaDlaStatusPlatnosciIstnieje(){
        boolean status = false;

        if (listaStatusPlatnosci.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje lista dla 'Status płatności'");
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma listy dla 'Status płatności'");
        }

        return status;
    }

    // Sprawdza, czy przycisk "Dodaj kolejny" jest widoczny
    public boolean zweryfikujCzyPrzyciskDodajKolejnyIstnieje(){
        boolean status = false;

        if (dodajKolejnyButton.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje przycisk: " + dodajKolejnyButton.getText());
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma przycisku DODAJ KOLEJNY");
        }

        return status;
    }

    // Sprawdza, czy przycisk "Utwórz płatność" jest widoczny
    public boolean zweryfikujCzyPrzyciskUtworzPlatnoscIstnieje(){
        boolean status = false;

        if (utworzPlatnoscButton.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje przycisk: " + utworzPlatnoscButton.getAccessibleName());
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma przycisku DODAJ KOLEJNY");
        }

        return status;
    }

    // Zwraca aktualną liczbę pozycji formularza "Utwórz nową płatność"
    public int zwrocAktualnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(){
        System.out.println("Liczba pozycji formularza UTWÓRZ NOWĄ PŁATNOŚĆ: " + pozycjeFormularzaUtworzNowaPlatnosc.size());
        return pozycjeFormularzaUtworzNowaPlatnosc.size();
    }

    // Zwraca oczekiwaną (poprawną) liczbę pozycji formularza "Utwórz nową płatność"
    public int zwrocPoprawnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(){
        System.out.println("Oczekiwana liczba pozycji formularza UTWÓRZ NOWĄ PŁATNOŚĆ: " + prawidlowaLiczbaPozycjiFormularza);
        return prawidlowaLiczbaPozycjiFormularza;
    }

    // Sprawdza, czy aktualne nazwy pozycji formularza są takie same, jak oczekiwane
    public boolean zweryfikujNazwyPozycjiFormularzaUtworzNowaPlatnosc() {
        // Mapa z nazwami pozycji formularza (oczekiwana, obecna)
        // W przypadku zmian w nazwach pozycji formularza należy wprowadzić tu odpowiednie zmiany:
        // (zmienić tekst / dodać nową pozycję formularza i jej nazwę)
        Map<String, WebElement> nazwyPozycji = new HashMap<>();
        nazwyPozycji.put("Produkt", pozycjaProdukt);
        nazwyPozycji.put("Email lub ID kupującego", pozycjaEmailLubIDKupujacego);
        nazwyPozycji.put("Imię", pozycjaImie);
        nazwyPozycji.put("Nazwisko", pozycjaNazwisko);
        nazwyPozycji.put("Kwota", pozycjaKwota);
        nazwyPozycji.put("Status płatności", pozycjaStatusPlatnosci);
        nazwyPozycji.put("Wyślij potwierdzenie zakupu", pozycjaWyslijPotwierdzenieZakupu);
        nazwyPozycji.put("Data", pozycjaData);

        boolean status = true;

        // Iterujemy po mapie z nazwami pozycji formularza
        for (Map.Entry<String, WebElement> entry : nazwyPozycji.entrySet()) {
            String oczekiwanaNazwaPozycji = entry.getKey();
            WebElement aktualnaNazwaPozycji = entry.getValue();

            // Sprawdzamy, czy nazwa pozycji formularza jest widoczna i zgodna z oczekiwaną
            try {
                WebElement obecnyElement = wait.waitForVisibility(aktualnaNazwaPozycji);

                boolean nazwaWidoczna = obecnyElement.isDisplayed();
                boolean nazwaZgodna = obecnyElement.getText().trim().equals(oczekiwanaNazwaPozycji);

                if (!nazwaWidoczna || !nazwaZgodna) {
                    if (!nazwaWidoczna) {
                        System.out.println("Pozycja formularza nie jest widoczna: " + oczekiwanaNazwaPozycji);
                    }
                    if (!nazwaZgodna) {
                        System.out.println("Nazwa pozycji formularza jest niezgodna. "
                                + "Oczekiwano: '" + oczekiwanaNazwaPozycji + "' "
                                + "Znaleziono: '" + obecnyElement.getText().trim() + "' ");
                    }
                    status = false;
                } else {
                    System.out.println("Pozycje formularza są widoczne i mają zgodne nazwy : " + oczekiwanaNazwaPozycji);
                }

            } catch (Exception e) {
                System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma pozycji: " + oczekiwanaNazwaPozycji);
                e.printStackTrace();
                status = false;
            }
        }

        return status;
    }

    // Sprawdza, czy checkbox "Wyślij potwierdzenie zakupu" jest widoczny i zaznaczony
    public boolean zweryfikujCzyCheckboxWyslijPotwierdzenieZakupuIstniejeIJestZaznaczony() {
        boolean status = true;

        try {
            WebElement obecnyElement = wait.waitForVisibility(checkboxWyslijPotwierdzenieZakupu);
            boolean checkboxWidoczny = obecnyElement.isDisplayed();
            boolean checkboxZaznaczony = obecnyElement.isSelected();

            if (!checkboxWidoczny || !checkboxZaznaczony) {
                if (!checkboxWidoczny) {
                    System.out.println("Checkbox 'Wyślij potwierdzenie zakupu' nie jest widoczny");
                }
                if (!checkboxZaznaczony) {
                    System.out.println("Checkbox 'Wyślij potwierdzenie zakupu' nie jest zaznaczony");
                }
                status = false;
            } else {
                System.out.println("Checkbox 'Wyślij potwierdzenie zakupu' jest widoczny i zaznaczony");
            }

        } catch (Exception e) {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma checkboxa 'Wyślij potwierdzenie zakupu'");
            e.printStackTrace();
            status = false;
        }

        return status;
    }


    public void stworzNowaPlatnosc(String produkt, String email, String status, String data) {

        //Przekształca listę produktów oraz status płatności z WebElement na Select dla łatwiejszego wyboru
        Select listaProdukt = new Select(listaWybierzProdukty);
        Select statusPlatnosci = new Select(listaStatusPlatnosci);

        listaProdukt.selectByVisibleText(produkt);
        poleWpiszAdresEmail.sendKeys(email);
        statusPlatnosci.selectByVisibleText(status);
        //Datę podajemy w formacie MM/DD/RRRR
        poleData.sendKeys(data);
        utworzPlatnoscButton.click();
    }


//**********************************Operacje na webelementach KONIEC ******************************************/
}
