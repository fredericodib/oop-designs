package parking;

import lombok.Getter;
import lombok.Setter;
import ticket.Ticket;
import vehicles.Vehicle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParkingFloor {
    @Getter
    @Setter
    private String id;

    private final Map<ParkingSpot.ParkingSpotType, Map<String, ParkingSpot>> mapperSpot;
    private final Map<ParkingSpot.ParkingSpotType, LinkedList<ParkingSpot>> freeSpots;
    private final Map<Vehicle.VehicleType, ParkingSpot.ParkingSpotType> vehicleTypeMapper;

    public ParkingFloor() {
        mapperSpot = new HashMap<>();
        mapperSpot.put(ParkingSpot.ParkingSpotType.CAR, new HashMap<>());
        mapperSpot.put(ParkingSpot.ParkingSpotType.MOTO, new HashMap<>());
        mapperSpot.put(ParkingSpot.ParkingSpotType.TRUCK, new HashMap<>());

        freeSpots = new HashMap<>();
        freeSpots.put(ParkingSpot.ParkingSpotType.CAR, new LinkedList<>());
        freeSpots.put(ParkingSpot.ParkingSpotType.MOTO, new LinkedList<>());
        freeSpots.put(ParkingSpot.ParkingSpotType.TRUCK, new LinkedList<>());

        vehicleTypeMapper = new HashMap<>();
        vehicleTypeMapper.put(Vehicle.VehicleType.CAR, ParkingSpot.ParkingSpotType.CAR);
        vehicleTypeMapper.put(Vehicle.VehicleType.MOTO, ParkingSpot.ParkingSpotType.MOTO);
        vehicleTypeMapper.put(Vehicle.VehicleType.TRUCK, ParkingSpot.ParkingSpotType.TRUCK);
    }

    public void addSpot(ParkingSpot parkingSpot) {
        mapperSpot.get(parkingSpot.getParkingSpotType()).put(parkingSpot.getSpotId(), parkingSpot);
        freeSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
    }

    public SpotAddress parkVehicle(Vehicle vehicle) {
        ParkingSpot.ParkingSpotType parkingSpotType = vehicleTypeMapper.get(vehicle.getType());
        ParkingSpot parkingSpot = freeSpots.get(parkingSpotType).getFirst();
        if (!parkingSpot.getFree()) {
            throw new RuntimeException("This spot is not Free");
        }
        freeSpots.get(parkingSpotType).removeFirst();
        mapperSpot.get(parkingSpot.getParkingSpotType()).get(parkingSpot.getSpotId()).addVehicle(vehicle);

        SpotAddress spotAddress = new SpotAddress(id, parkingSpot.getSpotId(), parkingSpotType);
        Ticket ticket = new Ticket(vehicle, spotAddress);
        vehicle.setTicket(ticket);
        return spotAddress;
    }

    public Vehicle releaseVehicle(String spotId, ParkingSpot.ParkingSpotType parkingSpotType) {
        ParkingSpot parkingSpot = mapperSpot.get(parkingSpotType).get(spotId);
        if (parkingSpot.getFree()) {
            throw new RuntimeException("This spot is Free");
        }
        Vehicle vehicle = parkingSpot.releaseVehicle();
        freeSpots.get(parkingSpotType).add(parkingSpot);

        vehicle.getTicket().pay();
        return vehicle;
    }

    public Boolean isFull(Vehicle.VehicleType vehicleType) {
        ParkingSpot.ParkingSpotType parkingSpotType = vehicleTypeMapper.get(vehicleType);
        return freeSpots.get(parkingSpotType).size() == 0;
    }
}
