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

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    @Step("Write the text in TextArea")
    public void write(String text) {
        driver.findElement(By.id(String.format(textAreaLocator, this.id))).sendKeys(text);
        log.info("Write " + text + " into Text Area with id " + this.id);
    }
}