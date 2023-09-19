package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorPage extends BasePage{

    public final static By PACE_CALCULATOR_TITLE = By.xpath("//h4[text()='Pace Calculator']");
    public final static By RESULTS_PACE_CHART_LABEL=By.xpath("//h4[text()='Pace Chart']");

    public PaceCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Visible Pace Calculator results")
    public boolean titlePaceChartIsVisible() {
        boolean titlePaceCalculatorResultsIsVisible = driver.findElement(RESULTS_PACE_CHART_LABEL).isDisplayed();
        log.info("Make sure that the results of the calorie requirement calculation are visible on the page");
        return titlePaceCalculatorResultsIsVisible;
    }

    @Step("Frame Pace Calculator is visible")
    @Override
    public boolean isPageOpen() {
        return isExist(PACE_CALCULATOR_TITLE);
    }
}