package strava.acambieri.skatebuddy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wheel {

    private long id;
    private String username;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime lastProcessedDate;
    private LocalDateTime lastRotationDate;
    private BigDecimal totalKM;
    private BigDecimal currentKM;
    private long rotationCounter;

    public long getRotationCounter() {
        return rotationCounter;
    }

    public void setRotationCounter(long rotationCounter) {
        this.rotationCounter = rotationCounter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getLastProcessedDate() {
        return lastProcessedDate;
    }

    public void setLastProcessedDate(LocalDateTime lastProcessedDate) {
        this.lastProcessedDate = lastProcessedDate;
    }

    public LocalDateTime getLastRotationDate() {
        return lastRotationDate;
    }

    public void setLastRotationDate(LocalDateTime lastRotationDate) {
        this.lastRotationDate = lastRotationDate;
    }

    public BigDecimal getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(BigDecimal totalKM) {
        this.totalKM = totalKM;
    }

    public BigDecimal getCurrentKM() {
        return currentKM;
    }

    public void setCurrentKM(BigDecimal currentKM) {
        this.currentKM = currentKM;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", lastProcessedDate=" + lastProcessedDate +
                ", lastRotationDate=" + lastRotationDate +
                ", totalKM=" + totalKM +
                ", currentKM=" + currentKM +
                '}';
    }
}
