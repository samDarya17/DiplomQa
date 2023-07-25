package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void open() {
        navigate();
    }

    @Test(description = "Положительный тест на выход из FinalSurge",groups = {"Regression"})
    @Description(value = "Положительный тест на выход из FinalSurge")
    public void logoutTest() {
        String expected_message = "Вы успешно вышли из системы.";
        homePage.clickLogoutButton();
        assertEquals(loginPage.getLogoutMessage(), expected_message);
    }
}