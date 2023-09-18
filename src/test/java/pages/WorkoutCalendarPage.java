package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@Log4j2

public  class WorkoutCalendarPage extends BasePage {
    public static final By DATE_TODAY = By.id("fs-date-today");
    public static final By PROFILE_ICON = By.xpath("//div[@class='nav-profile-images']//span[@class='profile-icon-md']");
    public static final By MY_PROFILE = By.xpath("//span[@class='menu-collapsed' and normalize-space()='My Profile']");

    public WorkoutCalendarPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open Workoutcalendar page")
    public WorkoutCalendarPage open() {
        driver.get(URL + "workoutcalendar");
        log.info("Open  workout calendar page:" + URL + "workoutcalendar");
        return this;
    }

    @Step("Click Profile Icon")
    public WorkoutCalendarPage clickProfileIcon() {
        WebElement button = driver.findElement(PROFILE_ICON);
        clickElementByJavascript(button);
        log.info("Click Profile icon:" + PROFILE_ICON);
        return this;
    }
    @Step("Select my profile from dropdown")
    public UserProfilePage selectMyProfileFromDropdown() {
        driver.findElement(MY_PROFILE).click();
        log.info("Click My Profile:"+ MY_PROFILE);
        return new UserProfilePage(driver);
    }

    @Step("Find element to make sure that page is open")
    @Override
    public boolean isPageOpen() {
        log.info("Find element"+ DATE_TODAY);
        return isExist(DATE_TODAY);
    }
}