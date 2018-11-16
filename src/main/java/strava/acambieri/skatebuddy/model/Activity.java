package strava.acambieri.skatebuddy.model;

import io.swagger.client.model.SummaryActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Activity {

    private long id;
    private String name;
    private LocalDateTime date;
    private BigDecimal distance;
    private int time;
    private BigDecimal avgSpeed;
    private BigDecimal maxSpeed;
    private long stravaId; //strava user associated with the activity
    private Wheel wheel;

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public BigDecimal getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(BigDecimal avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public long getStravaId() {
        return stravaId;
    }

    public void setStravaId(long stravaId) {
        this.stravaId = stravaId;
    }

    public static Activity from(SummaryActivity activity){
        Activity newActivity = new Activity();
        newActivity.setId(activity.getId());
        newActivity.setAvgSpeed(BigDecimal.valueOf(activity.getAverageSpeed()).multiply(BigDecimal.valueOf(3.6)));
        newActivity.setDate(activity.getStartDate());
        newActivity.setDistance(BigDecimal.valueOf(activity.getDistance()).divide(BigDecimal.valueOf(1000),4, RoundingMode.HALF_UP));
        newActivity.setMaxSpeed(BigDecimal.valueOf(activity.getMaxSpeed()).multiply(BigDecimal.valueOf(3.6)));
        newActivity.setName(activity.getName());
        newActivity.setTime(activity.getMovingTime());
        newActivity.setStravaId(activity.getAthlete().getId());
        return newActivity;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", distance=" + distance +
                ", time=" + time +
                ", avgSpeed=" + avgSpeed +
                ", maxSpeed=" + maxSpeed +
                ", stravaId=" + stravaId +
                '}';
    }
}
