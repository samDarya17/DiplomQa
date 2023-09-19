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

    @Step("Открытые калькуляторы темпа")
    public PaceCalculatorModalPage clickPaceCalculatorButton() {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATORS_FRAME));
        log.info("Переключился на кадр по идентификатору: " + OTHER_CALCULATORS_FRAME);
        driver.findElement(PACE_CALCULATOR_BUTTON).click();
        log.info("Нажмите кнопку «Калькулятор темпа» с помощью XPath.: " + PACE_CALCULATOR_BUTTON);
        return new PaceCalculatorModalPage(driver);
    }

    @Step("Результаты калькулятора видимых калорийных потребностей")
    public boolean titleCaloricNeedsCalculatorIsVisible() {
        boolean titleIsVisible = driver.findElement(RESULTS_CALORIC_NEEDS_CALCULATOR).isDisplayed();
        log.info("Убедитесь, что результаты расчета потребности в калориях видны на странице.");
        return titleIsVisible;
    }

    @Step("Убедитесь, что страница «Калькуляторы потребности в калориях» открыта.")
    @Override
    public boolean isPageOpen() {
        return isExist(CALORIC_NEEDS_TITLE);
    }


}