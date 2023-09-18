package tests;

import models.WorkoutQuickAdd;
import models.WorkoutQuickAddFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WorkoutQuickAddTest extends BaseTest {
    @Test
    public void addQuickWorkout() {
        loginPage.open()
                .inputEmailAndPass(email, password)
                .clickSignInButton()
                .selectPlatformAndClick()
                .clickProfileIcon()
                .selectMyProfileFromDropdown()
                .goToTrainingCalendar();
        trainingCalendarPage.clickQuickAdd();

        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getData();

        workoutQuickAddPage.editWorkout(workoutQuickAdd);


        String date = workoutQuickAdd.getDate();
        String activityType = workoutQuickAdd.getActivityType();

        boolean isWorkoutPresent = trainingCalendarPage.isAddedQuickWorkoutVisible();

        assertTrue(isWorkoutPresent, "The workout was not added successfully");

    }
}