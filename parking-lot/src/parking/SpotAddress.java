package parking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpotAddress {
    private String parkingFloorId;
    private String spotId;
    private ParkingSpot.ParkingSpotType parkingSpotType;
}
