package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
public class PlatformSelectTest extends BaseTest {
    @Test(description = "Continue with Beta platform")
    public void selectPlatformAndClick(){
        loginPage.open()
                .inputEmailAndPass(email, password)
                .clickSignInButton()
                .selectPlatformAndClick();

        assertTrue(workoutCalendarPage.isPageOpen(),"Страница не открылась");
    }
}