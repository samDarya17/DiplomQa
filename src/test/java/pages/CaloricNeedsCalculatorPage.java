package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaloricNeedsCalculatorPage extends BasePage {

    public static final By CALORIC_NEEDS_TITLE =
            By.xpath("//div[@class='w-box-header']/h4[text()='Daily Caloric Needs Calculator']");
    public static final By PACE_CALCULATOR_BUTTON = By.xpath("//a[text()='Pace Calculator']");
    public static final By RESULTS_CALORIC_NEEDS_CALCULATOR = By.xpath("//th[text()='Non-Activity Calories']");
    public static final By OTHER_CALCULATORS_FRAME = By.id("OtherCalciFrame");

    public CaloricNeedsCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Pace Calculators")
    public PaceCalculatorModalPage clickPaceCalculatorButton() {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATORS_FRAME));
        log.info("Switched to frame by id: " + OTHER_CALCULATORS_FRAME);
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
        log.info("Click Pace Calculator button by xpath: " + PACE_CALCULATOR_BUTTON);
        return new PaceCalculatorModalPage(driver);
    }

    @Step("Visible Caloric Needs Calculator results")
    public boolean titleCaloricNeedsCalculatorIsVisible() {
        boolean titleIsVisible = driver.findElement(RESULTS_CALORIC_NEEDS_CALCULATOR).isDisplayed();
        log.info("Make sure that the results of the calorie requirement calculation are visible on the page");
        return titleIsVisible;
    }

    @Step("Check that Caloric Needs Calculators page is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(CALORIC_NEEDS_TITLE);
    }


}