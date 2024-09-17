package ParkingLot.Services;

import ParkingLot.Models.Ticket;

public class ExitGate {
    private final String gateId;
    private final ParkingLotService parkingLotService;

    public ExitGate(String gateId, ParkingLotService parkingLotService) {
        this.gateId = gateId;
        this.parkingLotService = parkingLotService;
    }

    public String getGateId() {
        return gateId;
    }

    public void processTicket(Ticket ticket) {
        parkingLotService.releaseSpot(ticket);
    }
}
