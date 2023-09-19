package tests;


import static org.testng.Assert.*;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "Check that validation is successful when entering a login and password")
    public void emailAndPasswordValidDate() {
        loginPage.open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();

        assertTrue(platformSelectPage.isPageOpen(), "Пользователь не авторизован");

    }

    @Test(description = "leave the password field blank")
    public void blankPasswordField() {
        loginPage
                .open()
                .inputEmailAndPassword(email, "")
                .clickSignInButton();

        assertEquals(loginPage.getPasswordErrorMessage(), "Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "leave the email field blank")
    public void blankEmailField() {
        loginPage.open()
                .inputEmailAndPassword("", password)
                .clickSignInButton();

        assertEquals(loginPage.getEmailErrorMessage(), "Email is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid email")
    public void invalidEmail() {
        loginPage.open()
                .inputEmailAndPassword("vvvdufna@mailto.plus", password)
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "invalid password")
    public void invalidPassword() {
        loginPage.open()
                .inputEmailAndPassword(email, "12345Alkkk")
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }


}