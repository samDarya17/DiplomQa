package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PlatformSelectPage extends BasePage {

    public static final By SELECT_PLATFORM_LABEL = By.xpath("//h1[@class='h4 mb-4']");
    public static final By CONTINUE_WITH_CLASSIC = By.xpath("//span[contains(text(),'Continue with Classic')]");

    public PlatformSelectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выберите платформу")
    public PlatformSelectPage selectPlatform() {
        driver.findElement(CONTINUE_WITH_CLASSIC).click();
        log.info("Выберите платформу с помощью XPath: " + CONTINUE_WITH_CLASSIC);
        return this;
    }


    @Step("Убедитесь, что страница выбора платформы открыта")
    @Override
    public boolean isPageOpen() {
        return isExist(SELECT_PLATFORM_LABEL);
    }
}