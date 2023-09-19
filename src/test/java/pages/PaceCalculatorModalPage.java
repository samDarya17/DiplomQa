package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModalPage extends BasePage {

    public final static By PACE_CALCULATOR_TITLE = By.xpath("//h4[text()='Pace Calculator']");
    public final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");

    public PaceCalculatorModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Pace Calculator form")
    public PaceCalculatorModalPage fillInForm(PaceCalculator paceCalculator) {
        new Input(driver, "RunDist").write(paceCalculator.getDistance());
        new DropDown(driver, "DistType").selectOption(paceCalculator.getDistType());
        new Input(driver, "TimeHH").write(paceCalculator.getTimeInHours());
        new Input(driver, "TimeMM").write(paceCalculator.getTimeInHours());
        new Input(driver, "TimeSS").write(paceCalculator.getTimeInHours());
        log.info("Fill in the data " + paceCalculator);
        return clickCalculatePacesButton();
    }

    @Step("Click Calculator Paces button")
    public PaceCalculatorModalPage clickCalculatePacesButton() {
        driver.findElement(CALCULATE_PACES_BUTTON).click();
        log.info("Click Calculator Paces button by xpath: " + CALCULATE_PACES_BUTTON);
        return new PaceCalculatorModalPage(driver);
    }

    @Step("Frame Pace Calculator is visible")
    @Override
    public boolean isPageOpen() {
        return isExist(PACE_CALCULATOR_TITLE);
    }
}