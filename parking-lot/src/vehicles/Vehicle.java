package vehicles;

import lombok.Data;
import ticket.Ticket;

@Data
public abstract class Vehicle {
    private String id;
    private VehicleType type;
    private String color;
    private Ticket ticket;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public enum VehicleType {
        CAR, MOTO, TRUCK
    }
}

