package Model;

public class Room {
    public String roomNumber;
    public String roomType;
    public String bedType;
    public double rate;
    public String occupancyStatus;

    public Room(String roomNumber, String roomType, String bedType, double rate, String occupancyStatus) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.rate = rate;
        this.occupancyStatus = occupancyStatus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getOccupancyStatus() {
        return occupancyStatus;
    }

    public void setOccupancyStatus(String occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }
}
