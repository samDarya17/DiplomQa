package tests;

import models.PaceCalculator;
import models.PaceCalculatorFactory;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class PaceCalculatorTest extends BaseTest {

    @Test(description = "Using Pace Calculator to calculate paces")
    public void editProfilePageShouldBeOpened() {
        loginPage
                .open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickOtherCalculators();
        caloricNeedsCalculatorPage.clickPaceCalculatorButton();
        PaceCalculator paceCalculator = PaceCalculatorFactory.fillingPaceCalculatorForm();
        paceCalculatorModalPage.fillInForm(paceCalculator);

        assertTrue(paceCalculatorPage.titlePaceChartIsVisible(),
                "Форма Pace Calculator заполнена не верно");
    }

}