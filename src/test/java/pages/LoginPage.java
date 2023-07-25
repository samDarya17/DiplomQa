package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private static final By ACCOUNT_LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести адрес  электронной почты: {email}")
    public void setEmailInput(String email) {
        log.info("Ввести адрес  электронной почты: {email}");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Ввести пароль: {пароль}")
    public void setPasswordInput(String password) {
        log.info("Ввести пароль: {пароль}");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Нажать кнопки «Войти»")
    public void clickLoginButton() {
        log.info("Нажать кнопки «Войти»");
        clickButton(LOGIN_BUTTON);
    }

    @Step("Войдите на Finalsurge.com с именем пользователя {email} и паролем {password}.")
    public void login(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    @Step("Сообщения об успешном выходе из системы")
    public String getLogoutMessage() {
        log.info("Сообщения об успешном выходе из системы");
        return driver.findElement(ACCOUNT_LOGOUT_MESSAGE).getText();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(LOGIN_BUTTON);
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URl);
        return this;
    }
}