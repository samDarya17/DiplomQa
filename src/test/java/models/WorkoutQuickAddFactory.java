package models;

import com.github.javafaker.Faker;

public class WorkoutQuickAddFactory {
    static Faker faker = new Faker();
    public static WorkoutQuickAdd getData(){
        return WorkoutQuickAdd.builder()
                .date("09/12/2023")
                .time("02:00 PM")
                .activityType("Bike")
                .workoutName(faker.artist().name())
                .workoutDescription(faker.lorem().sentence())
                .showPlannedDistance(faker.random().nextBoolean())
                .plannedDistanceType("km")
                .plannedDistance(faker.random().nextInt(3,5).toString())
                .plannedDuration("00:40:00")
                .distance(faker.random().nextInt(2,6).toString())
                .distanceType("km")
                .duration("01:00:00")
                .pace("08:00")
                .paceType("min/mi")
                .howIFelt("Normal")
                .perceivedEffort("4 (Moderate)")
                .postNotes(faker.lorem().sentence())
                .saveToLibrary(true)
                .build();
    }
}