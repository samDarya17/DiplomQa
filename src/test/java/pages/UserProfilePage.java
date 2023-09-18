package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class UserProfilePage extends BasePage{
    public static final By EDIT_PROFILE_BUTTON = By.xpath("//span[normalize-space()='Edit Profile']");

    public static final By CALENDAR_BUTTON = By.xpath("//*[@class='icsw16-day-calendar']");

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("Open edit profile")
    public UserModalProfilePage clickEditProfileButton() {
        driver.findElement(EDIT_PROFILE_BUTTON).click();
        log.info("Click edit profile button:" + EDIT_PROFILE_BUTTON);
        return new UserModalProfilePage(driver);
    }

    public UserModalProfilePage goToTrainingCalendar() {
        log.info("Clicking on the Calendar button");
        driver.findElement(CALENDAR_BUTTON).click();
        return new UserModalProfilePage(driver);
    }

    @Step("Find element to make sure that page is open")
    @Override
    public boolean isPageOpen() {
        log.info("Find element"+ EDIT_PROFILE_BUTTON);
        return isExist(EDIT_PROFILE_BUTTON);
    }
}