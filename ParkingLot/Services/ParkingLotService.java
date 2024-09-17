package ParkingLot.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ParkingLot.Models.ParkingLevel;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;

public class ParkingLotService {
    private final List<ParkingLevel> parkingLevels;

    public ParkingLotService(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : parkingLevels) {
            for (ParkingSpot parkingSpot : parkingLevel.getParkingSpots()) {
                if (!parkingSpot.isOccupied() && vehicle.getVehicleType() == parkingSpot.getVehicleType()) {
                    parkingSpot.occupySpot(vehicle);
                    return new Ticket(UUID.randomUUID().toString(), vehicle, parkingSpot, LocalDateTime.now());
                }
            }
        }

        return null; // no available spots
    }

    public void releaseSpot(Ticket ticket) {
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.releaseSpot();
        ticket.setExitTime(LocalDateTime.now());
    }

    public void getAvailableParkingSpots() {
        for (ParkingLevel parkingLevel : parkingLevels) {
            for (ParkingSpot parkingSpot : parkingLevel.getParkingSpots()) {
                if (!parkingSpot.isOccupied()) {
                    System.out.println("Parking Level: " + parkingLevel.getParkingLevelNumber() + " Parking Spot: " + parkingSpot.getSpotNumber() + "Parking Vehicle Type: " + parkingSpot.getVehicleType());
                }
            }
        }
    }
}
