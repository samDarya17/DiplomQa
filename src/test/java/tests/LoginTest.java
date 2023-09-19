package tests;


import static org.testng.Assert.*;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "Убедитесь, что проверка прошла успешно при вводе логина и пароля")
    public void emailAndPasswordValidDate() {
        loginPage.open()
                .inputEmailAndPassword(email, password)
                .clickSignInButton();

        assertTrue(platformSelectPage.isPageOpen(), "Пользователь не авторизован");

    }

    @Test(description = "Оставьте поле пароля пустым")
    public void blankPasswordField() {
        loginPage
                .open()
                .inputEmailAndPassword(email, "")
                .clickSignInButton();

        assertEquals(loginPage.getPasswordErrorMessage(), "Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "Оставьте поле емаил пустым")
    public void blankEmailField() {
        loginPage.open()
                .inputEmailAndPassword("", password)
                .clickSignInButton();

        assertEquals(loginPage.getEmailErrorMessage(), "Email is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "Неверный адрес электронной почты")
    public void invalidEmail() {
        loginPage.open()
                .inputEmailAndPassword("Varasamoi@gmail.com", password)
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }

    @Test(description = "Неверный пароль")
    public void invalidPassword() {
        loginPage.open()
                .inputEmailAndPassword(email, "121asas")
                .clickSignInButton();

        assertEquals(loginPage.getErrorMessage(), "Invalid login credentials. Please try again.",
                "Текст сообщения неверный или отсутствует");
    }


}