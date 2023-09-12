package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    final String URL = "https://www.finalsurge.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        Duration timeoutDuration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
    }

    public abstract boolean isPageOpen();

    public boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;

        }
    }
}