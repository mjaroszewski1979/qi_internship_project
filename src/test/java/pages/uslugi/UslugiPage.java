package pages.uslugi;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UslugiPage {


    //parametry klasy UslugiPage
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony Uslugi
    public UslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //zmienne pomocnicze

    String poprawnyURLZakladkiUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-services";
    String poprawnyTytulZakladkiUslugi = "Usługi ‹ Platforma kursów online — WordPress";


    //elementy bazowej strona Uslugi

    @FindBy(xpath = "//button[text()='Utwórz nową usługę']")
    private WebElement utworzNowaUslugeButton;

    @FindBy(xpath = "//button[text()='Typy danych']")
    private WebElement typyDanychButton;

    //element konieczny do utworzenia waita na pelne zaladowanie dynamicznej tabeli uslug
    @FindBy(xpath = "//table[@class='dynamic-table loaded']")
    private WebElement tabelaUslug;

    //dodaje widoczne w tabeli uslugi do listy
    @FindBy(xpath = "//td[@class='type-id']/a")
    private List<WebElement> listaUslug;

    //komunikat pojawiajacy sie po kliknieciu buttony 'Typy danych'
    private String typyDanychKomunikat = "Wybierz które kolumny mają być widoczne w tabeli";


    //elementy okna "Utwórz nową usługę'

    @FindBy(xpath = "//button[text()='Utwórz i edytuj']")
    private WebElement utworzIEdytujButton;

    @FindBy(xpath = "//h2[contains(text(), 'Utwórz nową usługę')]")
    private WebElement utworzNowaUslugeOkno;

    @FindBy(id = "name")
    private WebElement nazwaUslugiInput;

    @FindBy(id = "price")
    private WebElement cenaInput;


    //gettery

    //zwraca pobrany adres obecnej strony
    public String zwrocAktualnyURLStronyUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwraca wzorowy adres strony
    public String zwrocPoprawnyURLStronyUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiUslugi);
        return poprawnyURLZakladkiUslugi;
    }

    //zwraca pobrany adres aktualnej strony
    public String zwrocAktualnyTytulStronyUslugi() {
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    //zwraca wzorowy tytul strony
    public String zwrocPoprawnyTytulStronyUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiUslugi);
        return poprawnyTytulZakladkiUslugi;
    }


    //metody weryfikujace

    //metoda weryfikujaca czy po kliknieciu przycisku 'Typy danych' pojawia się komunikat: "Wybierz które kolumny mają być widoczne w tabeli"
    public boolean zweryfikujCzyIstniejeSekcjaWyboruKolumn() {
        return driver.getPageSource().contains(typyDanychKomunikat);
    }

    //metoda weryfikujaca czy po kliknieciu 'Utworz nowa uslugę' w pojawiajacym się oknie dialogowym istnieja zarowno pole 'Nazwa uslugi' jak i 'Cena'
    public boolean zweryfikujCzyIstniejaPolaNazwaUslugiICena() {
        boolean status = false;

        if (nazwaUslugiInput.isDisplayed() && cenaInput.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean zweryfikujCzyIstniejeUtworzNowaUslugeButton() {
        return utworzNowaUslugeButton.isDisplayed();
    }

    public boolean zweryfikujCzyIstniejeTypyDanychButton() {
        return typyDanychButton.isDisplayed();
    }


    //bazowa strona Uslugi

    //oczekiwanie na zaladowanie sie dynamicznej tabeli uslug
    public void poczekajNaTabeleUslug() {
        wait.waitForVisibility(tabelaUslug);
    }

    public void kliknijTypyDanychButton() {
        wait.waitForClickability(typyDanychButton).click();
    }

    //    przejscie do strony 'Edycja uslugi' poprzez klikniecie w pierwsza od gory usluge w dynamicznej tabeli
    //    pozwala przejsc do Edycji bez tworzenia nowej uslugi
    public void przejdzDoPierwszejUslugiZListy() {
        wait.waitForClickability(listaUslug.getFirst()).click();
    }


    //Okno 'Utworz nową usługę'

    public void kliknijUtworzNowaUslugeButton() {
        wait.waitForClickability(utworzNowaUslugeButton).click();
    }

    //oczekiwanie na okno dialogowe po kliknieciu przycisku 'Utwórz nową usługę'
    public void poczekajNaUtworzNowaUslugeOkno() {
        wait.waitForVisibility(utworzNowaUslugeOkno);
    }

    //nadaje usludze nazwe
    public void wprowadzNazweUslugiDoPolaNazwaUslugi() {
        wait.waitForVisibility(nazwaUslugiInput).clear();
        nazwaUslugiInput.sendKeys("testtest");
    }

    //ekwiwalent metody wyzej - potrzebna do zadania
    public void wprowadzNazweUslugiDoPolaNazwaUslugiZadanie() {
        wait.waitForVisibility(nazwaUslugiInput).sendKeys("testzadanie1");
    }

    //nadaje usludze cene
    public void wprowadzCeneDoPolaCena() {
        wait.waitForVisibility(cenaInput).clear();
        cenaInput.sendKeys("123");
    }

    //ekwiwalent metody wyzej - do zadania
    public void wprowadzCeneDoPolaCenaZadanie() {
        wait.waitForVisibility(cenaInput).sendKeys("2999");
    }

    public void kliknijUtworzIEdytujButton() {
        wait.waitForClickability(utworzIEdytujButton).click();
    }

    //metoda przechodząca przez proces tworzenia nowej uslugi o nazwie 'testtest' i cenie '123'
    //moze byc uzyta by przejsc do strony 'Edycja uslugi'
    public void utworzNowaUsluge() {
        kliknijUtworzNowaUslugeButton();
        poczekajNaUtworzNowaUslugeOkno();
        wprowadzNazweUslugiDoPolaNazwaUslugi();
        wprowadzCeneDoPolaCena();
        kliknijUtworzIEdytujButton();
    }

    //ekwiwalent metody wyzej - zawiera metody do zadania
    public void utworzNowaUslugeZadanie() {
        kliknijUtworzNowaUslugeButton();
        poczekajNaUtworzNowaUslugeOkno();
        wprowadzNazweUslugiDoPolaNazwaUslugiZadanie();
        wprowadzCeneDoPolaCenaZadanie();
        kliknijUtworzIEdytujButton();
    }


}
