package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.IntensityCalculatorModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {

    private static final By ICONS_IMG = By.cssSelector(".nav-icons");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    private static final By WORKOUTS_MENU = By.xpath("//a[text()='Workouts']");
    private static final By ADD_WORKOUT_LINK = By.xpath("//a[text()='Add PaceCalculator']");
    private static final By PRINT_WORKOUTS_LINK = By.xpath("//a[text()='Print Workouts']");
    private static final By GEAR_ROUTES_MENU = By.xpath("//a[text()='Gear & Routes']");
    private static final By BIKES_LINK = By.xpath("//a[text()='Bikes']");
    private static final By OTHER_CALCULATORS_LINK = By.cssSelector("[data-reveal-id='OtherCalc']");
    private static final By WORKOUT_CALCULATORS_LINK = By.cssSelector("[data-reveal-id='IntensityCalc']");
    private static final By DAILY_VITALS_MENU = By.xpath("//a[text()='Daily Vitals']");
    private static final By VIEW_ADD_VITALS_LINK = By.xpath("//a[text()='View & Add Vitals']");
    private static final By REPORTS_STATISTICS_LINK = By.xpath("//a[text()='Reports & Statistics']");

    Actions action = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход в раздел меню")
    public void moveMenuSection(By locator) {
        action.moveToElement(driver.findElement(locator)).perform();
    }

    @Step("Нажмите ссылку «Выйти»")
    public void clickLogoutButton() {
        log.info("Нажмите ссылку «Выйти»");
        clickButton(LOGOUT_LINK);
    }

    @Step("Переходим в меню «Тренировки»")
    public void moveWorkoutsMenu() {
        log.info("переходим в меню «Тренировки»");
        moveMenuSection(WORKOUTS_MENU);
    }

    @Step("Переход в меню «Снаряжение и маршруты»")
    public HomePage moveGearRoutesMenu() {
        log.info("переход в меню «Снаряжение и маршруты»");
        moveMenuSection(GEAR_ROUTES_MENU);
        return this;
    }

    @Step("Переходим в меню Daily Vitals")
    public void moveDailyVitalsMenu() {
        log.info("переходим в меню Daily Vitals");
        moveMenuSection(DAILY_VITALS_MENU);
    }

    @Step("Нажать по ссылке «Отчеты и статистика»")
    public void clickReportsAndStatistics() {
        moveWorkoutsMenu();
        log.info("нажать по ссылке «Отчеты и статистика»");
        clickButton(REPORTS_STATISTICS_LINK);
    }

    @Step("Нажать 'Добавить тренировку' link")
    public void clickAddWorkout() {
        moveWorkoutsMenu();
        log.info("нажать'Добавить тренировку' link");
        clickButton(ADD_WORKOUT_LINK);
    }

    @Step("Нажать 'Распечатать тренировки' link")
    public void clickPrintWorkouts() {
        moveWorkoutsMenu();
        log.info("нажать 'Распечатать тренировки' link");
        clickButton(PRINT_WORKOUTS_LINK);
    }

    @Step("Нажать на ссылку «Велосипеды»")
    public void clickBikes() {
        moveGearRoutesMenu();
        log.info("нажать на ссылку «Велосипеды»");
        clickButton(BIKES_LINK);
    }

    @Step("Нажмите ссылку «Просмотреть и добавить основные показатели»")
    public void clickViewAddVitals() {
        moveDailyVitalsMenu();
        log.info("нажмите ссылку «Просмотреть и добавить основные показатели»");
        clickButton(VIEW_ADD_VITALS_LINK);
    }

    @Step("Нажмите ссылку «Другие калькуляторы»")
    public void clickOtherCalculators() {
        log.info("нажмите ссылку «Другие калькуляторы»");
        clickButton(OTHER_CALCULATORS_LINK);
    }

    @Step("Нажмите на ссылку «Калькуляторы тренировок»")
    public IntensityCalculatorModal clickWorkoutCalculators() {
        log.info("нажмите на ссылку «Калькуляторы тренировок»");
        clickButton(WORKOUT_CALCULATORS_LINK);
        return new IntensityCalculatorModal(driver);
    }


    @Override
    public boolean isPageOpened() {
        return elementIsVisible(ICONS_IMG);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URl);
        return this;
    }
}