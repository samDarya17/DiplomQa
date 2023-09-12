package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class PlatformSelectPage extends BasePage{
    public static final By SELECT_PLATFORM_TITLE = By.xpath("//h1[@class='h4 mb-4']");
    public static final By CONTINUE_WITH_BETA_LINK = By.xpath(" //span[normalize-space()='Continue with Beta']");


    public PlatformSelectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open Platform select page")
    public PlatformSelectPage open(){
        driver.get(URL + "platform-select");
        log.info("Open Platform select page:" + URL + "platform-select");
        return this;
    }
    @Step("Choose the first platform")
    public WorkoutCalendarPage selectPlatformAndClick(){
        driver.findElement(CONTINUE_WITH_BETA_LINK).click();
        log.info("Select the first platform:" + CONTINUE_WITH_BETA_LINK);
        return new WorkoutCalendarPage(driver);
    }
    @Step("Find element to make sure the page is open")
    @Override
    public boolean isPageOpen() {
        log.info("Find element:"+SELECT_PLATFORM_TITLE);
        return isExist(SELECT_PLATFORM_TITLE);
    }
}