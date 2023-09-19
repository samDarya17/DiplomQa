package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserProfile {
    String firstName;
    String lastName;
    String gender;
    String birthday;
    String weight;
    String weightMeasure;
    String country;
    String state;
    String city;
    String zip;
}