package ParkingLot.Services;

import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;

public class EntryGate {
    private final String gateId;
    private final ParkingLotService parkingLotService;

    public EntryGate(String gateId, ParkingLotService parkingLotService) {
        this.gateId = gateId;
        this.parkingLotService = parkingLotService;
    }

    public Ticket issueTicket(Vehicle vehicle) {
        return parkingLotService.parkVehicle(vehicle);
    }

    public String getGateId() {
        return gateId;
    }
}
