package tests;

import io.qameta.allure.Description;
import modals.PrintWorkoutModal;
import models.DatePeriod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PrintPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertTrue;

public class PrintWorkoutsTest extends BaseTest {

    PrintWorkoutModal printWorkoutModal;
    PrintPage printPage;


    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        printWorkoutModal = new PrintWorkoutModal(driver);
        printPage = new PrintPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.switchTo().defaultContent();
        driver.manage().deleteAllCookies();
    }


    @Test(description = "Открытие страницы печати с тренировками за выбранный период времени",groups = {"Regression"})
    @Description(value = "Открытие страницы печати с тренировками за выбранный период времени")
    public void printWorkoutsTest() {
        homePage.clickPrintWorkouts();
        DatePeriod periodForPrint = TestDataHelper.getDatePeriod();
        printWorkoutModal.fillForm(periodForPrint);
        assertTrue(printPage.isPageOpened());
    }
}