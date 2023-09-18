package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Input valid user data")
    public void inputValidEmailAndPassword() {
        loginPage.open()
                .inputEmailAndPass(email,password)
                .clickSignInButton();

        assertTrue(platformSelectPage.isPageOpen());
    }
    @Test(description = "Input an invalid email and a valid password")
    public void inputInvalidEmailAndValidPassword(){
        loginPage.open()
                .inputEmailAndPass("ysegw@mailto.plus","Vara8908333")
                .clickSignInButton();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='notification__content']")));

        assertEquals(loginPage.getErrorMessage(),"Invalid login credentials. Please try again.","Текст сообщения неверный или отсутствует");
    }
    @Test(description = "Leave the email field blank and input a valid password")
    public void leaveEmailEmptyAndInputValidPassword(){
        loginPage.open()
                .inputEmailAndPass("","Vara8908333")
                .clickSignInButton();

        assertEquals(loginPage.getEmailErrorMessage(),"Email is required","Текст сообщения неверный или отсутствует");
    }
    @Test(description = "Input a valid email and leave the password field blank")
    public void inputValidEmailAndLeavePasswordEmpty(){
        loginPage.open()
                .inputEmailAndPass("dashikasam@gmail.com","")
                .clickSignInButton();

        assertEquals(loginPage.getPasswordErrorMessage(),"Password is required","Текст сообщения неверный или отсутствует");
    }

}