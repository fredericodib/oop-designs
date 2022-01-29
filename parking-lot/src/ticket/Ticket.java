package ticket;

import lombok.Data;
import parking.SpotAddress;
import vehicles.Vehicle;

import java.time.OffsetDateTime;

@Data
public class Ticket {
    private Vehicle vehicle;
    private OffsetDateTime entryTime;
    private OffsetDateTime exitTime;
    private SpotAddress spotAddress;

    public Ticket(Vehicle vehicle, SpotAddress spotAddress) {
        this.vehicle = vehicle;
        this.spotAddress = spotAddress;
        entryTime = OffsetDateTime.now();
    }

    public void pay() {
        exitTime = OffsetDateTime.now();
    }
}
