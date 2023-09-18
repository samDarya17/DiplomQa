package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

@Log4j2
public class Checkbox {
    String checkboxLocator = "%s";
    WebDriver driver;
    String id;

    public Checkbox(WebDriver driver, String id) {
        this.driver = driver;
        this.id = id;
    }
    @Step("Toggle Checkbox")
    public void toggleCheckbox() {
        WebElement checkbox = driver.findElement(By.id(String.format(checkboxLocator, id)));
        checkbox.click();
        log.info("Toggled checkbox with id: " + id);
    }
    @Step("Check if Checkbox is Selected")
    public boolean isChecked() {
        WebElement checkbox = driver.findElement(By.id(String.format(checkboxLocator, id)));
        boolean isSelected = checkbox.isSelected();
        log.info("Checkbox with id " + id + " is selected: " + isSelected);
        return isSelected;
    }
}