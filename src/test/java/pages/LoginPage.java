package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class LoginPage extends BasePage {


    public static final By SIGN_IN_TITLE = By.xpath("//h2[contains(text(), 'Sign In')]");
    public static final By EMAIL_INPUT = By.xpath("//input[@name='email']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    public static final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']");
    public static final By EMAIL_ERROR_MESSAGE = By.xpath("//div[contains(text(), 'Email is required')]");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//div[contains(text(), 'Password is required')]");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='notification__content']");


    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @Step("Open the login page")
    public LoginPage open() {
        driver.get(URL + "login");
        log.info("Open Login page with URL:" + URL + "login");
        return this;
    }

    @Step("Input email and password")
    public LoginPage inputEmailAndPass(String email, String pass) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Input email in the field" + email);
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
        log.info("Input password in the field:" + pass);
        return this;
    }
    @Step("Click on Sign In Button")
    public PlatformSelectPage clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("Click on Sign In Button:" + SIGN_IN_BUTTON);
        return new PlatformSelectPage(driver);
    }
    @Step("Get email error message")
    public String getEmailErrorMessage() {
        log.info("Take email error message:"+ EMAIL_ERROR_MESSAGE);
        return driver.findElement(EMAIL_ERROR_MESSAGE).getText();
    }
    @Step("Get password error message")
    public String getPasswordErrorMessage() {
        log.info("Take password error message:"+PASSWORD_ERROR_MESSAGE);
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }
    @Step("Get error message")
    public String getErrorMessage() {
        log.info("Take error message:"+ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    @Step("Find element to make sure that page is open")
    @Override
    public boolean isPageOpen() {
        log.info("Find element:" + SIGN_IN_TITLE);
        return isExist(SIGN_IN_TITLE);
    }
}