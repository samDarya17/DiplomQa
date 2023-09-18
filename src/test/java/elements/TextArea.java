package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    String textAreaLocator = "%s";
    WebDriver driver;
    String id;

    public TextArea(WebDriver driver, String id) {
        this.driver = driver;
        this.id = id;
    }

    @Step("Fill Text Area with {text}")
    public void fillDescription(String text) {
        driver.findElement(By.id(String.format(textAreaLocator, id))).sendKeys(text);
        log.info("Write " + text + " into Text Area with id " + id);
    }
}