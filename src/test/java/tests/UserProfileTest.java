package tests;

import models.UserProfile;
import models.UserProfileFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;;

public class UserProfileTest extends BaseTest {

    @Test(description = "Edit User profile page")
    public void userProfileShouldBeEdited() {
        loginPage.open()
                .inputEmailAndPass(email, password)
                .clickSignInButton()
                .selectPlatformAndClick()
                .clickProfileIcon()
                .selectMyProfileFromDropdown()
                .clickEditProfileButton();

        UserProfile userProfile = UserProfileFactory.get();

        userModalProfilePage.editProfile(userProfile);

        assertTrue(userProfilePage.isPageOpen(), "The page did not open");
    }
}