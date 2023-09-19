package models;

import com.github.javafaker.Faker;

public class PaceCalculatorFactory {

    static Faker faker = new Faker();

    public static PaceCalculator fillingPaceCalculatorForm(){
        return PaceCalculator.builder()
                .distance(faker.random().nextInt(5,15).toString())
                .distType("Kilometers")
                .timeInHours(faker.random().nextInt(1,3).toString())
                .timeInMinutes(faker.random().nextInt(01,60).toString())
                .timeInSeconds(faker.random().nextInt(01,60).toString())
                .build();
    }
}