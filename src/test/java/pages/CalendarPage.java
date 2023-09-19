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

    @Step("Открыть страницу профиля")
    public UserProfilePage clickSettingsButton() {
        driver.findElement(SETTINGS_BUTTON).click();
        log.info("Click sitting button by xpath: " + SETTINGS_BUTTON);
        return new UserProfilePage(driver);
    }

    @Step("Открыть быструю тренировку")
    public CalendarPage clickQuickAdd() {
        driver.findElement(QUICK_ADD_BUTTON).click();
        log.info("Click Quick Add button by id: " + QUICK_ADD_BUTTON);
        return new CalendarPage(driver);
    }

    @Step("Добавленная быстрая тренировка видна в календаре.")
    public boolean addedQuickWorkoutIsVisible() {
        log.info("Убедитесь, что добавленная быстрая тренировка видна в календаре с помощью XPath.");
        return driver.findElement(By.xpath(addedQuickWorkout)).isDisplayed();
    }

    @Step("Открыть страницу «Другой калькулятор»")
    public CaloricNeedsCalculatorPage clickOtherCalculators() {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
        log.info("Нажмите на другие калькуляторы по идентификатору: " + OTHER_CALCULATORS_BUTTON);
        return new CaloricNeedsCalculatorPage(driver);
    }

    public WorkoutCalculatorIntensityPage clickWorkoutCalculators() {
        driver.findElement(WORKOUT_CALCULATORS).click();
        log.info("Нажмите «Калькуляторы тренировок» от xpath.: " + WORKOUT_CALCULATORS);
        return new WorkoutCalculatorIntensityPage(driver);
    }

    @Step("Страница календаря открыта")
    @Override
    public boolean isPageOpen() {
        return isExist(CALENDER_PAGE_TITLE);
    }
}