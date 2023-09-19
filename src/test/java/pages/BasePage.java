package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

@Log4j2
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;


    final String BASE_URL = System.getenv().getOrDefault("FINAL_SURGE-URL",
            PropertyReader.getProperty("finalsurge.url"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickElementByJavascript(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        log.info("Click on the item with a by Javascript");
    }

    public abstract boolean isPageOpen();

    @Step("Checking for locator presence")
    public boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            log.error("Page is not loaded");
            return false;
        }
    }


}