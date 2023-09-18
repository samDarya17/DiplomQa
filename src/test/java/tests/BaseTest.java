package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;
@Log4j2
@Listeners(tests.TestListener.class)
public class BaseTest {
    protected String email, password, url;
    protected  WebDriver driver;
    protected LoginPage loginPage;
    protected PlatformSelectPage platformSelectPage;
    protected UserProfilePage userProfilePage;
    protected  UserModalProfilePage userModalProfilePage;
    protected WorkoutCalendarPage workoutCalendarPage;
    protected TrainingCalendarPage trainingCalendarPage;
    protected WorkoutQuickAddPage workoutQuickAddPage;

    @BeforeMethod(description = "Setting up and opening the browser")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        url = System.getenv().getOrDefault("FINALSURGE_URL",
                PropertyReader.getProperty("finalsurge.url"));
        email = System.getenv().getOrDefault("FINALSURGE_EMAIL",
                PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINALSURGE_PASSWORD",
                PropertyReader.getProperty("finalsurge.password"));

        loginPage = new LoginPage(driver);
        platformSelectPage = new PlatformSelectPage(driver);
        userProfilePage = new UserProfilePage(driver);
        userModalProfilePage = new UserModalProfilePage(driver);
        workoutCalendarPage = new WorkoutCalendarPage(driver);
        trainingCalendarPage = new TrainingCalendarPage(driver);
        workoutQuickAddPage = new WorkoutQuickAddPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void tearDown(){
        driver.quit();
    }

}