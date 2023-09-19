package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaloricNeedsCalculatorModalPage extends BasePage {

    public static final By OTHER_CALCULATOR_FRAME = By.id("OtherCalciFrame");
    public static final By SAVE_BUTTON_CALORIC_NEEDS = By.id("saveButtonSettings");
    public static final By CALORIC_NEEDS_TITLE =
            By.xpath("//div[@class='w-box-header']/h4[text()='Daily Caloric Needs Calculator']");

    public CaloricNeedsCalculatorModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение формы калькулятора потребности в калориях")
    public CaloricNeedsCalculatorModalPage fillInForm(CaloricNeedsCalculator caloricNeedsCalculator) {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATOR_FRAME));
        log.info("Переключился на кадр по идентификатору: " + OTHER_CALCULATOR_FRAME);
        new Input(driver, "Weight").write(caloricNeedsCalculator.getWeight());
        new RadioButton(driver, "kg").clickRadioButtonCaloricNeedsCalculator();
        new Input(driver, "HeightInchCent").write(caloricNeedsCalculator.getHeight());
        new RadioButton(driver, "centimeters").clickRadioButtonCaloricNeedsCalculator();
        new Input(driver, "Age").write(caloricNeedsCalculator.getRunDistance());
        new RadioButton(driver, "female").clickRadioButtonCaloricNeedsCalculator();
        new Input(driver, "RunDist").write(caloricNeedsCalculator.getRunDistance());
        new RadioButton(driver, "kilometers").clickRadioButtonCaloricNeedsCalculator();
        log.info("Fill in the data " + caloricNeedsCalculator);
        return clickSaveButton();
    }

    @Step("Нажмите кнопку «Сохранить» в калькуляторе калорийности.")
    public CaloricNeedsCalculatorModalPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON_CALORIC_NEEDS).click();
        log.info("Нажмите кнопку «Сохранить» по идентификатору.: " + SAVE_BUTTON_CALORIC_NEEDS);
        return new CaloricNeedsCalculatorModalPage(driver);
    }

    @Step("Всплывающий калькулятор потребности в калориях виден")
    @Override
    public boolean isPageOpen() {
        return isExist(CALORIC_NEEDS_TITLE);
    }
}