package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.xpath("//input[@tabindex='1']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@tabindex='2']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By EMAIL_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Email is required')]");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(),'Password is required')]");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='notification__content']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Откройте страницу входа")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        log.info("Open Login page with URL + login");
        return this;
    }

    @Step("Введите имя пользователя или адрес электронной почты: '{email}' and Password: '{password}'")
    public LoginPage inputEmailAndPassword(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Input the email in the field");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Input password in the field");
        return this;
    }

    @Step("Нажмите кнопку «Войти».")
    public PlatformSelectPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("Click on Sign In button with XPath: " + SIGN_IN_BUTTON);
        return new PlatformSelectPage(driver);
    }

    @Step("Получить сообщение об ошибке по электронной почте")
    public String getEmailErrorMessage() {
        log.info("Take the error message :" + EMAIL_ERROR_MESSAGE);
        return driver.findElement(EMAIL_ERROR_MESSAGE).getText();
    }

    @Step("Получить сообщение об ошибке пароля")
    public String getPasswordErrorMessage() {
        log.info("Take the error message :" + PASSWORD_ERROR_MESSAGE);
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }

    @Step("Получить сообщение об ошибке")
    public String getErrorMessage() {
        String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE)).getText();
        log.info("Take the error message : " + errorMessage);
        return errorMessage;

    }

    @Step("Проверка перехода на следующую страницу")
    @Override
    public boolean isPageOpen() {
        return isExist(SIGN_IN_BUTTON);
    }
}