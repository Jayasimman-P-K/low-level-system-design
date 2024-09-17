package ParkingLot.Models;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.Enums.VehicleType;

public class ParkingLevel {
    private final int parkingLevelNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingLevel(int parkingLevelNumber, int numberOfParkingSpots, VehicleType vehicleType) {
        this.parkingLevelNumber = parkingLevelNumber;
        this.parkingSpots = new ArrayList<>();
        for (int i = 1; i <= numberOfParkingSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, vehicleType));
        }
    }

    public int getParkingLevelNumber() {
        return parkingLevelNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
    
}
