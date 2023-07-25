package modals;

import elements.Input;
import elements.RadioButtonForCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class IntensityCalculatorModal extends BaseModal {

    private final static By WORKOUT_CALCULATORS_IFRAME = By.id("IntensityCalciFrame");
    private final static By HANSONS_FORM = By.xpath("//a[contains(text(), 'Hansons')]");
    private final static By TINMAN_FORM = By.xpath("//a[contains(text(), 'Tinman')]");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By WORKOUT_PACES_TABLE = By.xpath("//*[text()='Your Workout Paces']");


    public IntensityCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step("\n" +
            "Заполнение формы «Калькулятор интенсивности беговых тренировок»")
    public IntensityCalculatorModal fillForm(WorkoutCalculator intensityCalculator) {
        driver.switchTo().frame(driver.findElement(WORKOUT_CALCULATORS_IFRAME));
        new RadioButtonForCalculator(driver).clickRadioButton("EventType", intensityCalculator.getEvent().getValue());
        new Input(driver).write(HOURS, intensityCalculator.getHours());
        new Input(driver).write(MINUTES, intensityCalculator.getMinutes());
        new Input(driver).write(SECONDS, intensityCalculator.getSeconds());
        return this;
    }

    @Step("Нажатие кнопки «Рассчитать темп»")
    public void clickCalculateButton() {
        log.info("Нажатие кнопки «Рассчитать темп»");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    @Step("Таблица «Ваши темпы тренировки» видна")
    public boolean workoutPaceTableIsVisible() {
        log.info("Таблица «Ваши темпы тренировки» видна");
        return driver.findElement(WORKOUT_PACES_TABLE).isDisplayed();
    }

    @Step("Открытие калькулятора Хэнсона")
    public HansonsCalculatorModal openHansonCalculator() {
        driver.switchTo().frame(driver.findElement(WORKOUT_CALCULATORS_IFRAME));
        log.info("Открытие калькулятора Хэнсона");
        clickButton(HANSONS_FORM);
        return new HansonsCalculatorModal(driver);
    }

    @Step("Открытие калькулятора Тинмана")
    public TinmanCalculatorModal openTinmanCalculator() {
        driver.switchTo().frame(driver.findElement(WORKOUT_CALCULATORS_IFRAME));
        log.info("Открытие калькулятора Тинмана");
        clickButton(TINMAN_FORM);
        return new TinmanCalculatorModal(driver);
    }
}
