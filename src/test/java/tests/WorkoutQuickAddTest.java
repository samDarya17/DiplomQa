package tests;

import models.WorkoutQuickAdd;
import models.WorkoutQuickAddFactory;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class WorkoutQuickAddTest extends BaseTest {

    @Test(description = "Заполнение формы быстрой тренировки")
    public void addQuickWorkout() {
        loginPage
                .open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickQuickAdd();
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.fillWorkoutQuickData();
        workoutQuickAddPage.fillInFormQuickWorkout(workoutQuickAdd);

        assertTrue(calendarPage.addedQuickWorkoutIsVisible(),
                "Быстрая тренировка не добавлена");

    }
}