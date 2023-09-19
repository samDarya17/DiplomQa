package models;

public class WorkoutCalculatorIntensityFactory {

    public static WorkoutCalculatorIntensity  fillingCalculatorData(){
        return WorkoutCalculatorIntensity.builder()
                .selectEvent("Marathon")
                .hours("2")
                .minutes("35")
                .seconds("15")
                .build();
    }
}