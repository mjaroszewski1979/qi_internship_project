package tests.komentarzeTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.komentarze.KomentarzePage;
import tests.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KomentarzePageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KomentarzePage komentarzePage;

    @BeforeMethod
    public void setUpKomentarzePage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        komentarzePage = new KomentarzePage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do zakładki "Komentarze"
    private void przejdzDoZakladkiKomentarze() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiKomentarze();
    }

    // Sprawdza czy adres URL strony "Komentarze" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Komentarze'")
    public void weryfikacjaAdresuUrlZakladkiKomentarzeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertEquals(driver.getCurrentUrl(), komentarzePage.getPoprawnyUrlStrony(),
                "Adres URL strony jest niepoprawny.");
    }

    // Sprawdza czy tytuł strony "Komentarze" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Komentarze'")
    public void weryfikacjaTytuluStronyKomentarzeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertEquals(driver.getTitle(), komentarzePage.getPoprawnyTytulStrony(),
                "Tytuł strony jest niepoprawny.");
    }

    // Sprawdza czy na stronie znajdują się pole tekstowe oraz button do szukania komentarzy
    @Test(priority = 120, enabled = true,
            description = "Weryfikacja czy pole tekstowe i button do szukania komentarzy istnieją'")
    public void weryfikacjaCzyPoleTekstoweIButtonSzukaniaKomentarzyIstniejaTest() {
        przejdzDoZakladkiKomentarze();

        boolean poleKomentarzyWidoczne = komentarzePage.getPoleSzukajKomentarza().isDisplayed();
        boolean buttonSzukajWidoczny = komentarzePage.getSzukajKomentarzyButton().isDisplayed();

        // Domyślna wiadomość asercji w przypadku gdyby nie można było odnaleźć obu elementów
        String wiadomoscBledu = "Nie znaleziono obu elementów na stronie";

        // Instrukcja sprawdza, które z dwóch elementów są widoczne
        // i na podstawie wyniku ustawia zmienną "wiadomoscBledu" do asercji
        if (poleKomentarzyWidoczne && !buttonSzukajWidoczny) {
            wiadomoscBledu = "Nie znaleziono buttona 'Szukaj komentarzy'";
        } else if (!poleKomentarzyWidoczne && buttonSzukajWidoczny) {
            wiadomoscBledu = "Nie znaleziono pola tekstowego do szukania komentarzy";
        }

        Assert.assertTrue(poleKomentarzyWidoczne && buttonSzukajWidoczny,
                wiadomoscBledu);
    }

    // Sprawdza czy na stronie znajduje się button "Zastosuj"
    @Test(priority = 130, enabled = true, description = "Weryfikacja czy na stronie jest button 'Zastosuj'")
    public void weryfikacjaCzyButtonZastosujIstniejeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertTrue(komentarzePage.getZastosujButton().isDisplayed(),
                "Nie znaleziono buttona 'Zastosuj'");
    }

    // Sprawdza czy na stronie znajduje się button "Przefiltruj"
    @Test(priority = 140, enabled = true, description = "Weryfikacja czy na stronie jest button 'Przefiltruj'")
    public void weryfikacjaCzyButtonPrzefiltrujIstniejeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertTrue(komentarzePage.getPrzefiltrujButton().isDisplayed(),
                "Nie znaleziono buttona 'Przefiltruj'");
    }

    // Sprawdza czy na stronie znajduje się lista rozwijana "Działania masowe"
    @Test(priority = 150, enabled = true,
            description = "Weryfikacja czy na stronie jest lista rozwijana 'Działania masowe'")
    public void weryfikacjaCzyListaDzialaniaMasoweIstniejeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertTrue(komentarzePage.getDzialaniaMasoweLista().isDisplayed(),
                "Nie znaleziono listy rozwijanej 'Działania masowe'");
    }

    // Sprawdza czy na stronie znajduje się lista rozwijana "Wszystkie typy komentarzy"
    @Test(priority = 160, enabled = true,
            description = "Weryfikacja czy na stronie jest lista rozwijana 'Wszystkie typy komentarzy'")
    public void weryfikacjaCzyListaWszystkieTypyKomentarzyIstniejeTest() {
        przejdzDoZakladkiKomentarze();
        Assert.assertTrue(komentarzePage.getWszystkieTypyKomentarzyLista().isDisplayed(),
                "Nie znaleziono listy rozwijanej 'Wszystkie typy komentarzy'");
    }


    // Sprawdza czy na stronie "Komentarze" znajduje się menu z konkretną ilością elementów pod nagłówkiem
    @Test(priority = 170, enabled = true,
            description = "Weryfikacja czy na stronie jest menu o podanej ilości elementów")
    public void weryfikacjaCzyIstniejeMenuTest() {
        przejdzDoZakladkiKomentarze();

        int oczekiwanaIloscElementow = 6;
        int aktualnaIloscElementow = komentarzePage.getElementyMenu().size();

        Assert.assertEquals(aktualnaIloscElementow, oczekiwanaIloscElementow,
                "Ilość elementów w menu jest inna niż oczekiwana");
    }

    // Sprawdza czy wszystkie elementy w menu strony "Komentarze" są poprawne
    @Test(priority = 180, enabled = true,
            description = "Weryfikacja czy wszystkie elementy menu strony 'Komentarze' są poprawne")
    public void weryfikacjaCzyWszystkieElemenetyMenuSaPoprawneTest() {
        przejdzDoZakladkiKomentarze();

        // Stream wyciągający przefiltrowany tekst z każdego elementu menu
        // aby pasował do oczekiwanych nazw w liście Stringów poniżej
        List<String> faktyczneNazwy = komentarzePage.getElementyMenu().stream()
                .map(a -> a.getText().replaceAll("\\s*\\(.*?\\)", "").trim())
                .toList();

        // Oczekiwane nazwy każdego z elementów menu
        List<String> oczekiwaneNazwy = Arrays.asList(
                "Wszystkie",
                "Moich",
                "Oczekujące na przegląd",
                "Zatwierdzono",
                "Spam",
                "Kosz"
        );

        Assert.assertEquals(faktyczneNazwy, oczekiwaneNazwy, "Nazwy w menu komentarzy są nieprawidłowe");
    }

    // Sprawdza czy każdy komentarz na liście posiada checkbox
    @Test(priority = 190, enabled = true,
            description = "Weryfikacja czy każdy komentarz na liście posiada checkbox")
    public void weryfikacjaCzyWszystkieKomentarzePosiadajaCheckboxTest() {
        przejdzDoZakladkiKomentarze();

        int faktycznaIloscCheckboxow = komentarzePage.getCheckboxyKomentarzy().size();
        int oczekiwanaIloscCheckboxow = komentarzePage.getKomentarze().size();

        Assert.assertEquals(faktycznaIloscCheckboxow, oczekiwanaIloscCheckboxow,
                "Nieprawidłowa ilość checkboxów względem komentarzy");
    }

    // Sprawdza czy każdy komentarz na liście jest domyślnie niezaznaczony
    @Test(priority = 200, enabled = true,
            description = "Weryfikacja czy każdy komentarz na liście jest domyślnie niezaznaczony")
    public void weryfikacjaCzyWszystkieCheckboxyKomentarzySaDomyslnieNiezaznaczoneTest() {
        przejdzDoZakladkiKomentarze();

        // Zmienna warunkowa do asercji - domyślnie zakłada, że wszystkie checkboxy są niezaznaczone
        boolean checkboxySaNiezaznaczone = true;

        // Pętla sprawdza czy każdy checkbox jest odznaczony, jeśli nie jest
        // to wychodzimy z pętli i ustawiamy zmienną "checkboxySaNiezaznaczone" na false
        for (WebElement checkbox : komentarzePage.getCheckboxyKomentarzy()) {
            if (checkbox.isSelected()) {
                checkboxySaNiezaznaczone = false;
                break;
            }
        }

        Assert.assertTrue(checkboxySaNiezaznaczone,
                "Nie wszystkie checkboxy są domyślnie niezaznaczone");
    }

}
