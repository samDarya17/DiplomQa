package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintPage extends BasePage {
    public static final By MAILBOX = By.xpath("/html/body/div[1]/header/div/div/div[2]/nav/ul/li[6]/a");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Step("Открыть почтовый ящик")
    public PrintPage openMyMessages() {
        driver.findElement(MAILBOX).click();
        log.info("Открыть почтовый ящик " + MAILBOX);
        return new PrintPage(driver);
    }
}


