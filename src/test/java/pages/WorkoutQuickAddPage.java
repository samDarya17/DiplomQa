package pages;

import elements.Checkbox;
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

    @Step("Edit Workout: {workoutQuickAdd}")
    public WorkoutQuickAddPage editWorkout(WorkoutQuickAdd workoutQuickAdd) {
        new Input(driver, "WorkoutDate").write(workoutQuickAdd.getDate());
        new DropDown(driver, "WorkoutTime").selectDropdown(workoutQuickAdd.getTime());
        new DropDown(driver, "ActivityType").selectDropdown(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").write(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Desc").fillDescription(workoutQuickAdd.getWorkoutDescription());
        new Checkbox(driver, "PlannedWorkout").toggleCheckbox();
        new Input(driver, "PDistance").write(workoutQuickAdd.getPlannedDistance());
        new DropDown(driver, "PDistType").selectDropdown(workoutQuickAdd.getPlannedDistanceType());
        new Input(driver, "PDuration").write(workoutQuickAdd.getPlannedDuration());
        new Input(driver, "Distance").write(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").selectDropdown(workoutQuickAdd.getDistanceType());
        new Input(driver, "Duration").write(workoutQuickAdd.getDuration());
        new Input(driver, "Pace").write(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").selectDropdown(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").selectDropdown(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").selectDropdown(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "PostDesc").fillDescription(workoutQuickAdd.getPostNotes());
        new Checkbox(driver, "SaveLibrary").toggleCheckbox();

        return clickAddWorkout();
    }

    @Step("Click Add Button")
    public WorkoutQuickAddPage clickAddWorkout() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        log.info("Clicked Add Workout button by id: " + ADD_WORKOUT_BUTTON);
        return new WorkoutQuickAddPage(driver);
    }
    @Step("Find element to make sure that page is open")
    @Override
    public boolean isPageOpen() {
        return isExist(QUICK_ADD_WORKOUT_TITLE);
    }
}