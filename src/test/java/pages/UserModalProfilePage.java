package pages;

import elements.DropDown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Log4j2
public class UserModalProfilePage extends BasePage{

    public static final By CANCEL = By.xpath("//span[normalize-space()='Cancel']");
    public static final By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");

    public UserModalProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("Edit User Profile")
    public UserModalProfilePage editProfile(UserProfile userProfile){
        new Input(driver,"fname").write(userProfile.getFirstName());
        new Input(driver,"lname").write(userProfile.getLastName());
        new RadioButton(driver,"male").selectRadioButton();
        new Input(driver, "BDay").inputBDay(userProfile.getBirthday());
        new Input(driver,"Weight").write(userProfile.getWeight());
        new RadioButton(driver,"optionsRadios4").selectRadioButton();
        new DropDown(driver,"Country").selectDropdown(userProfile.getCountry());
        new DropDown(driver,"Region").selectDropdown(userProfile.getState());
        new Input(driver,"City").write(userProfile.getCity());
        new Input(driver,"Zip").write(userProfile.getZipCode());

        return clickSaveButton();
    }

    private void clickElementByJavascript(WebElement element, WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    @Step("Save changes")
    public UserModalProfilePage clickSaveButton() {
        WebElement saveButton = driver.findElement(SAVE_CHANGES_BUTTON);
        clickElementByJavascript(saveButton, driver);
        return new UserModalProfilePage(driver);
    }

    @Step("Find element to make sure that page is open")
    @Override
    public boolean isPageOpen() {
        log.info("Find element"+CANCEL);
        return isExist(CANCEL);
    }
}