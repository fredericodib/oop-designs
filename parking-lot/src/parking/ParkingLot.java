package parking;

import vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<String, ParkingFloor> floors;

    public ParkingLot() {
        floors = new HashMap<>();
    }

    public void addFloor() {
        ParkingFloor parkingFloor = new ParkingFloor();
        floors.put(parkingFloor.getId(), parkingFloor);
    }

    public void addFloor(ParkingFloor parkingFloor) {
        floors.put(parkingFloor.getId(), parkingFloor);
    }

    public Boolean isFull(Vehicle vehicle) {
        for (var floor : floors.entrySet()) {
            if (!floor.getValue().isFull(vehicle.getType())) {
                return false;
            }
        }

        return true;
    }

    public void parkVehicle(Vehicle vehicle) {
        for (var floor : floors.entrySet()) {
            if (!floor.getValue().isFull(vehicle.getType())) {
                floor.getValue().parkVehicle(vehicle);
                return;
            }
        }
    }

    public Vehicle leaveVehicle(SpotAddress spotAddress) {
        ParkingFloor floor = floors.get(spotAddress.getParkingFloorId());
        return floor.releaseVehicle(spotAddress.getSpotId(), spotAddress.getParkingSpotType());
    }
}
