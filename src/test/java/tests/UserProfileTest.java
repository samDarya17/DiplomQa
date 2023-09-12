package tests;

import models.UserProfile;
import models.UserProfileFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;;

public class UserProfileTest extends BaseTest {

    @Test(description = "Open and edit User profile page")
    public void userProfileShouldBeEdited() {
        loginPage.open()
                .inputEmailAndPass(email, password)
                .clickSignInButton();
        platformSelectPage.selectPlatformAndClick();
        workoutCalendarPage.open()
                .clickProfileIcon()
                .selectMyProfileFromDropdown();
        userProfilePage.clickEditProfileButton();

        UserProfile userProfile = UserProfileFactory.get();

        userModalProfilePage.editProfile(userProfile)
                .clickSaveButton();

        assertTrue(userProfilePage.isPageOpen(), "Страница не открылась");

    }
}