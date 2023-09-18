package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder

public class WorkoutQuickAdd {
    String date;
    String time;
    String activityType;
    String workoutName;
    String workoutDescription;
    boolean showPlannedDistance;
    String plannedDistance;
    String plannedDistanceType;
    String plannedDuration;
    String distance;
    String distanceType;
    String duration;
    String pace;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String postNotes;
    boolean saveToLibrary;

}