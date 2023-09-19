package pages;

import elements.Checkboxes;
import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuickAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutQuickAddPage extends BasePage {

    public static final By QUICK_ADD_WORKOUT_TITLE = By.id("WorkoutAddHeader");
    public static final By ADD_WORKOUT_BUTTON = By.id("saveButton");

    public WorkoutQuickAddPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавьте тренировку через быстрое добавление")
    public void fillInFormQuickWorkout(WorkoutQuickAdd workoutQuickAdd) {
        new Input(driver, "WorkoutDate").write(workoutQuickAdd.getDate());
        new DropDown(driver, "WorkoutTime").selectOption(workoutQuickAdd.getTime());
        new DropDown(driver, "ActivityType").selectOption(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").write(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Desc").write(workoutQuickAdd.getWorkoutDescription());
        new Checkboxes(driver, "PlannedWorkout").tickCheckbox(workoutQuickAdd.isShowPlanned());
        if (workoutQuickAdd.isShowPlanned()) {
            new Input(driver, "PDistance").write(workoutQuickAdd.getPlannedDistance());
            new DropDown(driver, "PDistType").selectOption(workoutQuickAdd.getPlannedDistanceType());
            new Input(driver, "PDuration").write(workoutQuickAdd.getPlannedDuration());
        }
        new Input(driver, "Distance").write(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").selectOption(workoutQuickAdd.getDistType());
        new Input(driver, "Duration").write(workoutQuickAdd.getDuration());
        new Input(driver, "Pace").write(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").selectOption(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").selectOption(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectOption(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "PostDesc").write(workoutQuickAdd.getPostDesc());
        new Checkboxes(driver, "SaveLibrary").tickCheckbox(workoutQuickAdd.isSaveLibrary());
        log.info("Fill in the data " + workoutQuickAdd);
        clickSaveButton();
    }

    @Step("Нажмите кнопку «Добавить тренировку»")
    public WorkoutQuickAddPage clickSaveButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        log.info("Нажмите кнопку «Добавить тренировку по идентификатору»: " + ADD_WORKOUT_BUTTON);
        return new WorkoutQuickAddPage(driver);
    }

    @Step("Убедитесь, что страница быстрого добавления тренировки открыта")
    @Override
    public boolean isPageOpen() {
        return isExist(QUICK_ADD_WORKOUT_TITLE);
    }
}