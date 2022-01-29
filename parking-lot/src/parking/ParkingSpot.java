package parking;

import lombok.Data;
import vehicles.Vehicle;

@Data
public abstract class ParkingSpot {
    private String spotId;
    private Vehicle vehicle;
    private ParkingSpotType parkingSpotType;
    private Boolean free = true;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public enum ParkingSpotType {
        CAR, MOTO, TRUCK
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public Vehicle releaseVehicle() {
        Vehicle vehicle = this.vehicle;
        this.vehicle = null;
        free = true;
        return vehicle;
    }
}
