package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class DropDown {

    String dropDownLocator = "%s";
    String optionDropDown = "//option[normalize-space(text())='%s']";

    WebDriver driver;
    String id;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.id = label;
    }

    public void selectDropdown(String option) {
        driver.findElement(By.id(String.format(dropDownLocator, this.id))).click();
        log.info("Click on dropdown: " + dropDownLocator);
        driver.findElement(By.xpath(String.format(optionDropDown, option, option, option))).click();
        log.info("Select option:" + optionDropDown);
    }
}