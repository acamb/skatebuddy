package strava.acambieri.skatebuddy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Stats {

    private LocalDateTime lastImportedActivityDate;
    private Wheel currentWheel;
    private BigDecimal maxSpeed;
    private BigDecimal avgSpeed;
    private BigDecimal maxRunKM;
    private BigDecimal avgRunKM;
    private BigDecimal totalKM;
    private BigDecimal rotationKM;
    private boolean autoimport;

    public boolean isAutoimport() {
        return autoimport;
    }

    public void setAutoimport(boolean autoimport) {
        this.autoimport = autoimport;
    }

    public LocalDateTime getLastImportedActivityDate() {
        return lastImportedActivityDate;
    }

    public void setLastImportedActivityDate(LocalDateTime lastImportedActivityDate) {
        this.lastImportedActivityDate = lastImportedActivityDate;
    }

    public Wheel getCurrentWheel() {
        return currentWheel;
    }

    public void setCurrentWheel(Wheel currentWheel) {
        this.currentWheel = currentWheel;
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BigDecimal getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(BigDecimal avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public BigDecimal getMaxRunKM() {
        return maxRunKM;
    }

    public void setMaxRunKM(BigDecimal maxRunKM) {
        this.maxRunKM = maxRunKM;
    }

    public BigDecimal getAvgRunKM() {
        return avgRunKM;
    }

    public void setAvgRunKM(BigDecimal avgRunKM) {
        this.avgRunKM = avgRunKM;
    }

    public BigDecimal getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(BigDecimal totalKM) {
        this.totalKM = totalKM;
    }

    public BigDecimal getRotationKM() {
        return rotationKM;
    }

    public void setRotationKM(BigDecimal rotationKM) {
        this.rotationKM = rotationKM;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "lastImportedActivityDate=" + lastImportedActivityDate +
                ", currentWheel=" + currentWheel +
                ", maxSpeed=" + maxSpeed +
                ", avgSpeed=" + avgSpeed +
                ", maxRunKM=" + maxRunKM +
                ", avgRunKM=" + avgRunKM +
                ", totalKM=" + totalKM +
                ", rotationKM=" + rotationKM +
                '}';
    }
}
