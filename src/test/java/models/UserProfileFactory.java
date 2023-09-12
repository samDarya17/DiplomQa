package models;

import com.github.javafaker.Faker;

public class UserProfileFactory {
    static Faker faker = new Faker();
    public static UserProfile get(){
        return UserProfile.builder()
                .firstName(faker.funnyName().name())
                .lastName(faker.lebowski().actor())
                .gender("Male")
                .birthday("10/12/1999")
                .weight("75")
                .weightType("kg")
                .country("Canada")
                .state("Ontario")
                .city(faker.address().cityName())
                .zipCode(faker.address().zipCode())
                .build();
    }

}
