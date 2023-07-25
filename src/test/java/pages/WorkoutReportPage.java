package pages;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutReportPage extends BasePage {

    private static final By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By STARTING_DATE = By.id("WorkoutDate");
    private static final By ENDING_DATE = By.id("WorkoutDateEnd");
    private static final By ACTIVITY_TYPE = By.id("ActivityType");
    private static final By ACTIVITY_COLUMN_OF_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[2]");


    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение формы «Фильтры отчетов»")
    public WorkoutReportPage fillForm(Report report) {
        new Input(driver).clear(STARTING_DATE);
        new Input(driver).write(STARTING_DATE, report.getStartDate());
        new Input(driver).clear(ENDING_DATE);
        new Input(driver).write(ENDING_DATE, report.getEndDate());
        new Dropdown(driver).selectOptionByVisibleText(ACTIVITY_TYPE, report.getActivityType().getName());
        return this;
    }

    @Step("Нажатие кнопки «Просмотреть отчет»")
    public void clickViewReportButton() {
        log.info("Нажатие кнопки «Просмотреть отчет»");
        clickButton(VIEW_REPORT_BUTTON);
    }

    @Step("Получение данных из колонки действий в таблице результатов")
    public String getActivityFromTable() {
        log.info("Получение данных из колонки действий в таблице результатов");
        return driver.findElement(ACTIVITY_COLUMN_OF_TABLE).getText();
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(VIEW_REPORT_BUTTON).isDisplayed();
    }

    @Override
    public BasePage open() {
        driver.get(BASE_URl + "/WorkoutReport.cshtml");
        return this;
    }
}