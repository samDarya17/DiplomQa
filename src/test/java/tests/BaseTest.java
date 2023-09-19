package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;


@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PlatformSelectPage platformSelectPage;
    protected CalendarPage calendarPage;
    protected UserProfilePage userProfilePage;
    protected UserProfileModalPage userProfileModalPage;
    protected CaloricNeedsCalculatorPage caloricNeedsCalculatorPage;
    protected CaloricNeedsCalculatorModalPage caloricNeedsCalculatorModalPage;
    protected PaceCalculatorModalPage paceCalculatorModalPage;
    protected PaceCalculatorPage paceCalculatorPage;
    protected WorkoutCalculatorIntensityPage workoutCalculatorIntensityPage;
    protected WorkoutQuickAddPage workoutQuickAddPage;
    protected String email, password;


    @BeforeMethod(description = "Setting up and opening the browser")
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("-headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        email = System.getenv().getOrDefault("FINAL_SURGE-EMAIL", PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINAL_SURGE-PASSWORD",
                PropertyReader.getProperty("finalsurge.password"));
        loginPage = new LoginPage(driver);
        userProfileModalPage = new UserProfileModalPage(driver);
        userProfilePage = new UserProfilePage(driver);
        platformSelectPage = new PlatformSelectPage(driver);
        caloricNeedsCalculatorPage = new CaloricNeedsCalculatorPage(driver);
        caloricNeedsCalculatorModalPage = new CaloricNeedsCalculatorModalPage(driver);
        workoutCalculatorIntensityPage = new WorkoutCalculatorIntensityPage(driver);
        calendarPage = new CalendarPage(driver);
        workoutQuickAddPage = new WorkoutQuickAddPage(driver);
        paceCalculatorModalPage = new PaceCalculatorModalPage(driver);
        paceCalculatorPage = new PaceCalculatorPage(driver);
    }


    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void tearDown() {
        driver.quit();
    }
}