package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

@Log4j2
public class RadioButton {
    String radioButton = "%s";
    WebDriver driver;
    String id;

    public RadioButton(WebDriver driver, String id) {
        this.driver = driver;
        this.id = id;
    }
    @Step("Select radio button")
    public void selectRadioButton() {
        WebElement radioButtonElement = driver.findElement(By.id(String.format(radioButton, this.id)));
        radioButtonElement.click();
        log.info("Selected radio button with id: " + id);
    }
}