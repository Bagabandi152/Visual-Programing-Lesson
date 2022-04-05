package Model;

import java.util.Date;

public class Occupancy {
    public String occupancyNumber;
    public Date dateOccupied;
    public String processedBy;
    public String processedFor;
    public String roomOccupied;
    public double rateApplied;
    public double phoneUse;

    public Occupancy(String occupancyNumber, Date dateOccupied, String processedBy, String processedFor, String roomOccupied, double rateApplied, double phoneUse) {
        this.occupancyNumber = occupancyNumber;
        this.dateOccupied = dateOccupied;
        this.processedBy = processedBy;
        this.processedFor = processedFor;
        this.roomOccupied = roomOccupied;
        this.rateApplied = rateApplied;
        this.phoneUse = phoneUse;
    }

    public String getOccupancyNumber() {
        return occupancyNumber;
    }

    public void setOccupancyNumber(String occupancyNumber) {
        this.occupancyNumber = occupancyNumber;
    }

    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getProcessedFor() {
        return processedFor;
    }

    public void setProcessedFor(String processedFor) {
        this.processedFor = processedFor;
    }

    public String getRoomOccupied() {
        return roomOccupied;
    }

    public void setRoomOccupied(String roomOccupied) {
        this.roomOccupied = roomOccupied;
    }

    public double getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(double rateApplied) {
        this.rateApplied = rateApplied;
    }

    public double getPhoneUse() {
        return phoneUse;
    }

    public void setPhoneUse(double phoneUse) {
        this.phoneUse = phoneUse;
    }
}
