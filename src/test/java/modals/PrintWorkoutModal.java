package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DatePeriod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintWorkoutModal extends BaseModal {

    private static final By STARTING_DATE = By.name("PrintStartDate");
    private static final By ENDING_DATE = By.id("PrintEndDate");
    private static final By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");
    private static final By PRINT_WORKOUTS_IFRAME = By.id("PrintWorkoutsiFrame");


    public PrintWorkoutModal(WebDriver driver) {
        super(driver);
    }

    @Step("Нажмите кнопку «Распечатать тренировки».")
    public void clickPrintWorkoutsButton() {
        log.info("Нажмите кнопку «Распечатать тренировки».");
        clickButton(PRINT_WORKOUTS_BUTTON);
    }

    @Step("Заполнение формы «Распечатать тренировки»")
    public void fillForm(DatePeriod printWorkouts) {
        driver.switchTo().frame(driver.findElement(PRINT_WORKOUTS_IFRAME));
        new Input(driver).write(STARTING_DATE, printWorkouts.getStartDate());
        new Input(driver).write(ENDING_DATE, printWorkouts.getEndDate());
        clickPrintWorkoutsButton();
        driver.switchTo().defaultContent();
    }
}