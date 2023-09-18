package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import io.qameta.allure.Step;

@Log4j2
public class Input {
    private final String inputLocator = "%s";
    private final WebDriver driver;
    private final String id;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    private By getInputLocator() {
        return By.id(String.format(inputLocator, this.id));
    }

    private void clearInput() {
        driver.findElement(getInputLocator()).clear();
        log.info("Clear input with id: " + id);
    }

    @Step("Write text: {text} into input")
    public void write(String text) {
        clearInput();
        driver.findElement(getInputLocator()).sendKeys(text);
        log.info("Write into input with label: " + id + ", text: " + text);
    }

    @Step("Input BDay: {text}")
    public void inputBDay(String text) {
        clearInput();
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(getInputLocator())).perform();
        driver.findElement(getInputLocator()).sendKeys(text);
        log.info("Write into input BDay with label: " + id + ", text: " + text);
    }
}