package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class Dropdown extends BaseElement {

    public Dropdown(WebDriver driver) {
        super(driver);
    }

    @Step("Выберите вариант по видимому тексту")
    public void selectOptionByVisibleText(By locator, String optionName) {
        log.info(String.format("selecting option %s", optionName));
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(optionName);
    }

    @Step("Bыберите вариант по значению")
    public void selectOptionByValue(By locator, String optionName) {
        log.info(String.format("selecting option %s", optionName));
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(optionName);
    }
}