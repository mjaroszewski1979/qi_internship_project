package tests.uzytkownicyTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.uzytkownicy.EdytujUzytkownikaPage;
import pages.uzytkownicy.UtworzUzytkownikaPage;
import pages.uzytkownicy.UzytkownicyPage;
import tests.TestBase;


public class UzytkownicyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/



    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UzytkownicyPage uzytkownicyPage;
    private EdytujUzytkownikaPage edytujUzytkownikaPage;
    private UtworzUzytkownikaPage utworzUzytkownikaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpEdytujUzytkownikaPagePage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uzytkownicyPage = new UzytkownicyPage(driver);
        edytujUzytkownikaPage = new EdytujUzytkownikaPage(driver);
        utworzUzytkownikaPage = new UtworzUzytkownikaPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja czy po  zmianie roli na 'Menadzer Tresci Publigo' zmieni sie ona rowniez w zakladce w tabeli 'Uzytkownicy'")
    public void weryfikacjaZmianyRoliNaMenadzerTresciPubligo(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkaUzytkownicyMenuBoczne();
        uzytkownicyPage.nacisnijDodajNowegoUzytkownikaButton();
        utworzUzytkownikaPage.wprowadzNazweIEmailUzytkownika();
        utworzUzytkownikaPage.nacisnijPrzyciskUtworzUzytkownika();
        uzytkownicyPage.nacisnijPrzyciskLupy();
        uzytkownicyPage.wpiszNazweDoPolaWpiszByWyszukacNazwe();
        uzytkownicyPage.nacisnijWIdWyswietlonegoUzytkownika();
        edytujUzytkownikaPage.edytujRoleUzytkownikaNaMenadzerTresciPubligo();
        edytujUzytkownikaPage.nacisnijPrzyciskZaktualizujKontoUzytkownika();
        uzytkownicyPage.cofnijSieDoStronyUzytkownicy();
        uzytkownicyPage.nacisnijPrzyciskLupy();
        uzytkownicyPage.wpiszNazweDoPolaWpiszByWyszukacNazwe();

        Assert.assertTrue(uzytkownicyPage.sprawdzCzyUzytkownikPosiadaRoleMenadzerTresciPubligo(), "Zmiana roli nie powiodla sie.");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawności pełnego procesu tworzenia nowego użytkownika: "
            + "nazwa, email, imię, nazwisko, język 'Polski', generuj hasło o domyślnym statusie 'Silne', "
            + "domyślne zaznaczony checkbox 'Wyślij powiadomienie użytkownikowi', kliknięcie przycisku 'Utwórz użytkownika'."
            + "Oczekiwany wynik: pojawia się komunikat o pomyślnym utworzeniu użytkownika i widać dane użytkownika w tabeli.")
    public void weryfikacjaUtworzeniaNowegoUzytkownika() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkaUzytkownicyMenuBoczne();
        uzytkownicyPage.nacisnijDodajNowegoUzytkownikaButton();
        utworzUzytkownikaPage.wprowadzNazweIEmailUzytkownika();
        utworzUzytkownikaPage.wprowadzImieINazwiskoUzytkownika();
        utworzUzytkownikaPage.wybierzJezykPolskiUzytkownika();
        utworzUzytkownikaPage.nacisnijGenerujHasloButton();
        utworzUzytkownikaPage.sprawdzCzyHasloJestSilne();
        utworzUzytkownikaPage.sprawdzCzyCheckboxWyslijPowiadomienieUzytkownikowiJestZaznaczony();
        utworzUzytkownikaPage.nacisnijPrzyciskUtworzUzytkownika();

        Assert.assertTrue(uzytkownicyPage.sprawdzCzyWidacKomunikatUzytkownikUtworzonyPomyslnie(),
                "Nie udało się poprawnie utworzyć użytkownika.");
        Assert.assertTrue(uzytkownicyPage.sprawdzCzyWidacDaneNowegoUtworzonegoUzytkownikaWTabeli(),
                "Nie widać danych użytkownika w tabeli.");
    }








}
