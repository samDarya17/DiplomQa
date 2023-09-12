package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;


public abstract class BaseTest {
    String email, password, url;
    WebDriver driver;
    LoginPage loginPage;
    PlatformSelectPage platformSelectPage;
    UserProfilePage userProfilePage;
    UserModalProfilePage userModalProfilePage;
    WorkoutCalendarPage workoutCalendarPage;



    @Parameters({"browser"})
    @Step("Настройка и открытие браузера")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
//        options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        } else{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();

        }
        url = System.getenv().getOrDefault("FINALSURGE_URL", PropertyReader.getProperty("finalsurge.url"));
        email = System.getenv().getOrDefault("FINALSURGE_EMAIL", PropertyReader.getProperty("finalsurge.email"));
        password = System.getenv().getOrDefault("FINALSURGE_PASSWORD", PropertyReader.getProperty("finalsurge.password"));

        loginPage = new LoginPage(driver);
        platformSelectPage = new PlatformSelectPage(driver);
        userProfilePage = new UserProfilePage(driver);
        userModalProfilePage = new UserModalProfilePage(driver);
        workoutCalendarPage = new WorkoutCalendarPage(driver);





    }

    @Step("Закрытие браузера")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}