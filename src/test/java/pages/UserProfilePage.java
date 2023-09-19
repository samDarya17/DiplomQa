package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class UserProfilePage extends BasePage {

    public static final By EDIT_PROFILE = By.xpath("//span[contains(text(),'Edit Profile')]");
    String userProfileField = "//small[text()='%s:']/..";

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть редактируемый профиль")
    public UserProfilePage openEditProfileForm() {
        driver.findElement(EDIT_PROFILE).click();
        log.info("Нажмите кнопку «Редактировать профиль» с помощью XPath:" + EDIT_PROFILE);
        return new UserProfilePage(driver);
    }


    @Step("Получить текст из поля профиля пользователя")
    public String getFieldValue(String label) {
        String textFromUserProfileField = driver.findElement(By.xpath(String.format(userProfileField, label))).getText();
        log.info("Получить текст из поля профиля пользователя по метке: " + label);
        return textFromUserProfileField.split(":")[1].trim();
    }

    @Step("Убедитесь, что страница профиля открыта")
    @Override
    public boolean isPageOpen() {
        return isExist(EDIT_PROFILE);
    }


}