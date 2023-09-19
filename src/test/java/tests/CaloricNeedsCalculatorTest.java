package tests;

import models.CaloricNeedsCalculator;
import models.CaloricNeedsCalculatorFactory;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class CaloricNeedsCalculatorTest extends BaseTest {
    @Test(description = "Using Caloric Calculator to calculate caloric needs")
    public void caloricCalculatorTest() {
        loginPage
                .open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();
        platformSelectPage.selectPlatform();
        calendarPage.clickOtherCalculators();
        CaloricNeedsCalculator form = CaloricNeedsCalculatorFactory.getDataFromTheForm();
        caloricNeedsCalculatorModalPage.fillInForm(form);

        assertTrue(caloricNeedsCalculatorPage.titleCaloricNeedsCalculatorIsVisible(),
                "Форма Caloric Needs Calculator заполнена не верно");


    }
}