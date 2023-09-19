package models;
import com.github.javafaker.Faker;

public class UserProfileFactory {

    static Faker faker = new Faker();
    public static UserProfile getFillingUserProfileForm() {
        return UserProfile.builder()
                .firstName(faker.gameOfThrones().character())
                .lastName(faker.gameOfThrones().character())
                .gender("Male")
                .birthday("11/12/2023")
                .weight("57")
                .weightMeasure("lbs")
                .country("Belarus")
                .state("Vitsyebskaya voblasts")
                .city(faker.gameOfThrones().city())
                .zip("222301")
                .build();
    }

}