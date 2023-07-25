package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearSession() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Положительный тест входа в систему FinalSurge", groups = {"Smoke"})
    @Description(value = "Положительный тест входа в систему FinalSurge")
    public void positiveLoginTest() {
        loginPage.login(EMAIL, PASSWORD);
        assertTrue(homePage.isPageOpened());
    }

    @Test(description = "Отрицательный тест входа в систему FinalSurge", groups = {"Negative"}, dataProvider = "Negative Login Test Data")
    @Description(value = "Отрицательный тест входа в систему FinalSurge")
    public void negativeLoginTest(String email, String password) {
        loginPage.login(email, password);
        assertTrue(loginPage.isPageOpened());
    }

    @DataProvider(name = "Отрицательные данные проверки входа")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"", ""},
                {EMAIL, ""},
                {EMAIL, "123"},
        };
    }
}