import parking.CarSpot;
import parking.ParkingFloor;
import parking.ParkingLot;
import parking.ParkingSpot;
import vehicles.Car;
import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setId("myCar");
        Car car2 = new Car();
        car2.setId("myCar2");
        Car car3 = new Car();
        car3.setId("myCar3");
        Car car4 = new Car();
        car4.setId("myCar4");

        ParkingSpot spot1 = new CarSpot();
        spot1.setSpotId("spot1");
        ParkingSpot spot2 = new CarSpot();
        spot2.setSpotId("spot2");
        ParkingSpot spot3 = new CarSpot();
        spot3.setSpotId("spot3");

        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setId("floor1");
        parkingFloor1.addSpot(spot1);
        parkingFloor1.addSpot(spot2);

        ParkingFloor parkingFloor2 = new ParkingFloor();
        parkingFloor2.setId("floor2");
        parkingFloor2.addSpot(spot3);

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addFloor(parkingFloor1);
        parkingLot.addFloor(parkingFloor2);

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);
    }
}
