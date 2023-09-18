package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class TrainingCalendarPage extends BasePage{
    public static final By TRAINING_CALENDAR_TITLE = By.xpath("//a[normalize-space()='Training Calendar']");
    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");

    private final String addedWorkout = "//a[@class='dropdown-toggle detailslink']";

    public TrainingCalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Quick Add button")
    public TrainingCalendarPage clickQuickAdd(){
        driver.findElement(QUICK_ADD_BUTTON).click();
        log.info("Clicked Quick Add button");
        return new TrainingCalendarPage(driver);
    }

    @Step("Verify the visibility of the added quick workout in the calendar")
    public boolean isAddedQuickWorkoutVisible() {
        log.info("Checking if the added quick workout is visible in the calendar using xpath");
        return driver.findElement(By.xpath(addedWorkout)).isDisplayed();
    }

    @Step("Check if Training Calendar Page is Open")
    @Override
    public boolean isPageOpen() {
        return isExist(TRAINING_CALENDAR_TITLE);
    }
}