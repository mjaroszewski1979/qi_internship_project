package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {

    /*****************sekja techniczna START **********************************************/
    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*****************sekja techniczna KONIEC **********************************************/


    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForElementsPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitForInvisibility(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForTextToBePresent(WebElement element, String text){
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean waitForTextInPageSource(String text){
        return wait.until(driver -> driver.getPageSource().contains(text));
    }

    public boolean waitForAttributeToBe(WebElement element, String attribute, String value) {
        return wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }


}
