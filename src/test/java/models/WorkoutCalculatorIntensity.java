package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutCalculatorIntensity {
    String selectEvent;
    String hours;
    String minutes;
    String seconds;
}