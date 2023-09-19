package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarPage extends BasePage {

    public static final By SETTINGS_BUTTON = By.xpath("//a[contains( text(),'Settings')]");
    public static final By CALENDER_PAGE_TITLE = By.xpath("//span[text()='View, Edit and Add workouts.']");
    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");
    public static final By OTHER_CALCULATORS_BUTTON = By.xpath("//i[@class='icsw16-calculator']");
    public static final By WORKOUT_CALCULATORS = By.xpath("//i[@class='icsw16-stop-watch']");
    String addedQuickWorkout = "//a[@class='dropdown-toggle detailslink']";


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Profile Page")
    public UserProfilePage clickSettingsButton() {
        driver.findElement(SETTINGS_BUTTON).click();
        log.info("Click sitting button by xpath: " + SETTINGS_BUTTON);
        return new UserProfilePage(driver);
    }

    @Step("Open Quick Workout")
    public CalendarPage clickQuickAdd() {
        driver.findElement(QUICK_ADD_BUTTON).click();
        log.info("Click Quick Add button by id: " + QUICK_ADD_BUTTON);
        return new CalendarPage(driver);
    }

    @Step("The added quick workout is visible in the calendar")
    public boolean addedQuickWorkoutIsVisible() {
        log.info("Check that the added quick workout is visible in the calendar by xpath");
        return driver.findElement(By.xpath(addedQuickWorkout)).isDisplayed();
    }

    @Step("Open Other Calculator page")
    public CaloricNeedsCalculatorPage clickOtherCalculators() {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
        log.info("Click on other calculators by id: " + OTHER_CALCULATORS_BUTTON);
        return new CaloricNeedsCalculatorPage(driver);
    }

    public WorkoutCalculatorIntensityPage clickWorkoutCalculators() {
        driver.findElement(WORKOUT_CALCULATORS).click();
        log.info("Click Workout Calculators by xpath: " + WORKOUT_CALCULATORS);
        return new WorkoutCalculatorIntensityPage(driver);
    }

    @Step("Calendar page is open")
    @Override
    public boolean isPageOpen() {
        return isExist(CALENDER_PAGE_TITLE);
    }
}