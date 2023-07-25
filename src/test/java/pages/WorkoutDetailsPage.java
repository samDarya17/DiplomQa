package pages;

import enums.DistanceType;
import enums.Feeling;
import enums.PaceType;
import enums.PerceivedEffort;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    private static final By SHARE_LINK = By.cssSelector("[data-target='#ShareDiv']");
    private static final By ACTUAL_TIME = By.xpath("//div[@class='formSep']/div/small");
    private static final By ACTUAL_NAME = By.xpath("//span[@class='activityTypeName']/parent::div/following-sibling::div");
    private static final By ACTUAL_DESCRIPTION = By.xpath("//small[contains(text(),'Description:')]/ancestor::p");
    private static final By ACTUAL_DISTANCE_AND_DURATION = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label-info']");
    private static final By ACTUAL_HR = By.xpath("//p[@class='formSep']");
    private static final By ACTUAL_CALORIES = By.xpath("//p[@class='formSep']/span");
    private static final By ACTUAL_PACE_TYPE = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label']");
    private static final By ACTUAL_PERCEIVED_EFFORT = By.xpath("//div[@class='formSep'][3]");
    private static final By ACTUAL_FEELING = By.xpath("//small[text()='How I Felt:']/following-sibling::span");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting workout details")
    public Workout getWorkoutDetails() {
        Workout workout = new Workout();
        workout.setTimeOfDay(getActualTime());
        workout.setName(getActualName());
        workout.setDescription(getDescription());
        workout.setDistance(getActualDistance());
        workout.setDuration(getActualDuration());
        workout.setAvgHR(getActualAvgHR());
        workout.setMinHR(getActualMinHR());
        workout.setMaxHR(getActualMaxHR());
        workout.setCaloriesBurned(getActualCalories());
        workout.setDistanceType(DistanceType.fromString(getActualDistanceType()));
        workout.setPaceType(PaceType.fromString(getActualPaceType()));
        workout.setPerceivedEffort(PerceivedEffort.fromString(getActualPerceivedEffort()));
        workout.setFeeling(Feeling.fromString(getActualFeeling()));
        return workout;
    }

    @Step("Получение фактического названия тренировки")
    public String getActualName() {
        log.info("Получение фактического названия тренировки");
        return driver.findElement(ACTUAL_NAME).getText().trim();
    }

    @Step("Получение фактического времени тренировки")
    public String getActualTime() {
        log.info("Получение фактического времени тренировки");
        return driver.findElement(ACTUAL_TIME).getText().split("-")[1].trim();
    }

    @Step("Получение фактического описания тренировки")
    public String getDescription() {
        log.info("Получение фактического описания тренировки");
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    @Step("Получение реальной дистанции тренировки")
    public String getActualDistance() {
        log.info("Получение реальной дистанции тренировки");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[0].trim().split(" ")[0];
    }

    @Step("Получение фактического типа дистанционной тренировки")
    public String getActualDistanceType() {
        log.info("Получение фактического типа дистанционной тренировки");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[0].trim().split(" ")[1];
    }

    @Step("Получение фактической продолжительности тренировки")
    public String getActualDuration() {
        log.info("Получение фактической продолжительности тренировки");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[1].trim();
    }

    @Step("Получение фактического количества сожженных калорий")
    public String getActualCalories() {
        log.info("Получение фактического количества сожженных калорий");
        return driver.findElement(ACTUAL_CALORIES).getText().split(" ")[2].trim();
    }

    @Step("Получение фактического темпа тренировки")
    public String getActualPaceType() {
        log.info("Получение фактического темпа тренировки");
        return driver.findElement(ACTUAL_PACE_TYPE).getText().split(" ")[1].trim();
    }

    @Step("Получение фактического воспринимаемого усилия тренировки")
    public String getActualPerceivedEffort() {
        log.info("Получение фактического воспринимаемого усилия тренировки");
        return driver.findElement(ACTUAL_PERCEIVED_EFFORT).getText().split("rt")[1].trim();
    }

    @Step("Получение реальных ощущений от тренировки")
    public String getActualFeeling() {
        log.info("Получение реальных ощущений от тренировки");
        return driver.findElement(ACTUAL_FEELING).getText().trim();
    }

    @Step("Получение фактического минимального ")
    public String getActualMinHR() {
        log.info("Получение фактического минимального ");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[2].trim();
    }

    @Step("Получение фактического среднего")
    public String getActualAvgHR() {
        log.info("Получение фактического среднего");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[8].trim();
    }

    @Step("Получение фактического максимального")
    public String getActualMaxHR() {
        log.info("Получение фактического максимального");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[15].trim();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(SHARE_LINK);
    }

    @Override
    public WorkoutDetailsPage open() {
        driver.get(BASE_URl + "/WorkoutDetails.cshtml");
        return this;
    }

}