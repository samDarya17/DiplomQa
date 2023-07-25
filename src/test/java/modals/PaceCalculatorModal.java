package modals;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModal extends BaseModal {

    private final static By DISTANCE = By.id("RunDist");
    private final static By DISTANCE_TYPE = By.id("DistType");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By PACE_CHART_TABLE = By.xpath("//*[@class='w-box-content']/table[contains(@class,'table-condensed table-hover')]");


    public PaceCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение формы «Калькулятор темпа»")
    public PaceCalculatorModal fillForm(PaceCalculator paceCalculator) {
        new Dropdown(driver).selectOptionByValue(DISTANCE_TYPE, paceCalculator.getDistanceType().getValue());
        new Input(driver).write(DISTANCE, paceCalculator.getDistance());
        new Input(driver).write(HOURS, paceCalculator.getHours());
        new Input(driver).write(MINUTES, paceCalculator.getMinutes());
        new Input(driver).write(SECONDS, paceCalculator.getSeconds());
        return this;
    }

    @Step("Нажатие кнопки «Рассчитать темп")
    public void clickCalculateButton() {
        log.info("Нажатие кнопки «Рассчитать темп");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    @Step("Таблица «Темповая диаграмма» видна")
    public boolean paceChartTableIsVisible() {
        log.info("Таблица «Темповая диаграмма» видна");
        return driver.findElement(PACE_CHART_TABLE).isDisplayed();
    }
}