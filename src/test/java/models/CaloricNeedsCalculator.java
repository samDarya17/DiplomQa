package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CaloricNeedsCalculator {
    String weight;
    String weightType;
    String height;
    String heightType;
    String age;
    String gender;
    String runDistance;
    String runDistanceType;
}