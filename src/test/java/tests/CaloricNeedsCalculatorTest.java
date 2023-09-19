package tests;

import io.qameta.allure.Step;
import models.CaloricNeedsCalculator;
import models.CaloricNeedsCalculatorFactory;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class CaloricNeedsCalculatorTest extends BaseTest {
    @Step("Использование калькулятора калорий")
    @Test(description = "Использование калькулятора калорий для расчета потребности в калориях")
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