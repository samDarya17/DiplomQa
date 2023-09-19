package pages;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculatorIntensity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutCalculatorIntensityPage extends BasePage {


    public static final By YOUR_WORKOUT_PACES_TITLE = By.xpath("//h4[text()='Your Workout Paces']");
    public static final By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    public static final By INTENSITY_CALCULATOR_FRAME = By.id("IntensityCalciFrame");
    public static final By WORKOUT_INTENSITY_CALCULATOR_TITLE = By.xpath("//h4[text()='Running Workout Intensity Calculator']");

    public WorkoutCalculatorIntensityPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение формы «Калькулятор интенсивности тренировок»")
    public WorkoutCalculatorIntensityPage fillInForm(WorkoutCalculatorIntensity workoutCalculatorIntensity) {
        driver.switchTo().frame(driver.findElement(INTENSITY_CALCULATOR_FRAME));
        log.info("Переключился на кадр по идентификатору: " + INTENSITY_CALCULATOR_FRAME);
        new RadioButton(driver, "MARATHON").clickRadioButton();
        new Input(driver, "TimeHH").write(workoutCalculatorIntensity.getHours());
        new Input(driver, "TimeMM").write(workoutCalculatorIntensity.getMinutes());
        new Input(driver, "TimeSS").write(workoutCalculatorIntensity.getSeconds());
        log.info("Fill in the data " + workoutCalculatorIntensity);
        return clickCalculatePaces();
    }

    @Step("Нажмите кнопку «Калькулятор темпов»")
    public WorkoutCalculatorIntensityPage clickCalculatePaces() {
        driver.findElement(CALCULATE_PACES_BUTTON).click();
        log.info("Click Calculate Paces in Workout Calculator Intensity by id: " + CALCULATE_PACES_BUTTON);
        return new WorkoutCalculatorIntensityPage(driver);
    }

    @Step("Видимые результаты интенсивности калькулятора тренировок")
    public boolean titleYourWorkoutPacesIsVisible() {
        boolean titleCalculatorIntensityResultsIsVisible = driver.findElement(YOUR_WORKOUT_PACES_TITLE).isDisplayed();
        log.info("Убедитесь, что результаты расчета интенсивности тренировки видны на странице");
        return titleCalculatorIntensityResultsIsVisible;
    }


    @Step("Калькулятор тренировки кадров. Интенсивность видна")
    @Override
    public boolean isPageOpen() {
        return isExist(WORKOUT_INTENSITY_CALCULATOR_TITLE);
    }
}