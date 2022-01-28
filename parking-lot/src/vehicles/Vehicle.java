package vehicles;

import lombok.Data;

@Data
public abstract class Vehicle {
    private String id;
    private VehicleType type;
    private String color;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public static enum VehicleType {
        CAR, MOTO, TRUCK
    }
}

