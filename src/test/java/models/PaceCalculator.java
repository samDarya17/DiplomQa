package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PaceCalculator {
    String distance;
    String distType;
    String timeInHours;
    String timeInMinutes;
    String timeInSeconds;
}