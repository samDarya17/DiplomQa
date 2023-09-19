package models;

import com.github.javafaker.Faker;

public class CaloricNeedsCalculatorFactory {

    static Faker faker = new Faker();

    public static CaloricNeedsCalculator getDataFromTheForm() {
        return  CaloricNeedsCalculator.builder()
                .weight(faker.random().nextInt(45,100).toString())
                .weightType("kg")
                .height(faker.random().nextInt(150,200).toString())
                .heightType("centimeters")
                .age("28")
                .gender("female")
                .runDistance(faker.random().nextInt(1,50).toString())
                .runDistanceType("kilometers")
                .build();
    }
}