package tests;

import io.qameta.allure.Description;
import modals.EditBikeModal;
import models.Bike;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BikesPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EquipmentTest extends BaseTest {

    protected BikesPage bikesPage;
    protected EditBikeModal editBikeModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        bikesPage = new BikesPage(driver);
        editBikeModal = new EditBikeModal(driver);
    }


    @Test(description = "Добавление оборудования «Новый велосипед» и проверка сведений об оборудовании",groups = {"Smoke"})
    @Description(value = "Добавление оборудования «Новый велосипед» и проверка сведений об оборудовании")
    public void addNewBikeTest() {
        homePage.moveGearRoutesMenu()
                .clickBikes();
        assertTrue(bikesPage.isPageOpened());
        Bike newBikeDetails = TestDataHelper.getBikeWithAllData();
        bikesPage.fillForm(newBikeDetails)
                .clickAddBikeButton()
                .clickBikeName(newBikeDetails.getBikeName());
        Bike actualBikeDetails = editBikeModal.getBikeDetails();
        assertEquals(actualBikeDetails, newBikeDetails);
    }
}
